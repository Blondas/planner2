package pl.edu.agh.planner.hibernate.general;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.general.User;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

public class UserDao extends GenericQuery {

    public User getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        User user = (User) criteria.uniqueResult();

        endTransaction();

        return user;
    }

    public void add(User user) {
        beginTransaction();
        getSession().save(user);
        endTransaction();
    }

    public void update(User user) {
        beginTransaction();
        getSession().update(user);
        endTransaction();
    }

    public void delete(User user) {
        beginTransaction();
        getSession().delete(user);
        endTransaction();
    }
}