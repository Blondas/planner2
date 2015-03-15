package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class ConcreteDateTemplate {
    @Id
    @GeneratedValue
//    @Column(name = "cdt_id")
    private int id;

//    @Column(name = "cdt_name")
    private String name;

    @OneToMany(mappedBy="concreteDateTemplate")
    private Set<ConcreteDate> concreteDates;

    @ManyToOne
    @JoinColumn //(name = "cdt_terms_set_id")
    private TermsSet termsSet;
}
