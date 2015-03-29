package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.hibernate.entity.Avatar;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

@Component("avatarDao")
public class AvatarDao extends GenericQuery {

    public Avatar getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(Avatar.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Avatar avatar = (Avatar) criteria.uniqueResult();

        endTransaction();

        return avatar;
    }

    public void add(Avatar avatar) {
        beginTransaction();
        getSession().save(avatar);
        endTransaction();
    }

    public void update(Avatar avatar) {
        beginTransaction();
        getSession().update(avatar);
        endTransaction();
    }

    public void delete(Avatar avatar) {
        beginTransaction();
        getSession().delete(avatar);
        endTransaction();
    }
}