package client.group12.vegetarianMeal;

import java.io.IOException;
import java.lang.Math;
import java.util.List;

public class Calculations {

    private double calculatedCO2;
    private String food;
    private int co2;
    private double servingSize;
    private int reducedCO2;

    //this is the first calculation that is done. the Chosen food is looked up in the mealList and than the private values are updated
    // and the CO2 emmision is calculated.
    public double calculateCO2(String chosenFood, int chosenServingSize) throws IOException {
        MealAPI mealapi = new MealAPI();
        mealapi.readAPI();
        List<Meal> mealList = mealapi.getMealList();
        for(int i = 0; i < mealList.size(); i++){
            if(chosenFood.equals(mealList.get(i).getFood())){
                this.food = mealList.get(i).getFood();
                this.co2 = mealList.get(i).getCo2();
                this.servingSize = mealList.get(i).getServingSize();

                double co2PerGram = co2/servingSize;
                calculatedCO2 = co2PerGram*chosenServingSize;
            }
        }
        return calculatedCO2;
    }

    //this is the second calculation that is done, people also choose a bad food what they normally eat, so the reduced CO2 can be calculated.
    public int reducedCO2(String badFood, int chosenServingSize, double CO2GoodFood) throws IOException{
        this.reducedCO2 = (int) (calculateCO2(badFood, chosenServingSize) - CO2GoodFood);
        //System.out.println(reducedCO2);
        return this.reducedCO2;
    }

    //this is the last calculation that is done, the points for the user are calculated.
    public int calculatePoints(){
        return (int) this.reducedCO2*5;
    }
}
