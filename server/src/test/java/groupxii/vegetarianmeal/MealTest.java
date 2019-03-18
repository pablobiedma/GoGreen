package groupxii.vegetarianmeal;

import org.junit.Test;

import static org.junit.Assert.*;

public class MealTest {

    @Test
    public void getServingSize() {
       Meal m = new Meal("apple",10,2.5);
       assertEquals(2.5,m.getServingSize(),0);
    }

    @Test
    public void getCo2() {
        Meal m = new Meal("apple",10,2.5);
        assertEquals(10,m.getCo2());
    }

    @Test
    public void getFood() {
        Meal m = new Meal("apple",10,2.5);
        assertEquals("apple",m.getFood());
    }

    @Test
    public void setCo2() {
        Meal m1 = new Meal("apple",10,2.5);
        Meal m2 = new Meal("apple",12,2.5);
        m1.setCo2(12);
        assertEquals(m1.getCo2(),m2.getCo2());
    }

    @Test
    public void setFood() {
        Meal m1 = new Meal("apple",10,2.5);
        Meal m2 = new Meal("pear",10,2.5);
        m1.setFood("pear");
        assertEquals(m1.getFood(),m2.getFood());
    }

    @Test
    public void setServingSize() {
        Meal m1 = new Meal("apple",10,2.5);
        Meal m2 = new Meal("apple",10,3.5);
        m1.setServingSize(3.5);
        assertEquals(m1.getServingSize(),m2.getServingSize(),0);
    }
}