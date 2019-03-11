package group12.database;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

public class Database extends Thread {

    public static Database instance = new Database();

    private static class VehicleEntryTracker {
        public interface Repo extends MongoRepository<VehicleEntry, ObjectId> {
            public VehicleEntry getById(ObjectId id);
        }

        @Autowired
        private Repo repo;

        public void save(VehicleEntry entry) {
            repo.save(entry);
        }
    }

    VehicleEntryTracker vehicleEntryTracker;

    private class TrackVehicleEnriesNonBlocking extends Thread {
        private VehicleEntry entry;

        TrackVehicleEnriesNonBlocking(VehicleEntry entry) {
            this.entry = entry;
        }

        public void run() {
            vehicleEntryTracker.save(entry);
        }
    }

    public void trackVehicleEntries(VehicleEntry ve) {
        vehicleEntryTracker.save(ve);
    }

    public void trackVehicleEnriesNonBlocking(VehicleEntry ve) {
        TrackVehicleEnriesNonBlocking worker = new TrackVehicleEnriesNonBlocking(ve);
        worker.start();
    }
}
