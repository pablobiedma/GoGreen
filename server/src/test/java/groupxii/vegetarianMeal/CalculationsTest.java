package groupxii.vegetarianMeal;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalculationsTest {

    @Test
    public void setMealList() {
        Calculations c1 = new Calculations();
        Calculations c2 = new Calculations();
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
        c1.setMealList(l1);
        c2.setMealList(l2);
        c1.setMealList(l2);
        assertEquals(c2.getMealList(),c1.getMealList());
    }

    @Test
    public void getMealList() {
        Calculations c = new Calculations();
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
        c.setMealList(l);
        assertEquals(l.subList(0,5),c.getMealList());
    }

    @Test
    public void calculateCO2() throws IOException {
        Calculations c = new Calculations();
        List<Meal> l = new ArrayList<>();
        Meal m1 = new Meal("apple",1,1.4);
        Meal m2 = new Meal("pear",2,2.1);
        l.add(0,m1);
        l.add(1,m2);
        c.setMealList(l);
        assertEquals(2,c.calculateCO2("apple",2));
    }

    @Test
    public void reducedCO2() throws IOException{
        Calculations c = new Calculations();
        List<Meal> l = new ArrayList<>();
        Meal m1 = new Meal("apple",1,1.4);
        Meal m2 = new Meal("pear",2,2.1);
        Meal m3 = new Meal("steak",100,1.2);
        l.add(0,m1);
        l.add(1,m2);
        l.add(2,m3);
        c.setMealList(l);
        assertEquals(198,c.reducedCO2("steak",2,2));
    }

    @Test
    public void calculatePoints() throws IOException{
        Calculations c = new Calculations();
        List<Meal> l = new ArrayList<>();
        Meal m1 = new Meal("apple",1,1.4);
        Meal m2 = new Meal("pear",2,2.1);
        Meal m3 = new Meal("steak",100,1.2);
        l.add(0,m1);
        l.add(1,m2);
        l.add(2,m3);
        c.setMealList(l);
        assertEquals(c.reducedCO2("steak",2,2)*5,c.calculatePoints());
    }
}