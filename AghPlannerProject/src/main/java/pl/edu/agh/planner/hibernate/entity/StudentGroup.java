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
//    @Column(name = "sg_id")
    private int id;

//    @Column(name = "sg_letter_designation_id")
    private int letterDesignationDictionaryId;

//    @Column(name = "sg_start_date")
    private Date startDate;

//    @Column(name = "sg_end_date")
    private Date endDate;

    // wydzial
    @ManyToOne
    @JoinColumn //(name = "sg_department_id")
    private Dictionary department;

    // oznaczenie grupy diekanatowej
    @ManyToOne
    @JoinColumn //(name = "sg_letter_designation_id")
    private Dictionary letterDesignation;

    // kierunek studiow
    @ManyToOne
    @JoinColumn //(name = "sg_faculty_id")
    private Dictionary faculty;

    @OneToMany(mappedBy = "studentGroup")
    private Set<Aggregate> aggregates;
}
