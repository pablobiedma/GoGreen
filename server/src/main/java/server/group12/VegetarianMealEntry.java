package server.group12;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class VegetarianMealEntry {

    @Id
    public ObjectId id;
    public int userId;
    public String vegetarianMeal;
    public int points;
    public int co2;

    public VegetarianMealEntry(int userId, String vegetarianMeal, int points, int co2) {
        this.userId = userId;
        this.vegetarianMeal = vegetarianMeal;
        this.points = points;
        this.co2 = co2;
    }

    public int getById() {
        return this.userId;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
