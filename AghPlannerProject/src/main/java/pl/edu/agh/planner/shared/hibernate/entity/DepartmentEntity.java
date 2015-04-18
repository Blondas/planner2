package pl.edu.agh.planner.shared.hibernate.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class DepartmentEntity {


    @Id
    @GeneratedValue
    @Column(name = "d_id")
    private int id;

    @Column(name = "d_name")
    private String name;

}
