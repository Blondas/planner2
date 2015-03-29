package pl.edu.agh.planner.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.planner.hibernate.entity.Teacher;
import pl.edu.agh.planner.service.TeacherService;
import pl.edu.agh.planner.shared.TeacherJson;

import java.util.List;

@RestController
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "**/" + "jsonStockPrices.json", method = RequestMethod.GET, produces = "application/json")
    public String saveTeacher(){
        TeacherJson teacherJson = new TeacherJson();
        teacherJson.setLastname("dupa2222");
        teacherJson.setName("dupa3333");
        teacherService.save(teacherJson);

        return "ALA MA KOTA HURAaaaaaaaaaaaaaaaa teacher ";
    }


    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
    public @ResponseBody Teacher getTeacher(@PathVariable("id") int teacherId){
        return teacherService.getById(teacherId);
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public @ResponseBody List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public @ResponseBody Teacher addTeacher(@RequestBody Teacher teacher){
        teacherService.add(teacher);
        return teacher;
    }

    @RequestMapping(value = "/teacher/addlist", method = RequestMethod.POST)
    public @ResponseBody List<Teacher> addTeachers(@RequestBody List<Teacher> teachers){
        teacherService.addTeachers(teachers);
        return teachers;
    }

    @RequestMapping(value = "/teacher/delete", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTeacher(@RequestBody Teacher teacher){
        teacherService.delete(teacher);
    }

    @RequestMapping(value = "/teacher/update", method = RequestMethod.POST)
    public void updateTeacher(@RequestBody Teacher teacher){
        teacherService.update(teacher);
    }

//    @RequestMapping(value = "/teacher/update/list", method = RequestMethod.GET)
//    public void updateTeacher(@RequestBody List<Teacher> teachers){
//        teacherService.updateList(teachers);
//    }










}
