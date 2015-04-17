package pl.edu.agh.planner.server.hibernate.dao;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.agh.planner.server.hibernate.entity.TeacherEntity;

import java.util.ArrayList;
import java.util.List;

public class TeacherDaoTest {

    @Test
    public void shouldSave(){
        //given

        List<TeacherEntity> list = givenTeachers();

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

        TeacherEntity teacher = givenTeacher();

        // when

        TeacherDao teacherDao = new TeacherDao();
        teacherDao.add(teacher);


        //then
        Assert.assertEquals("Marmolada", teacherDao.getById(1).getName());



    }

    @Test
    public void shouldAddAndDelete(){
        //given

        TeacherEntity teacher = givenTeacher();

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

        TeacherEntity teacher = givenTeacher();

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

        List<TeacherEntity> list = givenTeachers();

        //when

        TeacherDao teacherDao = new TeacherDao();
        teacherDao.add(list);

        //then

        Assert.assertEquals(4,teacherDao.getList().size());

    }

    private TeacherEntity givenTeacher(){
        TeacherEntity teacher = new TeacherEntity();
        teacher.setName("Marmolada");
        teacher.setLastName("Muchomorek");

        return teacher;
    }

    private List<TeacherEntity> givenTeachers(){
        List<TeacherEntity> list = new ArrayList();

        for(int i = 1 ; i<5 ; i++){
            TeacherEntity teacher = new TeacherEntity();
            teacher.setName("Marmolada" + i);
            teacher.setLastName("Muchomorek" + i);
            list.add(teacher);
        }

        return list;
    }


}
