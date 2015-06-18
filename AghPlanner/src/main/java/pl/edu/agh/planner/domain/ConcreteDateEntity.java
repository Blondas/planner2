package pl.edu.agh.planner.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "concrete_date")
public class ConcreteDateEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private Long id;

    @Column(name = "cd_real_date")
    private Date realDate;

    @ManyToOne
    @JoinColumn(name = "cd_concrete_date_template_id")
    private ConcreteDateTemplateEntity concreteDateTemplate;

    //@OneToOne old - do przemyslenia
    @OneToMany(mappedBy = "concreteDate")
    private Set<ConcreteLessonEntity> concreteLessons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRealDate() {
        return realDate;
    }

    public void setRealDate(Date realDate) {
        this.realDate = realDate;
    }

    public ConcreteDateTemplateEntity getConcreteDateTemplate() {
        return concreteDateTemplate;
    }

    public void setConcreteDateTemplate(ConcreteDateTemplateEntity concreteDateTemplate) {
        this.concreteDateTemplate = concreteDateTemplate;
    }

    public Set<ConcreteLessonEntity> getConcreteLessons() {
        return concreteLessons;
    }

    public void setConcreteLessons(Set<ConcreteLessonEntity> concreteLessons) {
        this.concreteLessons = concreteLessons;
    }
}
