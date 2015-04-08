package pl.edu.agh.planner.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.planner.hibernate.entity.Classroom;
import pl.edu.agh.planner.service.ClassroomService;

import java.util.List;

@RestController
public class ClassroomController {

    private ClassroomService classroomService;

    @Autowired
    public void setTeacherService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @RequestMapping(value = "/classroom/{id}", method = RequestMethod.GET)
    public @ResponseBody Classroom getClassroom(@PathVariable("id") int classroomId){
        return classroomService.getById(classroomId);
    }

    @RequestMapping(value = "/classrooms", method = RequestMethod.GET)
    public @ResponseBody List<Classroom> getClassrooms(){
        return classroomService.getClassrooms();
    }

    @RequestMapping(value = "/classroom/add", method = RequestMethod.POST)
    public @ResponseBody Classroom addClassroom(@RequestBody Classroom classroom){
        classroomService.add(classroom);
        return classroom;
    }

    @RequestMapping(value = "/classroom/addlist", method = RequestMethod.POST)
    public @ResponseBody List<Classroom> addClassrooms(@RequestBody List<Classroom> classrooms){
        classroomService.addClassrooms(classrooms);
        return classrooms;
    }

    @RequestMapping(value = "/classroom/delete", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTeacher(@RequestBody Classroom classroom){
        classroomService.delete(classroom);
    }

    @RequestMapping(value = "/classroom/update", method = RequestMethod.POST)
    public void updateTeacher(@RequestBody Classroom classroom){
        classroomService.update(classroom);
    }

}
