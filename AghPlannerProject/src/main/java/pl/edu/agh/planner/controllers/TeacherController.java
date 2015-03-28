package pl.edu.agh.planner.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.planner.hibernate.dao.TeacherDao;
import pl.edu.agh.planner.hibernate.entity.Teacher;
import pl.edu.agh.planner.service.TeacherService;
import pl.edu.agh.planner.shared.TeacherJson;

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


    @RequestMapping(value = "**/" + "dupa.json", method = RequestMethod.POST)
    public @ResponseBody Teacher saveTeacher(@RequestBody Teacher teacher){
        System.out.println(teacher);

        TeacherDao dao = new TeacherDao();
        dao.add(teacher);
//        teacherService.save(teacher);

        return teacher;
    }

}
