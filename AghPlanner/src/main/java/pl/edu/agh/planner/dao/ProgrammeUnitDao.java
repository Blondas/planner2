package pl.edu.agh.planner.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.domain.ProgrammeUnitEntity;
import pl.edu.agh.planner.utils.GenericQuery;

import java.util.List;

@Component("programmeUnitDao")
public class ProgrammeUnitDao extends GenericQuery implements  DaoInterface<ProgrammeUnitEntity, Long>{

    @Override
    public ProgrammeUnitEntity getById (Long id) {
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

    @Override
    public ProgrammeUnitEntity saveOrUpdate(ProgrammeUnitEntity object) {
        beginTransaction();
        getSession().saveOrUpdate(object);
        endTransaction();

        return object;
    }
}