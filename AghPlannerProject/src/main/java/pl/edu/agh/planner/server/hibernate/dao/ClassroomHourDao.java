package pl.edu.agh.planner.server.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.server.hibernate.entity.ClassroomHourEntity;
import pl.edu.agh.planner.server.hibernate.utils.GenericQuery;

@Component("classroomHourDao")
public class ClassroomHourDao extends GenericQuery {

    public ClassroomHourEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ClassroomHourEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ClassroomHourEntity classroomHourEntity = (ClassroomHourEntity) criteria.uniqueResult();

        endTransaction();

        return classroomHourEntity;
    }

    public void add(ClassroomHourEntity classroomHourEntity) {
        beginTransaction();
        getSession().save(classroomHourEntity);
        endTransaction();
    }

    public void update(ClassroomHourEntity classroomHourEntity) {
        beginTransaction();
        getSession().update(classroomHourEntity);
        endTransaction();
    }

    public void delete(ClassroomHourEntity classroomHourEntity) {
        beginTransaction();
        getSession().delete(classroomHourEntity);
        endTransaction();
    }
}