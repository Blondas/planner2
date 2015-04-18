package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.ConcreteDateEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

@Component("concreteDateDao")
public class ConcreteDateDao extends GenericQuery {

    public ConcreteDateEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ConcreteDateEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ConcreteDateEntity concreteDateEntity = (ConcreteDateEntity) criteria.uniqueResult();

        endTransaction();

        return concreteDateEntity;
    }

    public void addConcreteDate (ConcreteDateEntity concreteDateEntity) {
        beginTransaction();
        getSession().save(concreteDateEntity);
        endTransaction();
    }

    public void updateConcreteDate (ConcreteDateEntity concreteDateEntity) {
        beginTransaction();
        getSession().update(concreteDateEntity);
        endTransaction();
    }

    public void delete(ConcreteDateEntity concreteDateEntity) {
        beginTransaction();
        getSession().delete(concreteDateEntity);
        endTransaction();
    }
}