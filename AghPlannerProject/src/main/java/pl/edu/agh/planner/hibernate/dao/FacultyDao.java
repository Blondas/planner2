package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.hibernate.entity.Faculty;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

@Component("facultyDao")
public class FacultyDao extends GenericQuery {

    public Faculty getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(Faculty.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Faculty faculty = (Faculty) criteria.uniqueResult();

        endTransaction();

        return faculty;
    }

    public void add(Faculty faculty) {
        beginTransaction();
        getSession().save(faculty);
        endTransaction();
    }

    public void update(Faculty faculty) {
        beginTransaction();
        getSession().update(faculty);
        endTransaction();
    }

    public void delete(Faculty faculty) {
        beginTransaction();
        getSession().delete(faculty);
        endTransaction();
    }
}