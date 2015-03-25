package pl.edu.agh.planner.hibernate.dao.general;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.general.AuthorizationType;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

public class AuthorizationTypeDao extends GenericQuery {

    public AuthorizationType getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(AuthorizationType.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        AuthorizationType authorizationType = (AuthorizationType) criteria.uniqueResult();

        endTransaction();

        return authorizationType;
    }

    public void add(AuthorizationType authorizationType) {
        beginTransaction();
        getSession().save(authorizationType);
        endTransaction();
    }

    public void update(AuthorizationType authorizationType) {
        beginTransaction();
        getSession().update(authorizationType);
        endTransaction();
    }

    public void delete(AuthorizationType authorizationType) {
        beginTransaction();
        getSession().delete(authorizationType);
        endTransaction();
    }
}