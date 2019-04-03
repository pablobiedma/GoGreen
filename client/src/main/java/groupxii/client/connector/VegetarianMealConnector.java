package groupxii.client.connector;

import groupxii.client.vegetarianmeal.MealList;

public class VegetarianMealConnector {
	public static MealList retrieveMealList() {
		String resource = "/getMealList";
		return new MealList(Connector.getRequest(resource));
	}
}
