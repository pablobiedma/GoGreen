package groupxii.vegetarianmeal;

import groupxii.database.Database;
import groupxii.database.MealEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveMeal {

    private MealEntry mealEntry;
    private List<Meal> mealList = new ArrayList<Meal>();

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public MealEntry getMealEntry() {
        return mealEntry;
    }

    /**
     * Save the existing MealData.
     */
    public void saveMealData(long userId, String goodFoodName,
                             String badFoodName, int goodServingSize,
                             int badServingSize, int reducedCo2)
            throws IOException {
        //Maybe add points later, don't know how we are goin to calculate that right now.
        MealEntry entry = new MealEntry(userId, goodFoodName,
                badFoodName, goodServingSize, badServingSize,
                reducedCo2);
        Database.instance.saveNonBlocking(entry);
        this.mealEntry = entry;
    }
}
