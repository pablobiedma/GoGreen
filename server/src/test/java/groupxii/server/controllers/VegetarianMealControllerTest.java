package groupxii.server.controllers;

import groupxii.database.MealEntry;
import groupxii.server.controllers.VegetarianMealController;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class VegetarianMealControllerTest {

    VegetarianMealController vegetarianMealController = new VegetarianMealController();

    @Test
    public void saveMealTest() throws IOException {
        vegetarianMealController.getMealData();
        MealEntry entry = vegetarianMealController.saveMealData("APPLES", 50, "HAZELNUTS", 50);
        assertEquals(entry.getBadFoodName(), "HAZELNUTS");
        assertEquals(entry.getGoodServingSize(), 50);
    }

    @Test
    public void getNameList() throws IOException {
        vegetarianMealController.getMealData();
        String nameList = vegetarianMealController.getNameList();
        assertTrue(nameList.contains("APPLES"));
    }
}
