package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.ConcreteDateTemplate;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

public class ConcreteDateTemplateDao extends GenericQuery {

    public ConcreteDateTemplate getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ConcreteDateTemplate.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ConcreteDateTemplate concreteDateTemplate = (ConcreteDateTemplate) criteria.uniqueResult();

        endTransaction();

        return concreteDateTemplate;
    }

    public void addConcreteDateTemplate (ConcreteDateTemplate concreteDateTemplate) {
        beginTransaction();
        getSession().save(concreteDateTemplate);
        endTransaction();
    }

    public void updateConcreteDateTemplate (ConcreteDateTemplate concreteDateTemplate) {
        beginTransaction();
        getSession().update(concreteDateTemplate);
        endTransaction();
    }

    public void delete(ConcreteDateTemplate concreteDateTemplate) {
        beginTransaction();
        getSession().delete(concreteDateTemplate);
        endTransaction();
    }
}