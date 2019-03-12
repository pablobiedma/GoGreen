package group12.database;

import org.bson.types.ObjectId;
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

    
    private class SaveNonBlocking<T> extends Thread {
        private T entry;

        SaveNonBlocking(T entry) {
            this.entry = entry;
        }

        public void run() {
            Database.instance.save((VehicleEntry) entry); //temp hack 
	    // Maybe T should be an interface that VehicleEntry extends?
        }
    }

    public void save(VehicleEntry ve) {
        this.vehicleTrackerCollection.insert(ve.toDBObject());
    }

    public void saveNonBlocking(VehicleEntry ve) {
        SaveNonBlocking<VehicleEntry> worker = new SaveNonBlocking<VehicleEntry>(ve);
        worker.start();
    }
}
