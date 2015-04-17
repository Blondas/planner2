package pl.edu.agh.planner.server.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.server.hibernate.entity.AuthorizationEntity;
import pl.edu.agh.planner.server.hibernate.utils.GenericQuery;

public class AuthorizationDao extends GenericQuery {

    public AuthorizationEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(AuthorizationEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        AuthorizationEntity authorizationEntity = (AuthorizationEntity) criteria.uniqueResult();

        endTransaction();

        return authorizationEntity;
    }

    public void add(AuthorizationEntity authorizationEntity) {
        beginTransaction();
        getSession().save(authorizationEntity);
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