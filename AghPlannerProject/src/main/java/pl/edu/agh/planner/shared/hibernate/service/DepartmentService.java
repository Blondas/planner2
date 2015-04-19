package pl.edu.agh.planner.shared.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.shared.hibernate.dao.DepartmentDao;
import pl.edu.agh.planner.shared.hibernate.entity.DepartmentEntity;

import java.util.List;

@Service("departmentService")
public class DepartmentService implements ServiceInterface<DepartmentEntity, Integer>{

    private DepartmentDao departmentDao;

    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void add(DepartmentEntity departmentEntity) {
        departmentDao.add(departmentEntity);
    }

    @Override
    public void add(List<DepartmentEntity> departmentEntities) {
        departmentDao.add(departmentEntities);
    }

    @Override
    public void update(DepartmentEntity departmentEntity) {
        departmentDao.update(departmentEntity);
    }

    @Override
    public void delete(DepartmentEntity departmentEntity) {
        departmentDao.delete(departmentEntity);
    }

    @Override
    public DepartmentEntity getById(Integer id) {
        return departmentDao.getById(id);
    }

    @Override
    public List<DepartmentEntity> getList() {
        return departmentDao.getList();
    }
}
