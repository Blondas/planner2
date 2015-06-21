package datasources;

import pl.edu.agh.planner.dao.ProgrammeUnitDao;
import pl.edu.agh.planner.domain.ProgrammeUnitEntity;

public class ProgrammeUnitDataSource {

    private ProgrammeUnitDao programmeUnitDao = new ProgrammeUnitDao();

    public ProgrammeUnitEntity createProgrammeUnit(String name){
        ProgrammeUnitEntity programmeUnitEntity = new ProgrammeUnitEntity();
        programmeUnitEntity.setName(name);

        programmeUnitDao.add(programmeUnitEntity);

        return programmeUnitEntity;
    }
}