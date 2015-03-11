package pl.edu.agh.planner.hibernate.entity.general;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    private String login;

    private String password;

    //TODO: crete setter
    private String passwordMd5;

    @OneToMany(mappedBy = "user")
    private Set<Authorization> authorizations;
}
