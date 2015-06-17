package pl.edu.agh.planner.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.domain.AvatarEntity;
import pl.edu.agh.planner.dto.Avatar;
import pl.edu.agh.planner.utils.GenericQuery;

import java.util.List;

@Component("avatarDao")
public class AvatarDao extends GenericQuery implements DaoInterface<AvatarEntity, Long>{

    @Override
    public AvatarEntity getById (Long id) {
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
        Criteria criteria = session.createCriteria(AvatarEntity.class,"avatar");
        criteria.createAlias("avatar.teachers","teachers");
//        criteria.setProjection(Projections.groupProperty())
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        criteria.setProjection(
//                Projections.distinct(Projections.projectionList().add(Projections.groupProperty("teachers.id"))
//                criteria.setProjection(Projections.distinct(Projections.property("teachers.id")
        Projections.projectionList()
//
                .add(Projections.property("avatar.id"))
                .add(Projections.property("avatar.name"))
                .add(Projections.property("teachers.id"))
                .add(Projections.property("teachers.name"))
                .add(Projections.property("teachers.lastName")


                )).setResultTransformer(Transformers.aliasToBean(AvatarEntity.class));

        List<AvatarEntity> list1 = criteria.list();


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

    @Override
    public AvatarEntity saveOrUpdate(AvatarEntity object) {
        beginTransaction();
        getSession().saveOrUpdate(object);
        endTransaction();

        return object;
    }
}