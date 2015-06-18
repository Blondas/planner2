package pl.edu.agh.planner.domain;

import javax.persistence.*;

@Entity(name = "concrete_lesson")
public class ConcreteLessonEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "cl_aggregate_id")
    private AggregateEntity aggregate;

    @ManyToOne
    @JoinColumn(name = "cl_schedule_id")
    private ScheduleEntity schedule;

    @OneToOne
    @JoinColumn(name = "cl_classroom_hour_id")
    private ClassroomHourEntity classroomHour;

    //@OneToOne old - do przemyslenia
    @ManyToOne
    @JoinColumn(name = "cl_concrete_date_id")
    private ConcreteDateEntity concreteDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AggregateEntity getAggregate() {
        return aggregate;
    }

    public void setAggregate(AggregateEntity aggregate) {
        this.aggregate = aggregate;
    }

    public ScheduleEntity getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleEntity schedule) {
        this.schedule = schedule;
    }

    public ClassroomHourEntity getClassroomHour() {
        return classroomHour;
    }

    public void setClassroomHour(ClassroomHourEntity classroomHour) {
        this.classroomHour = classroomHour;
    }

    public ConcreteDateEntity getConcreteDate() {
        return concreteDate;
    }

    public void setConcreteDate(ConcreteDateEntity concreteDate) {
        this.concreteDate = concreteDate;
    }
}
