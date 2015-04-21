package pl.edu.agh.planner.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pl.edu.agh.planner.shared.Classroom;
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

	void getTeacherById(int id, AsyncCallback<Teacher> async);

	void addClassroom(Classroom classroom, AsyncCallback<Void> async);

	void deleteClassroom(Classroom classroom, AsyncCallback<Void> async);

	void getClassroomsList(AsyncCallback<List<Classroom>> async);

	void getClassroomById(int id, AsyncCallback<Classroom> async);
}
