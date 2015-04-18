package pl.edu.agh.planner.shared.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class ProgrammeUnitEntity {
    @Id
    @GeneratedValue
    @Column(name = "pu_id")
    private int id;


    @Column(name = "pu_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "pu_type_id")
    private ProgrammeUnitTypeEntity type;


    @OneToMany(mappedBy = "programmeUnit")
    private Set<AggregateEntity> aggregates;

}
