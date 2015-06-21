package datasources;

import pl.edu.agh.planner.dao.ClassroomDao;
import pl.edu.agh.planner.domain.BuildingEntity;
import pl.edu.agh.planner.domain.ClassroomEntity;

import java.util.Random;

public class ClassroomDataSource {

    private ClassroomDao classroomDao = new ClassroomDao();

    public ClassroomEntity createClassroom(BuildingEntity building){
        Random random = new Random();

        ClassroomEntity classroomEntity = new ClassroomEntity();
        classroomEntity.setNumber("D" + random.nextInt(50));
        classroomEntity.setNumberOfSeats(random.nextInt(50));
        classroomEntity.setBuilding(building);

        classroomDao.add(classroomEntity);

        return classroomEntity;
    }
}
