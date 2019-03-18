package groupxii.vegetarianmeal;

public class Meal {

    private String food;
    private int co2;
    private double servingSize;

    /** This is a meal.
     * @param food the name of the foo
     * @param co2  the amount of co2 per serving
     * @param servingSize the serving size (has to be in grams)
     */

    public Meal(String food, int co2, double servingSize) {
        this.food = food;
        this.co2 = co2;
        this.servingSize = servingSize;
    }

    public double getServingSize() {
        return servingSize;
    }

    public int getCo2() {
        return co2;
    }

    public String getFood() {
        return food;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }
}
