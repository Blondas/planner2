package pl.edu.agh.planner.domain;

import javax.persistence.*;

@Entity(name = "programme_unit_type")
public class ProgrammeUnitTypeEntity implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "put_id")
    private Long id;

    @Column(name = "put_name")
    private String name;

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
}
