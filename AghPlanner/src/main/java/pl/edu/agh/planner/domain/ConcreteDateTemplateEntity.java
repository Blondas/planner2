package pl.edu.agh.planner.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ConcreteDateTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdt_id")
    private Long id;

    @Column(name = "cdt_name")
    private String name;

    @OneToMany(mappedBy="concreteDateTemplate")
    private Set<ConcreteDateEntity> concreteDates;

    @ManyToOne
    @JoinColumn(name = "cdt_terms_set_id")
    private TermsSetEntity termsSet;

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

    public Set<ConcreteDateEntity> getConcreteDates() {
        return concreteDates;
    }

    public void setConcreteDates(Set<ConcreteDateEntity> concreteDates) {
        this.concreteDates = concreteDates;
    }

    public TermsSetEntity getTermsSet() {
        return termsSet;
    }

    public void setTermsSet(TermsSetEntity termsSet) {
        this.termsSet = termsSet;
    }
}
