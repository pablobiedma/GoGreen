package server.group12;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class VegetarianMealControllerTest {

    @Autowired
    private VegetarianMealUsageRepository repository;

    @Test
    public void testVegetarianMealController(){
        VegetarianMealController vmc = new VegetarianMealController();
        VegetarianMealEntry meal = new VegetarianMealEntry(1, "carrot", 20, 50);
        meal.setId(ObjectId.get());
        repository.save(meal);
        vmc.createVegetarianMeal(meal);
        assertEquals(repository.getByUserId(1), vmc.getRepository());
    }
}