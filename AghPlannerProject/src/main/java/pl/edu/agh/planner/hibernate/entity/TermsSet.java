package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class TermsSet {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy="termsSet")
    private Set<ConcreteDateTemplate> concreteDateTemplates;

}
