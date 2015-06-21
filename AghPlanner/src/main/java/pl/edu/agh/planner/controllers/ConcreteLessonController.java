package pl.edu.agh.planner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.planner.domain.ConcreteLessonEntity;
import pl.edu.agh.planner.dto.ConcreteLesson;
import pl.edu.agh.planner.service.ConcreteLessonService;
import pl.edu.agh.planner.utils.DtoEntityMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ConcreteLessonController {

    @Autowired
    private ConcreteLessonService concreteLessonService;

    @RequestMapping(method=GET,value="/concreteLesson")
    public ConcreteLesson getConcreteLesson(@RequestParam("id") Long id){
        ConcreteLessonEntity concreteLessonEntity = concreteLessonService.getById(id);
        return DtoEntityMapper.entityToConcreteLesson(concreteLessonEntity);
    }

    @RequestMapping(method=GET,value="/concreteLessons")
    public List<ConcreteLesson> findConcreteLessons(){
        List<ConcreteLessonEntity> concreteLessonEntities = concreteLessonService.getList();
        List<ConcreteLesson> concreteLessons = concreteLessonEntities.stream().map(DtoEntityMapper::entityToConcreteLesson).collect(Collectors.toList());

        return concreteLessons;
    }

    @RequestMapping(method=DELETE,value="/concreteLesson")
    public void deleteConcreteLesson(@RequestBody ConcreteLesson concreteLesson){
        ConcreteLessonEntity concreteLessonEntity = DtoEntityMapper.concreteLessonToEntity(concreteLesson);
        concreteLessonService.delete(concreteLessonEntity);
    }

    @RequestMapping(method=POST,value="/concreteLesson")
    public ConcreteLesson saveOrUpdate(@RequestBody ConcreteLesson concreteLesson){
        ConcreteLessonEntity concreteLessonEntity = DtoEntityMapper.concreteLessonToEntity(concreteLesson);
        return DtoEntityMapper.entityToConcreteLesson(concreteLessonService.saveOrUpdate(concreteLessonEntity));
    }
}
