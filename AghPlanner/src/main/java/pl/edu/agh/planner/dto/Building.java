package pl.edu.agh.planner.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

public class Building {

    private Long id;
    private String name;
    @JsonManagedReference(value = "building_classrooms")
    private Set<Classroom> classrooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Set<Classroom> classrooms) {
        this.classrooms = classrooms;
    }
}
