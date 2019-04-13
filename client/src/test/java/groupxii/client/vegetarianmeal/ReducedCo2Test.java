package groupxii.client.vegetarianmeal;

import org.junit.Test;

import static groupxii.client.vegetarianmeal.ReducedCo2.getReducedCo2;
import static org.junit.Assert.*;

public class ReducedCo2Test {

    @Test
    public void getReducedCo2Test() {
        assertTrue(getReducedCo2("APPLES", 100, "BANANAS", 100).contains("{\"reducedCO2\":"));
    }
}