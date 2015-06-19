package pl.edu.agh.planner.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import pl.edu.agh.planner.domain.TeacherEntity;
import pl.edu.agh.planner.utils.GenericQuery;

@Component("teacherDao")
public class TeacherDao extends GenericQuery implements DaoInterface<TeacherEntity, Long>{

    @Override
    public TeacherEntity getById(Long id) {
        beginTransaction();

        Criteria criteria = getSession().createCriteria(TeacherEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        TeacherEntity TeacherEntity = (TeacherEntity) criteria.uniqueResult();

        endTransaction();

        return TeacherEntity;
    }

    public List<TeacherEntity> getList(){
        beginTransaction();
        List<TeacherEntity> list = session.createCriteria(TeacherEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(List<TeacherEntity> teacherEntitys){
        beginTransaction();
        for ( int i=0; i< teacherEntitys.size(); i++ ) {
            getSession().save(teacherEntitys.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void add(TeacherEntity teacherEntity) {
        beginTransaction();
        getSession().save(teacherEntity);
        endTransaction();
    }

    public void update(TeacherEntity teacherEntity) {
        beginTransaction();
        getSession().update(teacherEntity);
        endTransaction();
    }

    public void delete(TeacherEntity teacherEntity) {
        beginTransaction();
        getSession().delete(teacherEntity);
        endTransaction();
    }

    public TeacherEntity saveOrUpdate(TeacherEntity teacherEntity){
        beginTransaction();
        getSession().saveOrUpdate(teacherEntity);
        endTransaction();

        return teacherEntity;
    }

}