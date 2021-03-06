package pl.edu.agh.planner.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.agh.planner.dao.StudentGroupDao;
import pl.edu.agh.planner.domain.StudentGroupEntity;
import pl.edu.agh.planner.dto.StudentGroup;
import pl.edu.agh.planner.utils.DtoEntityMapper;

@RestController
public class StudentGroupController {

    @Autowired
    private StudentGroupDao studentGroupDao;


    @RequestMapping(method=GET,value="/studentGroup")
    public StudentGroup getStudentGroup(@RequestParam("id") Long id){
        StudentGroupEntity studentGroupEntity = studentGroupDao.getById(id);
        return DtoEntityMapper.entityToStudentGroup(studentGroupEntity);
    }

    @RequestMapping(method=GET,value="/studentGroups")
    public List<StudentGroup> findStudentGroups(){
        List<StudentGroupEntity> studentGroupEntities = studentGroupDao.getList();
        List<StudentGroup> studentGroups = studentGroupEntities.stream().map(DtoEntityMapper::entityToStudentGroup).collect(Collectors.toList());

        return studentGroups;
    }

    @RequestMapping(method=DELETE,value="/studentGroup")
    public void deleteAvatar(@RequestBody StudentGroup studentGroup){
        StudentGroupEntity studentGroupEntity = DtoEntityMapper.studentGroupToEntity(studentGroup);
        studentGroupDao.delete(studentGroupEntity);
    }

    @RequestMapping(method=POST,value="/studentGroup")
    public StudentGroup saveOrUpdate(@RequestBody StudentGroup studentGroup){
        StudentGroupEntity studentGroupEntity = DtoEntityMapper.studentGroupToEntity(studentGroup);

        return DtoEntityMapper.entityToStudentGroup(studentGroupDao.saveOrUpdate(studentGroupEntity));
    }

    @RequestMapping(method=GET,value="/getStudentGroupsWithoutAggregate")
    public List<StudentGroup> getStudentGroupsWithoutAggregate(){
      List<StudentGroupEntity> studentGroupEntities = studentGroupDao.getStudentGroupsWithoutAggregate();
      List<StudentGroup> studentGroups = studentGroupEntities.stream().map(DtoEntityMapper::entityToStudentGroup).collect(Collectors.toList());

      return studentGroups;
    }


}
