package pl.edu.agh.planner.dto;

import java.util.Date;

public class ConcreteDate{

    private Long id;
    private Date realDate;
    private ConcreteDateTemplate concreteDateTemplate;

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

    public ConcreteDateTemplate getConcreteDateTemplate() {
        return concreteDateTemplate;
    }

    public void setConcreteDateTemplate(ConcreteDateTemplate concreteDateTemplate) {
        this.concreteDateTemplate = concreteDateTemplate;
    }
}
