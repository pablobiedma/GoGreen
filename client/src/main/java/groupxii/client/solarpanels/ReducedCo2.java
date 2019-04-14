package groupxii.client.solarpanels;

import groupxii.client.connector.SolarPanelConnector;

public class ReducedCo2 {
    /**
     * get the reduced CO2 of a panelList.
     * @param panel
     * @param amount
     * @return
     */
    public static String getReducedCo2(String panel, int amount) {
        String result = SolarPanelConnector
                .calculateCO2Reduction(panel, amount);
        return result;
    }
}
