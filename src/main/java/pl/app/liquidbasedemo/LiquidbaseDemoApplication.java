package pl.app.liquidbasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.app.liquidbasedemo.services.DbService;

@SpringBootApplication
public class LiquidbaseDemoApplication {

    @Autowired
    private DbService dbService;

    public static void main(String[] args) {
        SpringApplication.run(LiquidbaseDemoApplication.class, args);
    }
}
