package pl.edu.agh.planner.datasources;

import pl.edu.agh.planner.dao.FacultyDao;
import pl.edu.agh.planner.domain.FacultyEntity;

public class FacultyDataSource {

    private FacultyDao facultyDao = new FacultyDao();

    public FacultyEntity createFaculty(String name){
        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setName(name);

        facultyDao.add(facultyEntity);

        return facultyEntity;
    }
}
