package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.ProgrammeUnitEntity;
import pl.edu.agh.planner.shared.hibernate.entity.ProgrammeUnitTypeEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("programmeUnitDao")
public class ProgrammeUnitDao extends GenericQuery implements  DaoInterface<ProgrammeUnitEntity, Integer>{

    @Override
    public ProgrammeUnitEntity getById (Integer id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ProgrammeUnitEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ProgrammeUnitEntity programmeUnit = (ProgrammeUnitEntity) criteria.uniqueResult();

        endTransaction();

        return programmeUnit;
    }

    @Override
    public List<ProgrammeUnitEntity> getList() {
        beginTransaction();
        List<ProgrammeUnitEntity> list = session.createCriteria(ProgrammeUnitEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(ProgrammeUnitEntity programmeUnit) {
        beginTransaction();
        getSession().save(programmeUnit);
        endTransaction();
    }

    @Override
    public void add(List<ProgrammeUnitEntity> programmeUnitEntities) {
        beginTransaction();
        for ( int i=0; i<programmeUnitEntities.size(); i++ ) {
            getSession().save(programmeUnitEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
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