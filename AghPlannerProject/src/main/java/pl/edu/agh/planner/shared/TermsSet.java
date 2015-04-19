package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;
import java.util.Set;

public class TermsSet implements IsSerializable, Serializable {

    private int id;
    private Set<ConcreteDateTemplate> concreteDateTemplates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<ConcreteDateTemplate> getConcreteDateTemplates() {
        return concreteDateTemplates;
    }

    public void setConcreteDateTemplates(Set<ConcreteDateTemplate> concreteDateTemplates) {
        this.concreteDateTemplates = concreteDateTemplates;
    }
}
