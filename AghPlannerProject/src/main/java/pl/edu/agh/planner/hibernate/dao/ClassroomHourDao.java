package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.ClassroomHour;

public class ClassroomHourDao extends GenericQuery {

    public ClassroomHour getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ClassroomHour.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ClassroomHour classroomHour = (ClassroomHour) criteria.uniqueResult();

        endTransaction();

        return classroomHour;
    }

    public void add(ClassroomHour classroomHour) {
        beginTransaction();
        getSession().save(classroomHour);
        endTransaction();
    }

    public void update(ClassroomHour classroomHour) {
        beginTransaction();
        getSession().update(classroomHour);
        endTransaction();
    }
}