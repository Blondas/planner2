package pl.edu.agh.planner.server.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.server.hibernate.entity.FacultyEntity;
import pl.edu.agh.planner.server.hibernate.utils.GenericQuery;

@Component("facultyDao")
public class FacultyDao extends GenericQuery {

    public FacultyEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(FacultyEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        FacultyEntity faculty = (FacultyEntity) criteria.uniqueResult();

        endTransaction();

        return faculty;
    }

    public void add(FacultyEntity faculty) {
        beginTransaction();
        getSession().save(faculty);
        endTransaction();
    }

    public void update(FacultyEntity faculty) {
        beginTransaction();
        getSession().update(faculty);
        endTransaction();
    }

    public void delete(FacultyEntity faculty) {
        beginTransaction();
        getSession().delete(faculty);
        endTransaction();
    }
}