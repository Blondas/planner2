package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.hibernate.dao.ClassroomDao;
import pl.edu.agh.planner.hibernate.entity.Classroom;

import java.util.List;

@Service("classroomService")
public class ClassroomService {

    private ClassroomDao classroomDao;

    @Autowired
    public void setClassroomDao(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    public Classroom getById(int classRoomId) {
        return classroomDao.getById(classRoomId);
    }


    public List<Classroom> getClassrooms() {
        return classroomDao.getList();
    }

    public void add(Classroom classroom) {
        classroomDao.add(classroom);
    }

    public void addClassrooms(List<Classroom> classrooms) {
        classroomDao.add(classrooms);
    }

    public void delete(Classroom classroom) {
        classroomDao.delete(classroom);
    }

    public void update(Classroom classroom) {
        classroomDao.update(classroom);
    }
}
