package pl.edu.agh.planner.shared.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
// grupa studenctka (składowa agregatu)
public class StudentGroupEntity {
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
    private DepartmentEntity department;

    // oznaczenie grupy diekanatowej
    @ManyToOne
    @JoinColumn(name = "sg_letter_designation_id")
    private LetterDesignationEntity letterDesignation;

    // kierunek studiow
    @ManyToOne
    @JoinColumn(name = "sg_faculty_id")
    private FacultyEntity faculty;

    @OneToMany(mappedBy = "studentGroup")
    private Set<AggregateEntity> aggregates;
}
