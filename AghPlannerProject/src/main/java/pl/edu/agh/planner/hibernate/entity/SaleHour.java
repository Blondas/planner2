package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SaleHour {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    private Lesson lesson;

    private int lessonBeginId;

    private int lessonEndId;

    @ManyToOne
    @JoinColumn
    private Sale sale;
}
