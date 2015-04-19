package pl.edu.agh.planner.shared.hibernate.entity;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;
import pl.edu.agh.planner.shared.Teacher;

import javax.persistence.*;
import java.io.Serializable;

//@Data
@Entity

public class TeacherEntity implements IsSerializable, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private int id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_last_name")
    private String lastName;

    // TODO poprawic typy kaskadowosci poprawnie wszedzie
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "t_avatar_id")
    private AvatarEntity avatar;

    public TeacherEntity() {

    }

    public TeacherEntity(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.lastName = teacher.getLastName();
        //TODO: avatar
        if(teacher.getAvatar() != null){
            this.avatar.setId(teacher.getAvatar().getId());
            this.avatar.setName(teacher.getName());
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AvatarEntity getAvatar() {
        return avatar;
    }

    public void setAvatar(AvatarEntity avatar) {
        this.avatar = avatar;
    }
}
