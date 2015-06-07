package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.ConcreteDateDao;
import pl.edu.agh.planner.domain.ConcreteDateEntity;

import java.util.List;

@Service("concreteDateService")
public class ConcreteDateService implements ServiceInterface<ConcreteDateEntity, Long> {

    private ConcreteDateDao concreteDateDao;

    @Autowired
    public void setConcreteDateDao(ConcreteDateDao concreteDateDao) {
        this.concreteDateDao = concreteDateDao;
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

    @Override
    public ConcreteDateEntity getById(Long id) {
        return concreteDateDao.getById(id);
    }

    @Override
    public List<ConcreteDateEntity> getList() {
        return concreteDateDao.getList();
    }

    @Override
    public ConcreteDateEntity saveOrUpdate(ConcreteDateEntity entity) {
        return concreteDateDao.saveOrUpdate(entity);
    }

}
