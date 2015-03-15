package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;
import pl.edu.agh.planner.hibernate.entity.dictionary.Dictionary;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
// jednostka programu studiow (skladowa agregatu)
public class ProgrammeUnit {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "programmeUnit")
    private Set<Aggregate> aggregates;

    @ManyToOne
    @JoinColumn
    private Dictionary type;
}
