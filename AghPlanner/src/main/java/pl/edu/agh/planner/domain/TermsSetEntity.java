package pl.edu.agh.planner.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "terms_set")
public class TermsSetEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ts_id")
    private int id;

    @OneToMany(mappedBy="termsSet")
    private Set<ConcreteDateTemplateEntity> concreteDateTemplates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<ConcreteDateTemplateEntity> getConcreteDateTemplates() {
        return concreteDateTemplates;
    }

    public void setConcreteDateTemplates(Set<ConcreteDateTemplateEntity> concreteDateTemplates) {
        this.concreteDateTemplates = concreteDateTemplates;
    }
}
