package pl.edu.agh.planner.shared.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.shared.hibernate.dao.ProgrammeUnitTypeDao;
import pl.edu.agh.planner.shared.hibernate.entity.ProgrammeUnitTypeEntity;

import java.util.List;

@Service("programmeUnitTypeService ")
public class ProgrammeUnitTypeService implements ServiceInterface<ProgrammeUnitTypeEntity, Integer>{

    private ProgrammeUnitTypeDao programmeUnitTypeDao;

    @Autowired
    public void setProgrammeUnitTypeDao(ProgrammeUnitTypeDao programmeUnitTypeDao) {
        this.programmeUnitTypeDao = programmeUnitTypeDao;
    }


    @Override
    public void add(ProgrammeUnitTypeEntity programmeUnitTypeEntity) {
        programmeUnitTypeDao.add(programmeUnitTypeEntity);
    }

    @Override
    public void add(List<ProgrammeUnitTypeEntity> programmeUnitTypeEntities) {
        programmeUnitTypeDao.add(programmeUnitTypeEntities);
    }

    @Override
    public void update(ProgrammeUnitTypeEntity programmeUnitTypeEntity) {
        programmeUnitTypeDao.update(programmeUnitTypeEntity);
    }

    @Override
    public void delete(ProgrammeUnitTypeEntity programmeUnitTypeEntity) {
        programmeUnitTypeDao.delete(programmeUnitTypeEntity);
    }

    @Override
    public ProgrammeUnitTypeEntity getById(Integer id) {
        return programmeUnitTypeDao.getById(id);
    }

    @Override
    public List<ProgrammeUnitTypeEntity> getList() {
        return programmeUnitTypeDao.getList();
    }
}
