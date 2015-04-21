package pl.edu.agh.planner.shared.hibernate.entity;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private int id;

    @OneToMany(mappedBy = "schedule")
    private Set<ConcreteLessonEntity> concreteLessonEntities;

    @Column(name = "s_name")
    private String name;

    @Column(name = "s_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "s_user_id")
    private UserEntity user;
}
