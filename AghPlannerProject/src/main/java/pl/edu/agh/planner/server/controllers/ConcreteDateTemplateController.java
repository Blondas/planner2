package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.dao.ConcreteDateTemplateDao;
import pl.edu.agh.planner.shared.hibernate.entity.ConcreteDateTemplateEntity;

import java.util.List;

@Controller("concreteDateTemplateController")
public class ConcreteDateTemplateController implements ControllerInterface<ConcreteDateTemplateEntity, Integer>{

    private ConcreteDateTemplateDao concreteDateTemplateDao;

    @Autowired
    public void setConcreteDateTemplateDao(ConcreteDateTemplateDao concreteDateTemplateDao) {
        this.concreteDateTemplateDao = concreteDateTemplateDao;
    }

    @Override
    public ConcreteDateTemplateEntity getById(Integer id) {
        return concreteDateTemplateDao.getById(id);
    }

    @Override
    public List<ConcreteDateTemplateEntity> getList() {
        return concreteDateTemplateDao.getList();
    }

    @Override
    public void add(ConcreteDateTemplateEntity concreteDateTemplateEntity) {
        concreteDateTemplateDao.add(concreteDateTemplateEntity);
    }

    @Override
    public void add(List<ConcreteDateTemplateEntity> concreteDateTemplateEntities) {
        concreteDateTemplateDao.add(concreteDateTemplateEntities);
    }

    @Override
    public void update(ConcreteDateTemplateEntity concreteDateTemplateEntity) {
        concreteDateTemplateDao.update(concreteDateTemplateEntity);
    }

    @Override
    public void delete(ConcreteDateTemplateEntity concreteDateTemplateEntity) {
        concreteDateTemplateDao.delete(concreteDateTemplateEntity);
    }
}
