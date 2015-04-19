package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;
import pl.edu.agh.planner.shared.hibernate.service.TeacherService;

import java.util.List;

@Controller("teacherController")
public class TeacherController implements ControllerInterface<TeacherEntity, Integer> {


    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

	@Override
	public void add(TeacherEntity object) { teacherService.add(object); }

    @Override
    public void add(List<TeacherEntity> object) { teacherService.add(object); }

    @Override
    public void update(TeacherEntity object) { teacherService.update(object); }

    @Override
	public TeacherEntity getById(Integer id) {
        return teacherService.getById(id);
	}

	@Override
	public void delete(TeacherEntity object) {
        teacherService.delete(object);
	}

	@Override
	public List<TeacherEntity> getList() { return teacherService.getList(); }

}
