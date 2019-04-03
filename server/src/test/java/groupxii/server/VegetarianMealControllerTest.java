package groupxii.server.controllers;

import groupxii.database.MealEntry;
import groupxii.database.Database;
import groupxii.database.MealListPublic;
import groupxii.vegetarianmeal.CalculatedMeal;
import org.junit.Test;
import org.junit.Before;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class VegetarianMealControllerTest {

    VegetarianMealController vmc;
    @Before
    public void createVMC() {
	    try {
		    Database.instance.startDb();
	    } catch (IOException e) {
		    assertTrue(false);
	    }
	    vmc = new VegetarianMealController();
    }

    @Test
    public void calculateMealTest() {
	CalculatedMeal localCalculateMeal = new CalculatedMeal("GRAPEFRUIT", 100, "EGGPLANT", 120);
	CalculatedMeal remoteCalculateMeal = vmc.calculateMeal("GRAPEFRUIT", 100, "EGGPLANT", 120);
        assertEquals(localCalculateMeal.getReducedCO2(), remoteCalculateMeal.getReducedCO2());
    }

    @Test
    public void getNameList() {
        List<String> nameList = vmc.getNameList();
        assertFalse(nameList.isEmpty());
    }
}
