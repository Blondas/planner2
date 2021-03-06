package pl.edu.agh.planner.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.planner.dao.TeacherDao;
import pl.edu.agh.planner.domain.TeacherEntity;

@Service("teacherService")
public class TeacherService implements ServiceInterface<TeacherEntity, Long> {

    private TeacherDao teacherDao = new TeacherDao();

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
    public TeacherEntity getById(Long id) {
        return teacherDao.getById(id);
    }

    @Override
    public List<TeacherEntity> getList() {
        return teacherDao.getList();
    }

    @Override
    public TeacherEntity saveOrUpdate(TeacherEntity entity) {
        return teacherDao.saveOrUpdate(entity);
    }

    public List<TeacherEntity> getTeachersWithoutAvatar(){ return teacherDao.getTeachersWithoutAvatar(); }


}