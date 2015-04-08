package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class LetterDesignation {

    @Id
    @GeneratedValue
    @Column(name = "ld_id")
    private int id;

    @Column(name = "ld_name")
    private String name;
}
