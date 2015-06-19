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
    public boolean calendar;

    @Column(name = "v_teacher_container")
    public boolean teacherContainer;

    @Column(name = "v_avatar_container")
    public boolean avatarContainer;

    @Column(name = "v_aggregate_container")
    public boolean aggregateContainer;

    @Column(name = "v_student_group_container")
    public boolean studentGroupContainer;

    @Column(name = "v_programme_unit_container")
    public boolean programmeUnitContainer;

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
