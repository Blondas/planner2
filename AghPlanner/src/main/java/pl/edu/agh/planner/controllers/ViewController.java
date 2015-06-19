package pl.edu.agh.planner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.planner.domain.ViewEntity;
import pl.edu.agh.planner.dto.View;
import pl.edu.agh.planner.service.ViewService;
import pl.edu.agh.planner.utils.DtoEntityMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
public class ViewController {

    @Autowired
    private ViewService viewService;

    @RequestMapping(method=GET,value="/view")
    public View getView(@RequestParam("id") Long viewId){
        ViewEntity viewEntity = viewService.getById(viewId);
        return DtoEntityMapper.entityToView(viewEntity);
    }

    @RequestMapping(method=GET,value="/views")
    public List<View> findViews(){
        List<ViewEntity> viewEntity = viewService.getList();
        List<View> views = viewEntity.stream().map(DtoEntityMapper::entityToView).collect(Collectors.toList());

        return views;
    }

    @RequestMapping(method=DELETE,value="/views")
    public void deleteView(@RequestBody View view){
        ViewEntity viewEntity = DtoEntityMapper.viewToEntity(view);
        viewService.delete(viewEntity);
    }

    @RequestMapping(method=POST,value="/view")
    public View saveOrUpdate(@RequestBody View view){
        ViewEntity viewEntity = DtoEntityMapper.viewToEntity(view);
        return DtoEntityMapper.entityToView(viewService.saveOrUpdate(viewEntity));
    }
}

