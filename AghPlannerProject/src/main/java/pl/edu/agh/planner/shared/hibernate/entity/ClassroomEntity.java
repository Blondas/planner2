package pl.edu.agh.planner.shared.hibernate.entity;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class ClassroomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private int id;

    @Column(name = "c_number")
    private int number;

    @Column(name = "c_building_id")
    private int buildingId;

    @Column(name = "c_number_of_seats")
    private int numberOfSeats;

    @OneToMany(mappedBy = "classroom")
    private Set<ClassroomHourEntity> classroomHourEntities;
}
