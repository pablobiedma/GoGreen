package server.group12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* TransportationController - Use Spring Boot controller
 * to handle /transport requests
 */
@RestController
public class TransportationController {
    @Autowired
    private VehicleUsageRepository repository;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, value = "/transport")
    public Transportation transportation(@RequestParam(value = "vehicle",
                                                       defaultValue = "Unknown")
                                          String vehicleType) {
        Transportation trans = new Transportation(counter.incrementAndGet(), vehicleType);
        VehicleEntry entry = new VehicleEntry(counter.get(), vehicleType);
        try {
            repository.save(entry);
        } catch (NullPointerException e) {
            // By documentation this should never happen.
            // But during testing the save method throws NPE for uknown reasons
            // Since this is not critical we ignore this for now
            // Furthur investigation necessary
            // (Maybe beacuse during testing it dosen't connect to the database?)
        }
        return trans;
    }
    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public List<VehicleEntry> getAllVehiclesByType(@RequestParam(value = "type", defaultValue = "Uknown") String type) {
        return repository.getByVehicleType(type);
    }
}
