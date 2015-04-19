package pl.edu.agh.planner.shared.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.shared.hibernate.entity.ProgrammeUnitTypeEntity;
import pl.edu.agh.planner.shared.hibernate.utils.GenericQuery;

import java.util.List;

@Component("programmeUnitTypeDao")
public class ProgrammeUnitTypeDao extends GenericQuery implements DaoInterface<ProgrammeUnitTypeEntity, Integer>{

    @Override
    public ProgrammeUnitTypeEntity getById (Integer id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ProgrammeUnitTypeEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ProgrammeUnitTypeEntity programmeUnitType = (ProgrammeUnitTypeEntity) criteria.uniqueResult();

        endTransaction();

        return programmeUnitType;
    }

    @Override
    public List<ProgrammeUnitTypeEntity> getList() {
        beginTransaction();
        List<ProgrammeUnitTypeEntity> list = session.createCriteria(ProgrammeUnitTypeEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(ProgrammeUnitTypeEntity programmeUnityType) {
        beginTransaction();
        getSession().save(programmeUnityType);
        endTransaction();
    }

    @Override
    public void add(List<ProgrammeUnitTypeEntity> programmeUnitTypeEntities) {
        beginTransaction();
        for ( int i=0; i<programmeUnitTypeEntities.size(); i++ ) {
            getSession().save(programmeUnitTypeEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
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
