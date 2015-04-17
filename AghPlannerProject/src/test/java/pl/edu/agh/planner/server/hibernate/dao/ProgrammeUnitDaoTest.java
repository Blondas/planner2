package pl.edu.agh.planner.server.hibernate.dao;

import org.junit.Test;
import pl.edu.agh.planner.server.hibernate.entity.ProgrammeUnitEntity;
import pl.edu.agh.planner.server.hibernate.entity.ProgrammeUnitTypeEntity;


public class ProgrammeUnitDaoTest {


    @Test
    public void shouldSave(){
        //given
        ProgrammeUnitTypeEntity type = new ProgrammeUnitTypeEntity();
        type.setName("Marmolada");

        ProgrammeUnitTypeDao programmeUnitTypeDao = new ProgrammeUnitTypeDao();
        programmeUnitTypeDao.add(type);

        ProgrammeUnitEntity unit = new ProgrammeUnitEntity();
        unit.setType(type);
        unit.setName("Ubijanie masla lokciem");

        ProgrammeUnitDao dao = new ProgrammeUnitDao();
        dao.add(unit);



    }

}
