package groupxii.client.vegetarianmeal;

import groupxii.client.connector.VegetarianMealConnector;

public class ReducedCo2 {

    /**
     * get the reduced CO2 of a meal.
     * @param goodFoodName name of the good food
     * @param goodServingSize size of the good food
     * @param badFoodName name of the bad food
     * @param badServingSize size of the bad food
     * @return String with the reduced CO2 amount
     */
    public static String getReducedCo2(String goodFoodName,
                                       int goodServingSize,
                                       String badFoodName,
                                       int badServingSize) {
        String result = VegetarianMealConnector
                .calculateCO2Reduction(goodFoodName,
                        goodServingSize,
                        badFoodName,
                        badServingSize);
        return result;
    }
}
