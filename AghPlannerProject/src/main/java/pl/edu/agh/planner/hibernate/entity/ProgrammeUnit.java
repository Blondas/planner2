package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
// jednostka programu studiow (skladowa agregatu)
public class ProgrammeUnit {
    @Id
    @GeneratedValue
    @Column(name = "pu_id")
    private int id;


    @Column(name = "pu_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "pu_type_id")
    private ProgrammeUnitType type;


    @OneToMany(mappedBy = "programmeUnit")
    private Set<Aggregate> aggregates;

}
