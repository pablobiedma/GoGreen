package groupxii.client.solarpanels;


import groupxii.client.connector.Connector;
import org.junit.Test;

import static groupxii.client.solarpanels.ReducedCo2.getReducedCo2;
import static org.junit.Assert.assertTrue;

public class ReducedCo2Test {
    @Test
    public void getReducedCo2Test() {
        if(Connector.getRequest("/getPanelNameList") != "An error has occured"){
            assertTrue(getReducedCo2("Monocrystalline", 100).contains("{\"reducedCO2\":"));
        }
        else{
            assertTrue(getReducedCo2("Monocrystalline", 100).contains("An error has occured"));
        }
    }

}
