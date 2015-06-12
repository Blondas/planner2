package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.StudentGroupDao;
import pl.edu.agh.planner.domain.StudentGroupEntity;

import java.util.List;

@Service("studentGroupService")
public class StudentGroupService implements ServiceInterface<StudentGroupEntity, Long>{

    private StudentGroupDao studentGroupDao;

    @Autowired
    public void setStudentGroupDao(StudentGroupDao studentGroupDao) {
        this.studentGroupDao = studentGroupDao;
    }

    @Override
    public void add(StudentGroupEntity studentGroupEntity) {
        studentGroupDao.add(studentGroupEntity);
    }

    @Override
    public void add(List<StudentGroupEntity> studentGroupEntities) {
        studentGroupDao.add(studentGroupEntities);
    }

    @Override
    public void update(StudentGroupEntity studentGroupEntity) {
        studentGroupDao.update(studentGroupEntity);
    }

    @Override
    public void delete(StudentGroupEntity studentGroupEntity) {
        studentGroupDao.delete(studentGroupEntity);
    }

    @Override
    public StudentGroupEntity getById(Long id) {
        return studentGroupDao.getById(id);
    }

    @Override
    public List<StudentGroupEntity> getList() {
        return studentGroupDao.getList();
    }

    @Override
    public StudentGroupEntity saveOrUpdate(StudentGroupEntity entity) {
        return null;
    }
}
