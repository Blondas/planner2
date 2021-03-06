package pl.edu.agh.planner.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.domain.AuthorizationTypeEntity;
import pl.edu.agh.planner.utils.GenericQuery;

import java.util.List;

@Component("authorizationTypeDao")
public class AuthorizationTypeDao extends GenericQuery implements DaoInterface<AuthorizationTypeEntity, Long>{

    @Override
    public AuthorizationTypeEntity getById (Long id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(AuthorizationTypeEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        AuthorizationTypeEntity authorizationTypeEntity = (AuthorizationTypeEntity) criteria.uniqueResult();

        endTransaction();

        return authorizationTypeEntity;
    }

    @Override
    public List<AuthorizationTypeEntity> getList() {
        beginTransaction();
        List<AuthorizationTypeEntity> list = session.createCriteria(AuthorizationTypeEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(AuthorizationTypeEntity authorizationTypeEntity) {
        beginTransaction();
        getSession().save(authorizationTypeEntity);
        endTransaction();
    }

    @Override
    public void add(List<AuthorizationTypeEntity> authorizationTypeEntities) {
        beginTransaction();
        for ( int i=0; i< authorizationTypeEntities.size(); i++ ) {
            getSession().save(authorizationTypeEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void update(AuthorizationTypeEntity authorizationTypeEntity) {
        beginTransaction();
        getSession().update(authorizationTypeEntity);
        endTransaction();
    }

    public void delete(AuthorizationTypeEntity authorizationTypeEntity) {
        beginTransaction();
        getSession().delete(authorizationTypeEntity);
        endTransaction();
    }

    @Override
    public AuthorizationTypeEntity saveOrUpdate(AuthorizationTypeEntity object) {
        beginTransaction();
        getSession().saveOrUpdate(object);
        endTransaction();

        return object;
    }
}