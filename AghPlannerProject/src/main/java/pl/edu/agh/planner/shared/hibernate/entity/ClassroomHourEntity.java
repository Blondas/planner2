package pl.edu.agh.planner.shared.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ClassroomHourEntity {
    @Id
    @GeneratedValue
    @Column(name = "ch_id")
    private int id;

    @Column(name = "ch_lesson_begin_id")
    private int lessonBeginId;

    @Column(name = "ch_lesson_end_id")
    private int lessonEndId;

    @ManyToOne
    @JoinColumn(name = "ch_classroom_id")
    private ClassroomEntity classroom;
}
