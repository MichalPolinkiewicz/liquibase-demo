package pl.app.liquibasedemo.data.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.app.liquibasedemo.data.mysql.entity.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {

    Dog save(Dog dog);
}
