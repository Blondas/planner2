package pl.edu.agh.planner.server.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.server.hibernate.dao.ClassroomDao;
import pl.edu.agh.planner.server.hibernate.entity.ClassroomEntity;

import java.util.List;

@Service("classroomService")
public class ClassroomService {

    private ClassroomDao classroomDao;

    @Autowired
    public void setClassroomDao(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    public ClassroomEntity getById(int classRoomId) {
        return classroomDao.getById(classRoomId);
    }


    public List<ClassroomEntity> getClassrooms() {
        return classroomDao.getList();
    }

    public void add(ClassroomEntity classroomEntity) {
        classroomDao.add(classroomEntity);
    }

    public void addClassrooms(List<ClassroomEntity> classroomEntities) {
        classroomDao.add(classroomEntities);
    }

    public void delete(ClassroomEntity classroomEntity) {
        classroomDao.delete(classroomEntity);
    }

    public void update(ClassroomEntity classroomEntity) {
        classroomDao.update(classroomEntity);
    }
}
