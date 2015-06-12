package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.ClassroomHourDao;
import pl.edu.agh.planner.domain.ClassroomHourEntity;

import java.util.List;

@Service("classroomHourService")
public class ClassroomHourService implements ServiceInterface<ClassroomHourEntity, Long> {

    private ClassroomHourDao classroomHourDao;

    @Autowired
    public void setClassroomHourDao(ClassroomHourDao classroomHourDao) {
        this.classroomHourDao = classroomHourDao;
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

    @Override
    public ClassroomHourEntity getById(Long id) {
        return classroomHourDao.getById(id);
    }

    @Override
    public List<ClassroomHourEntity> getList() {
        return classroomHourDao.getList();
    }

    @Override
    public ClassroomHourEntity saveOrUpdate(ClassroomHourEntity entity) {
        return classroomHourDao.saveOrUpdate(entity);
    }

}