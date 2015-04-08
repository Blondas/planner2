package pl.edu.agh.planner.hibernate.entity.general;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Authorization {
    @Id
    @GeneratedValue
    @Column(name = "a_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "a_type_id")
    private AuthorizationType type;

    @ManyToOne
    @JoinColumn(name = "a_user_id")
    private User user;
}
