package pl.edu.agh.planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.planner.dao.ProgrammeUnitDao;
import pl.edu.agh.planner.domain.ProgrammeUnitEntity;

@Service("programmeUnitService")
public class ProgrammeUnitService implements ServiceInterface<ProgrammeUnitEntity, Long>{

    private ProgrammeUnitDao programmeUnitDao;

    @Autowired
    public void setProgrammeUnitDao(ProgrammeUnitDao programmeUnitDao) {
        this.programmeUnitDao = programmeUnitDao;
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

    @Override
    public ProgrammeUnitEntity getById(Long id) {
        return programmeUnitDao.getById(id);
    }

    @Override
    public List<ProgrammeUnitEntity> getList() {
        return programmeUnitDao.getList();
    }

    @Override
    public ProgrammeUnitEntity saveOrUpdate(ProgrammeUnitEntity entity) {
        return programmeUnitDao.saveOrUpdate(entity);
    }

    public List<ProgrammeUnitEntity> getProgrammeUnitsWithoutAggregate(){
        return programmeUnitDao.getProgrammeUnitsWithoutAggregate();
    }
}
