package pl.edu.agh.planner.shared.hibernate.entity;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class ClassroomHourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ch_id")
    private int id;

    @Column(name = "ch_lesson_begin_id")
    private int lessonBeginId;

    @Column(name = "ch_lesson_end_id")
    private int lessonEndId;

    @ManyToOne
    @JoinColumn(name = "ch_classroom_id")
    private ClassroomEntity classroom;
}
