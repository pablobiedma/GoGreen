package client.groupxii.vegetarianmeal;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class EatenMealListTest {

    private EatenMealList eatenMealList = new EatenMealList();

    @Test
    public void readDatabaseTest() throws IOException {
        SafeMeal safeMeal = new SafeMeal();
        safeMeal.safeMeal("APPLES", "BANANAS", 50, 50);
        eatenMealList.readDatabase();
        assertTrue(eatenMealList.getEatenMealList().toString().contains("APPLES"));
    }

    @Test
    public void toStringTest() {
        assertTrue(eatenMealList.toString("APPLES", "BEEF", 20, 20, 50).contains("You ate 20 grams of APPLES instead of 20 grams of BEEF , by doing so you reduced your carbon footprint"));
    }

    @Test
    public void getLatestMealTest() throws IOException {
        SafeMeal safeMeal = new SafeMeal();
        safeMeal.safeMeal("APPLES", "BANANAS", 50, 50);
        assertTrue(eatenMealList.getLatestMeal().contains("You ate 50 grams of APPLES instead of 50 grams of BANANAS , by doing so you reduced your carbon footprint"));
    }
}
