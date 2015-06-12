package pl.edu.agh.planner.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.domain.TermsSetEntity;
import pl.edu.agh.planner.utils.GenericQuery;

import java.util.List;

@Component("termsSetDao")
public class TermsSetDao extends GenericQuery implements DaoInterface<TermsSetEntity,Long>{

    @Override
    public TermsSetEntity getById (Long id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(TermsSetEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        TermsSetEntity termsSet = (TermsSetEntity) criteria.uniqueResult();

        endTransaction();

        return termsSet;
    }

    @Override
    public List<TermsSetEntity> getList() {
        beginTransaction();
        List<TermsSetEntity> list = session.createCriteria(TermsSetEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(TermsSetEntity termsSet) {
        beginTransaction();
        getSession().save(termsSet);
        endTransaction();
    }

    @Override
    public void add(List<TermsSetEntity> termsSetEntities) {
        beginTransaction();
        for ( int i=0; i<termsSetEntities.size(); i++ ) {
            getSession().save(termsSetEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
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

    @Override
    public TermsSetEntity saveOrUpdate(TermsSetEntity object) {
        beginTransaction();
        getSession().saveOrUpdate(object);
        endTransaction();

        return object;
    }
}