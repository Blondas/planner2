package pl.edu.agh.planner.shared;


import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;
import java.util.Set;

public class ProgrammeUnit implements IsSerializable, Serializable {

    private int id;
    private String name;
    private ProgrammeUnitType type;
    private Set<Aggregate> aggregates;

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

    public ProgrammeUnitType getType() {
        return type;
    }

    public void setType(ProgrammeUnitType type) {
        this.type = type;
    }

    public Set<Aggregate> getAggregates() {
        return aggregates;
    }

    public void setAggregates(Set<Aggregate> aggregates) {
        this.aggregates = aggregates;
    }
}
