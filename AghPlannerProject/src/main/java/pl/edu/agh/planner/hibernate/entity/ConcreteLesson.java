package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class ConcreteLesson {
    @Id
    @GeneratedValue
    @Column(name = "cl_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "cl_aggregate_id")
    private Aggregate aggregate;

    @ManyToOne
    @JoinColumn(name = "cl_schedule_id")
    private Schedule schedule;

    @OneToOne
    @JoinColumn(name = "cl_classroom_hour_id")
    private ClassroomHour classroomHour;

    @OneToOne
    @JoinColumn(name = "cl_concrete_date_id")
    private ConcreteDate concreteDate;

}
