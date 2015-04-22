package pl.edu.agh.planner.shared.hibernate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.shared.hibernate.dao.TeacherDao;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;

import java.util.List;

@Service("teacherService")
public class TeacherService implements ServiceInterface<TeacherEntity, Integer> {

    private TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) { this.teacherDao = teacherDao; }

    @Override
    public void add(TeacherEntity entity) {
        teacherDao.add(entity);
    }

    @Override
    public void add(List<TeacherEntity> object) { teacherDao.add(object); }

    @Override
    public void update(TeacherEntity entity) {
        teacherDao.update(entity);
    }

    @Override
    public void delete(TeacherEntity entity) {
        teacherDao.delete(entity);
    }

    @Override
    public TeacherEntity getById(Integer integer) {
        return teacherDao.getById(integer);
    }

    @Override
    public List<TeacherEntity> getList() {
        return teacherDao.getList();
    }

}