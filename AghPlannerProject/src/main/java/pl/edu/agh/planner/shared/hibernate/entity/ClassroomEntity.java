package pl.edu.agh.planner.shared.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClassroomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private int id;

    @Column(name = "c_number")
    private String number;

    @Column(name = "c_building_id")
    private int buildingId;

    @Column(name = "c_number_of_seats")
    private int numberOfSeats;

    @OneToMany(mappedBy = "classroom")
    private Set<ClassroomHourEntity> classroomHours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Set<ClassroomHourEntity> getClassroomHours() {
        return classroomHours;
    }

    public void setClassroomHours(Set<ClassroomHourEntity> classroomHours) {
        this.classroomHours = classroomHours;
    }
}
