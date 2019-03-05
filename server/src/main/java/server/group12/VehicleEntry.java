package server.group12;

import org.springframework.data.annotation.Id;

/* VehicleEntry - POJO class to represent
 * entries in the database
 * Tracks which vehicle each user uses
 * (evil)
 */
public class VehicleEntry {
    @Id
    public String id; // Internel for MondoDB

    public long userId;
    public String vehicleType;

    public VehicleEntry(long userId,String vehicleType) {
        this.userId = userId;
        this.vehicleType = vehicleType;
    }
}
