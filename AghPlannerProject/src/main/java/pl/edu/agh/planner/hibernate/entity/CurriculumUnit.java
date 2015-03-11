package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;
import pl.edu.agh.planner.hibernate.entity.dictionary.DictionaryName;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class CurriculumUnit {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "curriculumUnit")
    private Set<Aggregate> aggregates;

    @ManyToOne
    @JoinColumn
    private DictionaryName dictionaryName;
    
    private int curriculumUnitTypeDictionaryId;
}
