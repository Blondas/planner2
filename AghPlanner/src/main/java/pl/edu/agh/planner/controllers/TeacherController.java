package pl.edu.agh.planner.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import pl.edu.agh.planner.domain.TeacherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.planner.dto.Teacher;
import pl.edu.agh.planner.service.TeacherService;
import pl.edu.agh.planner.utils.DtoEntityMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class TeacherController  {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(method=GET,value="/teacher")
    public Teacher getTeacher(@RequestParam("id") Long teacherId){
        TeacherEntity teacherEntity = teacherService.getOne(teacherId);
        return DtoEntityMapper.entityToTeacher(teacherEntity);
    }

    @RequestMapping(method=GET,value="/teachers")
    public List<Teacher> findTeachers(){
        List<TeacherEntity> teacherEntity = teacherService.findAll();
        List<Teacher> teachers = teacherEntity.stream().map(DtoEntityMapper::entityToTeacher).collect(Collectors.toList());

        return teachers;
    }

    @RequestMapping(method=DELETE,value="/teacher")
    public void deleteTeacher(@RequestParam("id") Long teacherId){
        teacherService.delete(teacherId);
    }

    @RequestMapping(method=POST,value="/teacher")
    public Teacher saveOrUpdate(@RequestBody Teacher teacher){
//        public Teacher saveOrUpdate(){
//        TeacherEntity teacherEntity = DtoEntityMapper.teacherToEntity(teacher);

//        TeacherEntity entity = teacherService.getOne(new Long(6));
//        entity.setLastName("update dzialaj prosze");
//        Teacher teacher = new Teacher();
//        teacher.setId(new Long(7));
//        teacher.setLastName("update kurwa wpis");
//        teacher.setName("update dupa123 wpis");

        TeacherEntity teacherEntity = DtoEntityMapper.teacherToEntity(teacher);
        return DtoEntityMapper.entityToTeacher(teacherService.saveOrUpdate(teacherEntity));

//        return new Teacher();
    }



}

