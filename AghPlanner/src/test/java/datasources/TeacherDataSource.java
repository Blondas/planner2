package datasources;

import pl.edu.agh.planner.dao.TeacherDao;
import pl.edu.agh.planner.domain.AvatarEntity;
import pl.edu.agh.planner.domain.TeacherEntity;

public class TeacherDataSource {

    private TeacherDao teacherDao = new TeacherDao();

    public TeacherEntity createTeacher(String name, String lastName){
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setLastName(name);
        teacherEntity.setName(lastName);

        teacherDao.add(teacherEntity);
        return teacherEntity;
    }

    public TeacherEntity createTeacher(String name, String lastName, AvatarEntity avatarEntity){
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setLastName(name);
        teacherEntity.setName(lastName);
        teacherEntity.setAvatar(avatarEntity);

        teacherDao.add(teacherEntity);
        return teacherEntity;
    }
}