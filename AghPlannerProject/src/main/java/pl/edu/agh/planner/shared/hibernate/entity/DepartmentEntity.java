package pl.edu.agh.planner.shared.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "d_id")
    private int id;

    @Column(name = "d_name")
    private String name;

}
