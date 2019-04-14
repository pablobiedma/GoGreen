package groupxii.client.connector;

public class VegetarianMealConnector {
    public static String retrieveMealList() {
        String resource = "/getMealList";
        return Connector.getRequest(resource);
    }

    /**
     * calculate the reduced co2 of a meal.
     * @param goodFoodName name of the good food
     * @param goodServingSize size of the good food
     * @param badFoodName name of the bad food
     * @param badServingSize size of the bad food
     * @return String with the amount of reduced CO2
     */
    public static String calculateCO2Reduction(String goodFoodName, int goodServingSize,
                                               String badFoodName, int badServingSize) {
        String resource = "/calculateMeal"
                + "?" + goodFoodName
                + "&" + goodServingSize
                + "&" + badFoodName
                + "&" + badServingSize;

        return Connector.getRequest(resource);
    }

    public static String retrieveEatenMealList() {
        String resource = "/eatenMealList";
        return Connector.getRequest(resource);
    }
}
