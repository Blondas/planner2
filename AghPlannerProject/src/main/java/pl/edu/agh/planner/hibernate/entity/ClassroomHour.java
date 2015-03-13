package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ClassroomHour {
    @Id
    @GeneratedValue
    private int id;

    private int lessonBeginId;

    private int lessonEndId;

    @ManyToOne
    @JoinColumn
    private Classroom classroom;
}
