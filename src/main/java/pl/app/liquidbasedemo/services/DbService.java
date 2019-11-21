package pl.app.liquidbasedemo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.app.liquidbasedemo.data.mysql.entity.Dog;
import pl.app.liquidbasedemo.data.mysql.repository.DogRepository;

@Service
@RequiredArgsConstructor
public class DbService {

    private final DogRepository dogRepository;

    public Dog save(Dog dog) {
        return dogRepository.save(dog);
    }

}
