package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue
    private int id;

    private String login;
}
