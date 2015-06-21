package pl.edu.agh.planner.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "building")
public class BuildingEntity {

    @Id
    @SequenceGenerator(name="building_id_seq", sequenceName="building_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="building_id_seq")
    @Column(name = "b_id")
    private Long id;

    @Column(name = "b_name")
    private String name;

    @OneToMany(mappedBy = "building", fetch = FetchType.EAGER)
    private Set<ClassroomEntity> classrooms;

    public BuildingEntity() {
    }

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

    public Set<ClassroomEntity> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Set<ClassroomEntity> classrooms) {
        this.classrooms = classrooms;
    }
}
