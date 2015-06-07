package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.ScheduleDao;
import pl.edu.agh.planner.domain.ScheduleEntity;

import java.util.List;

@Service("scheduleService")
public class ScheduleService implements ServiceInterface<ScheduleEntity, Long>{

    private ScheduleDao scheduleDao;

    @Autowired
    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    @Override
    public void add(ScheduleEntity scheduleEntity) {
        scheduleDao.add(scheduleEntity);
    }

    @Override
    public void add(List<ScheduleEntity> scheduleEntities) {
        scheduleDao.add(scheduleEntities);
    }

    @Override
    public void update(ScheduleEntity scheduleEntity) {
        scheduleDao.update(scheduleEntity);
    }

    @Override
    public void delete(ScheduleEntity scheduleEntity) {
        scheduleDao.delete(scheduleEntity);
    }

    @Override
    public ScheduleEntity getById(Long id) {
        return scheduleDao.getById(id);
    }

    @Override
    public List<ScheduleEntity> getList() {
        return scheduleDao.getList();
    }

    @Override
    public ScheduleEntity saveOrUpdate(ScheduleEntity entity) {
        return scheduleDao.saveOrUpdate(entity);
    }
}
