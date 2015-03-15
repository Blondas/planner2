package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue
//    @Column(name = "t_id")
    private int id;

//    @Column(name = "t_name")
    private String name;

//    @Column(name = "t_last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn //(name = "t_avatar_id")
    private Avatar avatar;
}
