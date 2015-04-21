package pl.edu.agh.planner.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pl.edu.agh.planner.shared.Classroom;
import pl.edu.agh.planner.shared.Teacher;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;

import java.util.List;

@RemoteServiceRelativePath("PlannerService")
public interface PlannerService extends RemoteService {


	public void addTeacher(Teacher teacher);
	public void deleteTeacher(Teacher teacher);
	public List<Teacher> getTeachersList();
	public Teacher getTeacherById(int id);

	public void addClassroom(Classroom classroom);
	public void deleteClassroom(Classroom classroom);
	public List<Classroom> getClassroomsList();
	public Classroom getClassroomById(int id);

}
