package pl.edu.agh.planner.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "classroom")
public class ClassroomEntity implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long id;

    @Column(name = "c_number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "c_building_id")
    private BuildingEntity building;

    @Column(name = "c_number_of_seats")
    private int numberOfSeats;

    @OneToMany(mappedBy = "classroom", fetch = FetchType.EAGER)
    private Set<ClassroomHourEntity> classroomHours;

    public ClassroomEntity() {
    }

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

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
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
