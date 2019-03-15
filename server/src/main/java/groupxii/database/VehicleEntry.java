package groupxii.database;

import com.mongodb.DBObject;

/**
 * Represents entries in the database which tracks 
 * which vehicle each request indicates.
 */
public class VehicleEntry extends Entry {
    private long userId;
    private String vehicleType;

    /**
     * Creates VehicleEntry with a userid and a vehicle type.
     */
    public VehicleEntry(long userId, String vehicleType) {
        super();
        this.userId = userId;
        this.vehicleType = vehicleType;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    /**
     * Translates into a MongoDB JSON object.
     */
    public final DBObject toDbObject() {
        return super.toBasicDbObject()
            .append("userId", this.userId)
            .append("vehicleType", this.vehicleType);
    }
}
