package pl.edu.agh.planner.hibernate.dao;

import org.junit.*;
import org.junit.Test;
import pl.edu.agh.planner.hibernate.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDaoTest {

    @Test
    public void shouldSave(){
        //given

        List<Teacher> list = givenTeachers();

        //when

        TeacherDao teacherDao = new TeacherDao();
        teacherDao.add(list);

        //then

        System.out.println(teacherDao.getById(2));
        System.out.println(teacherDao.getById(1));


    }

    @Test
     public void shouldAdd(){
        //given

        Teacher teacher = givenTeacher();

        // when

        TeacherDao teacherDao = new TeacherDao();
        teacherDao.add(teacher);


        //then
        Assert.assertEquals("Marmolada", teacherDao.getById(1).getName());



    }

    @Test
    public void shouldAddAndDelete(){
        //given

        Teacher teacher = givenTeacher();

        // when

        TeacherDao teacherDao = new TeacherDao();
        teacherDao.add(teacher);
        teacherDao.delete(teacher);

        //then
        Assert.assertNull(teacherDao.getById(1));

    }

    @Test
    public void shouldUpdate(){
        //given

        Teacher teacher = givenTeacher();

        //when

        TeacherDao teacherDao = new TeacherDao();
        teacher.setId(1);
        teacherDao.add(teacher);

        teacher.setName("Marmolada update");
        teacherDao.update(teacher);

        //then

        Assert.assertEquals("Marmolada update", teacherDao.getById(1).getName());

    }

    @Test
    public void shouldReturnAllTeachers(){
        //given

        List<Teacher> list = givenTeachers();

        //when

        TeacherDao teacherDao = new TeacherDao();
        teacherDao.add(list);

        //then

        Assert.assertEquals(4,teacherDao.getList().size());

    }

    private Teacher givenTeacher(){
        Teacher teacher = new Teacher();
        teacher.setName("Marmolada");
        teacher.setLastName("Muchomorek");

        return teacher;
    }

    private List<Teacher> givenTeachers(){
        List<Teacher> list = new ArrayList();

        for(int i = 1 ; i<5 ; i++){
            Teacher teacher = new Teacher();
            teacher.setName("Marmolada" + i);
            teacher.setLastName("Muchomorek" + i);
            list.add(teacher);
        }

        return list;
    }


}
