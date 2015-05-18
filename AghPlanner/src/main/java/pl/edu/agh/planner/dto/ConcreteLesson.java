package pl.edu.agh.planner.dto;

public class ConcreteLesson {

    private Long id;
    private Aggregate aggregate;
    private Schedule schedule;
    private ClassroomHour classroomHour;
    private ConcreteDate concreteDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aggregate getAggregate() {
        return aggregate;
    }

    public void setAggregate(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public ClassroomHour getClassroomHour() {
        return classroomHour;
    }

    public void setClassroomHour(ClassroomHour classroomHour) {
        this.classroomHour = classroomHour;
    }

    public ConcreteDate getConcreteDate() {
        return concreteDate;
    }

    public void setConcreteDate(ConcreteDate concreteDate) {
        this.concreteDate = concreteDate;
    }
}
