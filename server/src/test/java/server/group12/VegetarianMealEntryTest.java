package server.group12;

import org.junit.Test;

import static org.junit.Assert.*;

public class VegetarianMealEntryTest {
    @Test
    public void testVegetarianMealEntryTestUserId() {
        VegetarianMealEntry vm = new VegetarianMealEntry(1, "Apple", 20, 50);
        assertEquals(1, vm.userId);
    }
    @Test
    public void testVegetarianMealEntryTestVegetarianMeal() {
        VegetarianMealEntry vm = new VegetarianMealEntry(1, "Apple", 20, 50);
        assertEquals("Apple", vm.vegetarianMeal);
    }
    @Test
    public void testVegetarianMealEntryTestPoints() {
        VegetarianMealEntry vm = new VegetarianMealEntry(1, "Apple", 20, 50);
        assertEquals(20, vm.points);
    }
    @Test
    public void testVegetarianMealEntryTestCo2() {
        VegetarianMealEntry vm = new VegetarianMealEntry(1, "Apple", 20, 50);
        assertEquals(50, vm.co2);
    }
}