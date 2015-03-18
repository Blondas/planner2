package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.agh.planner.hibernate.entity.ProgrammeUnit;
import pl.edu.agh.planner.hibernate.utils.GenericQuery;

public class ProgrammeUnitDao extends GenericQuery {

    public ProgrammeUnit getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ProgrammeUnit.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ProgrammeUnit programmeUnit = (ProgrammeUnit) criteria.uniqueResult();

        endTransaction();

        return programmeUnit;
    }

    public void add(ProgrammeUnit programmeUnit) {
        beginTransaction();
        getSession().save(programmeUnit);
        endTransaction();
    }

    public void update(ProgrammeUnit programmeUnit) {
        beginTransaction();
        getSession().update(programmeUnit);
        endTransaction();
    }

    public void delete(ProgrammeUnit programmeUnit) {
        beginTransaction();
        getSession().delete(programmeUnit);
        endTransaction();
    }
}