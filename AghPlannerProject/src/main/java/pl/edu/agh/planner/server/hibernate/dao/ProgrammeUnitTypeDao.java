package pl.edu.agh.planner.server.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.server.hibernate.entity.ProgrammeUnitTypeEntity;
import pl.edu.agh.planner.server.hibernate.utils.GenericQuery;

@Component("programmeUnitTypeDao")
public class ProgrammeUnitTypeDao extends GenericQuery {


    public ProgrammeUnitTypeEntity getById (int id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ProgrammeUnitTypeEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ProgrammeUnitTypeEntity programmeUnitType = (ProgrammeUnitTypeEntity) criteria.uniqueResult();

        endTransaction();

        return programmeUnitType;
    }

    public void add(ProgrammeUnitTypeEntity programmeUnityType) {
        beginTransaction();
        getSession().save(programmeUnityType);
        endTransaction();
    }

    public void update(ProgrammeUnitTypeEntity programmeUnityType) {
        beginTransaction();
        getSession().update(programmeUnityType);
        endTransaction();
    }

    public void delete(ProgrammeUnitTypeEntity programmeUnityType) {
        beginTransaction();
        getSession().delete(programmeUnityType);
        endTransaction();
    }
}
