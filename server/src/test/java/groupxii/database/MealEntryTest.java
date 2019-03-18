package groupxii.database;

import org.junit.Test;

import static org.junit.Assert.*;

public class MealEntryTest {

    @Test
    public void getUserId() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        assertEquals(1,m.getUserId());
    }

    @Test
    public void getGoodFoodName() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        assertEquals("apple",m.getGoodFoodName());
    }

    @Test
    public void getBadFoodName() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        assertEquals("steak",m.getBadFoodName());
    }

    @Test
    public void getGoodServingSize() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        assertEquals(1,m.getGoodServingSize());
    }

    @Test
    public void getBadServingSize() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        assertEquals(5,m.getBadServingSize());
    }

    @Test
    public void getReducedCo2() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        assertEquals(10,m.getReducedCo2());
    }

    @Test
    public void setUserId() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        m.setUserId(3);
        assertEquals(3,m.getUserId());
    }

    @Test
    public void setGoodFoodName() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        m.setGoodFoodName("pear");
        assertEquals("pear",m.getGoodFoodName());
    }

    @Test
    public void setBadFoodName() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        m.setBadFoodName("pizza");
        assertEquals("pizza",m.getBadFoodName());
    }

    @Test
    public void setGoodServingSize() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        m.setGoodServingSize(2);
        assertEquals(2,m.getGoodServingSize());
    }

    @Test
    public void setBadServingSize() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        m.setBadServingSize(10);
        assertEquals(10,m.getBadServingSize());
    }

    @Test
    public void setReducedCo2() {
        MealEntry m = new MealEntry(1,"apple","steak",1,5,10);
        m.setReducedCo2(12);
        assertEquals(12,m.getReducedCo2());
    }
//Not really sure how to do this one
//    @Test
//    public void toDbObject() {
//
//    }
}