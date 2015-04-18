package pl.edu.agh.planner.shared.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AggregateEntity {
    @Id
    @GeneratedValue
    @Column(name = "ag_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ag_avatar_id")
    private AvatarEntity avatar;

    @ManyToOne
    @JoinColumn(name = "ag_programme_unit_id")
    private ProgrammeUnitEntity programmeUnit;

    @ManyToOne
    @JoinColumn(name = "ag_student_group_id")
    private StudentGroupEntity studentGroup;
}
