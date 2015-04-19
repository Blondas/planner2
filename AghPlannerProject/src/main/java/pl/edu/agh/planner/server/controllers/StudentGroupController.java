package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.dao.StudentGroupDao;
import pl.edu.agh.planner.shared.hibernate.entity.StudentGroupEntity;

import java.util.List;

@Controller("studentGroupController")
public class StudentGroupController implements ControllerInterface<StudentGroupEntity, Integer>{

    private StudentGroupDao studentGroupDao;

    @Autowired
    public void setStudentGroupDao(StudentGroupDao studentGroupDao) {
        this.studentGroupDao = studentGroupDao;
    }

    @Override
    public StudentGroupEntity getById(Integer id) {
        return studentGroupDao.getById(id);
    }

    @Override
    public List<StudentGroupEntity> getList() {
        return studentGroupDao.getList();
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
}
