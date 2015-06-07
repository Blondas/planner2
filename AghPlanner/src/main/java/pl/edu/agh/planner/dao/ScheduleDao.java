package pl.edu.agh.planner.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.domain.ScheduleEntity;
import pl.edu.agh.planner.utils.GenericQuery;

import java.util.List;

@Component("scheduleDao")
public class ScheduleDao extends GenericQuery implements  DaoInterface<ScheduleEntity, Long>{

    @Override
    public ScheduleEntity getById (Long id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(ScheduleEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ScheduleEntity schedule = (ScheduleEntity) criteria.uniqueResult();

        endTransaction();

        return schedule;
    }

    @Override
    public List<ScheduleEntity> getList() {
        beginTransaction();
        List<ScheduleEntity> list = session.createCriteria(ScheduleEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(ScheduleEntity schedule) {
        beginTransaction();
        getSession().save(schedule);
        endTransaction();
    }

    @Override
    public void add(List<ScheduleEntity> scheduleEntities) {
        beginTransaction();
        for ( int i=0; i<scheduleEntities.size(); i++ ) {
            getSession().save(scheduleEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void update(ScheduleEntity schedule) {
        beginTransaction();
        getSession().update(schedule);
        endTransaction();
    }

    public void delete(ScheduleEntity schedule) {
        beginTransaction();
        getSession().delete(schedule);
        endTransaction();
    }

    @Override
    public ScheduleEntity saveOrUpdate(ScheduleEntity object) {
        beginTransaction();
        getSession().saveOrUpdate(object);
        endTransaction();

        return object;
    }
}