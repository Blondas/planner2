package pl.edu.agh.planner.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.domain.ClassroomEntity;
import pl.edu.agh.planner.utils.GenericQuery;

import java.util.List;

@Component("classroomDao")
public class ClassroomDao extends GenericQuery implements DaoInterface<ClassroomEntity, Long>{

    @Override
    public ClassroomEntity getById (Long id) {
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

    @Override
    public ClassroomEntity saveOrUpdate(ClassroomEntity object) {
        beginTransaction();
        getSession().saveOrUpdate(object);
        endTransaction();

        return object;
    }
}