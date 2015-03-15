package pl.edu.agh.planner.hibernate.entity.dictionary;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Dictionary {
    @Id
    @GeneratedValue
    @Column(name = "d_id")
    private int id;

    @Column(name = "d_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "d_dictionary_name_id")
    private DictionaryName dictionaryName;
}
