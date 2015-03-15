package pl.edu.agh.planner.hibernate.entity.general;

import lombok.Data;
import pl.edu.agh.planner.hibernate.entity.dictionary.Dictionary;

import javax.persistence.*;

@Data
@Entity
public class Authorization {
    @Id
    @GeneratedValue
    @Column(name = "a_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "a_type")
    private Dictionary type;

    @ManyToOne
    @JoinColumn(name = "a_user_id")
    private User user;
}
