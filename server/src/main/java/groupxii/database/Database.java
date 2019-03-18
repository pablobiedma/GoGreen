package groupxii.database;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;



import com.mongodb.MongoException;


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

    private boolean running;
    private boolean active;

    Database() {
        dbAddr = "localhost";
        dbPort = 27017;
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
<<<<<<< HEAD
     * method which saves an entry.
=======
     * Determine in which collection to put an entry.
>>>>>>> 6953de15f0ad7f8a6e60328fd93ae7e0db978942
     */
    public void save(Entry entry) {
        this.active = true;

        if (entry instanceof MealEntry) {
            this.vegetarianMealCollection.insert(entry.toDbObject());
        }
<<<<<<< server/src/main/java/groupxii/database/Database.java

        //if (entry instanceof VehicleEntry) {
        //this.vehicleTrackerCollection.insert(entry.toDbObject());
        //}
=======
        if (entry instanceof VehicleEntry) {
        this.vehicleTrackerCollection.insert(entry.toDbObject());
        }
>>>>>>> server/src/main/java/groupxii/database/Database.java
        this.active = false;
    }

    /**
<<<<<<< HEAD
     * Save a nonblocking entry.
=======
     * Call save(Entry) on a new thread.
>>>>>>> 6953de15f0ad7f8a6e60328fd93ae7e0db978942
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
}
