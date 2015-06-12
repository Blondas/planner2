package pl.edu.agh.planner.dto;

public class Aggregate {

    private Long id;
    private Avatar avatar;
    private ProgrammeUnit programmeUnit;
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
