package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Aggregate {
    @Id
    @GeneratedValue
    @Column(name = "ag_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ag_avatar_id")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn(name = "ag_programme_unit_id")
    private ProgrammeUnit programmeUnit;

    @ManyToOne
    @JoinColumn(name = "ag_student_group_id")
    private StudentGroup studentGroup;
}
