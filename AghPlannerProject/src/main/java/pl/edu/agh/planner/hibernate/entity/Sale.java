package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Sale {
    @Id
    @GeneratedValue
    private int id;

    private int number;

    private int buildingId;

    private int numberOfSeats;

    @OneToMany(mappedBy = "sale")
    private Set<SaleHour> saleHours;
}
