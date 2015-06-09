package pl.edu.agh.planner.dto;


import java.util.Set;

public class Classroom{

    private Long id;
    private String number;
    private int buildingId;
    private int numberOfSeats;
    private Set<ClassroomHour> classroomHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Set<ClassroomHour> getClassroomHours() {
        return classroomHours;
    }

    public void setClassroomHours(Set<ClassroomHour> classroomHours) {
        this.classroomHours = classroomHours;
    }
}
