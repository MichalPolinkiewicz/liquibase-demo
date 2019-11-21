package pl.app.liquibasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.app.liquibasedemo.services.DbService;

@SpringBootApplication
public class LiquidbaseDemoApplication {

    @Autowired
    private DbService dbService;

    public static void main(String[] args) {
        SpringApplication.run(LiquidbaseDemoApplication.class, args);
    }
}
