package pl.edu.agh.planner.hibernate.entity.dictionary;

import lombok.Data;
import pl.edu.agh.planner.hibernate.entity.ProgrammeUnit;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class DictionaryName {
    @Id
    @GeneratedValue
    @Column(name = "dn_id")
    private int id;

    @Column(name = "dn_name")
    private String name;

    @OneToMany(mappedBy = "dictionaryName")
    private Set<Dictionary> dictionaries;

}
