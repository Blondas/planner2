package pl.edu.agh.planner.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import pl.edu.agh.planner.domain.AvatarEntity;
import pl.edu.agh.planner.dto.Foo;
import pl.edu.agh.planner.utils.GenericQuery;

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
        List<AvatarEntity> list = session.createCriteria(AvatarEntity.class).list();
        endTransaction();
        return list;
    }

    public List<Foo> getList2() {
        beginTransaction();


        Criteria criteria = session.createCriteria(AvatarEntity.class,"avatar");
        criteria.createAlias("avatar.teachers","teacher");

        ProjectionList projections = Projections.projectionList();
        projections.add(Projections.property("avatar.id").as("id"));
        projections.add(Projections.property("avatar.name").as("name"));
        projections.add(Projections.property("teacher.id").as("teacherId"));
        projections.add(Projections.property("teacher.name").as("teacherName"));
        projections.add(Projections.property("teacher.lastName").as("teacherLastName"));
        criteria.setProjection(projections);
        criteria.setResultTransformer(Transformers.aliasToBean(Foo.class));



//        criteria.setProjection(Projections.distinct(Projections.property("avatar.id").as("id")));
//        criteria.setProjection(Projections.distinct(Projections.property("avatar.name").as("name")));
//        criteria.setProjection(Projections.distinct(Projections.property("avatar.aggregates").as("aggregates")));
//        criteria.setProjection(Projections.distinct(Projections.property("avatar.teachers").as("teachers")));

//        criteria.setProjection(Projections.groupProperty("avatar.id").as("id"));
//        criteria.setResultTransformer(Transformers.aliasToBean(AvatarEntity.class));
//
        List<Foo> list1 = (List<Foo>) criteria.list();


//        List<AvatarEntity> list = session.createCriteria(AvatarEntity.class).list();
        endTransaction();

        return list1;
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

    public List<AvatarEntity> getAvatarsWithoutAggregate(){
        beginTransaction();
        Criteria criteria = session.createCriteria(AvatarEntity.class,"avatar");
        criteria.createAlias("avatar.aggregates","aggregates", JoinType.LEFT_OUTER_JOIN);
        criteria.add(Restrictions.isNull("aggregates.avatar"));

        List<AvatarEntity> list = (List<AvatarEntity>) criteria.list();
        endTransaction();

        return list;
    }
}