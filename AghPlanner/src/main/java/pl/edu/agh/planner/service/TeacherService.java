package pl.edu.agh.planner.service;

import pl.edu.agh.planner.domain.TeacherEntity;

import java.util.List;

public interface TeacherService {

    TeacherEntity getOne(Long id);

    List<TeacherEntity> findAll();

    void delete(Long id);

    TeacherEntity saveOrUpdate(TeacherEntity teacherEntity);


}
