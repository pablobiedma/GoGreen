package groupxii.client.vegetarianmeal;

import groupxii.client.connector.Connector;
import org.junit.Test;

import static groupxii.client.vegetarianmeal.ReducedCo2.getReducedCo2;
import static org.junit.Assert.*;

public class ReducedCo2Test {

    @Test
    public void getReducedCo2Test() {
        if(Connector.getRequest("/getMealNameList") != "An error has occured"){
            assertTrue(getReducedCo2("APPLES", 100, "BANANAS", 100).contains("{\"reducedCO2\":"));
        }
        else{
            assertTrue(getReducedCo2("APPLES", 100, "BANANAS", 100).contains("An error has occured"));
        }
    }
}