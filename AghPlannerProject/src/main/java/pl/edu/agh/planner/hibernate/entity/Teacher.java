package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String lastName;

    @ManyToOne
    @JoinColumn
    private Avatar avatar;
}
