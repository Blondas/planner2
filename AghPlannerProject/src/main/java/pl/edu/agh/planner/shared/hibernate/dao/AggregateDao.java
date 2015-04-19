package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.AggregateEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("aggregateDao")
public class AggregateDao extends GenericQuery implements DaoInterface<AggregateEntity, Integer>{

    @Override
    public AggregateEntity getById (Integer id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(AggregateEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        AggregateEntity aggregate = (AggregateEntity) criteria.uniqueResult();

        endTransaction();

        return aggregate;
    }

    @Override
    public List<AggregateEntity> getList() {
        beginTransaction();
        List<AggregateEntity> list = session.createCriteria(AggregateEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(AggregateEntity aggregate) {
        beginTransaction();
        getSession().save(aggregate);
        endTransaction();
    }

    @Override
    public void add(List<AggregateEntity> aggregateEntities) {
        beginTransaction();
        for ( int i=0; i< aggregateEntities.size(); i++ ) {
            getSession().save(aggregateEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
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