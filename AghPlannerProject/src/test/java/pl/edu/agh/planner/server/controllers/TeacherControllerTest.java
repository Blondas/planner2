package pl.edu.agh.planner.server.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import pl.edu.agh.planner.shared.Avatar;
import pl.edu.agh.planner.shared.DtoToEntity;
import pl.edu.agh.planner.shared.Teacher;
import pl.edu.agh.planner.shared.hibernate.entity.AvatarEntity;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;
import utils.DefaultTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TeacherControllerTest extends DefaultTest {

    @Test
     public void shouldAddTeacher(){
        //given

        TeacherEntity givenTeacher = givenTeacher();

        // when
        teacherController.add(givenTeacher);


        //then
        ArrayList<TeacherEntity> teacherListReceived = (ArrayList<TeacherEntity>) teacherController.getList();
        TeacherEntity teacherReceived = teacherListReceived.get(teacherListReceived.size()-1);

        assertEquals(givenTeacher.getName(), teacherReceived.getName());

    }

    @Test
    public void shouldAddTeacherAvatar(){
        //given

        AvatarEntity givenAvatar = givenAvatar();
        TeacherEntity givenTeacher = givenTeacher();
        givenTeacher.setAvatar(givenAvatar);


        // when

        teacherController.add(givenTeacher);


        //then

        ArrayList<TeacherEntity> teacherListReceived = (ArrayList<TeacherEntity>) teacherController.getList();
        TeacherEntity teacherReceived = teacherListReceived.get(teacherListReceived.size()-1);

        assertEquals(givenTeacher.getName(), teacherReceived.getName());
        assertEquals(givenTeacher.getAvatar().getName(), teacherReceived.getAvatar().getName());

    }

    @Test
    public void shouldReturnTeachersList(){

        //when
        List<TeacherEntity> teachers = teacherController.getList();

        //then
        assertNotNull("list is empty ", teachers);

    }

    @Test(expected=ConstraintViolationException.class)
    public void shouldNotDeleteAvatar(){
        //given

        AvatarEntity givenAvatar = givenAvatar();
        TeacherEntity givenTeacher = givenTeacher();
        givenTeacher.setAvatar(givenAvatar);


        // when

        teacherController.add(givenTeacher);
        List<TeacherEntity> teacherListReceived = (ArrayList<TeacherEntity>) teacherController.getList();
        System.out.println("list size :"+teacherListReceived.size());


        TeacherEntity teacherReceived = teacherListReceived.get(0);

        avatarController.delete(teacherReceived.getAvatar());
    }

    @Test
    public void testDtoToEntity(){
        Avatar avatar = new Avatar();
        avatar.setName("avatar");


        Teacher teacher = new Teacher();
        teacher.setLastName("111");
        teacher.setName("222");
        teacher.setAvatar(avatar);
        TeacherEntity teacherEntity = DtoToEntity.teacherToEntity(teacher);

        teacherController.add(teacherEntity);
    }

    private TeacherEntity givenTeacher(){
        TeacherEntity teacher = new TeacherEntity();
        teacher.setName("Marmolada 2");
        teacher.setLastName("Muchomorek");

        return teacher;
    }

    private AvatarEntity givenAvatar(){
        AvatarEntity avatarEntity = new AvatarEntity();
        avatarEntity.setName("Super avatar");

        return avatarEntity;
    }



}
