package groupxii.database;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

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

    private boolean running;

    Database() {
        dbAddr = "localhost";
        dbPort = 27017;
        dbName = "GoGreen";
        running = false;
    }

    public boolean isRunning() {
        return this.running;
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
            running = true;
        } catch (UnknownHostException e) {
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

    public void save(Entry entry) {
        this.vehicleTrackerCollection.insert(entry.toDbObject());
    }

    public void saveNonBlocking(Entry entry) {
        SaveNonBlocking worker = new SaveNonBlocking(entry);
        worker.start();
    }

    public DBObject findVehicleEntry(VehicleEntry entry) {
        DBCursor cursor = vehicleTrackerCollection.find(entry.toDbObject());
        return cursor.one();
    }
}
