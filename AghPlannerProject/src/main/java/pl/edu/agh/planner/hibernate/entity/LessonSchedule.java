package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class LessonSchedule {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "lessonSchedule")
    private Set<Lesson> lessons;

    private String name;

    private Date date;

    private int operatorId;
}
