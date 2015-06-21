package pl.edu.agh.planner.datasources;

import pl.edu.agh.planner.dao.ClassroomHourDao;
import pl.edu.agh.planner.domain.ClassroomEntity;
import pl.edu.agh.planner.domain.ClassroomHourEntity;

public class ClassroomHourDataSource {

    private ClassroomHourDao classroomHourDao = new ClassroomHourDao();

    public ClassroomHourEntity createClassroomHour(ClassroomEntity classroomEntity, int beginId, int endId){
        ClassroomHourEntity classroomHourEntity = new ClassroomHourEntity();
        classroomHourEntity.setClassroom(classroomEntity);
        classroomHourEntity.setLessonBeginId(beginId);
        classroomHourEntity.setLessonEndId(endId);

        classroomHourDao.add(classroomHourEntity);

        return classroomHourEntity;
    }

}
