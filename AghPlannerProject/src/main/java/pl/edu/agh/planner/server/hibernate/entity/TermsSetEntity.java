package pl.edu.agh.planner.server.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class TermsSetEntity {
    @Id
    @GeneratedValue
    @Column(name = "ts_id")
    private int id;

    @OneToMany(mappedBy="termsSet")
    private Set<ConcreteDateTemplateEntity> concreteDateTemplateEntities;

}
