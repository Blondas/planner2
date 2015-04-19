package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.ClassroomHourEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("classroomHourDao")
public class ClassroomHourDao extends GenericQuery implements DaoInterface<ClassroomHourEntity, Integer>{

    @Override
    public ClassroomHourEntity getById (Integer id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ClassroomHourEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ClassroomHourEntity classroomHourEntity = (ClassroomHourEntity) criteria.uniqueResult();

        endTransaction();

        return classroomHourEntity;
    }

    @Override
    public List<ClassroomHourEntity> getList() {
        beginTransaction();
        List<ClassroomHourEntity> list = session.createCriteria(ClassroomHourEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(ClassroomHourEntity classroomHourEntity) {
        beginTransaction();
        getSession().save(classroomHourEntity);
        endTransaction();
    }

    @Override
    public void add(List<ClassroomHourEntity> classroomHourEntities) {
        beginTransaction();
        for ( int i=0; i< classroomHourEntities.size(); i++ ) {
            getSession().save(classroomHourEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void update(ClassroomHourEntity classroomHourEntity) {
        beginTransaction();
        getSession().update(classroomHourEntity);
        endTransaction();
    }

    public void delete(ClassroomHourEntity classroomHourEntity) {
        beginTransaction();
        getSession().delete(classroomHourEntity);
        endTransaction();
    }
}