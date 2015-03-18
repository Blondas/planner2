package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.StudentGroup;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;


public class StudentGroupDao extends GenericQuery {

    public StudentGroup getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(StudentGroup.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        StudentGroup studentGroup = (StudentGroup) criteria.uniqueResult();

        endTransaction();

        return studentGroup;
    }

    public void add(StudentGroup studentGroup) {
        beginTransaction();
        getSession().save(studentGroup);
        endTransaction();
    }

    public void update(StudentGroup studentGroup) {
        beginTransaction();
        getSession().update(studentGroup);
        endTransaction();
    }

    public void delete(StudentGroup studentGroup) {
        beginTransaction();
        getSession().delete(studentGroup);
        endTransaction();
    }
}