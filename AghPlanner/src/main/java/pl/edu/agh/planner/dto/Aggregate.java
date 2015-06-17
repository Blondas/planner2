package pl.edu.agh.planner.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Aggregate {

    private Long id;
    @JsonBackReference(value = "avatar-aggregate")
    private Avatar avatar;
    @JsonBackReference(value = "programmeUnit-aggregate")
    private ProgrammeUnit programmeUnit;
    @JsonBackReference(value = "studentGroup-aggregate")
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
