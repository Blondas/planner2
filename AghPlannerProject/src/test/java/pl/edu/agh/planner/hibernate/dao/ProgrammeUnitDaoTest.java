package pl.edu.agh.planner.hibernate.dao;

import org.junit.Test;
import pl.edu.agh.planner.hibernate.entity.ProgrammeUnit;
import pl.edu.agh.planner.hibernate.entity.ProgrammeUnitType;


public class ProgrammeUnitDaoTest {


    @Test
    public void shouldSave(){
        //given
        ProgrammeUnitType type = new ProgrammeUnitType();
        type.setName("Marmolada");

        ProgrammeUnitTypeDao programmeUnitTypeDao = new ProgrammeUnitTypeDao();
        programmeUnitTypeDao.add(type);

        ProgrammeUnit unit = new ProgrammeUnit();
        unit.setType(type);
        unit.setName("Ubijanie masla lokciem");

        ProgrammeUnitDao dao = new ProgrammeUnitDao();
        dao.add(unit);



    }

}
