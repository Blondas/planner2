package datasources;

import pl.edu.agh.planner.dao.ScheduleDao;
import pl.edu.agh.planner.domain.ScheduleEntity;
import pl.edu.agh.planner.domain.UserEntity;

import java.util.Date;

public class ScheduleDataSource {

    private ScheduleDao scheduleDao = new ScheduleDao();

    public ScheduleEntity createSchedule(String name, Date date, UserEntity user){
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setName(name);
        scheduleEntity.setDate(date);
        scheduleEntity.setUser(user);

        scheduleDao.add(scheduleEntity);

        return scheduleEntity;
    }

    public ScheduleEntity createSchedule(String name, Date date){
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setName(name);
        scheduleEntity.setDate(date);

        scheduleDao.add(scheduleEntity);

        return scheduleEntity;
    }

}
