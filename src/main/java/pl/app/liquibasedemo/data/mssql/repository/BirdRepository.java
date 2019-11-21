package pl.app.liquibasedemo.data.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.app.liquibasedemo.data.mssql.entity.Bird;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Integer> {

    Bird save(Bird bird);
}
