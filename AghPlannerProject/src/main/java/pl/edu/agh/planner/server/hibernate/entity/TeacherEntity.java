package pl.edu.agh.planner.server.hibernate.entity;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class TeacherEntity implements IsSerializable, Serializable {
    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private int id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "t_avatar_id")
    private AvatarEntity avatar;

}
