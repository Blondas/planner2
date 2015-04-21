package pl.edu.agh.planner.shared.hibernate.entity;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class ConcreteDateTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdt_id")
    private int id;

    @Column(name = "cdt_name")
    private String name;

    @OneToMany(mappedBy="concreteDateTemplate")
    private Set<ConcreteDateEntity> concreteDateEntities;

    @ManyToOne
    @JoinColumn(name = "cdt_terms_set_id")
    private TermsSetEntity termsSet;
}
