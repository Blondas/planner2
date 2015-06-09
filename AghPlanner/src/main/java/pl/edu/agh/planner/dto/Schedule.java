package pl.edu.agh.planner.dto;

import java.util.Date;
import java.util.Set;

public class Schedule{

    private Long id;
    private Set<ConcreteLesson> concreteLessons;
    private String name;
    private Date date;
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
}
