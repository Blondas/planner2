package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.FacultyDao;
import pl.edu.agh.planner.domain.FacultyEntity;

import java.util.List;

@Service("facultyService")
public class FacultyService implements ServiceInterface<FacultyEntity, Long>{

    private FacultyDao facultyDao;

    @Autowired
    public void setFacultyDao(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
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

    @Override
    public FacultyEntity getById(Long id) {
        return facultyDao.getById(id);
    }

    @Override
    public List<FacultyEntity> getList() {
        return facultyDao.getList();
    }

    @Override
    public FacultyEntity saveOrUpdate(FacultyEntity entity) {
        return facultyDao.saveOrUpdate(entity);
    }
}
