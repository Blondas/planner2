package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.shared.hibernate.entity.UserEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

public class UserDao extends GenericQuery {

    public UserEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(UserEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        UserEntity user = (UserEntity) criteria.uniqueResult();

        endTransaction();

        return user;
    }

    public void add(UserEntity user) {
        beginTransaction();
        getSession().save(user);
        endTransaction();
    }

    public void update(UserEntity user) {
        beginTransaction();
        getSession().update(user);
        endTransaction();
    }

    public void delete(UserEntity user) {
        beginTransaction();
        getSession().delete(user);
        endTransaction();
    }
}