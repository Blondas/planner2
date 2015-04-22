package pl.edu.agh.planner.shared.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ConcreteDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private int id;

    @Column(name = "cd_real_date")
    private Date realDate;

    @ManyToOne
    @JoinColumn(name = "cd_concrete_date_template_id")
    private ConcreteDateTemplateEntity concreteDateTemplate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
