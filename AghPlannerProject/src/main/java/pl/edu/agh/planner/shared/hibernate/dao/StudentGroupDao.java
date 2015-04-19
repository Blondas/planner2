package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.StudentGroupEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("studentGroupDao")
public class StudentGroupDao extends GenericQuery implements DaoInterface<StudentGroupEntity, Integer>{

    @Override
    public StudentGroupEntity getById (Integer id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(StudentGroupEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        StudentGroupEntity studentGroup = (StudentGroupEntity) criteria.uniqueResult();

        endTransaction();

        return studentGroup;
    }

    @Override
    public List<StudentGroupEntity> getList() {
        beginTransaction();
        List<StudentGroupEntity> list = session.createCriteria(StudentGroupEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(StudentGroupEntity studentGroup) {
        beginTransaction();
        getSession().save(studentGroup);
        endTransaction();
    }

    @Override
    public void add(List<StudentGroupEntity> studentGroupEntities) {
        beginTransaction();
        for ( int i=0; i<studentGroupEntities.size(); i++ ) {
            getSession().save(studentGroupEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();

    }

    public void update(StudentGroupEntity studentGroup) {
        beginTransaction();
        getSession().update(studentGroup);
        endTransaction();
    }

    public void delete(StudentGroupEntity studentGroup) {
        beginTransaction();
        getSession().delete(studentGroup);
        endTransaction();
    }
}