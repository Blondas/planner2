package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.Classroom;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

public class ClassroomDao extends GenericQuery {

    public Classroom getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(Classroom.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Classroom classroom = (Classroom) criteria.uniqueResult();

        endTransaction();

        return classroom;
    }

    public void add(Classroom classroom) {
        beginTransaction();
        getSession().save(classroom);
        endTransaction();
    }

    public void update(Classroom classroom) {
        beginTransaction();
        getSession().update(classroom);
        endTransaction();
    }

    public void delete(Classroom classroom) {
        beginTransaction();
        getSession().delete(classroom);
        endTransaction();
    }
}