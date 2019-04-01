package groupxii.vegetarianmeal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalculatedMeal {
    private int reducedCO2;

    public CalculatedMeal(String goodFoodName, int goodServingSize,
                          String badFoodName, int badServingSize) {
	    this.reducedCO2 = 1;
	    int result = Calculations.calculateCO2(badFoodName, badServingSize);
	    result -= Calculations.calculateCO2(goodFoodName, goodServingSize);
	    this.reducedCO2 = result;
    }

    public int getReducedCO2() {
	    return this.reducedCO2;
    }
}
