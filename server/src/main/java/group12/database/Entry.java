package group12.database;

import org.bson.types.ObjectId;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;

/* Entry - abstract class to be used in creating
 * MongoDB entries
 */
public abstract class Entry {
	private ObjectId _id; // MongoDB's _id
	public abstract DBObject toDBObject();

	public BasicDBObject toBasicDBObject() {
		return new BasicDBObject("_id", this._id);
	}
}
