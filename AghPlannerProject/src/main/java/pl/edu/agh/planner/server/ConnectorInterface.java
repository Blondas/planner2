package pl.edu.agh.planner.server;

import java.util.List;

public interface ConnectorInterface<T> {

	public void add(T object);

	public void delete(T object);

	public List<T> getList();

}
