package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.Teacher;


public class TeacherDao extends GenericQuery {

    public Teacher getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(Teacher.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Teacher teacher = (Teacher) criteria.uniqueResult();

        endTransaction();

        return teacher;
    }

    public void add(Teacher teacher) {
        beginTransaction();
        getSession().save(teacher);
        endTransaction();
    }

    public void update(Teacher teacher) {
        beginTransaction();
        getSession().update(teacher);
        endTransaction();
    }
}