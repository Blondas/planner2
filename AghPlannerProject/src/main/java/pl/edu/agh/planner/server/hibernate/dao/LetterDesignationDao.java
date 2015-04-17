package pl.edu.agh.planner.server.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.server.hibernate.entity.LetterDesignationEntity;
import pl.edu.agh.planner.server.hibernate.utils.GenericQuery;

@Component("letterDesignationDao")
public class LetterDesignationDao extends GenericQuery {

    public LetterDesignationEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(LetterDesignationEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        LetterDesignationEntity letterDesignation = (LetterDesignationEntity) criteria.uniqueResult();

        endTransaction();

        return letterDesignation;
    }

    public void add(LetterDesignationEntity letterDesignation) {
        beginTransaction();
        getSession().save(letterDesignation);
        endTransaction();
    }

    public void update(LetterDesignationEntity letterDesignation) {
        beginTransaction();
        getSession().update(letterDesignation);
        endTransaction();
    }

    public void delete(LetterDesignationEntity letterDesignation) {
        beginTransaction();
        getSession().delete(letterDesignation);
        endTransaction();
    }
}