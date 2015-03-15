package pl.edu.agh.planner.hibernate.entity.general;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "us_id")
    private int id;

    @Column(name = "us_login")
    private String login;

    @Column(name = "us_password")
    private String password;

    //TODO: crete setter
    @Column(name = "us_password_md5")
    private String passwordMd5;

    @OneToMany(mappedBy = "user")
    private Set<Authorization> authorizations;
}
