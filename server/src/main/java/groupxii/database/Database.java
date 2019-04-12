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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    private DBCollection mealEntryListCollection;
    private DBCollection userCollection;

    private MealListPublic mealListPublic;

    private boolean running;
    private boolean active;

    Database() {
        dbAddr = System.getenv("DB_ADDRESS");
        if (dbAddr == null) {
            dbAddr = "localhost";
        }
        try {
            String envPort = System.getenv("DB_PORT");
            dbPort = Integer.parseInt(envPort);
        } catch (NullPointerException e) {
            dbPort = 27017;
        } catch (NumberFormatException e) {
            dbPort = 27017;
        }
        dbName = "GoGreen";
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /**
     * Starts instance of Database.
     */
    public void startDb() throws IOException {
        try {
            mongoClient = new MongoClient(this.dbAddr, this.dbPort);
            mongodb = this.mongoClient.getDB(this.dbName);

            vehicleTrackerCollection = mongodb.getCollection("vehicleTrackerCollection");
            mealEntryListCollection = mongodb.getCollection("mealEntryListCollection");
            userCollection = mongodb.getCollection("userCollection");

        } catch (MongoException e) {
            // I don't think this state is reachable.
            // -L
        }

        mealEntryListCollection.drop();
        mealListPublic = new MealListPublic();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(
                                getClass().getClassLoader().getResource("mealList.json"));
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
    }

    public String getDbAddr() {
        return this.dbAddr;
    }

    public int getDbPort() {
        return this.dbPort;
    }

    /**
     * Determine in which collection to put an entry.
     */
    public void save(Entry entry) {
        if (entry instanceof VehicleEntry) {
            this.vehicleTrackerCollection.insert(entry.toDbObject());
        } else if (entry instanceof UserEntry) {
            this.userCollection.insert(entry.toDbObject());
        }
    }

    /**
     * Call save(Entry) on a new thread.
     * @Deprecated NonBlocking feature is dropped. This now just calls save.
     */
    public void saveNonBlocking(Entry entry) {
        save(entry);
    }

    /**
     * Given a vehicle entry, find it in the collection.
     */
    public DBObject findVehicleEntry(VehicleEntry entry) {
        DBCursor cursor = vehicleTrackerCollection.find(entry.toDbObject());
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
     * Return the food names from the meal list.
     */
    public List<String> getMealListFoodNames() {
        return this.mealListPublic.getMealList();
    }
 
    /**
     *Finds an UserEntry by id.
     */
    public UserEntry findUserById(int id) {
        BasicDBObject query = new BasicDBObject();
        query.put("userId", id);
        DBObject dbObject = userCollection.findOne(query);
        return new UserEntry(dbObject);
    }

    /**
     * Finds an UserEntry by username.
     */
    public UserEntry findUserByName(String username) {
        BasicDBObject query = new BasicDBObject();
        query.put("username", username);
        DBObject dbObject = userCollection.findOne(query);
        return new UserEntry(dbObject);
    }

    /** 
     * Returns all users sorted by points.
     */
    public List<UserEntry> sortUsersByReducedCo2() {
        List<UserEntry> list = new ArrayList<>();
        Iterator<DBObject> cursor = userCollection.find().sort(new BasicDBObject("reducedCo2",-1));
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            list.add(new UserEntry(obj));
        }
        return list;
    }

    /** 
     * Receives two id's and adds the first one as a friend to the first one.
     */
    public void addFriend(String userString,int friendId) {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$addToSet", new BasicDBObject().append("friendsId", friendId));
        BasicDBObject searchQuery = new BasicDBObject().append("username", userString);
        userCollection.update(searchQuery, newDocument);
    }

    /**
     * Increments the reducedCo2.
     */
    public void incrementReducedCo2(int id,int amount) {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$inc", new BasicDBObject().append("reducedCo2", amount));
        BasicDBObject searchQuery = new BasicDBObject().append("userId", id);
        userCollection.update(searchQuery, newDocument);
    }

    /** 
     * Counts how many entries there are in the database.
     */
    public int getUserCount() {
        return (int)userCollection.count();
    }

    /**
     * Receives username and a MealEntry and adds the eaten meal 
     * to the "eatenMeal" list of the user's database entry.
     */
    public void addEatenMeal(String userString, MealEntry mealEntry) {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$addToSet", new BasicDBObject().append("eatenMeals", mealEntry.toDbObject()));
        BasicDBObject searchQuery = new BasicDBObject().append("username", userString);
        userCollection.update(searchQuery, newDocument);
    }
}
