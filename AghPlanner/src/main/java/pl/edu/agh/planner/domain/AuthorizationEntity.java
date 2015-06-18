package pl.edu.agh.planner.domain;

import javax.persistence.*;

@Entity(name = "authorization")
public class AuthorizationEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "a_type_id")
    private AuthorizationTypeEntity type;

    @ManyToOne
    @JoinColumn(name = "a_user_id")
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
