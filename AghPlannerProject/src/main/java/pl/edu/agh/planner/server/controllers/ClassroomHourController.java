package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.dao.ClassroomHourDao;
import pl.edu.agh.planner.shared.hibernate.entity.ClassroomHourEntity;

import java.util.List;

@Controller("classroomHourController")
public class ClassroomHourController implements ControllerInterface<ClassroomHourEntity, Integer>{

    private ClassroomHourDao classroomHourDao;

    @Autowired
    public void setClassroomHourDao(ClassroomHourDao classroomHourDao) {
        this.classroomHourDao = classroomHourDao;
    }

    @Override
    public ClassroomHourEntity getById(Integer id) {
        return classroomHourDao.getById(id);
    }

    @Override
    public List<ClassroomHourEntity> getList() {
        return classroomHourDao.getList();
    }

    @Override
    public void add(ClassroomHourEntity classroomHourEntity) {
        classroomHourDao.add(classroomHourEntity);
    }

    @Override
    public void add(List<ClassroomHourEntity> classroomHourEntities) {
        classroomHourDao.add(classroomHourEntities);
    }

    @Override
    public void update(ClassroomHourEntity classroomHourEntity) {
        classroomHourDao.update(classroomHourEntity);
    }

    @Override
    public void delete(ClassroomHourEntity classroomHourEntity) {
        classroomHourDao.delete(classroomHourEntity);
    }
}
