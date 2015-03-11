package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;
import pl.edu.agh.planner.hibernate.entity.dictionary.DictionaryFaculty;
import pl.edu.agh.planner.hibernate.entity.dictionary.DictionaryFieldOfStudy;
import pl.edu.agh.planner.hibernate.entity.dictionary.DictionaryLetterDesignation;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class StudentGroup {
    @Id
    @GeneratedValue
    private int id;

    private int letterDesignationDictionaryId;

    private Date startDate;

    private Date endDate;

    @ManyToOne
    @JoinColumn
    private DictionaryFieldOfStudy dictionaryFieldOfStudy;

    @ManyToOne
    @JoinColumn
    private DictionaryLetterDesignation dictionaryLetterDesignation;

    @ManyToOne
    @JoinColumn
    private DictionaryFaculty dictionaryFaculty;

    @OneToMany(mappedBy = "studentGroup")
    private Set<Aggregate> aggregates;
}
