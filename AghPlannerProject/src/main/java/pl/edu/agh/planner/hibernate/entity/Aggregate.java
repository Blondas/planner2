package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Aggregate {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    private Avatar avatar;

    @ManyToOne
    @JoinColumn
    private ProgrammeUnit programmeUnit;

    @ManyToOne
    @JoinColumn
    private StudentGroup studentGroup;
}
