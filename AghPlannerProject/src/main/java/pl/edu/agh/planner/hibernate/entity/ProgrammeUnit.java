package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;
import pl.edu.agh.planner.hibernate.entity.dictionary.DictionaryName;
import pl.edu.agh.planner.hibernate.entity.dictionary.Dictionary;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class ProgrammeUnit {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "programmeUnit")
    private Set<Aggregate> aggregates;

    @ManyToOne
    @JoinColumn
    private DictionaryName dictionaryName; // typ przedmiotu

    private int curriculumUnitTypeDictionaryId;
}
