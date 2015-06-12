package pl.edu.agh.planner.dao;

import java.util.List;

public interface DaoInterface<T, Id> {

    public T getById(Id id);

    public List<T> getList();

    public void add(T object);

    public void add(List<T> object);

    public void update(T object);

    public void delete(T object);

    public T saveOrUpdate(T object);

}
