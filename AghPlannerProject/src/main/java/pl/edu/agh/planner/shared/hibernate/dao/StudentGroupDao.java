package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.StudentGroupEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

@Component("studentGroupDao")
public class StudentGroupDao extends GenericQuery {

    public StudentGroupEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(StudentGroupEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        StudentGroupEntity studentGroup = (StudentGroupEntity) criteria.uniqueResult();

        endTransaction();

        return studentGroup;
    }

    public void add(StudentGroupEntity studentGroup) {
        beginTransaction();
        getSession().save(studentGroup);
        endTransaction();
    }

    public void update(StudentGroupEntity studentGroup) {
        beginTransaction();
        getSession().update(studentGroup);
        endTransaction();
    }

    public void delete(StudentGroupEntity studentGroup) {
        beginTransaction();
        getSession().delete(studentGroup);
        endTransaction();
    }
}