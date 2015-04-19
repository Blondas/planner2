package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.ConcreteDateEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("concreteDateDao")
public class ConcreteDateDao extends GenericQuery implements DaoInterface<ConcreteDateEntity, Integer>{

    @Override
    public ConcreteDateEntity getById (Integer id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ConcreteDateEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ConcreteDateEntity concreteDateEntity = (ConcreteDateEntity) criteria.uniqueResult();

        endTransaction();

        return concreteDateEntity;
    }

    @Override
    public void add(ConcreteDateEntity concreteDateEntity) {
        beginTransaction();
        getSession().save(concreteDateEntity);
        endTransaction();
    }

    @Override
    public void update (ConcreteDateEntity concreteDateEntity) {
        beginTransaction();
        getSession().update(concreteDateEntity);
        endTransaction();
    }

    @Override
    public List<ConcreteDateEntity> getList() {
        beginTransaction();
        List<ConcreteDateEntity> list = session.createCriteria(ConcreteDateEntity.class).list();
        endTransaction();

        return list;
    }

    @Override
    public void add(List<ConcreteDateEntity> concreteDateEntities) {
        beginTransaction();
        for ( int i=0; i< concreteDateEntities.size(); i++ ) {
            getSession().save(concreteDateEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void delete(ConcreteDateEntity concreteDateEntity) {
        beginTransaction();
        getSession().delete(concreteDateEntity);
        endTransaction();
    }
}