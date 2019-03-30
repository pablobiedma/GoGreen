package groupxii.database;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/* Apparently those are unneded
import java.lang.System;
import java.lang.NullPointerException;
import java.lang.NumberFormatException;
*/

/**
 * Manages all database related operations between the server logic and MongoDB.
 */
public class Database extends Thread {
    public static final Database instance = new Database();

    private String dbAddr;
    private int dbPort;
    private String dbName;
    private MongoClient mongoClient;
    private DB mongodb;

    private DBCollection vehicleTrackerCollection;
    private DBCollection vegetarianMealCollection;
    private DBCollection userCredentialsCollection;

    private boolean running;
    private boolean active;

    Database() {
        dbAddr = System.getenv("DB_ADDRESS");
        if (dbAddr == null) {
            dbAddr = "localhost";
        }
        try {
            dbPort = Integer.parseInt(System.getenv("DB_PORT"));
        } catch (NullPointerException e) {
            dbPort = 27017;
        } catch (NumberFormatException e) {
            dbPort = 27017;
        }
        dbName = "GoGreen";
        running = false;
        active = false;
    }

    public boolean isRunning() {
        return this.running;
    }

    public boolean isActive() {
        return active;
    }

    public void setDbAddr(String dbAddr) {
        this.dbAddr = dbAddr;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbAddr() {
        return this.dbAddr;
    }

    public int getDbPort() {
        return this.dbPort;
    }

    public String getDbName() {
        return this.dbName;
    }

    /**
     * Starts instance of Database.
     */
    public void startDb() {
        try {
            mongoClient = new MongoClient(this.getDbAddr(), this.getDbPort());
            mongodb = this.mongoClient.getDB(this.getDbName());
            vehicleTrackerCollection = mongodb.getCollection("vehicleTrackerCollection");
            vegetarianMealCollection = mongodb.getCollection("vegetarianMealCollection");
            userCredentialsCollection = mongodb.getCollection("userCredentialsCollection");
            running = true;
        } catch (MongoException e) {
            // I don't think this state is reachable.
            // -L
            running = false;
        }
    }

    private class SaveNonBlocking extends Thread {
        private Entry entry;

        SaveNonBlocking(Entry entry) {
            this.entry = entry;
        }

        public void run() {
            Database.instance.save(entry);
        }
    }

    /**
     * Determine in which collection to put an entry.
     */
    public void save(Entry entry) {
        this.active = true;

        if (entry instanceof MealEntry) {
            this.vegetarianMealCollection.insert(entry.toDbObject());
        }
        if (entry instanceof VehicleEntry) {
            this.vehicleTrackerCollection.insert(entry.toDbObject());
        }
        /*
        if (entry instanceof UserCredentialsEntry) {
            this.userCredentialsCollection.insert(entry.toDbObject());
        }
        */
        this.active = false;
    }

    /**
     * Call save(Entry) on a new thread.
     */

    public void saveNonBlocking(Entry entry) {
        this.active = true;
        SaveNonBlocking worker = new SaveNonBlocking(entry);
        worker.start();
    }

    /**
     * Given a vehicle entry, find it in the collection.
     */
    public DBObject findVehicleEntry(VehicleEntry entry) {
        while (this.isActive()) {}
        DBCursor cursor = vehicleTrackerCollection.find(entry.toDbObject());
        return cursor.one();
    }

    /**
     * Given a meal entry, find it in the collection.
     */
    public DBObject findMealEntry(MealEntry entry) {
        while (this.isActive()) {}
        DBCursor cursor = vegetarianMealCollection.find(entry.toDbObject());
        return cursor.one();
    }
}
