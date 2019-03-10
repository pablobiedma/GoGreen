package server.group12;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VehicleUsageRepository extends MongoRepository<VehicleEntry,String> {
    public VehicleEntry getByUserId(long userId);

    public List<VehicleEntry> getByVehicleType(String vehicleType);
}
