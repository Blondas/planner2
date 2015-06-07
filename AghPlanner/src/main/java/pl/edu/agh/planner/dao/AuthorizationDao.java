package pl.edu.agh.planner.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.domain.AuthorizationEntity;
import pl.edu.agh.planner.utils.GenericQuery;

import java.util.List;

@Component("authorizationDao")
public class AuthorizationDao extends GenericQuery implements DaoInterface<AuthorizationEntity, Long>{

    @Override
    public AuthorizationEntity getById (Long id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(AuthorizationEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        AuthorizationEntity authorizationEntity = (AuthorizationEntity) criteria.uniqueResult();

        endTransaction();

        return authorizationEntity;
    }

    @Override
    public List<AuthorizationEntity> getList() {
        beginTransaction();
        List<AuthorizationEntity> list = session.createCriteria(AuthorizationEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(AuthorizationEntity authorizationEntity) {
        beginTransaction();
        getSession().save(authorizationEntity);
        endTransaction();
    }

    @Override
    public void add(List<AuthorizationEntity> authorizationEntities) {
        beginTransaction();
        for ( int i=0; i< authorizationEntities.size(); i++ ) {
            getSession().save(authorizationEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();

    }

    public void update(AuthorizationEntity authorizationEntity) {
        beginTransaction();
        getSession().update(authorizationEntity);
        endTransaction();
    }

    public void delete(AuthorizationEntity authorizationEntity) {
        beginTransaction();
        getSession().delete(authorizationEntity);
        endTransaction();
    }

    @Override
    public AuthorizationEntity saveOrUpdate(AuthorizationEntity object) {
        beginTransaction();
        getSession().saveOrUpdate(object);
        endTransaction();

        return object;
    }
}