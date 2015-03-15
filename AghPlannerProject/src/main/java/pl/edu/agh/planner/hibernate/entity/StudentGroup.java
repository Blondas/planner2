package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;
import pl.edu.agh.planner.hibernate.entity.dictionary.Dictionary;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
// grupa studenctka (składowa agregatu)
public class StudentGroup {
    @Id
    @GeneratedValue
    private int id;

    private int letterDesignationDictionaryId;

    private Date startDate;

    private Date endDate;

    // wydzial
    @ManyToOne
    @JoinColumn
    private Dictionary department;

    // oznaczenie grupy diekanatowej
    @ManyToOne
    @JoinColumn
    private Dictionary letterDesignation;

    // kierunek studiow
    @ManyToOne
    @JoinColumn
    private Dictionary faculty;

    @OneToMany(mappedBy = "studentGroup")
    private Set<Aggregate> aggregates;
}
