package groupxii.server;

import groupxii.vegetarianMeal.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VegetarianMealController {

    private SaveMeal saveMeal;
    private Calculations calculations = new Calculations();
    //FOR TESTING PURPOSES I USE A FIXED USER ID
    private long userId = 50;
    GetMealData getMealData;
    List<Meal> mealList = new ArrayList<Meal>();

    @RequestMapping(method = RequestMethod.GET, value = "/getMealData")
    public void getMealData() throws IOException {
        getMealData = new GetMealData();
        getMealData.readMealListData();
        mealList = getMealData.getMealList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mealNameList")
    public void getNameList(){
        MealNameList mealNameList = new MealNameList();
        mealNameList.setGetMealData(this.mealList);
        mealNameList.getMealNameList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/saveMealdata")
    public Meal saveMealData(@RequestParam(value = "goodFoodName", defaultValue = "Unknown") String goodFoodName,
                     @RequestParam(value = "goodServingSize", defaultValue = "Unknown") int goodServingSize,
                     @RequestParam(value = "badFoodName", defaultValue = "Unknown") String badFoodName,
                     @RequestParam(value = "badServingSize", defaultValue = "Unknown") int badServingSize) throws IOException {
        calculations.setMealList(this.mealList);
        int reducedCo2 = calculations.reducedCO2(badFoodName, badServingSize, (int)calculations.calculateCO2(goodFoodName, goodServingSize));
        saveMeal = new SaveMeal();
        saveMeal.setMealList(this.mealList);
        saveMeal.saveMealData(userId, goodFoodName, badFoodName, goodServingSize, badServingSize, reducedCo2);
        Meal returnMeal = new Meal(goodFoodName, reducedCo2, goodServingSize);
        return returnMeal;
    }
}

