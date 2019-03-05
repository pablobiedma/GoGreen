package server;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VegetarianMealUsageRepository extends MongoRepository<VegetarianMealEntry, String> {
    public VegetarianMealEntry getByUserId(long userId);
    public List<VegetarianMealEntry> getByVegetarianMeal(String vegetarianMeal, int points, int co2);
}
