package pl.edu.agh.planner.hibernate.entity.dictionary;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Dictionary {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn
    private DictionaryName dictionaryName;

    @ManyToOne
    @JoinColumn
    private DictionaryLetterDesignation dictionaryLetterDesignation;

    @ManyToOne
    @JoinColumn
    private DictionaryFieldOfStudy dictionaryFieldOfStudy;

    @ManyToOne
    @JoinColumn
    private DictionaryFaculty dictionaryFaculty;

    @ManyToOne
    @JoinColumn
    private DictionaryAuthorisationType dictionaryAuthorisationType;
}
