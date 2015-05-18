package pl.edu.agh.planner.domain;

import javax.persistence.*;


@Entity
public class TeacherEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "t_id")


    @Id
    @SequenceGenerator(name="teacher_id_seq", sequenceName="teacher_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="teacher_id_seq")
    @Column(name = "t_id")
    private Long id;

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



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
