package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.ProgrammeUnitEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

@Component("programmeUnitDao")
public class ProgrammeUnitDao extends GenericQuery {

    public ProgrammeUnitEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ProgrammeUnitEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ProgrammeUnitEntity programmeUnit = (ProgrammeUnitEntity) criteria.uniqueResult();

        endTransaction();

        return programmeUnit;
    }

    public void add(ProgrammeUnitEntity programmeUnit) {
        beginTransaction();
        getSession().save(programmeUnit);
        endTransaction();
    }

    public void update(ProgrammeUnitEntity programmeUnit) {
        beginTransaction();
        getSession().update(programmeUnit);
        endTransaction();
    }

    public void delete(ProgrammeUnitEntity programmeUnit) {
        beginTransaction();
        getSession().delete(programmeUnit);
        endTransaction();
    }
}