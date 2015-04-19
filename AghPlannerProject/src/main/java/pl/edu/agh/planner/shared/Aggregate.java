package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public class Aggregate implements IsSerializable, Serializable {

    private int id;
    private Avatar avatar;
    private ProgrammeUnit programmeUnit;
    private StudentGroup studentGroup;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public ProgrammeUnit getProgrammeUnit() {
        return programmeUnit;
    }

    public void setProgrammeUnit(ProgrammeUnit programmeUnit) {
        this.programmeUnit = programmeUnit;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }
}
