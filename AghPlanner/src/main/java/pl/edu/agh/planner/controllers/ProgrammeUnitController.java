package pl.edu.agh.planner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.planner.dao.ProgrammeUnitDao;
import pl.edu.agh.planner.domain.AvatarEntity;
import pl.edu.agh.planner.domain.ProgrammeUnitEntity;
import pl.edu.agh.planner.domain.TeacherEntity;
import pl.edu.agh.planner.dto.Avatar;
import pl.edu.agh.planner.dto.ProgrammeUnit;
import pl.edu.agh.planner.utils.DtoEntityMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProgrammeUnitController {

    @Autowired
    private ProgrammeUnitDao programmeUnitDao;

    @RequestMapping(method=GET,value="/programmeUnit")
    public ProgrammeUnit getProgrammeUnit(@RequestParam("id") Long id){
        ProgrammeUnitEntity programmeUnitEntity = programmeUnitDao.getById(id);
        return DtoEntityMapper.entityToProgrammeUnit(programmeUnitEntity);
    }

    @RequestMapping(method=GET,value="/programmeUnits")
    public List<ProgrammeUnit> findProgrammeUnits(){
        List<ProgrammeUnitEntity> programmeUnitEntities = programmeUnitDao.getList();
        List<ProgrammeUnit> programmeUnits = programmeUnitEntities.stream().map(DtoEntityMapper::entityToProgrammeUnit).collect(Collectors.toList());

        return programmeUnits;
    }

    @RequestMapping(method=DELETE,value="/programmeUnit")
    public void deleteProgrammeUnit(@RequestBody ProgrammeUnit programmeUnit){
        ProgrammeUnitEntity programmeUnitEntity = DtoEntityMapper.programmeUnitToEntity(programmeUnit);
        programmeUnitDao.delete(programmeUnitEntity);
    }

    @RequestMapping(method=POST,value="/programmeUnit")
    public ProgrammeUnit saveOrUpdate(@RequestBody ProgrammeUnit programmeUnit){
        ProgrammeUnitEntity programmeUnitEntity = DtoEntityMapper.programmeUnitToEntity(programmeUnit);

        return DtoEntityMapper.entityToProgrammeUnit(programmeUnitDao.saveOrUpdate(programmeUnitEntity));
    }
}
