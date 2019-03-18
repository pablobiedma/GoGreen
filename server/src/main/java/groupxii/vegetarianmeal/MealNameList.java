package groupxii.vegetarianmeal;

import java.util.List;

public class MealNameList {

    private String result = "";
    private List<Meal> mealList;

    public void setGetMealData(List<Meal> mealData) {
        this.mealList = mealData;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    /**
     * Human-friendly String representation of MealNameList.
     */
    public String getMealNameList() {
        //mealList = GetMealData.getMealList();
        for (int j = 0; j < mealList.size(); j++) {
            result = result + mealList.get(j).getFood() + ", ";
        }
        result = result.substring(0, result.length() - 2);
        System.out.println("result: " + result + "\n");
        return result;
    }
}
