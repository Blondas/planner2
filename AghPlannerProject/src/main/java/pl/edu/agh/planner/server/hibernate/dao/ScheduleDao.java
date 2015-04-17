package pl.edu.agh.planner.server.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.server.hibernate.entity.ScheduleEntity;
import pl.edu.agh.planner.server.hibernate.utils.GenericQuery;

@Component("scheduleDao")
public class ScheduleDao extends GenericQuery {

    public ScheduleEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ScheduleEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ScheduleEntity schedule = (ScheduleEntity) criteria.uniqueResult();

        endTransaction();

        return schedule;
    }

    public void add(ScheduleEntity schedule) {
        beginTransaction();
        getSession().save(schedule);
        endTransaction();
    }

    public void update(ScheduleEntity schedule) {
        beginTransaction();
        getSession().update(schedule);
        endTransaction();
    }

    public void delete(ScheduleEntity schedule) {
        beginTransaction();
        getSession().delete(schedule);
        endTransaction();
    }
}