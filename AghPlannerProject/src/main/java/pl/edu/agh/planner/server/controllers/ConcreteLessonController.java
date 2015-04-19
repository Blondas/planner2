package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.dao.ConcreteLessonDao;
import pl.edu.agh.planner.shared.hibernate.entity.ConcreteLessonEntity;

import java.util.List;

@Controller("concreteLessonController")
public class ConcreteLessonController implements ControllerInterface<ConcreteLessonEntity, Integer>{

    private ConcreteLessonDao concreteLessonDao;

    @Autowired
    public void setConcreteLessonDao(ConcreteLessonDao concreteLessonDao) {
        this.concreteLessonDao = concreteLessonDao;
    }

    @Override
    public ConcreteLessonEntity getById(Integer id) {
        return concreteLessonDao.getById(id);
    }

    @Override
    public List<ConcreteLessonEntity> getList() {
        return concreteLessonDao.getList();
    }

    @Override
    public void add(ConcreteLessonEntity concreteLessonEntity) {
        concreteLessonDao.add(concreteLessonEntity);
    }

    @Override
    public void add(List<ConcreteLessonEntity> concreteLessonEntities) {
        concreteLessonDao.add(concreteLessonEntities);
    }

    @Override
    public void update(ConcreteLessonEntity concreteLessonEntity) {
        concreteLessonDao.update(concreteLessonEntity);
    }

    @Override
    public void delete(ConcreteLessonEntity concreteLessonEntity) {
        concreteLessonDao.delete(concreteLessonEntity);
    }
}
