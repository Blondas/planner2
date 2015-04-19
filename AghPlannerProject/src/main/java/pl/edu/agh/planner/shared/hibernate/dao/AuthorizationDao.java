package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.AuthorizationEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("authorizationDao")
public class AuthorizationDao extends GenericQuery implements DaoInterface<AuthorizationEntity, Integer>{

    @Override
    public AuthorizationEntity getById (Integer id) {
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
}