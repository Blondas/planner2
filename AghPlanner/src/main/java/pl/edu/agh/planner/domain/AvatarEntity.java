package pl.edu.agh.planner.domain;

import javax.persistence.*;
import java.util.Set;

<<<<<<< HEAD:AghPlanner/src/main/java/pl/edu/agh/planner/domain/AvatarEntity.java
@Entity(name = "avatar")
// skï¿½adowa agregatu
=======
@Entity
// sk³adowa agregatu
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6:AghPlanner/src/main/java/pl/edu/agh/planner/domain/AvatarEntity.java
public class AvatarEntity {
    @Id
    @GeneratedValue
    @Column(name = "av_id")
    private Long id;

    @Column(name = "av_name")
    private String name;

    @OneToMany(mappedBy = "avatar", fetch = FetchType.EAGER)
    private Set<AggregateEntity> aggregates;

    @OneToMany(mappedBy = "avatar", fetch = FetchType.EAGER)
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
