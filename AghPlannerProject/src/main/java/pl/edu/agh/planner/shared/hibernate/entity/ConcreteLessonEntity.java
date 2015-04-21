package pl.edu.agh.planner.shared.hibernate.entity;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class ConcreteLessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "cl_aggregate_id")
    private AggregateEntity aggregate;

    @ManyToOne
    @JoinColumn(name = "cl_schedule_id")
    private ScheduleEntity schedule;

    @OneToOne
    @JoinColumn(name = "cl_classroom_hour_id")
    private ClassroomHourEntity classroomHourEntity;

    @OneToOne
    @JoinColumn(name = "cl_concrete_date_id")
    private ConcreteDateEntity concreteDateEntity;

}
