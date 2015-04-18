package pl.edu.agh.planner.shared.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class ConcreteDateTemplateEntity {
    @Id
    @GeneratedValue
    @Column(name = "cdt_id")
    private int id;

    @Column(name = "cdt_name")
    private String name;

    @OneToMany(mappedBy="concreteDateTemplate")
    private Set<ConcreteDateEntity> concreteDateEntities;

    @ManyToOne
    @JoinColumn(name = "cdt_terms_set_id")
    private TermsSetEntity termsSet;
}
