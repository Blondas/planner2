package pl.edu.agh.planner.shared.hibernate.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AuthorizationTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @Column(name = "at_name")
    private String name;




}
