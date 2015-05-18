package pl.edu.agh.planner.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
// sk³adowa agregatu
public class AvatarEntity {
    @Id
    @GeneratedValue
    @Column(name = "av_id")
    private Long id;

    @Column(name = "av_name")
    private String name;

    @OneToMany(mappedBy = "avatar")
    private Set<AggregateEntity> aggregates;

    @OneToMany(mappedBy = "avatar")
    private Set<TeacherEntity> teachers;

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

    public Set<AggregateEntity> getAggregates() {
        return aggregates;
    }

    public void setAggregates(Set<AggregateEntity> aggregates) {
        this.aggregates = aggregates;
    }

    public Set<TeacherEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherEntity> teachers) {
        this.teachers = teachers;
    }
}
