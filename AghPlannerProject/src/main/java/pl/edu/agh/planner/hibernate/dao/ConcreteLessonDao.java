package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

@Component("concreteLessonDao")
public class ConcreteLessonDao extends GenericQuery {

    public ConcreteLessonDao getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ConcreteLessonDao.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ConcreteLessonDao concreteLessonDao = (ConcreteLessonDao) criteria.uniqueResult();

        endTransaction();

        return concreteLessonDao;
    }

    public void addConcreteLessonDao (ConcreteLessonDao concreteLessonDao) {
        beginTransaction();
        getSession().save(concreteLessonDao);
        endTransaction();
    }

    public void updateConcreteLessonDao (ConcreteLessonDao concreteLessonDao) {
        beginTransaction();
        getSession().update(concreteLessonDao);
        endTransaction();
    }

    public void delete(ConcreteLessonDao concreteLessonDao) {
        beginTransaction();
        getSession().delete(concreteLessonDao);
        endTransaction();
    }
}