package pl.edu.agh.planner.server.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.server.hibernate.entity.TermsSetEntity;
import pl.edu.agh.planner.server.hibernate.utils.GenericQuery;

@Component("termsSetDao")
public class TermsSetDao extends GenericQuery {

    public TermsSetEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(TermsSetEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        TermsSetEntity termsSet = (TermsSetEntity) criteria.uniqueResult();

        endTransaction();

        return termsSet;
    }

    public void add(TermsSetEntity termsSet) {
        beginTransaction();
        getSession().save(termsSet);
        endTransaction();
    }

    public void update(TermsSetEntity termsSet) {
        beginTransaction();
        getSession().update(termsSet);
        endTransaction();
    }

    public void delete(TermsSetEntity termsSet) {
        beginTransaction();
        getSession().delete(termsSet);
        endTransaction();
    }
}