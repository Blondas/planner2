package pl.edu.agh.planner.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

public class ProgrammeUnit implements java.io.Serializable{

    private Long id;
    private String name;
    private ProgrammeUnitType type;
//    @JsonBackReference(value = "programmeUnit-aggregate")
//    private Set<Aggregate> aggregates;

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

    public ProgrammeUnitType getType() {
        return type;
    }

    public void setType(ProgrammeUnitType type) {
        this.type = type;
    }

//    public Set<Aggregate> getAggregates() {
//        return aggregates;
//    }

//    public void setAggregates(Set<Aggregate> aggregates) {
//        this.aggregates = aggregates;
//    }
}
