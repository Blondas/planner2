package pl.edu.agh.planner.shared.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Set<AuthorizationEntity> authorizations;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public void setPasswordMd5(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }

    public Set<AuthorizationEntity> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(Set<AuthorizationEntity> authorizations) {
        this.authorizations = authorizations;
    }
}
