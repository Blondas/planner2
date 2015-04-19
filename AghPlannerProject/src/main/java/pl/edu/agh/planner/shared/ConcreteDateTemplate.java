package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;
import java.util.Set;

public class ConcreteDateTemplate implements IsSerializable, Serializable {

    private int id;
    private String name;
    private Set<ConcreteDate> concreteDates;
    private TermsSet termsSet;

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
