package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import pl.edu.agh.planner.hibernate.entity.general.User;

@Data
@Entity
public class Schedule {
    @Id
    @GeneratedValue
    @Column(name = "s_id")
    private int id;

    @OneToMany(mappedBy = "schedule")
    private Set<ConcreteLesson> concreteLessons;

    @Column(name = "s_name")
    private String name;

    @Column(name = "s_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "s_user_id")
    private User user;
}
