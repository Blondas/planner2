package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.hibernate.entity.LetterDesignation;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

@Component("letterDesignationDao")
public class LetterDesignationDao extends GenericQuery {

    public LetterDesignation getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(LetterDesignation.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        LetterDesignation letterDesignation = (LetterDesignation) criteria.uniqueResult();

        endTransaction();

        return letterDesignation;
    }

    public void add(LetterDesignation letterDesignation) {
        beginTransaction();
        getSession().save(letterDesignation);
        endTransaction();
    }

    public void update(LetterDesignation letterDesignation) {
        beginTransaction();
        getSession().update(letterDesignation);
        endTransaction();
    }

    public void delete(LetterDesignation letterDesignation) {
        beginTransaction();
        getSession().delete(letterDesignation);
        endTransaction();
    }
}