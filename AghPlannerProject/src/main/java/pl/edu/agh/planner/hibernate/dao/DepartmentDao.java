package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.hibernate.entity.Department;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

@Component("departmentDao")
public class DepartmentDao extends GenericQuery {

    public Department getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(Department.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        Department department = (Department) criteria.uniqueResult();

        endTransaction();

        return department;
    }

    public void add(Department department) {
        beginTransaction();
        getSession().save(department);
        endTransaction();
    }

    public void update(Department department) {
        beginTransaction();
        getSession().update(department);
        endTransaction();
    }

    public void delete(Department department) {
        beginTransaction();
        getSession().delete(department);
        endTransaction();
    }
}