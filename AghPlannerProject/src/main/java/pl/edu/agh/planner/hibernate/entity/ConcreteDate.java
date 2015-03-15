package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ConcreteDate {
    @Id
    @GeneratedValue
//    @Column(name = "cd_id")
    private int id;

//    @Column(name = "cd_real_date")
    private Date realDate;

    @ManyToOne
    @JoinColumn //(name = "cd_concrete_date_template_id")
    private ConcreteDateTemplate concreteDateTemplate;

}
