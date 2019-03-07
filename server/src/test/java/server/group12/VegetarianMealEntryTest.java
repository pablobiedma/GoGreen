package server.group12;

import org.junit.Test;

import static org.junit.Assert.*;

public class VegetarianMealEntryTest {

    @Test
    public void testVegetarianMealUserId() {
        VegetarianMealEntry veg = new VegetarianMealEntry(1,"carrots",100,12);
        assertEquals(1,veg.userId);
    }
    @Test
    public void testVegetarianMeal() {
        VegetarianMealEntry veg = new VegetarianMealEntry(1,"carrots",100,12);
        assertEquals("carrots",veg.vegetarianMeal);
    }
    @Test
    public void testVegetarianMealPoints() {
        VegetarianMealEntry veg = new VegetarianMealEntry(1,"carrots",100,12);
        assertEquals(100,veg.points);
    }
    @Test
    public void testVegetarianMealCo2() {
        VegetarianMealEntry veg = new VegetarianMealEntry(1,"carrots",100,12);
        assertEquals(12,veg.co2);
    }
    @Test
    public void testVegetarianMealgetById() {
        VegetarianMealEntry veg = new VegetarianMealEntry(1,"carrots",100,12);
        assertEquals(1,veg.getById());
    }
    //Missing a test for setting Object_id
}