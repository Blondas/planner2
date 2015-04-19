package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.DepartmentEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("departmentDao")
public class DepartmentDao extends GenericQuery implements DaoInterface<DepartmentEntity, Integer>{

    @Override
    public DepartmentEntity getById (Integer id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(DepartmentEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        DepartmentEntity department = (DepartmentEntity) criteria.uniqueResult();

        endTransaction();

        return department;
    }

    @Override
    public List<DepartmentEntity> getList() {
        beginTransaction();
        List<DepartmentEntity> list = session.createCriteria(DepartmentEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(DepartmentEntity department) {
        beginTransaction();
        getSession().save(department);
        endTransaction();
    }

    @Override
    public void add(List<DepartmentEntity> departmentEntities) {
        beginTransaction();
        for ( int i=0; i<departmentEntities.size(); i++ ) {
            getSession().save(departmentEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void update(DepartmentEntity department) {
        beginTransaction();
        getSession().update(department);
        endTransaction();
    }

    public void delete(DepartmentEntity department) {
        beginTransaction();
        getSession().delete(department);
        endTransaction();
    }
}