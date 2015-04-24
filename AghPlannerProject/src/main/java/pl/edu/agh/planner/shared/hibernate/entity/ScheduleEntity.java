package pl.edu.agh.planner.shared.hibernate.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private int id;

    @OneToMany(mappedBy = "schedule")
    private Set<ConcreteLessonEntity> concreteLesson;

    @Column(name = "s_name")
    private String name;

    @Column(name = "s_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "s_user_id")
    private UserEntity user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<ConcreteLessonEntity> getConcreteLesson() {
        return concreteLesson;
    }

    public void setConcreteLesson(Set<ConcreteLessonEntity> concreteLesson) {
        this.concreteLesson = concreteLesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
