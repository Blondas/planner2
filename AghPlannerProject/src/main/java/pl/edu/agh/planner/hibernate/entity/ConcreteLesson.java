package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class ConcreteLesson {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private Aggregate aggregate;

    @ManyToOne
    @JoinColumn
    private Schedule schedule;

    @OneToOne
    private ClassroomHour classroomHour;

    @OneToOne
    private ConcreteDate concreteDate;

}
