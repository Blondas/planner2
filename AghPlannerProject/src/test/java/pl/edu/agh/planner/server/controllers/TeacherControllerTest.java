package pl.edu.agh.planner.server.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.agh.planner.shared.hibernate.dao.AvatarDao;
import pl.edu.agh.planner.shared.hibernate.dao.TeacherDao;
import pl.edu.agh.planner.shared.hibernate.entity.AvatarEntity;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = {
        "classpath:controllerContext.xml",
        "classpath:daoContext.xml",
        "classpath:serviceContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TeacherControllerTest {

    @Autowired
    TeacherController teacherController;

    @Test
     public void shouldAdd(){
        //given

        TeacherEntity teacher = givenTeacher();

        // when
        teacherController.add(teacher);


        //then
        assertEquals("Marmolada", teacherController.getById(1).getName());

    }

    @Test
    public void shouldAddTeacherAvatar(){
        //given

        AvatarEntity avatar = givenAvatar();
        TeacherEntity teacher = givenTeacher();
        teacher.setAvatar(avatar);


        // when

        TeacherDao teacherDao = new TeacherDao();
        teacherDao.add(teacher);


        //then
        assertEquals("Marmolada", teacherDao.getById(1).getName());



    }



    @Test
    public void shouldDeleteAvatar(){
        AvatarDao avatarDao = new AvatarDao();
        AvatarEntity av = new AvatarEntity();
        av.setId(1);
        avatarDao.delete(av);
    }


    private TeacherEntity givenTeacher(){
        TeacherEntity teacher = new TeacherEntity();
        teacher.setName("Marmolada");
        teacher.setLastName("Muchomorek");

        return teacher;
    }

    private AvatarEntity givenAvatar(){
        AvatarEntity avatarEntity = new AvatarEntity();
        avatarEntity.setName("Super avatar");

        return avatarEntity;
    }



}
