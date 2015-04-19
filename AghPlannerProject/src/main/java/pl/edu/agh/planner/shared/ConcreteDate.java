package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;
import java.util.Date;

public class ConcreteDate implements IsSerializable, Serializable {

    private int id;
    private Date realDate;
    private ConcreteDateTemplate concreteDateTemplate;

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

    public ConcreteDateTemplate getConcreteDateTemplate() {
        return concreteDateTemplate;
    }

    public void setConcreteDateTemplate(ConcreteDateTemplate concreteDateTemplate) {
        this.concreteDateTemplate = concreteDateTemplate;
    }
}
