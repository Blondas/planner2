package pl.edu.agh.planner.shared.hibernate.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class FacultyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private int id;

    @Column(name = "f_name")
    private String name;

}
