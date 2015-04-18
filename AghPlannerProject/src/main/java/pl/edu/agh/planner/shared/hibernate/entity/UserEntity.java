package pl.edu.agh.planner.shared.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "u_id")
    private int id;

    @Column(name = "u_login")
    private String login;

    @Column(name = "u_password")
    private String password;

    //TODO: crete setter
    @Column(name = "u_password_md5")
    private String passwordMd5;

    @OneToMany(mappedBy = "user")
    private Set<AuthorizationEntity> authorizationEntities;
}
