package server.group12;

import org.springframework.data.annotation.Id;

public class VehicleEntry {
    @Id
    public String id;

    public long userId;
    public String vehicleType;

    public VehicleEntry(long userId,String vehicleType) {
        this.userId = userId;
        this.vehicleType = vehicleType;
    }
}
