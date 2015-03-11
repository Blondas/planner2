package pl.edu.agh.planner.hibernate.entity.dictionary;

import lombok.Data;
import pl.edu.agh.planner.hibernate.entity.StudentGroup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class DictionaryLetterDesignation {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "dictionaryLetterDesignation")
    private Set<Dictionary> dictionaries;

    @OneToMany(mappedBy = "dictionaryLetterDesignation")
    private Set<StudentGroup> studentGroups;

}
