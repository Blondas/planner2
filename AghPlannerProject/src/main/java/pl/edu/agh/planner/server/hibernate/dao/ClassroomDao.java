package pl.edu.agh.planner.server.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.server.hibernate.entity.ClassroomEntity;
import pl.edu.agh.planner.server.hibernate.utils.GenericQuery;

import java.util.List;

@Component("classroomDao")
public class ClassroomDao extends GenericQuery {

    private final int FULL_BATCH_SIZE = 20;

    public ClassroomEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ClassroomEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ClassroomEntity classroomEntity = (ClassroomEntity) criteria.uniqueResult();

        endTransaction();

        return classroomEntity;
    }

    public List<ClassroomEntity> getList(){
        beginTransaction();
        List<ClassroomEntity> list = session.createCriteria(ClassroomEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(List<ClassroomEntity> classroomEntities){
        beginTransaction();
        for ( int i=0; i< classroomEntities.size(); i++ ) {
            getSession().save(classroomEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void add(ClassroomEntity classroomEntity) {
        beginTransaction();
        getSession().save(classroomEntity);
        endTransaction();
    }

    public void update(ClassroomEntity classroomEntity) {
        beginTransaction();
        getSession().update(classroomEntity);
        endTransaction();
    }

    public void delete(ClassroomEntity classroomEntity) {
        beginTransaction();
        getSession().delete(classroomEntity);
        endTransaction();
    }
}