package pl.edu.agh.planner.hibernate.entity;

import java.util.Date;

/**
 * Created by Krystian on 2015-03-09.
 */
public class StudentGroup {

    private int id;
    private int letterDesignationDictionaryId;
    private Date startDate;
    private Date endDate;
    private int fieldOfStudyDictionaryId;
    private int facultyDictionaryId;
}
