package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.ProgrammeUnitType;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

public class ProgrammeUnitTypeDao extends GenericQuery {


    public ProgrammeUnitType getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ProgrammeUnitType.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ProgrammeUnitType programmeUnitType = (ProgrammeUnitType) criteria.uniqueResult();

        endTransaction();

        return programmeUnitType;
    }

    public void add(ProgrammeUnitType programmeUnityType) {
        beginTransaction();
        getSession().save(programmeUnityType);
        endTransaction();
    }

    public void update(ProgrammeUnitType programmeUnityType) {
        beginTransaction();
        getSession().update(programmeUnityType);
        endTransaction();
    }

    public void delete(ProgrammeUnitType programmeUnityType) {
        beginTransaction();
        getSession().delete(programmeUnityType);
        endTransaction();
    }
}
