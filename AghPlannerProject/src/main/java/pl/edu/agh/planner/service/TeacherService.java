package pl.edu.agh.planner.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.hibernate.dao.TeacherDao;
import pl.edu.agh.planner.hibernate.entity.Teacher;
import pl.edu.agh.planner.shared.TeacherJson;

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


}
