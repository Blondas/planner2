package pl.edu.agh.planner.shared.hibernate.entity;

import javax.persistence.*;

@Entity
public class ClassroomHourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ch_id")
    private int id;

    @Column(name = "ch_lesson_begin_id")
    private int lessonBeginId;

    @Column(name = "ch_lesson_end_id")
    private int lessonEndId;

    @ManyToOne
    @JoinColumn(name = "ch_classroom_id")
    private ClassroomEntity classroom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLessonBeginId() {
        return lessonBeginId;
    }

    public void setLessonBeginId(int lessonBeginId) {
        this.lessonBeginId = lessonBeginId;
    }

    public int getLessonEndId() {
        return lessonEndId;
    }

    public void setLessonEndId(int lessonEndId) {
        this.lessonEndId = lessonEndId;
    }

    public ClassroomEntity getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomEntity classroom) {
        this.classroom = classroom;
    }
}
