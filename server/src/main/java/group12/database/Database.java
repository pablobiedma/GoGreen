package group12.database;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.DBCollection;

public class Database extends Thread {
    public static Database instance = new Database();

    private final String dbAddr = "mongodb://localhost";
    private final int dbPort = 27017;
    private final String dbName = "GoGreen";
    private MongoClient mongoClient;
    private DB mongodb;


    DBCollection vehicleTrackerCollection;

    Database() {
//	try {
        mongoClient = new MongoClient(new MongoClientURI(dbAddr + ":" + dbPort));
        mongodb = this.mongoClient.getDB(dbName);
        vehicleTrackerCollection = mongodb.getCollection("vehicleTrackerCollection");
//	} catch (Exception e){
		//bad init
//	}
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
        this.vehicleTrackerCollection.insert(entry.toDBObject());
    }

    public void saveNonBlocking(Entry entry) {
        SaveNonBlocking worker = new SaveNonBlocking(entry);
        worker.start();
    }
}
