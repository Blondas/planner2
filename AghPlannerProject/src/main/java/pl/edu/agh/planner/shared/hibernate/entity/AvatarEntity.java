package pl.edu.agh.planner.shared.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
// składowa agregatu
public class AvatarEntity {
    @Id
    @GeneratedValue
    @Column(name = "av_id")
    private int id;

    @Column(name = "av_name")
    private int name;

    @OneToMany(mappedBy = "avatar")
    private Set<AggregateEntity> aggregates;

    @OneToMany(mappedBy = "avatar")
    private Set<TeacherEntity> teachers;
}
