package pl.edu.agh.planner.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Component;

import pl.edu.agh.planner.domain.StudentGroupEntity;
import pl.edu.agh.planner.utils.GenericQuery;

@Component("studentGroupDao")
public class StudentGroupDao extends GenericQuery implements DaoInterface<StudentGroupEntity, Long>{

    @Override
    public StudentGroupEntity getById (Long id) {
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

    @Override
    public StudentGroupEntity saveOrUpdate(StudentGroupEntity object) {
        beginTransaction();
        getSession().saveOrUpdate(object);
        endTransaction();

        return object;
    }

    public List<StudentGroupEntity> getStudentGroupsWithoutAggregate(){
        beginTransaction();
        Criteria criteria = session.createCriteria(StudentGroupEntity.class,"studentGroupEntity");
        criteria.createAlias("studentGroupEntity.aggregates","aggregates", JoinType.LEFT_OUTER_JOIN);
        criteria.add(Restrictions.isNull("aggregates.studentGroup"));

        List<StudentGroupEntity> list = (List<StudentGroupEntity>) criteria.list();
        endTransaction();

        return list;
    }
}