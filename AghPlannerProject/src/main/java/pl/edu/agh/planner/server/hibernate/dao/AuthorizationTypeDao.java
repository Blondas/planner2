package pl.edu.agh.planner.server.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.server.hibernate.entity.AuthorizationTypeEntity;
import pl.edu.agh.planner.server.hibernate.utils.GenericQuery;

public class AuthorizationTypeDao extends GenericQuery {

    public AuthorizationTypeEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(AuthorizationTypeEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        AuthorizationTypeEntity authorizationTypeEntity = (AuthorizationTypeEntity) criteria.uniqueResult();

        endTransaction();

        return authorizationTypeEntity;
    }

    public void add(AuthorizationTypeEntity authorizationTypeEntity) {
        beginTransaction();
        getSession().save(authorizationTypeEntity);
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
}