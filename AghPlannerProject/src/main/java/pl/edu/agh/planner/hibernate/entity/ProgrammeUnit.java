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
//    @Column(name = "pu_id")
    private int id;

    @ManyToOne
    @JoinColumn //(name = "pu_type")
    private Dictionary type;

    @OneToMany(mappedBy = "programmeUnit")
    private Set<Aggregate> aggregates;

}
