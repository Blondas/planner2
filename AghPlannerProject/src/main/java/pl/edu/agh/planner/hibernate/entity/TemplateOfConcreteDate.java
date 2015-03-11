package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class TemplateOfConcreteDate {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy="templateOfConcreteDate")
    private Set<ConcreteDate> concreteDates;

    @ManyToOne
    @JoinColumn
    private SetOfTerms setOfTerms;
}
