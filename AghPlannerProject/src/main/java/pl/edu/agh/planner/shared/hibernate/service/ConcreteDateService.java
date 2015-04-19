package pl.edu.agh.planner.shared.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.shared.hibernate.dao.ConcreteDateDao;
import pl.edu.agh.planner.shared.hibernate.entity.ConcreteDateEntity;

import java.util.List;

@Service("concreteDateService")
public class ConcreteDateService implements ServiceInterface<ConcreteDateEntity, Integer> {

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
    public ConcreteDateEntity getById(Integer id) {
        return concreteDateDao.getById(id);
    }

    @Override
    public List<ConcreteDateEntity> getList() {
        return concreteDateDao.getList();
    }

}
