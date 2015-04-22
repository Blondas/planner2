package pl.edu.agh.planner.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.planner.client.PlannerService;
import pl.edu.agh.planner.server.controllers.TeacherController;
import pl.edu.agh.planner.shared.Classroom;
import pl.edu.agh.planner.shared.DtoToEntity;
import pl.edu.agh.planner.shared.Teacher;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;

import java.util.ArrayList;
import java.util.List;

public class PlannerServiceImpl extends RemoteServiceServlet implements PlannerService {


//    private DtoToEntity dtoToEntity;
//
//    @Autowired
//    public void setDtoToEntity(DtoToEntity dtoToEntity) {
//        this.dtoToEntity = dtoToEntity;
//    }

    @Override
	public void addTeacher(Teacher teacher) {
//		TeacherEntity teacherEntity = new TeacherEntity(teacher);
        TeacherEntity teacherEntity = DtoToEntity.teacherToEntity(teacher);

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
	public Teacher getTeacherById(int id) {
		TeacherEntity teacherEntity = new TeacherController().getById(id);

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