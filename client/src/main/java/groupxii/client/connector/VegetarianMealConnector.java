package groupxii.client.connector;

public class VegetarianMealConnector {
	public static String retrieveMealList() {
		String resource = "/getMealList";
		return Connector.getRequest(resource);
	}

	public static String calculateCO2Reduction(String goodFoodName, int goodServingSize,
											String badFoodName, int badServingSize) {
		String resource = "/calculaeMeal"
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
