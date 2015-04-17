package pl.edu.agh.planner.server.hibernate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.server.hibernate.dao.TeacherDao;
import pl.edu.agh.planner.server.hibernate.entity.TeacherEntity;
import pl.edu.agh.planner.shared.Avatar;
import pl.edu.agh.planner.shared.Teacher;

import java.util.ArrayList;
import java.util.List;

@Service("teacherService")
public class TeacherService implements ServiceInterface<Teacher, Integer> {

    private TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void addTT(pl.edu.agh.planner.shared.Teacher teacher) {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(teacher.getId());
        teacherEntity.setName(teacher.getName());
        teacherEntity.setLastName(teacher.getLastName());

        teacherDao.add(teacherEntity);
    }

    public void add(TeacherEntity teacher) {
        teacherDao.add(teacher);
    }

    public TeacherEntity getById(int teacherId) {
        return teacherDao.getById(teacherId);
    }

    public void addTeachers(List<TeacherEntity> teachers) {
        teacherDao.add(teachers);
    }

    public List<TeacherEntity> getTeachers() {
        return teacherDao.getList();
    }

    public void delete(TeacherEntity teacher) {
        teacherDao.delete(teacher);
    }

    public void update(TeacherEntity teacher) {
        teacherDao.update(teacher);
    }

    @Override
    public void add(Teacher entity) {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(entity.getId());
        teacherEntity.setName(entity.getName());
        teacherEntity.setLastName(entity.getLastName());

        teacherDao.add(teacherEntity);
    }

    @Override
    public void update(Teacher entity) {

    }

    @Override
    public Teacher findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Teacher> findAll() {
        ArrayList<TeacherEntity> teacherEntitiesArrayList = (ArrayList<TeacherEntity>) teacherDao.getList();
        ArrayList<Teacher> teachersArrayList = new ArrayList<Teacher>();

        for (TeacherEntity teacherEntity : teacherEntitiesArrayList) {
            Teacher teacher = new Teacher();
            teacher.setId(teacherEntity.getId());
            teacher.setName(teacherEntity.getName());
            teacher.setLastName(teacherEntity.getLastName());

            teachersArrayList.add(teacher);
        }

        return null;
    }

    @Override
    public void deleteAll() {

    }

//    public void updateList(List<Teacher> teachers) {
//        teacherDao.update(teachers);
//    }
}
