package pl.edu.agh.planner.shared.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class LetterDesignationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ld_id")
    private int id;

    @Column(name = "ld_name")
    private String name;
}
