package pl.edu.agh.planner.hibernate.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by Krystian on 2015-03-09.
 */
@Data
public class AccurateDate {

    private int id;
    private Date realDate;
    private int templateOfAccurateDateId;
}
