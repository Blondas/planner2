package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.ConcreteDate;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

public class ConcreteDateDao extends GenericQuery {

    public ConcreteDate getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ConcreteDate.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ConcreteDate concreteDate = (ConcreteDate) criteria.uniqueResult();

        endTransaction();

        return concreteDate;
    }

    public void addConcreteDate (ConcreteDate concreteDate) {
        beginTransaction();
        getSession().save(concreteDate);
        endTransaction();
    }

    public void updateConcreteDate (ConcreteDate concreteDate) {
        beginTransaction();
        getSession().update(concreteDate);
        endTransaction();
    }

    public void delete(ConcreteDate concreteDate) {
        beginTransaction();
        getSession().delete(concreteDate);
        endTransaction();
    }
}