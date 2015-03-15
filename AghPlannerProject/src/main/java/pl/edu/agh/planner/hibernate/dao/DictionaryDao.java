package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.dictionary.Dictionary;

public class DictionaryDao extends GenericQuery {

    public Dictionary getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(Dictionary.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Dictionary dictionary = (Dictionary) criteria.uniqueResult();

        endTransaction();

        return dictionary;
    }

    public void addDictionary (Dictionary dictionary) {
        beginTransaction();
        getSession().save(dictionary);
        endTransaction();
    }

    public void updateDictionary (Dictionary dictionary) {
        beginTransaction();
        getSession().update(dictionary);
        endTransaction();
    }
}