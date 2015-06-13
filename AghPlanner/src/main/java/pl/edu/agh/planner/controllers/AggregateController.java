package pl.edu.agh.planner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.planner.dao.AggregateDao;
import pl.edu.agh.planner.domain.AggregateEntity;
import pl.edu.agh.planner.dto.Aggregate;
import pl.edu.agh.planner.utils.DtoEntityMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AggregateController {

    @Autowired
    private AggregateDao aggregateDao;


    @RequestMapping(method=GET,value="/aggregate")
    public Aggregate getAggregate(@RequestParam("id") Long id){
        AggregateEntity aggregateEntity = aggregateDao.getById(id);
        return DtoEntityMapper.entityToAggregate(aggregateEntity);
    }

    @RequestMapping(method=GET,value="/aggregates")
    public List<Aggregate> findAggregates(){
        List<AggregateEntity> avatarEntity = aggregateDao.getList();
        List<Aggregate> aggregates = avatarEntity.stream().map(DtoEntityMapper::entityToAggregate).collect(Collectors.toList());

        return aggregates;
    }

    @RequestMapping(method=DELETE,value="/aggregate")
    public void deleteAggregate(@RequestBody Aggregate aggregate){
        AggregateEntity aggregateEntity = DtoEntityMapper.aggregateToEntity(aggregate);
        aggregateDao.delete(aggregateEntity);
    }

    @RequestMapping(method=POST,value="/aggregate")
    public Aggregate saveOrUpdate(@RequestBody Aggregate aggregate){
        AggregateEntity aggregateEntity = DtoEntityMapper.aggregateToEntity(aggregate);

        return DtoEntityMapper.entityToAggregate(aggregateDao.saveOrUpdate(aggregateEntity));
    }

}
