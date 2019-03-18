package groupxii.vegetarianmeal;

import groupxii.database.MealEntry;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SaveMealTest {

    @Test
    public void setMealList() {
        SaveMeal sm1 = new SaveMeal();
        SaveMeal sm2 = new SaveMeal();
        List<Meal> l1 = new ArrayList<>();
        List<Meal> l2 = new ArrayList<>();
        Meal m1 = new Meal("apple",1,1.4);
        Meal m2 = new Meal("pear",2,2.1);
        Meal m3 = new Meal("banana",3,1.9);
        Meal m4 = new Meal("watermelon",1,2.3);
        Meal m5 = new Meal("strawberry",5,1.9);
        l1.add(0,m1);
        l1.add(1,m2);
        l2.add(0,m3);
        l2.add(1,m4);
        l2.add(2,m5);
        sm1.setMealList(l1);
        sm2.setMealList(l2);
        sm1.setMealList(l2);
        assertEquals(sm2.getMealList(),sm1.getMealList());
    }

    @Test
    public void getMealList() {
        SaveMeal sm = new SaveMeal();
        List<Meal> l = new ArrayList<>();
        Meal m1 = new Meal("apple",1,1.4);
        Meal m2 = new Meal("pear",2,2.1);
        Meal m3 = new Meal("banana",3,1.9);
        Meal m4 = new Meal("watermelon",1,2.3);
        Meal m5 = new Meal("strawberry",5,1.9);
        l.add(0,m1);
        l.add(1,m2);
        l.add(2,m3);
        l.add(3,m4);
        l.add(4,m5);
        sm.setMealList(l);
        assertEquals(l.subList(0,5),sm.getMealList());
    }

    @Test
    public void getMealEntry() throws IOException {
        MealEntry m = new MealEntry(2,"apple","steak",1,5,10);
        SaveMeal sm = new SaveMeal();
        sm.saveMealData(1,"apple","steak",1,5,10);
        assertNotEquals(sm.getMealEntry(),m);
    }
}