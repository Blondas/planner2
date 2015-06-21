package database;

import datasources.DataSources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.agh.planner.Application;
import pl.edu.agh.planner.domain.BuildingEntity;

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


		BuildingEntity building1 = buildingDataSource.createBuilding("A1");
        classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building1), 1, 30);
        classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building1), 40, 70);
        classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building1), 80, 110);
        classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building1), 120, 150);
        classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building1), 160, 200);

		BuildingEntity building2 = buildingDataSource.createBuilding("A2");
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building2), 1, 30);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building2), 40, 70);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building2), 80, 110);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building2), 120, 150);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building2), 160, 200);

		BuildingEntity building3 = buildingDataSource.createBuilding("B15");
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building3), 1, 30);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building3), 40, 70);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building3), 80, 110);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building3), 120, 150);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building3), 160, 200);

		BuildingEntity building4 = buildingDataSource.createBuilding("B16");
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building4), 1, 30);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building4), 40, 70);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building4), 80, 110);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building4), 120, 150);
		classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building4), 160, 200);


	}

}