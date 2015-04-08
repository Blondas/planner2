package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.hibernate.entity.Classroom;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

import java.util.List;

@Component("classroomDao")
public class ClassroomDao extends GenericQuery {

    private final int FULL_BATCH_SIZE = 20;

    public Classroom getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(Classroom.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Classroom classroom = (Classroom) criteria.uniqueResult();

        endTransaction();

        return classroom;
    }

    public List<Classroom> getList(){
        beginTransaction();
        List<Classroom> list = session.createCriteria(Classroom.class).list();
        endTransaction();

        return list;
    }

    public void add(List<Classroom> classrooms){
        beginTransaction();
        for ( int i=0; i< classrooms.size(); i++ ) {
            getSession().save(classrooms.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void add(Classroom classroom) {
        beginTransaction();
        getSession().save(classroom);
        endTransaction();
    }

    public void update(Classroom classroom) {
        beginTransaction();
        getSession().update(classroom);
        endTransaction();
    }

    public void delete(Classroom classroom) {
        beginTransaction();
        getSession().delete(classroom);
        endTransaction();
    }
}