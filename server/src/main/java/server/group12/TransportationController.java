package server.group12;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private VehicleUsageRepository repository;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, value = "/transport")
    public Transportation transportation(@RequestParam(value = "vehicle",
                                                       defaultValue = "Unknown")
                                          String vehicleType) {
        repository.save(new VehicleEntry(counter.incrementAndGet(), vehicleType));
        return new Transportation(counter.get(),vehicleType);
    }
}
