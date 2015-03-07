package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

@Data
public class AppUser {

    private final String login;

    public AppUser(String login) {
        this.login = login;

    };
}
