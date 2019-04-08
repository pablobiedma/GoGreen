package groupxii.database;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.bson.BSONObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    private DBCollection vehicleEntryListCollection;
    private DBCollection vegetarianMealCollection;
    private DBCollection mealEntryListCollection;
    private DBCollection userCollection;

    private VehicleListPublic vehicleListPublic;
    private MealListPublic mealListPublic;

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
    public void startDb() throws IOException {
        try {
            mongoClient = new MongoClient(this.getDbAddr(), this.getDbPort());
            mongodb = this.mongoClient.getDB(this.getDbName());

            vehicleTrackerCollection = mongodb.getCollection("vehicleTrackerCollection");
            vegetarianMealCollection = mongodb.getCollection("vegetarianMealCollection");
            mealEntryListCollection = mongodb.getCollection("mealEntryListCollection");
            vehicleEntryListCollection = mongodb.getCollection("vehicleEntryListCollection");
            userCollection = mongodb.getCollection("userCollection");

            vehicleEntryListCollection.drop();
            mealEntryListCollection.drop();
            vehicleListPublic = new VehicleListPublic();
            mealListPublic = new MealListPublic();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(
                                    getClass().getClassLoader().getResource("mealList.json"));
            ObjectMapper objectMapper2 = new ObjectMapper();
            JsonNode rootNode2 = objectMapper.readTree(
                    getClass().getClassLoader().getResource("transportationList.json"));
            Iterator<JsonNode> elements;
            for (elements = rootNode.elements(); elements.hasNext(); elements.next()) {
                JsonNode node = elements.next();
                String food  = node.get("food").asText();
                double co2PerServing = node.get("grams_co2e_per_serving").asDouble();
                double calPerServing = node.get("calories_per_serving").asDouble();
                double sizeServing = node.get("serving_size").asDouble();
                MealListEntry mealListEntry = new MealListEntry(
                                                      food,
                                                      co2PerServing,
                                                      calPerServing,
                                                      sizeServing);
                mealEntryListCollection.insert(mealListEntry.toDbObject());
                mealListPublic.addFoodName(food);
            }
            Iterator<JsonNode> elements2 = rootNode2.elements();
            while (elements2.hasNext()) {
                JsonNode node = elements2.next();
                String panel = node.get("vehiclename").asText();
                double co2 = node.get("grams_co2_by_vehicle_per_km").asDouble();
                String fuel = node.get("fuel").asText();
                int avgConsumption = node.get("average_consumption_liter/100km").asInt();
                VehicleListEntry vehicleListEntry = new VehicleListEntry(panel,co2,fuel,avgConsumption);
                vehicleEntryListCollection.insert(vehicleListEntry.toDbObject());
                vehicleListPublic.addVehicleName(panel);
            }
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
        if (entry instanceof UserEntry) {
            this.userCollection.insert(entry.toDbObject());
        }
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

    /**
     * Given a food name, return the MealListEntry.
     */
    public MealListEntry findMealListEntry(String name) {
        BasicDBObject query = new BasicDBObject("foodName", name);
        DBCursor cursor = mealEntryListCollection.find(query);
        return new MealListEntry((BSONObject)cursor.one());
    }

    /**
     * Given a vehicle name, return the VehicleListEntry.
     */
    public VehicleListEntry findVehicleListEntry(String name) {
        BasicDBObject query = new BasicDBObject("vehicletype", name);
        DBCursor cursor = mealEntryListCollection.find(query);
        return new VehicleListEntry((BSONObject)cursor.one());
    }

    /**
     * Return the food names from the meal list.
     */
    public List<String> getMealListFoodNames() {
        return this.mealListPublic.getMealList();
    }

    /**
     * Return the vehicle names from the vehicle list.
     */
    public List<String> getVehicleListVehicleNames() {
        return this.vehicleListPublic.getVehicleList();
    }

    /** Finds user entry.
     */
    public DBObject findUserEntry(UserEntry entry) {
        while (this.isActive()) {}
        DBCursor cursor = userCollection.find(entry.toDbObject());
        return cursor.one();
    }

    /** Finds an UserEntry by id.
     */
    public DBObject findUserById(int id) {
        BasicDBObject query = new BasicDBObject();
        query.put("userId", id);
        DBObject dbObject = userCollection.findOne(query);
        return dbObject;
    }

    public DBObject findUserByName(String username) {
        BasicDBObject query = new BasicDBObject();
        query.put("username", username);
        DBObject dbObject = userCollection.findOne(query);
        return dbObject;
    }

    /** returns all users sorted by points.
     */
    public List<DBObject> sortUsersByReducedCo2() {
        List<DBObject> list = new ArrayList<>();
        Iterator<DBObject> cursor = userCollection.find().sort(new BasicDBObject("reducedCo2",-1));
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            list.add(obj);
        }
        return list;
    }

    /** receives two id's and adds the first one as a friend to the first one.
     */
    public void addFriend(String userString,int friendId) {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$addToSet", new BasicDBObject().append("friendsId", friendId));
        BasicDBObject searchQuery = new BasicDBObject().append("username", userString);
        userCollection.update(searchQuery, newDocument);
    }

    /** Increments the reducedCo2.
     */
    public void incrementReducedCo2(int id,int amount) {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$inc", new BasicDBObject().append("reducedCo2", amount));
        BasicDBObject searchQuery = new BasicDBObject().append("userId", id);
        userCollection.update(searchQuery, newDocument);
    }

    /* counts how many entries there are in the database and increments the number by one for the userId.
     */
    public int getUserCount() {
        return (int) userCollection.count();
    }

    /* receives username and a MealEntry and adds the eaten meal to the eaten meal list of the user.
     */
    public void addEatenMeal(String userString, MealEntry mealEntry) {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$addToSet", new BasicDBObject().append("eatenMeals", mealEntry.toDbObject()));
        BasicDBObject searchQuery = new BasicDBObject().append("username", userString);
        userCollection.update(searchQuery, newDocument);
    }

    /**
     * Add a used vehicle to the collection.
     */
    public void addUsedVehicle(String userString, VehicleEntry vehicleEntry) {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$addToSet", new BasicDBObject().append("usedPanels", vehicleEntry.toDbObject()));
        BasicDBObject searchQuery = new BasicDBObject().append("username", userString);
        userCollection.update(searchQuery, newDocument);
    }
}
