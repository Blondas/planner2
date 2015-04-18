package pl.edu.agh.planner.server.connectors;

import pl.edu.agh.planner.server.ConnectorInterface;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;
import pl.edu.agh.planner.shared.hibernate.service.TeacherService;

import java.util.List;

public class TeacherDbConnector implements ConnectorInterface<TeacherEntity> {

	public TeacherDbConnector() {

	}

	@Override
	public void add(TeacherEntity object) {
		new TeacherService().add(object);
	}

	@Override
	public void delete(TeacherEntity object) {
		new TeacherService().delete(object);
	}

	@Override
	public List<TeacherEntity> getList() {
		return new TeacherService().getList();
	}

}
