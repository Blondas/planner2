package pl.edu.agh.planner.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.domain.ConcreteLessonEntity;
import pl.edu.agh.planner.utils.GenericQuery;

import java.util.List;

@Component("concreteLessonDao")
public class ConcreteLessonDao extends GenericQuery implements DaoInterface<ConcreteLessonEntity, Long>{

    @Override
    public ConcreteLessonEntity getById (Long id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ConcreteLessonEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ConcreteLessonEntity concreteLessonEntity = (ConcreteLessonEntity) criteria.uniqueResult();

        endTransaction();

        return concreteLessonEntity;
    }

    @Override
    public void add(ConcreteLessonEntity concreteLessonEntity) {
        beginTransaction();
        getSession().save(concreteLessonEntity);
        endTransaction();
    }

    @Override
    public void update(ConcreteLessonEntity concreteLessonEntity) {
        beginTransaction();
        getSession().update(concreteLessonEntity);
        endTransaction();
    }

    @Override
    public void delete(ConcreteLessonEntity concreteLessonEntity) {
        beginTransaction();
        getSession().delete(concreteLessonEntity);
        endTransaction();
    }

    @Override
    public ConcreteLessonEntity saveOrUpdate(ConcreteLessonEntity object) {
        beginTransaction();
        getSession().saveOrUpdate(object);
        endTransaction();

        return object;
    }

    @Override
    public List<ConcreteLessonEntity> getList() {
        beginTransaction();
        List<ConcreteLessonEntity> list = session.createCriteria(ConcreteLessonEntity.class).list();
        endTransaction();

        return list;
    }

    @Override
    public void add(List<ConcreteLessonEntity> concreteLessonEntities) {
        beginTransaction();
        for ( int i=0; i< concreteLessonEntities.size(); i++ ) {
            getSession().save(concreteLessonEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();

    }



}