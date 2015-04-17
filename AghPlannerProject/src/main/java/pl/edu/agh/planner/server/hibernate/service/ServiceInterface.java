package pl.edu.agh.planner.server.hibernate.service;

import java.io.Serializable;
import java.util.List;

public interface ServiceInterface<T, Id extends Serializable> {

	public void add(T entity);

	public void update(T entity);

	public T findById(Id id);

	public void delete(Id id);

	public List<T> findAll();

	public void deleteAll();

}