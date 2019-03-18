package groupxii.vegetarianMeal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GetMealDataTest {

    @Test
    public void getMealList() {
        GetMealData ml = new GetMealData();
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
        ml.setMealList(l);
        assertEquals(l.subList(0,5),ml.getMealList());
    }

    @Test
    public void setMealList() {
        GetMealData ml1 = new GetMealData();
        GetMealData ml2 = new GetMealData();
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
        ml1.setMealList(l1);
        ml2.setMealList(l2);
        ml1.setMealList(l2);
        assertEquals(ml2.getMealList(),ml1.getMealList());
    }

    @Test
    public void readMealListData() {

    }
}