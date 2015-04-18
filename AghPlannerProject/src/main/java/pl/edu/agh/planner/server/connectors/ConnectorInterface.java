package pl.edu.agh.planner.server.connectors;

import java.io.Serializable;
import java.util.List;

public interface ConnectorInterface<T, Id extends Serializable> {

	public void add(T object);

	public T findById(Id id);

	public void delete(T object);

	public List<T> getList();

}
