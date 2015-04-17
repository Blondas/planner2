package pl.edu.agh.planner.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pl.edu.agh.planner.client.PlannerService;
import pl.edu.agh.planner.server.hibernate.entity.TeacherEntity;
import pl.edu.agh.planner.shared.Teacher;

import java.util.ArrayList;

public class PlannerServiceImpl extends RemoteServiceServlet implements PlannerService {

	@Override
	public ArrayList<Teacher> getTeachers() {
		return new TeacherDBTest().getTeachers();
	}

	@Override
	public TeacherEntity getTestTeachers() {
		return new TeacherDBTest().getTeacherEntity();
	}


}