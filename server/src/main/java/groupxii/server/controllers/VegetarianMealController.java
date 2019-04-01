package groupxii.server.controllers;

import groupxii.database.Database;
import groupxii.database.MealEntry;
import groupxii.server.ServerApplication;
import groupxii.vegetarianmeal.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class VegetarianMealController {

    /**
    This method will transform the data from the mealList into one string, which then can be used
    by the client, so the choiceboxes/listviews in the GUI are able to show all the meal names.
     */
    /*
    @RequestMapping(method = RequestMethod.GET, value = "/mealNameList")
    public String getNameList() {
        MealNameList mealNameList = new MealNameList();
        mealNameList.setGetMealData(this.mealList);
        String mealNameListString = mealNameList.getMealNameList();
        return mealNameListString;
    }
    */

    /**
     * Calculate the saved CO2 and send the response to the server
     */
    @RequestMapping(method = RequestMethod.GET, value = "/calculateMeal")
    public CalculatedMeal calculateMeal(@RequestParam(value = "goodFoodName",
                                                      defaultValue = "Unknown")
                                        String goodFoodName,
                                        @RequestParam(value = "goodServingSize",
                                                      defaultValue = "-1")
                                        Integer goodServingSize,
                                        @RequestParam(value = "badFoodName",
                                                      defaultValue = "Unknown")
                                        String badFoodName,
                                        @RequestParam(value = "badServingSize",
                                                      defaultValue = "-1")
                                        Integer badServingSize) {

        return new CalculatedMeal(goodFoodName, goodServingSize, badFoodName, badServingSize);
    }

    /**
    the client can send data to the server with the right values as parameter,
    then this method will store the data in the database.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/saveMealData")
    public void saveMealData(@RequestParam(value = "goodFoodName",
                                                         defaultValue = "Unknown")
                                           String goodFoodName,
                                           @RequestParam(value = "goodServingSize",
                                                         defaultValue = "-1")
                                           Integer goodServingSize,
                                           @RequestParam(value = "badFoodName",
                                                         defaultValue = "Unknown")
                                           String badFoodName,
                                           @RequestParam(value = "badServingSize",
                                                         defaultValue = "-1")
                                           Integer badServingSize,
                                           Principal principal) {
            //TODO find the userID and append the CalculatedCO2
        int userID = -1;
        MealEntry saveMeal = new MealEntry(userID, goodFoodName, badFoodName, 
                                         goodServingSize, badServingSize);
	Database.instance.saveNonBlocking(saveMeal);
    }

    /*
    @RequestMapping(method = RequestMethod.GET, value = "/eatenMealList")
    public String getEatenMealList() throws IOException {
        EatenMealList eatenMealListClass = new EatenMealList();
        eatenMealListClass.readDatabase();
        String jsonReturn = "";
        eatenMealList = eatenMealListClass.getEatenMealList();
        for (int i = 0; i < eatenMealList.size(); i++ ){
            jsonReturn += eatenMealList.get(i) + " - ";
        }
        return jsonReturn;
    }
    */

    /*
    @RequestMapping(method = RequestMethod.GET, value = "/latestMeal")
    public String getLatestMeal() {
    }
    */
}
