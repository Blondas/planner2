package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Aggregate {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "aggregate")
    private Set<Lesson> lessons;

    @ManyToOne
    @JoinColumn
    private Avatar avatar;

    @ManyToOne
    @JoinColumn
    private CurriculumUnit curriculumUnit;

    @ManyToOne
    @JoinColumn
    private StudentGroup studentGroup;
}
