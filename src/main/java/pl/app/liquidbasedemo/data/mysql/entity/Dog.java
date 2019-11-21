package pl.app.liquidbasedemo.data.mysql.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Dog {

    @Id
    @GeneratedValue
    private int id;
    private String name;
}
