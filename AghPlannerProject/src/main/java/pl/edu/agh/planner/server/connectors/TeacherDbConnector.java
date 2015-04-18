package pl.edu.agh.planner.server.connectors;

import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;
import pl.edu.agh.planner.shared.hibernate.service.TeacherService;

import java.io.Serializable;
import java.util.List;

public class TeacherDbConnector implements ConnectorInterface<TeacherEntity, Integer> {

	public TeacherDbConnector() {

	}

	@Override
	public void add(TeacherEntity object) {
		new TeacherService().add(object);
	}

	@Override
	public TeacherEntity findById(Integer id) {
		return new TeacherService().findById(id);
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
