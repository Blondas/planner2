package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.hibernate.entity.Aggregate;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

@Component("aggregateDao")
public class AggregateDao extends GenericQuery {

    public Aggregate getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(Aggregate.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Aggregate aggregate = (Aggregate) criteria.uniqueResult();

        endTransaction();

        return aggregate;
    }

    public void add(Aggregate aggregate) {
        beginTransaction();
        getSession().save(aggregate);
        endTransaction();
    }

    public void update(Aggregate aggregate) {
        beginTransaction();
        getSession().update(aggregate);
        endTransaction();
    }

    public void delete(Aggregate aggregate) {
        beginTransaction();
        getSession().delete(aggregate);
        endTransaction();
    }
}