package groupxii.server;

import groupxii.database.Database;
import groupxii.vegetarianMeal.GetMealData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        Database.instance.startDb();
        SpringApplication.run(ServerApplication.class, args);
    }
}
