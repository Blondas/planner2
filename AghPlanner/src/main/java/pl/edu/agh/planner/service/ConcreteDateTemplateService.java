package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.ConcreteDateTemplateDao;
import pl.edu.agh.planner.domain.ConcreteDateTemplateEntity;

import java.util.List;

@Service("concreteDateTemplateService")
public class ConcreteDateTemplateService implements ServiceInterface<ConcreteDateTemplateEntity, Long>{

    private ConcreteDateTemplateDao concreteDateTemplateDao;

    @Autowired
    public void setConcreteDateTemplateDao(ConcreteDateTemplateDao concreteDateTemplateDao) {
        this.concreteDateTemplateDao = concreteDateTemplateDao;
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

    @Override
    public ConcreteDateTemplateEntity getById(Long id) {
        return concreteDateTemplateDao.getById(id);
    }

    @Override
    public List<ConcreteDateTemplateEntity> getList() {
        return concreteDateTemplateDao.getList();
    }

    @Override
    public ConcreteDateTemplateEntity saveOrUpdate(ConcreteDateTemplateEntity entity) {
        return null;
    }
}
