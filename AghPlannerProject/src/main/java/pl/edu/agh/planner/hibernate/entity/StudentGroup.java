package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
// grupa studenctka (składowa agregatu)
public class StudentGroup {
    @Id
    @GeneratedValue
    @Column(name = "sg_id")
    private int id;

    @Column(name = "sg_start_date")
    private Date startDate;

    @Column(name = "sg_end_date")
    private Date endDate;

    // wydzial
    @ManyToOne
    @JoinColumn(name = "sg_department_id")
    private Department department;

    // oznaczenie grupy diekanatowej
    @ManyToOne
    @JoinColumn(name = "sg_letter_designation_id")
    private LetterDesignation letterDesignation;

    // kierunek studiow
    @ManyToOne
    @JoinColumn(name = "sg_faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "studentGroup")
    private Set<Aggregate> aggregates;
}
