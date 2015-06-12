package datasources;

import pl.edu.agh.planner.dao.StudentGroupDao;
import pl.edu.agh.planner.domain.DepartmentEntity;
import pl.edu.agh.planner.domain.FacultyEntity;
import pl.edu.agh.planner.domain.LetterDesignationEntity;
import pl.edu.agh.planner.domain.StudentGroupEntity;

import java.util.Date;

public class StudentGroupDataSource {

    private StudentGroupDao studentGroupDao = new StudentGroupDao();

    public StudentGroupEntity createStudentGroup(DepartmentEntity departmentEntity, FacultyEntity facultyEntity, LetterDesignationEntity letterDesignationEntity){
        StudentGroupEntity studentGroupEntity = new StudentGroupEntity();
        studentGroupEntity.setStartDate(new Date(System.currentTimeMillis()));
        studentGroupEntity.setEndDate(new Date(System.currentTimeMillis() +2000));
        studentGroupEntity.setDepartment(departmentEntity);
        studentGroupEntity.setFaculty(facultyEntity);
        studentGroupEntity.setLetterDesignation(letterDesignationEntity);

        studentGroupDao.add(studentGroupEntity);

        return studentGroupEntity;
    }
}