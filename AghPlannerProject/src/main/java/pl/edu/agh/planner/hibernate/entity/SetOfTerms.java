package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class SetOfTerms {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy="setOfTerms")
    private Set<TemplateOfConcreteDate> templateOfConcreteDates;

    @ManyToOne
    @JoinColumn
    private Lesson lesson;
}
