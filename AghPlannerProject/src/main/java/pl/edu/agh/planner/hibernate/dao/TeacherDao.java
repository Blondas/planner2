package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.hibernate.entity.Teacher;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

import java.util.List;

@Component("teacherDao")
public class TeacherDao extends GenericQuery {

    private final int FULL_BATCH_SIZE = 20;

    public Teacher getById(int id) {
        beginTransaction();

        Criteria criteria = getSession().createCriteria(Teacher.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Teacher teacher = (Teacher) criteria.uniqueResult();

        endTransaction();

        return teacher;
    }

    public List<Teacher> getList(){
        beginTransaction();
        List<Teacher> list = session.createCriteria(Teacher.class).list();
        endTransaction();

        return list;
    }

    public void add(List<Teacher> teachers){
        beginTransaction();
        for ( int i=0; i<teachers.size(); i++ ) {
            getSession().save(teachers.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }



    public void add(Teacher teacher) {
        beginTransaction();
        getSession().save(teacher);
        endTransaction();
    }

    public void update(Teacher teacher) {
        beginTransaction();
        getSession().update(teacher);
        endTransaction();
    }

    public void delete(Teacher teacher) {
        beginTransaction();
        getSession().delete(teacher);
        endTransaction();
    }
}