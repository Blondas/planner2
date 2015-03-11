package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ConcreteDate {
    @Id
    @GeneratedValue
    private int id;

    private Date realDate;

    @ManyToOne
    @JoinColumn
    private TemplateOfConcreteDate templateOfConcreteDate;
}
