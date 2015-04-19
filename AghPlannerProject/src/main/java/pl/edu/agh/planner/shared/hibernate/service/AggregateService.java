package pl.edu.agh.planner.shared.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.shared.hibernate.dao.AggregateDao;
import pl.edu.agh.planner.shared.hibernate.entity.AggregateEntity;

import java.util.List;

@Service("aggregateService")
public class AggregateService implements ServiceInterface<AggregateEntity, Integer> {

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
    public AggregateEntity getById(Integer integer) { return aggregateDao.getById(integer); }

    @Override
    public List<AggregateEntity> getList() { return aggregateDao.getList(); }
}
