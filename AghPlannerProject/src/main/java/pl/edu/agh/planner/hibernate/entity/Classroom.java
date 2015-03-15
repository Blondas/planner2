package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Classroom {
    @Id
    @GeneratedValue
//    @Column(name = "c_id")
    private int id;

//    @Column(name = "c_number")
    private int number;

//    @Column(name = "c_building_id")
    private int buildingId;

//    @Column(name = "c_number_of_seats")
    private int numberOfSeats;

    @OneToMany(mappedBy = "classroom")
    private Set<ClassroomHour> classroomHours;
}
