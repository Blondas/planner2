package pl.edu.agh.planner.domain;

import javax.persistence.*;

@Entity(name = "letter_designation")
public class LetterDesignationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ld_id")
    private Long id;

    @Column(name = "ld_name")
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
