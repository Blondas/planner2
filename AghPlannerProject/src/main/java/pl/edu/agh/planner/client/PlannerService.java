package pl.edu.agh.planner.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pl.edu.agh.planner.shared.Teacher;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;

import java.util.List;

@RemoteServiceRelativePath("PlannerService")
public interface PlannerService extends RemoteService {


	public void addTeacher(Teacher teacher);
	public void deleteTeacher(Teacher teacher);
	public List<Teacher> getTeachersList();
	public Teacher getById(int id);

}
