package pl.app.liquidbasedemo.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.app.liquidbasedemo.data.mysql.entity.Dog;

@SpringBootTest
public class DbServiceTestSuite {

    @Autowired
    private DbService dbService;

    @Test
    public void shouldSaveDog() {
        //given
        Dog dog = new Dog();
        dog.setName("A");

        //when
        Dog saved = dbService.save(dog);

        //then
        Assertions.assertEquals(saved.getName(), dog.getName());
    }
}
