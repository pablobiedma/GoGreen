package groupxii.database;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

/**
 * Manages all database related operations between the server logic and MongoDB.
 */
public class Database extends Thread {
    public static Database instance = new Database();

    private final String dbAddr = "mongodb://localhost";
    private final int dbPort = 27017;
    private final String dbName = "GoGreen";
    private MongoClient mongoClient;
    private DB mongodb;

    private DBCollection vehicleTrackerCollection;

    Database() {
        try {
            mongoClient = new MongoClient(new MongoClientURI(dbAddr + ":" + dbPort));
            mongodb = this.mongoClient.getDB(dbName);
            vehicleTrackerCollection = mongodb.getCollection("vehicleTrackerCollection");
        } catch (UnknownHostException e) {
            // Why?
            //TODO
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
}
