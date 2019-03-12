package group12.server;

import group12.database.Database;
import group12.database.VehicleEntry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

        Database.instance.saveNonBlocking(entry);

        return trans;
    }
}
