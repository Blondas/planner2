package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
// składowa agregatu
public class Avatar {
    @Id
    @GeneratedValue
//    @Column(name = "av_id")
    private int id;

//    @Column(name = "av_name")
    private int name;

    @OneToMany(mappedBy = "avatar")
    private Set<Aggregate> aggregates;

    @OneToMany(mappedBy = "avatar")
    private Set<Teacher> teachers;
}
