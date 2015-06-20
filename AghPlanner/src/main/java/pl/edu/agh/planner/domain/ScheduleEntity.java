package pl.edu.agh.planner.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "schedule")
public class ScheduleEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private Long id;

    @OneToMany(mappedBy = "schedule")
    private Set<ConcreteLessonEntity> concreteLesson;

    @Column(name = "s_name")
    private String name;

    @Column(name = "s_date")
    private Date date;

    @Column(name = "s_date_semester_begin")
    private Date dateSemesterBegin;

    @Column(name = "s_date_semester_end")
    private Date dateSemesterEnd;

    @ManyToOne
    @JoinColumn(name = "s_user_id")
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getDateSemesterBegin() {
        return dateSemesterBegin;
    }

    public void setDateSemesterBegin(Date dateSemesterBegin) {
        this.dateSemesterBegin = dateSemesterBegin;
    }

    public Date getDateSemesterEnd() {
        return dateSemesterEnd;
    }

    public void setDateSemesterEnd(Date dateSemesterEnd) {
        this.dateSemesterEnd = dateSemesterEnd;
    }
}
