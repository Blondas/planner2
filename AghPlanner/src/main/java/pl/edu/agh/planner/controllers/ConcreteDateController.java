package pl.edu.agh.planner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.planner.domain.ConcreteDateEntity;
import pl.edu.agh.planner.dto.ConcreteDate;
import pl.edu.agh.planner.service.ConcreteDateService;
import pl.edu.agh.planner.utils.DtoEntityMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ConcreteDateController {

    @Autowired
    private ConcreteDateService concreteDateService;

    @RequestMapping(method=GET,value="/concreteDate")
    public ConcreteDate getConcreteDate(@RequestParam("id") Long id){
        ConcreteDateEntity concreteDateEntity = concreteDateService.getById(id);
        return DtoEntityMapper.entityToConcreteDate(concreteDateEntity);
    }

    @RequestMapping(method=GET,value="/concreteDates")
    public List<ConcreteDate> findConcreteDates(){
        List<ConcreteDateEntity> concreteDateEntities = concreteDateService.getList();
        List<ConcreteDate> concreteLessons = concreteDateEntities.stream().map(DtoEntityMapper::entityToConcreteDate).collect(Collectors.toList());

        return concreteLessons;
    }

    @RequestMapping(method=DELETE,value="/concreteDate")
    public void deleteConcreteDate(@RequestBody ConcreteDate concreteDate){
        ConcreteDateEntity concreteDateEntity = DtoEntityMapper.concreteDateToEntity(concreteDate);
        concreteDateService.delete(concreteDateEntity);
    }

    @RequestMapping(method=POST,value="/concreteLesson")
    public ConcreteDate saveOrUpdate(@RequestBody ConcreteDate concreteDate){
        ConcreteDateEntity concreteDateEntity = DtoEntityMapper.concreteDateToEntity(concreteDate);
        return DtoEntityMapper.entityToConcreteDate(concreteDateService.saveOrUpdate(concreteDateEntity));
    }
}
