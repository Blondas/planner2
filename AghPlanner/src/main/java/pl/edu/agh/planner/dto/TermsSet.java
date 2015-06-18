package pl.edu.agh.planner.dto;

import java.util.Set;

public class TermsSet implements java.io.Serializable{

    private Long id;
    private Set<ConcreteDateTemplate> concreteDateTemplates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ConcreteDateTemplate> getConcreteDateTemplates() {
        return concreteDateTemplates;
    }

    public void setConcreteDateTemplates(Set<ConcreteDateTemplate> concreteDateTemplates) {
        this.concreteDateTemplates = concreteDateTemplates;
    }
}
