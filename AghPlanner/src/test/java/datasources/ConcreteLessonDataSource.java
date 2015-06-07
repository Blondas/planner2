package datasources;

import pl.edu.agh.planner.dao.ConcreteLessonDao;
import pl.edu.agh.planner.domain.*;

public class ConcreteLessonDataSource {

    private ConcreteLessonDao concreteLessonDao = new ConcreteLessonDao();

    public ConcreteLessonEntity createConcreteLesson(AggregateEntity aggregate, ClassroomHourEntity classroomHour, ConcreteDateEntity concreteDate, ScheduleEntity schedule){
        ConcreteLessonEntity concreteLessonEntity = new ConcreteLessonEntity();
        concreteLessonEntity.setAggregate(aggregate);
        concreteLessonEntity.setClassroomHour(classroomHour);
        concreteLessonEntity.setConcreteDate(concreteDate);
        concreteLessonEntity.setSchedule(schedule);

        concreteLessonDao.add(concreteLessonEntity);

        return concreteLessonEntity;
    }
}
