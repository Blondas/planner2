package datasources;

import pl.edu.agh.planner.dao.ProgrammeUnitDao;
import pl.edu.agh.planner.domain.ProgrammeUnitEntity;

/**
 * Created by krystian on 06.06.15.
 */
public class ProgrammeUnitDataSource {

    private ProgrammeUnitDao programmeUnitDao = new ProgrammeUnitDao();

    public ProgrammeUnitEntity createProgrammeUnit(String name){
        ProgrammeUnitEntity programmeUnitEntity = new ProgrammeUnitEntity();
        programmeUnitEntity.setName(name);

        programmeUnitDao.add(programmeUnitEntity);

        return programmeUnitEntity;
    }
}