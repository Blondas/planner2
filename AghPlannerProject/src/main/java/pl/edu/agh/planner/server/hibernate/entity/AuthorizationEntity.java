package pl.edu.agh.planner.server.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AuthorizationEntity {
    @Id
    @GeneratedValue
    @Column(name = "a_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "a_type_id")
    private AuthorizationTypeEntity type;

    @ManyToOne
    @JoinColumn(name = "a_user_id")
    private UserEntity user;
}
