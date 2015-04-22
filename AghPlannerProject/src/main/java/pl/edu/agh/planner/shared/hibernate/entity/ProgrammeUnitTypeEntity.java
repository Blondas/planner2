package pl.edu.agh.planner.shared.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProgrammeUnitTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "put_id")
    private int id;

    @Column(name = "put_name")
    private String name;
}
