package pl.edu.agh.planner.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pl.edu.agh.planner.server.hibernate.entity.TeacherEntity;
import pl.edu.agh.planner.shared.Teacher;

import java.util.ArrayList;

@RemoteServiceRelativePath("PlannerService")
public interface PlannerService extends RemoteService {

	public ArrayList<Teacher> getTeachers();

	public TeacherEntity getTestTeachers();
}
