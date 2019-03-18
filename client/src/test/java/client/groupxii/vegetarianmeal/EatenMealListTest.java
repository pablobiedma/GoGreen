package client.groupxii.vegetarianmeal;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class EatenMealListTest {

    private EatenMealList eatenMealList = new EatenMealList();

    @Test
    public void readDatabaseTest() throws IOException {
        SafeMeal safeMeal = new SafeMeal();
        safeMeal.safeMeal("APPLES", "BANANAS", 50, 50);
        eatenMealList.readDatabase();
        assertEquals("You ate 50 grams of APPLES instead of 50 grams of BANANAS , by doing so you reduced your carbon footprint with 0 grams of CO2", eatenMealList.getEatenMealList().get(0));
    }

    @Test
    public void toStringTest() {
        assertEquals("You ate 20 grams of APPLES instead of 20 grams of BEEF , by doing so you reduced your carbon footprint with 50 grams of CO2", eatenMealList.toString("APPLES", "BEEF", 20, 20, 50));
    }

    @Test
    public void getLatestMealTest() throws IOException {
        SafeMeal safeMeal = new SafeMeal();
        safeMeal.safeMeal("APPLES", "BANANAS", 50, 50);
        assertEquals("You ate 50 grams of APPLES instead of 50 grams of BANANAS , by doing so you reduced your carbon footprint with 0 grams of CO2", eatenMealList.getLatestMeal());
    }
}
