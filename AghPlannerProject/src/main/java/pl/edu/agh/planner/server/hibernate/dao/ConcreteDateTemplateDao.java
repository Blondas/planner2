package pl.edu.agh.planner.server.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.server.hibernate.entity.ConcreteDateTemplateEntity;
import pl.edu.agh.planner.server.hibernate.utils.GenericQuery;

@Component("concreteDateTemplateDao")
public class ConcreteDateTemplateDao extends GenericQuery {

    public ConcreteDateTemplateEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ConcreteDateTemplateEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ConcreteDateTemplateEntity concreteDateTemplateEntity = (ConcreteDateTemplateEntity) criteria.uniqueResult();

        endTransaction();

        return concreteDateTemplateEntity;
    }

    public void addConcreteDateTemplate (ConcreteDateTemplateEntity concreteDateTemplateEntity) {
        beginTransaction();
        getSession().save(concreteDateTemplateEntity);
        endTransaction();
    }

    public void updateConcreteDateTemplate (ConcreteDateTemplateEntity concreteDateTemplateEntity) {
        beginTransaction();
        getSession().update(concreteDateTemplateEntity);
        endTransaction();
    }

    public void delete(ConcreteDateTemplateEntity concreteDateTemplateEntity) {
        beginTransaction();
        getSession().delete(concreteDateTemplateEntity);
        endTransaction();
    }
}