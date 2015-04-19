package pl.edu.agh.planner.shared.hibernate.service;

import java.io.Serializable;
import java.util.List;

public interface ServiceInterface<T, Id extends Serializable> {

	public void add(T entity);

    public void add(List<T> object);

	public void update(T entity);

	public void delete(T entity);

	public T getById(Id id);

	public List<T> getList();

}