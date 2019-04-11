package groupxii.client.connector;

public class VegetarianMealConnector {
    public static String retrieveMealList() {
        String resource = "/mealNameList";
        return Connector.getRequest(resource);
    }

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
