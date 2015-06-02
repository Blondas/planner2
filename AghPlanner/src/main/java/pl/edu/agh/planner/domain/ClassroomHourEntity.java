package pl.edu.agh.planner.domain;

import javax.persistence.*;

@Entity
public class ClassroomHourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ch_id")
    private Long id;

    @Column(name = "ch_lesson_begin_id")
    private int lessonBeginId;

    @Column(name = "ch_lesson_end_id")
    private int lessonEndId;

    @ManyToOne
    @JoinColumn(name = "ch_classroom_id")
    private ClassroomEntity classroom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
