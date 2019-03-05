package server;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/vegetarianmeal")
public class VegetarianMealController {
        @Autowired
        private VegetarianMealUsageRepository repository;

        private final AtomicLong counter = new AtomicLong();

        @RequestMapping(value="/save", method = RequestMethod.POST)
        public VegetarianMealEntry createVegetarianMeal(@Valid @RequestBody VegetarianMealEntry vegetarianMealEntry){ {
            vegetarianMealEntry.setId(ObjectId.get());
            repository.save(vegetarianMealEntry);
            return vegetarianMealEntry;
            }
        }
    }
