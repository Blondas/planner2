package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Lesson {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "lesson")
    private Set<SetOfTerms> setOfTermses;

    @OneToMany(mappedBy = "lesson")
    private Set<SaleHour> saleHours;

    @ManyToOne
    @JoinColumn
    private Aggregate aggregate;

    @ManyToOne
    @JoinColumn
    private LessonSchedule lessonSchedule;
}
