package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.dao.FacultyDao;
import pl.edu.agh.planner.shared.hibernate.entity.FacultyEntity;

import java.util.List;

@Controller("facultyController")
public class FacultyController implements ControllerInterface<FacultyEntity, Integer> {

    private FacultyDao facultyDao;

    @Autowired
    public void setFacultyDao(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }

    @Override
    public FacultyEntity getById(Integer id) {
        return facultyDao.getById(id);
    }

    @Override
    public List<FacultyEntity> getList() {
        return facultyDao.getList();
    }

    @Override
    public void add(FacultyEntity facultyEntity) {
        facultyDao.add(facultyEntity);
    }

    @Override
    public void add(List<FacultyEntity> facultyEntities) {
        facultyDao.add(facultyEntities);
    }

    @Override
    public void update(FacultyEntity facultyEntity) {
        facultyDao.update(facultyEntity);
    }

    @Override
    public void delete(FacultyEntity facultyEntity) {
        facultyDao.delete(facultyEntity);
    }
}
