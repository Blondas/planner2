package pl.edu.agh.planner.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

public class Classroom implements java.io.Serializable{

    private Long id;
    private String number;
    @JsonBackReference(value = "building_classrooms")
    private Building building;
    private int numberOfSeats;
    @JsonManagedReference(value = "classroom_classroomHours")
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
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
