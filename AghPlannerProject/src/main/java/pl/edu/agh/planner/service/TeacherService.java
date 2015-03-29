package pl.edu.agh.planner.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.hibernate.dao.TeacherDao;
import pl.edu.agh.planner.hibernate.entity.Teacher;
import pl.edu.agh.planner.shared.TeacherJson;

import java.util.List;

@Service("teacherService")
public class TeacherService {


    private TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }


    public void save(TeacherJson teacherJson) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherJson.getName());
        teacher.setLastName(teacherJson.getLastname());

        teacherDao.add(teacher);
    }

    public void add(Teacher teacher) {
        teacherDao.add(teacher);
    }


    public Teacher getById(int teacherId) {
        return teacherDao.getById(teacherId);
    }

    public void addTeachers(List<Teacher> teachers) {
        teacherDao.add(teachers);
    }

    public List<Teacher> getTeachers() {
        return teacherDao.getList();
    }

    public void delete(Teacher teacher) {
        teacherDao.delete(teacher);
    }

    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }

//    public void updateList(List<Teacher> teachers) {
//        teacherDao.update(teachers);
//    }
}
