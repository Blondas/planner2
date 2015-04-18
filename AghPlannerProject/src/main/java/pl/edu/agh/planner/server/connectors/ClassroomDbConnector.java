package pl.edu.agh.planner.server.connectors;

import pl.edu.agh.planner.shared.hibernate.entity.ClassroomEntity;
import pl.edu.agh.planner.shared.hibernate.service.ClassroomService;

import java.io.Serializable;
import java.util.List;

public class ClassroomDbConnector implements ConnectorInterface<ClassroomEntity, Integer> {

	public ClassroomDbConnector() {

	}

	@Override
	public void add(ClassroomEntity object) {
		new ClassroomService().add(object);
	}

	@Override
	public ClassroomEntity findById(Integer id) {
		return new ClassroomService().findById(id);
	}

	@Override
	public void delete(ClassroomEntity object) {
		new ClassroomService().delete(object);
	}

	@Override
	public List<ClassroomEntity> getList() {
		return new ClassroomService().getList();
	}

}
