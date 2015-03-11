package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Avatar {
    @Id
    @GeneratedValue
    private int id;

    private int name;

    @OneToMany(mappedBy = "avatar")
    private Set<Aggregate> aggregates;

    @OneToMany(mappedBy = "avatar")
    private Set<ConductorOfClass> conductorOfClasses;
}
