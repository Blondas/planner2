package pl.edu.agh.planner.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Aggregate implements java.io.Serializable{

    private Long id;
    @JsonBackReference(value = "avatar-aggregate")
    private Avatar avatar;
//    @JsonManagedReference(value = "programmeUnit-aggregate")
    private ProgrammeUnit programmeUnit;
//    @JsonManagedReference(value = "studentGroup-aggregate")
    private StudentGroup studentGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
