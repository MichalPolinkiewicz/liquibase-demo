package pl.app.liquidbasedemo.data.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.app.liquidbasedemo.data.mysql.entity.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {

    Dog save(Dog dog);
}
