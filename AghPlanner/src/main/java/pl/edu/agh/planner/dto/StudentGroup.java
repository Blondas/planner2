package pl.edu.agh.planner.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.Set;

public class StudentGroup implements java.io.Serializable{

    private Long id;
    private Date startDate;
    private Date endDate;
    private Department department;
    private LetterDesignation letterDesignation;
    private Faculty faculty;
//    @JsonBackReference(value = "studentGroup-aggregate")
    private Set<Aggregate> aggregates;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LetterDesignation getLetterDesignation() {
        return letterDesignation;
    }

    public void setLetterDesignation(LetterDesignation letterDesignation) {
        this.letterDesignation = letterDesignation;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Set<Aggregate> getAggregates() {
        return aggregates;
    }

    public void setAggregates(Set<Aggregate> aggregates) {
        this.aggregates = aggregates;
    }
}
