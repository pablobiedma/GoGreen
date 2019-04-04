package groupxii.server;

import groupxii.database.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) throws IOException {
        Database.instance.startDb();
        SpringApplication.run(ServerApplication.class, args);
    }
}
