package pl.edu.agh.planner.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pl.edu.agh.planner.shared.Teacher;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;

import java.util.List;

/**
 * The client side stub for the RPC service.
 */
public interface PlannerServiceAsync {

	void getTeachersList(AsyncCallback<List<Teacher>> async);

	void deleteTeacher(Teacher teacher, AsyncCallback<Void> async);

	void addTeacher(Teacher teacher, AsyncCallback<Void> async);
}
