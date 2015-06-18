package pl.edu.agh.planner.dto;


public class ClassroomHour implements java.io.Serializable{
    private Long id;
    private int lessonBeginId;
    private int lessonEndId;
    private Classroom classroom;

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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
