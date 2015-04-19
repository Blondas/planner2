package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.entity.ClassroomEntity;
import pl.edu.agh.planner.shared.hibernate.service.ClassroomService;

import java.util.List;

@Controller("classroomController")
public class ClassroomController implements ControllerInterface<ClassroomEntity, Integer> {

	private ClassroomService classroomService;

    @Autowired
    public void setClassroomService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public ClassroomController() {

	}

	@Override
	public void add(ClassroomEntity object) {
        classroomService.add(object);
	}

    @Override
    public void add(List<ClassroomEntity> object) { classroomService.add(object); }

    @Override
    public void update(ClassroomEntity object) { classroomService.update(object); }

    @Override
	public ClassroomEntity getById(Integer id) { return classroomService.getById(id); }

	@Override
	public void delete(ClassroomEntity object) {
        classroomService.delete(object);
	}

	@Override
	public List<ClassroomEntity> getList() {
        return classroomService.getList();
	}

}
