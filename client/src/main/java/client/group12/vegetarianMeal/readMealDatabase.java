package client.group12.vegetarianMeal;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class readMealDatabase {

    private List<Meal> mealList;

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }


    public void readMealFile(){
        try{
            Scanner sc = new Scanner(new File(getClass().getClassLoader().getResource("mealDatabase.csv")))
        }
    }
}
