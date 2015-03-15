package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.Aggregate;

public class AggregateDao extends GenericQuery {

    public Aggregate getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(Aggregate.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Aggregate aggregate = (Aggregate) criteria.uniqueResult();

        endTransaction();

        return aggregate;
    }
}