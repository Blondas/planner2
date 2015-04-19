package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.FacultyEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("facultyDao")
public class FacultyDao extends GenericQuery implements DaoInterface<FacultyEntity, Integer>{

    @Override
    public FacultyEntity getById (Integer id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(FacultyEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        FacultyEntity faculty = (FacultyEntity) criteria.uniqueResult();

        endTransaction();

        return faculty;
    }

    @Override
    public List<FacultyEntity> getList() {
        beginTransaction();
        List<FacultyEntity> list = session.createCriteria(FacultyEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(FacultyEntity faculty) {
        beginTransaction();
        getSession().save(faculty);
        endTransaction();
    }

    @Override
    public void add(List<FacultyEntity> facultyEntities) {
        beginTransaction();
        for ( int i=0; i<facultyEntities.size(); i++ ) {
            getSession().save(facultyEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void update(FacultyEntity faculty) {
        beginTransaction();
        getSession().update(faculty);
        endTransaction();
    }

    public void delete(FacultyEntity faculty) {
        beginTransaction();
        getSession().delete(faculty);
        endTransaction();
    }
}