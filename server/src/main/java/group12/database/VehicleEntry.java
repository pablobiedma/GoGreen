package group12.database;

import org.bson.types.ObjectId;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;

/* VehicleEntry - POJO class to represent
 * entries in the database
 * Tracks which vehicle each user uses
 * (evil)
 */
public class VehicleEntry {
    public ObjectId id; // Internel for MondoDB

    public long userId;
    public String vehicleType;

    public VehicleEntry(long userId,String vehicleType) {
        this.userId = userId;
        this.vehicleType = vehicleType;
    }

    public final DBObject toDBObject() {
	    return new BasicDBObject("_id", this.id)
		    .append("userId", this.userId)
		    .append("vehicleType", this.vehicleType);
    }
}
