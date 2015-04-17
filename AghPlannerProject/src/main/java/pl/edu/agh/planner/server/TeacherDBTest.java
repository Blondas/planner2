package pl.edu.agh.planner.server;

import pl.edu.agh.planner.server.hibernate.dao.TeacherDao;
import pl.edu.agh.planner.server.hibernate.entity.TeacherEntity;
import pl.edu.agh.planner.server.hibernate.service.TeacherService;
import pl.edu.agh.planner.shared.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDBTest {

	public TeacherDBTest() {

	}

	public ArrayList<Teacher> getTeachers() {
		List<pl.edu.agh.planner.server.hibernate.entity.TeacherEntity> teachersHibernateList = new TeacherDao().getList();

		ArrayList<Teacher> teachersSharedArrayList = new ArrayList<Teacher>();

		for (pl.edu.agh.planner.server.hibernate.entity.TeacherEntity teacherHibernate : teachersHibernateList) {

			Teacher teacherShared = new Teacher();
			teacherShared.setName(teacherHibernate.getName());

			teachersSharedArrayList.add(teacherShared);
		}

		return teachersSharedArrayList;
	}

	public TeacherEntity getTeacherEntity() {
		return new TeacherService().getTeachers().get(1);
	}

}
