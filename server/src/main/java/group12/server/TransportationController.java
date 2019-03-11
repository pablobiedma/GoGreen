package server.group12;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* TransportationController - Use Spring Boot controller
 * to handle /transport requests
 */
@RestController
public class TransportationController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, value = "/transport")
    public Transportation transportation(@RequestParam(value = "vehicle",
                                                       defaultValue = "Unknown")
                                          String vehicleType) {
        Transportation trans = new Transportation(counter.incrementAndGet(), vehicleType);
        VehicleEntry entry = new VehicleEntry(counter.get(), vehicleType);

		Database.instance.trackVehicleEnriesNonBlocking(entry);


        return trans;
    }
	/*
    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public List<VehicleEntry> getAllVehiclesByType(@RequestParam(value = "type", defaultValue = "Uknown") String type) {
        return Database.instance.getByVehicleType(type);
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public VehicleEntry getAllVehiclesById(@RequestParam(value = "id", defaultValue = "Uknown") ObjectId id) {
        return Database.instance.getById(id);
    }
	*/
}
