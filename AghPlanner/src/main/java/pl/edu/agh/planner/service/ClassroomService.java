package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.ClassroomDao;
import pl.edu.agh.planner.domain.ClassroomEntity;

import java.util.List;

@Service("classroomService")
public class ClassroomService implements  ServiceInterface<ClassroomEntity, Long> {

    private ClassroomDao classroomDao;

    @Autowired
    public void setClassroomDao(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    @Override
    public void add(ClassroomEntity classroomEntity) {
        classroomDao.add(classroomEntity);
    }

    @Override
    public void add(List<ClassroomEntity> classroomEntities) {
        classroomDao.add(classroomEntities);
    }

    @Override
    public void update(ClassroomEntity classroomEntity) {
        classroomDao.update(classroomEntity);
    }

    @Override
    public void delete(ClassroomEntity classroomEntity) {
        classroomDao.delete(classroomEntity);
    }

    @Override
    public ClassroomEntity getById(Long id) {
        return classroomDao.getById(id);
    }

    @Override
    public List<ClassroomEntity> getList() {
        return classroomDao.getList();
    }

    @Override
    public ClassroomEntity saveOrUpdate(ClassroomEntity entity) {
        return classroomDao.saveOrUpdate(entity);
    }

}