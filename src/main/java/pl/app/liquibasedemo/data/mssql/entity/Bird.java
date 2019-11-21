package pl.app.liquibasedemo.data.mssql.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Bird {

    @Id
    @GeneratedValue
    private int id;
    private String name;
}
