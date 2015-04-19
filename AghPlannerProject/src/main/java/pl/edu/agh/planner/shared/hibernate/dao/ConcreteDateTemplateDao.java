package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.ConcreteDateTemplateEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("concreteDateTemplateDao")
public class ConcreteDateTemplateDao extends GenericQuery implements DaoInterface<ConcreteDateTemplateEntity, Integer>{

    @Override
    public ConcreteDateTemplateEntity getById (Integer id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ConcreteDateTemplateEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ConcreteDateTemplateEntity concreteDateTemplateEntity = (ConcreteDateTemplateEntity) criteria.uniqueResult();

        endTransaction();

        return concreteDateTemplateEntity;
    }

    @Override
    public void add (ConcreteDateTemplateEntity concreteDateTemplateEntity) {
        beginTransaction();
        getSession().save(concreteDateTemplateEntity);
        endTransaction();
    }

    @Override
    public void update (ConcreteDateTemplateEntity concreteDateTemplateEntity) {
        beginTransaction();
        getSession().update(concreteDateTemplateEntity);
        endTransaction();
    }

    @Override
    public List<ConcreteDateTemplateEntity> getList() {
        beginTransaction();
        List<ConcreteDateTemplateEntity> list = session.createCriteria(ConcreteDateTemplateEntity.class).list();
        endTransaction();

        return list;
    }

    @Override
    public void add(List<ConcreteDateTemplateEntity> concreteDateTemplateEntities) {
        beginTransaction();
        for ( int i=0; i< concreteDateTemplateEntities.size(); i++ ) {
            getSession().save(concreteDateTemplateEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    @Override
    public void delete(ConcreteDateTemplateEntity concreteDateTemplateEntity) {
        beginTransaction();
        getSession().delete(concreteDateTemplateEntity);
        endTransaction();
    }
}