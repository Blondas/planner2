package pl.edu.agh.planner.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "programme_unit")
public class ProgrammeUnitEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pu_id")
    private Long id;


    @Column(name = "pu_name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pu_type_id")
    private ProgrammeUnitTypeEntity type;


    @OneToMany(mappedBy = "programmeUnit", fetch = FetchType.EAGER)
    private Set<AggregateEntity> aggregates;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
