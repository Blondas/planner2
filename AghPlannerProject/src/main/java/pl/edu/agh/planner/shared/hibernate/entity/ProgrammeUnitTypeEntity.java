package pl.edu.agh.planner.shared.hibernate.entity;

import javax.persistence.*;

@Entity
public class ProgrammeUnitTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "put_id")
    private int id;

    @Column(name = "put_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
