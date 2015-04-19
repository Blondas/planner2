package pl.edu.agh.planner.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pl.edu.agh.planner.client.PlannerService;
import pl.edu.agh.planner.server.controllers.TeacherController;
import pl.edu.agh.planner.shared.Teacher;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;

import java.util.ArrayList;
import java.util.List;

public class PlannerServiceImpl extends RemoteServiceServlet implements PlannerService {

	@Override
	public void addTeacher(Teacher teacher) {
		TeacherEntity teacherEntity = new TeacherEntity(teacher);

		TeacherController teacherController = new TeacherController();
		teacherController.add(teacherEntity);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		TeacherEntity teacherEntity = new TeacherEntity(teacher);

		TeacherController teacherController = new TeacherController();
		teacherController.delete(teacherEntity);
	}

	@Override
	public List<Teacher> getTeachersList() {
		List<Teacher> teacherList = new ArrayList<Teacher>();

		List<TeacherEntity> teacherEntities = new TeacherController().getList();

		for (TeacherEntity teacherEntity : teacherEntities) {
			Teacher teacher = new Teacher(teacherEntity);
			teacherList.add(teacher);
		}

		return teacherList;
	}

	@Override
	public Teacher getById(int id) {
		TeacherEntity teacherEntity = new TeacherController().getById(id);

		return new Teacher(teacherEntity);
	}

}