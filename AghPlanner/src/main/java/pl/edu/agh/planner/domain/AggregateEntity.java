package pl.edu.agh.planner.domain;

import javax.persistence.*;

@Entity(name = "aggregate")
public class AggregateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ag_avatar_id")
    private AvatarEntity avatar;

    @ManyToOne
    @JoinColumn(name = "ag_programme_unit_id")
    private ProgrammeUnitEntity programmeUnit;

    @ManyToOne
    @JoinColumn(name = "ag_student_group_id")
    private StudentGroupEntity studentGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AvatarEntity getAvatar() {
        return avatar;
    }

    public void setAvatar(AvatarEntity avatar) {
        this.avatar = avatar;
    }

    public ProgrammeUnitEntity getProgrammeUnit() {
        return programmeUnit;
    }

    public void setProgrammeUnit(ProgrammeUnitEntity programmeUnit) {
        this.programmeUnit = programmeUnit;
    }

    public StudentGroupEntity getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroupEntity studentGroup) {
        this.studentGroup = studentGroup;
    }
}
