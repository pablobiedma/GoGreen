package groupxii.vegetarianmeal;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class EatenMealListTest {

    private EatenMealList eatenMealList = new EatenMealList();

    @Test
    public void readDatabaseTest() throws IOException {
        SaveMeal saveMeal = new SaveMeal();
        saveMeal.saveMealData(1, "APPLES", "BANANAS", 50, 50, 250);
        eatenMealList.readDatabase();
        assertTrue(eatenMealList.getEatenMealList().toString().contains("APPLES"));
    }

    @Test
    public void toStringTest() {
        assertTrue(eatenMealList.toString("APPLES", "BEEF", 20, 20, 50).contains("You ate 20 grams of APPLES instead of 20 grams of BEEF , by doing so you reduced your carbon footprint"));
    }

}