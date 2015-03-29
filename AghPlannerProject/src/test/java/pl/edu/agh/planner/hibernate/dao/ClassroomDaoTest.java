package pl.edu.agh.planner.hibernate.dao;

import org.junit.Test;
import pl.edu.agh.planner.hibernate.entity.Classroom;

public class ClassroomDaoTest {


    @Test
    public void shouldAdd(){
        ClassroomDao dao = new ClassroomDao();
        Classroom classroom = new Classroom();
        classroom.setNumber(1);
        classroom.setBuildingId(2);
        classroom.setNumberOfSeats(3);
        classroom.setId(1);
//        classroom.setClassroomHours(null);
        dao.add(classroom);

        dao.getById(1);


    }


}
