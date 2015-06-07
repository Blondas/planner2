package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.AggregateDao;
import pl.edu.agh.planner.domain.AggregateEntity;

import java.util.List;

@Service("aggregateService")
public class AggregateService implements ServiceInterface<AggregateEntity, Long> {

    private AggregateDao aggregateDao;

    @Autowired
    public void setAggregateDao(AggregateDao aggregateDao) {
        this.aggregateDao = aggregateDao;
    }


    @Override
    public void add(AggregateEntity entity) {
        aggregateDao.add(entity);
    }

    @Override
    public void add(List<AggregateEntity> object) { aggregateDao.add(object); }

    @Override
    public void update(AggregateEntity entity) {
        aggregateDao.update(entity);
    }

    @Override
    public void delete(AggregateEntity entity) {
        aggregateDao.delete(entity);
    }

    @Override
    public AggregateEntity getById(Long id) { return aggregateDao.getById(id); }

    @Override
    public List<AggregateEntity> getList() { return aggregateDao.getList(); }

    @Override
    public AggregateEntity saveOrUpdate(AggregateEntity entity) {
        return aggregateDao.saveOrUpdate(entity);
    }
}
