package pl.edu.agh.planner.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Set;

public class Schedule implements java.io.Serializable{

    private Long id;
    private Set<ConcreteLesson> concreteLessons;
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateSemesterBegin;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateSemesterEnd;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ConcreteLesson> getConcreteLessons() {
        return concreteLessons;
    }

    public void setConcreteLessons(Set<ConcreteLesson> concreteLessons) {
        this.concreteLessons = concreteLessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateSemesterBegin() {
        return dateSemesterBegin;
    }

    public void setDateSemesterBegin(Date dateSemesterBegin) {
        this.dateSemesterBegin = dateSemesterBegin;
    }

    public Date getDateSemesterEnd() {
        return dateSemesterEnd;
    }

    public void setDateSemesterEnd(Date dateSemesterEnd) {
        this.dateSemesterEnd = dateSemesterEnd;
    }
}
