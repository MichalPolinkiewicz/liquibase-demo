package pl.app.liquibasedemo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.app.liquibasedemo.data.mysql.entity.Dog;
import pl.app.liquibasedemo.data.mysql.repository.DogRepository;

@Service
@RequiredArgsConstructor
public class DbService {

    private final DogRepository dogRepository;

    public Dog save(Dog dog) {
        return dogRepository.save(dog);
    }

}
