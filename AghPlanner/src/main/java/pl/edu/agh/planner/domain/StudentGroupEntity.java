package pl.edu.agh.planner.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "student_group")
// grupa studenctka (sk³adowa agregatu)
public class StudentGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sg_id")
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public LetterDesignationEntity getLetterDesignation() {
        return letterDesignation;
    }

    public void setLetterDesignation(LetterDesignationEntity letterDesignation) {
        this.letterDesignation = letterDesignation;
    }

    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }

    public Set<AggregateEntity> getAggregates() {
        return aggregates;
    }

    public void setAggregates(Set<AggregateEntity> aggregates) {
        this.aggregates = aggregates;
    }
}
