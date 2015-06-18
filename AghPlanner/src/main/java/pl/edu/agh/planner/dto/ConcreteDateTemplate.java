package pl.edu.agh.planner.dto;

import java.util.Set;

public class ConcreteDateTemplate implements java.io.Serializable{

    private Long id;
    private String name;
    private Set<ConcreteDate> concreteDates;
    private TermsSet termsSet;

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

    public Set<ConcreteDate> getConcreteDates() {
        return concreteDates;
    }

    public void setConcreteDates(Set<ConcreteDate> concreteDates) {
        this.concreteDates = concreteDates;
    }

    public TermsSet getTermsSet() {
        return termsSet;
    }

    public void setTermsSet(TermsSet termsSet) {
        this.termsSet = termsSet;
    }
}
