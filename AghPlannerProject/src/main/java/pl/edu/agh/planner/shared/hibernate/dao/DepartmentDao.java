package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.DepartmentEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

@Component("departmentDao")
public class DepartmentDao extends GenericQuery {

    public DepartmentEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(DepartmentEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        DepartmentEntity department = (DepartmentEntity) criteria.uniqueResult();

        endTransaction();

        return department;
    }

    public void add(DepartmentEntity department) {
        beginTransaction();
        getSession().save(department);
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