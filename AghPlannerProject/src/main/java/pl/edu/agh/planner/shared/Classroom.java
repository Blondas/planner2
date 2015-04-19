package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;
import java.util.Set;

public class Classroom implements IsSerializable, Serializable {

    private int id;
    private int number;
    private int buildingId;
    private int numberOfSeats;
    private Set<ClassroomHour> classroomHours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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
