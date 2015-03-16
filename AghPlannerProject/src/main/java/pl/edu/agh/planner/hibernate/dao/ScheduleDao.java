package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.Schedule;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;


public class ScheduleDao extends GenericQuery {

    public Schedule getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(Schedule.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Schedule schedule = (Schedule) criteria.uniqueResult();

        endTransaction();

        return schedule;
    }

    public void add(Schedule schedule) {
        beginTransaction();
        getSession().save(schedule);
        endTransaction();
    }

    public void update(Schedule schedule) {
        beginTransaction();
        getSession().update(schedule);
        endTransaction();
    }

    public void delete(Schedule schedule) {
        beginTransaction();
        getSession().delete(schedule);
        endTransaction();
    }
}