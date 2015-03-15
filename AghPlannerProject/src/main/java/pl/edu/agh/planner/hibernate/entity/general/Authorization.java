package pl.edu.agh.planner.hibernate.entity.general;

import lombok.Data;
import pl.edu.agh.planner.hibernate.entity.dictionary.Dictionary;

import javax.persistence.*;

@Data
@Entity
public class Authorization {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    private Dictionary type;

    @ManyToOne
    @JoinColumn
    private User user;
}
