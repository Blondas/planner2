package pl.edu.agh.planner.server.controllers;

import java.io.Serializable;
import java.util.List;

public interface ControllerInterface<T, Id extends Serializable> {

    public T getById(Id id);

    public List<T> getList();

    public void add(T object);

    public void add(List<T> object);

    public void update(T object);

	public void delete(T object);



}
