package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.dictionary.DictionaryName;

public class DictionaryNameDao extends GenericQuery {

    public DictionaryName getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(DictionaryName.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        DictionaryName dictionaryName = (DictionaryName) criteria.uniqueResult();

        endTransaction();

        return dictionaryName;
    }

    public void add(DictionaryName dictionaryName) {
        beginTransaction();
        getSession().save(dictionaryName);
        endTransaction();
    }

    public void update(DictionaryName dictionaryName) {
        beginTransaction();
        getSession().update(dictionaryName);
        endTransaction();
    }
}