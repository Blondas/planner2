package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.AvatarEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("avatarDao")
public class AvatarDao extends GenericQuery implements DaoInterface<AvatarEntity, Integer>{

    @Override
    public AvatarEntity getById (Integer id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(AvatarEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        AvatarEntity avatarEntity = (AvatarEntity) criteria.uniqueResult();

        endTransaction();

        return avatarEntity;
    }

    @Override
    public List<AvatarEntity> getList() {
        beginTransaction();
        List<AvatarEntity> list = session.createCriteria(AvatarEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(AvatarEntity avatarEntity) {
        beginTransaction();
        getSession().save(avatarEntity);
        endTransaction();
    }

    @Override
    public void add(List<AvatarEntity> avatarEntities) {
        beginTransaction();
        for ( int i=0; i< avatarEntities.size(); i++ ) {
            getSession().save(avatarEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void update(AvatarEntity avatarEntity) {
        beginTransaction();
        getSession().update(avatarEntity);
        endTransaction();
    }

    public void delete(AvatarEntity avatarEntity) {
        beginTransaction();
        getSession().delete(avatarEntity);
        endTransaction();
    }
}