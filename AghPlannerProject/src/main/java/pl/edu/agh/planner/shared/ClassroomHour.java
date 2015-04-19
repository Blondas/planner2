package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public class ClassroomHour implements IsSerializable, Serializable {
    private int id;
    private int lessonBeginId;
    private int lessonEndId;
    private Classroom classroom;

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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
