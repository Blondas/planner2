package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.DepartmentDao;
import pl.edu.agh.planner.domain.DepartmentEntity;

import java.util.List;

@Service("departmentService")
public class DepartmentService implements ServiceInterface<DepartmentEntity, Long>{

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
    public DepartmentEntity getById(Long id) {
        return departmentDao.getById(id);
    }

    @Override
    public List<DepartmentEntity> getList() {
        return departmentDao.getList();
    }

    @Override
    public DepartmentEntity saveOrUpdate(DepartmentEntity entity) {
        return departmentDao.saveOrUpdate(entity);
    }
}
