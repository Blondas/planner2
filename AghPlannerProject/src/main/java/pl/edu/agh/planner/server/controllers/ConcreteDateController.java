package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.dao.ConcreteDateDao;
import pl.edu.agh.planner.shared.hibernate.entity.ConcreteDateEntity;

import java.util.List;

@Controller("concreteDateController")
public class ConcreteDateController implements ControllerInterface<ConcreteDateEntity, Integer>{

    private ConcreteDateDao concreteDateDao;

    @Autowired
    public void setConcreteDateDao(ConcreteDateDao concreteDateDao) {
        this.concreteDateDao = concreteDateDao;
    }

    @Override
    public ConcreteDateEntity getById(Integer id) {
        return concreteDateDao.getById(id);
    }

    @Override
    public List<ConcreteDateEntity> getList() {
        return concreteDateDao.getList();
    }

    @Override
    public void add(ConcreteDateEntity concreteDateEntity) {
        concreteDateDao.add(concreteDateEntity);
    }

    @Override
    public void add(List<ConcreteDateEntity> concreteDateEntities) {
        concreteDateDao.add(concreteDateEntities);
    }

    @Override
    public void update(ConcreteDateEntity concreteDateEntity) {
        concreteDateDao.update(concreteDateEntity);
    }

    @Override
    public void delete(ConcreteDateEntity concreteDateEntity) {
        concreteDateDao.delete(concreteDateEntity);
    }
}
