package pl.edu.agh.planner.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pl.edu.agh.planner.client.PlannerService;
import pl.edu.agh.planner.server.controllers.TeacherController;
import pl.edu.agh.planner.shared.Classroom;
import pl.edu.agh.planner.shared.DtoEntityMapper;
import pl.edu.agh.planner.shared.Teacher;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;

import java.util.ArrayList;
import java.util.List;

public class PlannerServiceImpl extends RemoteServiceServlet implements PlannerService {

    private TeacherController teacherController = new TeacherController();


    @Override
	public void addTeacher(Teacher teacher) {
        TeacherEntity teacherEntity = DtoEntityMapper.teacherToEntity(teacher);

		teacherController.add(teacherEntity);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
        TeacherEntity teacherEntity = DtoEntityMapper.teacherToEntity(teacher);

		teacherController.delete(teacherEntity);
	}

	@Override
	public List<Teacher> getTeachersList() {
		List<Teacher> teacherList = new ArrayList<Teacher>();

		List<TeacherEntity> teacherEntities = teacherController.getList();

		for (TeacherEntity teacherEntity : teacherEntities) {
			Teacher teacher = DtoEntityMapper.entityToTeacher(teacherEntity);

			teacherList.add(teacher);
		}

		return teacherList;
	}

	@Override
	public Teacher getTeacherById(int id) {
		TeacherEntity teacherEntity = teacherController.getById(id);

        return new Teacher(teacherEntity);
	}

	@Override
	public void addClassroom(Classroom classroom) {

	}

	@Override
	public void deleteClassroom(Classroom classroom) {

	}

	@Override
	public List<Classroom> getClassroomsList() {
		return null;
	}

	@Override
	public Classroom getClassroomById(int id) {
		return null;
	}

}