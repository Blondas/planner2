package pl.edu.agh.planner.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class AppUser {
    @Id
    @GeneratedValue
    private int id;

    private String login;

    public AppUser() {
    }

    public AppUser(String login) {
        this.login = login;
    };
}
