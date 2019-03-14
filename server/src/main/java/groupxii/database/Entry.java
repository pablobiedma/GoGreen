package groupxii.database;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

/* Entry - abstract class to be used in creating
 * MongoDB entries
 */
public abstract class Entry {
    private ObjectId id; // MongoDB's _id

    public abstract DBObject toDbObject();

    public BasicDBObject toBasicDbObject() {
        return new BasicDBObject("_id", this.id);
    }
}
