package database;

import datasources.DataSources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.agh.planner.Application;

import java.util.Date;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CreateDatabaseWithoutRelations extends DataSources {

	@Test
	public void contextLoads() {
		teacherDataSource.createTeacher("Jan", "Nowak");
		teacherDataSource.createTeacher("Marian", "Kowalski");
		teacherDataSource.createTeacher("Andrzej", "Zetowski");
		teacherDataSource.createTeacher("Miś", "Koala");
		teacherDataSource.createTeacher("Szymon", "Szymański");
		teacherDataSource.createTeacher("Paweł", "Jot");
		teacherDataSource.createTeacher("Adrian", "Olszewski");
		teacherDataSource.createTeacher("Piotr", "Piotrowski");

		avatarDataSource.createAvatar("Awatar mistrz");
		avatarDataSource.createAvatar("Awatar Joda");
		avatarDataSource.createAvatar("Awatar pro");

		programmeUnitDataSource.createProgrammeUnit("Analiza Matematyczna");
		programmeUnitDataSource.createProgrammeUnit("Fizyka");
		programmeUnitDataSource.createProgrammeUnit("Algebra");
		programmeUnitDataSource.createProgrammeUnit("Sieci komputerowe");
		programmeUnitDataSource.createProgrammeUnit("Statystyka");
		programmeUnitDataSource.createProgrammeUnit("Programowanie równoległe");
		programmeUnitDataSource.createProgrammeUnit("Między przyszlością a przeszłością");
		programmeUnitDataSource.createProgrammeUnit("Języki i techniki programowania");
		programmeUnitDataSource.createProgrammeUnit("Technologie internetowe");
		programmeUnitDataSource.createProgrammeUnit("Internet rzeczy");
		
		studentGroupDataSource.createStudentGroup(departmentDataSource.createDepartmentEntity("Informatyka")
											 	, facultyDataSource.createFaculty("IET")
												, letterDesignationDataSource.createLetterDesignation("A"));

		studentGroupDataSource.createStudentGroup(departmentDataSource.createDepartmentEntity("Elektronika i telekomunikacja")
												, facultyDataSource.createFaculty("IET")
												, letterDesignationDataSource.createLetterDesignation("A"));

		studentGroupDataSource.createStudentGroup(departmentDataSource.createDepartmentEntity("Geografia")
												, facultyDataSource.createFaculty("GLSD")
												, letterDesignationDataSource.createLetterDesignation("C"));

		studentGroupDataSource.createStudentGroup(departmentDataSource.createDepartmentEntity("Inżynieria materiałowa")
												, facultyDataSource.createFaculty("FKDL")
												, letterDesignationDataSource.createLetterDesignation("B"));

		studentGroupDataSource.createStudentGroup(departmentDataSource.createDepartmentEntity("Metalurgia")
												, facultyDataSource.createFaculty("FKDL")
												, letterDesignationDataSource.createLetterDesignation("A"));

        Random random = new Random();
        concreteDateDataSource.createConcreteDate(new Date(System.currentTimeMillis() + random.nextInt(10000)));
        concreteDateDataSource.createConcreteDate(new Date(System.currentTimeMillis() + random.nextInt(10000)));
        concreteDateDataSource.createConcreteDate(new Date(System.currentTimeMillis() + random.nextInt(10000)));
        concreteDateDataSource.createConcreteDate(new Date(System.currentTimeMillis() + random.nextInt(10000)));
        concreteDateDataSource.createConcreteDate(new Date(System.currentTimeMillis() + random.nextInt(10000)));
        concreteDateDataSource.createConcreteDate(new Date(System.currentTimeMillis() + random.nextInt(10000)));
        concreteDateDataSource.createConcreteDate(new Date(System.currentTimeMillis() + random.nextInt(10000)));
        concreteDateDataSource.createConcreteDate(new Date(System.currentTimeMillis() + random.nextInt(10000)));
        concreteDateDataSource.createConcreteDate(new Date(System.currentTimeMillis() + random.nextInt(10000)));
        concreteDateDataSource.createConcreteDate(new Date(System.currentTimeMillis() + random.nextInt(10000)));

        classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(), 1, 30);
        classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(), 40, 70);
        classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(), 80, 110);
        classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(), 120, 150);
        classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(), 160, 200);

	}

}