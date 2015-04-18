package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("TeacherDao")
public class TeacherDao extends GenericQuery {

    private final int FULL_BATCH_SIZE = 20;

    public TeacherEntity getById(int id) {
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

    public void add(List<TeacherEntity> TeacherEntitys){
        beginTransaction();
        for ( int i=0; i<TeacherEntitys.size(); i++ ) {
            getSession().save(TeacherEntitys.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }



    public void add(TeacherEntity TeacherEntity) {
        beginTransaction();
        getSession().save(TeacherEntity);
        endTransaction();
    }

    public void update(TeacherEntity TeacherEntity) {
        beginTransaction();
        getSession().update(TeacherEntity);
        endTransaction();
    }

    public void delete(TeacherEntity TeacherEntity) {
        beginTransaction();
        getSession().delete(TeacherEntity);
        endTransaction();
    }
}