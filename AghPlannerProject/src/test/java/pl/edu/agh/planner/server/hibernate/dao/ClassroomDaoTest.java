package pl.edu.agh.planner.server.hibernate.dao;

import org.junit.Test;
import pl.edu.agh.planner.server.hibernate.entity.ClassroomEntity;

public class ClassroomDaoTest {


    @Test
    public void shouldAdd(){
        ClassroomDao dao = new ClassroomDao();
        ClassroomEntity classroomEntity = new ClassroomEntity();
        classroomEntity.setNumber(1);
        classroomEntity.setBuildingId(2);
        classroomEntity.setNumberOfSeats(3);
        classroomEntity.setId(1);
//        classroom.setClassroomHours(null);
        dao.add(classroomEntity);

        dao.getById(1);


    }


}
