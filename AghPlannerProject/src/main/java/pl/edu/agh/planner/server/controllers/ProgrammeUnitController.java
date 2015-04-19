package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.dao.ProgrammeUnitDao;
import pl.edu.agh.planner.shared.hibernate.entity.ProgrammeUnitEntity;

import java.util.List;

@Controller("programmeUnitController")
public class ProgrammeUnitController implements ControllerInterface<ProgrammeUnitEntity, Integer>{

    private ProgrammeUnitDao programmeUnitDao;

    @Autowired
    public void setProgrammeUnitDao(ProgrammeUnitDao programmeUnitDao) {
        this.programmeUnitDao = programmeUnitDao;
    }

    @Override
    public ProgrammeUnitEntity getById(Integer id) {
        return programmeUnitDao.getById(id);
    }

    @Override
    public List<ProgrammeUnitEntity> getList() {
        return programmeUnitDao.getList();
    }

    @Override
    public void add(ProgrammeUnitEntity programmeUnitEntity) {
        programmeUnitDao.add(programmeUnitEntity);
    }

    @Override
    public void add(List<ProgrammeUnitEntity> programmeUnitEntities) {
        programmeUnitDao.add(programmeUnitEntities);
    }

    @Override
    public void update(ProgrammeUnitEntity programmeUnitEntity) {
        programmeUnitDao.update(programmeUnitEntity);
    }

    @Override
    public void delete(ProgrammeUnitEntity programmeUnitEntity) {
        programmeUnitDao.delete(programmeUnitEntity);
    }
}
