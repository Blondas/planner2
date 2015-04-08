package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ProgrammeUnitType {

    @Id
    @GeneratedValue
    @Column(name = "put_id")
    private int id;

    @Column(name = "put_name")
    private String name;
}
