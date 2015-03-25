package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Department {


    @Id
    @GeneratedValue
    @Column(name = "d_id")
    private int id;

    @Column(name = "d_name")
    private String name;

}
