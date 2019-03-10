package server.group12;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import javax.validation.Valid;

@RestController
@RequestMapping("/vegetarianmeal")
public class VegetarianMealController {
    @Autowired
    private VegetarianMealUsageRepository repository;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public VegetarianMealEntry createVegetarianMeal(
            @Valid @RequestBody VegetarianMealEntry vegetarianMealEntry) {
        vegetarianMealEntry.setId(ObjectId.get());
        repository.save(vegetarianMealEntry);
        return vegetarianMealEntry;
    }
}
