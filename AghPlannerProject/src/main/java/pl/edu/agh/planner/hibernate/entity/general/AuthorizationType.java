package pl.edu.agh.planner.hibernate.entity.general;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class AuthorizationType {

    @Id
    @GeneratedValue
    @Column(name = "at_id")
    private int id;

    @Column(name = "at_name")
    private String name;




}
