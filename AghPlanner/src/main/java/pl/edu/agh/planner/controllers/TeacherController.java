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

import pl.edu.agh.planner.domain.TeacherEntity;
import pl.edu.agh.planner.dto.Teacher;
import pl.edu.agh.planner.service.TeacherService;
import pl.edu.agh.planner.utils.DtoEntityMapper;


@RestController
public class TeacherController  {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(method=GET,value="/teacher")
    public Teacher getTeacher(@RequestParam("id") Long teacherId){
        TeacherEntity teacherEntity = teacherService.getById(teacherId);
        return DtoEntityMapper.entityToTeacher(teacherEntity);
    }

    @RequestMapping(method=GET,value="/teachers")
    public List<Teacher> findTeachers(){
        List<TeacherEntity> teacherEntity = teacherService.getList();
        List<Teacher> teachers = teacherEntity.stream().map(DtoEntityMapper::entityToTeacher).collect(Collectors.toList());

        return teachers;
    }

    @RequestMapping(method=DELETE,value="/teacher")
    public void deleteTeacher(@RequestBody Teacher teacher){
        TeacherEntity teacherEntity = DtoEntityMapper.teacherToEntity(teacher);
        teacherService.delete(teacherEntity);
    }

    @RequestMapping(method=POST,value="/teacher")
    public Teacher saveOrUpdate(@RequestBody Teacher teacher){
        TeacherEntity teacherEntity = DtoEntityMapper.teacherToEntity(teacher);
        return DtoEntityMapper.entityToTeacher(teacherService.saveOrUpdate(teacherEntity));
    }

    @RequestMapping(method=GET,value="/teachersWithoutAvatar")
    public List<Teacher> findTeachersWithoutAvatar(){
      List<TeacherEntity> teacherEntity = teacherService.getTeachersWithoutAvatar();
      List<Teacher> teachers = teacherEntity.stream().map(DtoEntityMapper::entityToTeacher).collect(Collectors.toList());

      return teachers;
    }




}

