package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.AggregateEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

@Component("aggregateDao")
public class AggregateDao extends GenericQuery {

    public AggregateEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(AggregateEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        AggregateEntity aggregate = (AggregateEntity) criteria.uniqueResult();

        endTransaction();

        return aggregate;
    }

    public void add(AggregateEntity aggregate) {
        beginTransaction();
        getSession().save(aggregate);
        endTransaction();
    }

    public void update(AggregateEntity aggregate) {
        beginTransaction();
        getSession().update(aggregate);
        endTransaction();
    }

    public void delete(AggregateEntity aggregate) {
        beginTransaction();
        getSession().delete(aggregate);
        endTransaction();
    }
}