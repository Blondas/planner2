package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.entity.AggregateEntity;
import pl.edu.agh.planner.shared.hibernate.service.AggregateService;

import java.util.List;

@Controller("aggregateController")
public class AggregateController implements ControllerInterface<AggregateEntity, Integer> {

    private AggregateService aggregateService;

    @Autowired
    public void setAggregateService(AggregateService aggregateService) {
        this.aggregateService = aggregateService;
    }

    @Override
    public AggregateEntity getById(Integer id) {
        return aggregateService.getById(id);
    }

    @Override
    public List<AggregateEntity> getList() {
        return aggregateService.getList();
    }

    @Override
    public void add(AggregateEntity aggregateEntity) {
        aggregateService.add(aggregateEntity);
    }

    @Override
    public void add(List<AggregateEntity> aggregateEntities) {
        aggregateService.add(aggregateEntities);
    }

    @Override
    public void update(AggregateEntity aggregateEntity) {
        aggregateService.update(aggregateEntity);
    }

    @Override
    public void delete(AggregateEntity aggregateEntity) {
        aggregateService.delete(aggregateEntity);
    }
}
