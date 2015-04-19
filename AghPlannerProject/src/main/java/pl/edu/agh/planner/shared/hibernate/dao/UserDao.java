package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.UserEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("userDao")
public class UserDao extends GenericQuery implements DaoInterface<UserEntity, Integer>{

    @Override
    public UserEntity getById (Integer id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(UserEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        UserEntity user = (UserEntity) criteria.uniqueResult();

        endTransaction();

        return user;
    }

    @Override
    public List<UserEntity> getList() {
        beginTransaction();
        List<UserEntity> list = session.createCriteria(UserEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(UserEntity user) {
        beginTransaction();
        getSession().save(user);
        endTransaction();
    }

    @Override
    public void add(List<UserEntity> userEntities) {
        beginTransaction();
        for ( int i=0; i<userEntities.size(); i++ ) {
            getSession().save(userEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
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