package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.TermsSet;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;


public class TermsSetDao extends GenericQuery {

    public TermsSet getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(TermsSet.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        TermsSet termsSet = (TermsSet) criteria.uniqueResult();

        endTransaction();

        return termsSet;
    }

    public void add(TermsSet termsSet) {
        beginTransaction();
        getSession().save(termsSet);
        endTransaction();
    }

    public void update(TermsSet termsSet) {
        beginTransaction();
        getSession().update(termsSet);
        endTransaction();
    }

    public void delete(TermsSet termsSet) {
        beginTransaction();
        getSession().delete(termsSet);
        endTransaction();
    }
}