package pl.edu.agh.planner.shared.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProgrammeUnitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pu_id")
    private int id;


    @Column(name = "pu_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "pu_type_id")
    private ProgrammeUnitTypeEntity type;


    @OneToMany(mappedBy = "programmeUnit")
    private Set<AggregateEntity> aggregates;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProgrammeUnitTypeEntity getType() {
        return type;
    }

    public void setType(ProgrammeUnitTypeEntity type) {
        this.type = type;
    }

    public Set<AggregateEntity> getAggregates() {
        return aggregates;
    }

    public void setAggregates(Set<AggregateEntity> aggregates) {
        this.aggregates = aggregates;
    }
}
