package pl.edu.agh.planner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.planner.domain.BuildingEntity;
import pl.edu.agh.planner.dto.Building;
import pl.edu.agh.planner.service.BuildingService;
import pl.edu.agh.planner.utils.DtoEntityMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;


    @RequestMapping(method=GET,value="/buildings")
    public List<Building> findBuildings(){
        List<BuildingEntity> buildingEntities = buildingService.getList();
        List<Building> buildings = buildingEntities.stream().map(DtoEntityMapper::entityToBuilding).collect(Collectors.toList());

        return buildings;
    }


}