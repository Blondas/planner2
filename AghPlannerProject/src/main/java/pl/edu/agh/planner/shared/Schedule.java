package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Schedule implements IsSerializable, Serializable {

    private int id;
    private Set<ConcreteLesson> concreteLessons;
    private String name;
    private Date date;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
