package pl.edu.agh.planner.shared.hibernate.service;

import org.springframework.stereotype.Service;
import pl.edu.agh.planner.shared.hibernate.dao.ClassroomDao;
import pl.edu.agh.planner.shared.hibernate.entity.ClassroomEntity;

import java.util.List;

@Service("classroomService")
public class ClassroomService implements  ServiceInterface<ClassroomEntity, Integer> {

    private ClassroomDao classroomDao;

    public ClassroomService() {
        this.classroomDao = new ClassroomDao();
    }

    @Override
    public void add(ClassroomEntity entity) {
        classroomDao.add(entity);
    }

    @Override
    public void update(ClassroomEntity entity) {
        classroomDao.update(entity);
    }

    @Override
    public void delete(ClassroomEntity entity) {
        classroomDao.delete(entity);
    }

    @Override
    public ClassroomEntity findById(Integer integer) {
        return classroomDao.getById(integer);
    }

    @Override
    public List<ClassroomEntity> getList() {
        return classroomDao.getList();
    }

}
