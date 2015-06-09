package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.planner.domain.TeacherEntity;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherEntity getOne(Long id) {
        return teacherRepository.getOne(id);
    }

    @Override
    public List<TeacherEntity> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        teacherRepository.delete(id);
    }

    @Override
    public TeacherEntity saveOrUpdate(TeacherEntity teacherEntity) {
        return teacherRepository.save(teacherEntity);
    }
}
