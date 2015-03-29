package pl.edu.agh.planner.hibernate.general;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.general.Authorization;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

public class AuthorizationDao extends GenericQuery {

    public Authorization getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(Authorization.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Authorization authorization = (Authorization) criteria.uniqueResult();

        endTransaction();

        return authorization;
    }

    public void add(Authorization authorization) {
        beginTransaction();
        getSession().save(authorization);
        endTransaction();
    }

    public void update(Authorization authorization) {
        beginTransaction();
        getSession().update(authorization);
        endTransaction();
    }

    public void delete(Authorization authorization) {
        beginTransaction();
        getSession().delete(authorization);
        endTransaction();
    }
}