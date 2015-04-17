package pl.edu.agh.planner.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pl.edu.agh.planner.server.hibernate.entity.TeacherEntity;
import pl.edu.agh.planner.shared.Teacher;

import java.util.ArrayList;

/**
 * The client side stub for the RPC service.
 */
public interface PlannerServiceAsync {

	public void getTeachers(AsyncCallback<ArrayList<Teacher>> async);

	void getTestTeachers(AsyncCallback<TeacherEntity> async);
}
