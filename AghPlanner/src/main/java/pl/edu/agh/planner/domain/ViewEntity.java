package pl.edu.agh.planner.domain;

import javax.persistence.*;


@Entity(name = "view")
public class ViewEntity implements java.io.Serializable{
    @Id
    @SequenceGenerator(name="view_id_seq", sequenceName="view_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="view_id_seq")
    @Column(name = "v_id")
    private Long id;

    @Column(name = "v_name")
    private String name;

    @Column(name = "v_calendar")
    private boolean calendar;

    @Column(name = "v_teacher_container")
    private boolean teacherContainer;

    @Column(name = "v_avatar_container")
    private boolean avatarContainer;

    @Column(name = "v_aggregate_container")
    private boolean aggregateContainer;

    @Column(name = "v_student_group_container")
    private boolean studentGroupContainer;

    @Column(name = "v_programme_unit_container")
    private boolean programmeUnitContainer;

    public ViewEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getCalendar() {
        return calendar;
    }

    public void setCalendar(boolean calendar) {
        this.calendar = calendar;
    }

    public boolean getTeacherContainer() {
        return teacherContainer;
    }

    public void setTeacherContainer(boolean teacherContainer) {
        this.teacherContainer = teacherContainer;
    }

    public boolean getAvatarContainer() {
        return avatarContainer;
    }

    public void setAvatarContainer(boolean avatarContainer) {
        this.avatarContainer = avatarContainer;
    }

    public boolean getAggregateContainer() {
        return aggregateContainer;
    }

    public void setAggregateContainer(boolean aggregateContainer) {
        this.aggregateContainer = aggregateContainer;
    }

    public boolean getStudentGroupContainer() {
        return studentGroupContainer;
    }

    public void setStudentGroupContainer(boolean studentGroupContainer) {
        this.studentGroupContainer = studentGroupContainer;
    }

    public boolean getProgrammeUnitContainer() {
        return programmeUnitContainer;
    }

    public void setProgrammeUnitContainer(boolean programmeUnitContainer) {
        this.programmeUnitContainer = programmeUnitContainer;
    }

    @Override
    public String toString() {
        return "ViewEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calendar=" + calendar +
                ", teacherContainer=" + teacherContainer +
                ", avatarContainer=" + avatarContainer +
                ", aggregateContainer=" + aggregateContainer +
                ", studentGroupContainer=" + studentGroupContainer +
                ", programmeUnitContainer=" + programmeUnitContainer +
                '}';
    }
}
