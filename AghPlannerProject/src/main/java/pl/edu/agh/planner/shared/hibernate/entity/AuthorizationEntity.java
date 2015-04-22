package pl.edu.agh.planner.shared.hibernate.entity;

import javax.persistence.*;

@Entity
public class AuthorizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "a_type_id")
    private AuthorizationTypeEntity type;

    @ManyToOne
    @JoinColumn(name = "a_user_id")
    private UserEntity user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AuthorizationTypeEntity getType() {
        return type;
    }

    public void setType(AuthorizationTypeEntity type) {
        this.type = type;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
