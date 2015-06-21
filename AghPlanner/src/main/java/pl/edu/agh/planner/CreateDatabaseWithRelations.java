package pl.edu.agh.planner;


import pl.edu.agh.planner.datasources.DataSources;
import pl.edu.agh.planner.domain.*;

import java.util.Calendar;
import java.util.Date;


public class CreateDatabaseWithRelations extends DataSources {


    public void create(){
        AvatarEntity avatar1 = avatarDataSource.createAvatar("Awatar mistrz");
        AvatarEntity avatar2 = avatarDataSource.createAvatar("Awatar Joda");
        AvatarEntity avatar3 = avatarDataSource.createAvatar("Awatar pro");

        teacherDataSource.createTeacher("Jan", "Nowak", avatar1);
        teacherDataSource.createTeacher("Marian", "Kowalski", avatar1);
        teacherDataSource.createTeacher("Andrzej", "Zetowski", avatar1);
        teacherDataSource.createTeacher("Miś", "Koala", avatar2);
        teacherDataSource.createTeacher("Szymon", "Szymański", avatar2);
        teacherDataSource.createTeacher("Paweł", "Jot", avatar2);
        teacherDataSource.createTeacher("Adrian", "Olszewski", avatar2);
        teacherDataSource.createTeacher("Piotr", "Piotrowski", avatar3);


        ProgrammeUnitEntity programmeUnitEntity1 = programmeUnitDataSource.createProgrammeUnit("Analiza Matematyczna");
        ProgrammeUnitEntity programmeUnitEntity2 = programmeUnitDataSource.createProgrammeUnit("Fizyka");
        ProgrammeUnitEntity programmeUnitEntity3 = programmeUnitDataSource.createProgrammeUnit("Algebra");
        ProgrammeUnitEntity programmeUnitEntity4 = programmeUnitDataSource.createProgrammeUnit("Sieci komputerowe");
        ProgrammeUnitEntity programmeUnitEntity5 = programmeUnitDataSource.createProgrammeUnit("Statystyka");
        ProgrammeUnitEntity programmeUnitEntity6 = programmeUnitDataSource.createProgrammeUnit("Programowanie równoległe");
        ProgrammeUnitEntity programmeUnitEntity7 = programmeUnitDataSource.createProgrammeUnit("Między przyszlością a przeszłością");
        ProgrammeUnitEntity programmeUnitEntity8 = programmeUnitDataSource.createProgrammeUnit("Języki i techniki programowania");
        ProgrammeUnitEntity programmeUnitEntity9 = programmeUnitDataSource.createProgrammeUnit("Technologie internetowe");
        ProgrammeUnitEntity programmeUnitEntity10 = programmeUnitDataSource.createProgrammeUnit("Internet rzeczy");


        StudentGroupEntity studentGroupEntity1 = studentGroupDataSource.createStudentGroup(departmentDataSource.createDepartmentEntity("Informatyka")
                                                                                        , facultyDataSource.createFaculty("IET")
                                                                                        , letterDesignationDataSource.createLetterDesignation("A"));

        StudentGroupEntity studentGroupEntity2 = studentGroupDataSource.createStudentGroup(departmentDataSource.createDepartmentEntity("Elektronika i telekomunikacja")
                                                                                        , facultyDataSource.createFaculty("IET")
                                                                                        , letterDesignationDataSource.createLetterDesignation("A"));

        StudentGroupEntity studentGroupEntity3 = studentGroupDataSource.createStudentGroup(departmentDataSource.createDepartmentEntity("Geografia")
                                                                                        , facultyDataSource.createFaculty("GLSD")
                                                                                        , letterDesignationDataSource.createLetterDesignation("C"));

        StudentGroupEntity studentGroupEntity4 = studentGroupDataSource.createStudentGroup(departmentDataSource.createDepartmentEntity("Inżynieria materiałowa")
                                                                                        , facultyDataSource.createFaculty("FKDL")
                                                                                        , letterDesignationDataSource.createLetterDesignation("B"));

        StudentGroupEntity studentGroupEntity5 = studentGroupDataSource.createStudentGroup(departmentDataSource.createDepartmentEntity("Metalurgia")
                                                                                        , facultyDataSource.createFaculty("FKDL")
                                                                                        , letterDesignationDataSource.createLetterDesignation("A"));

        AggregateEntity aggregateEntity1 = aggregateDataSource.createAggregate(avatar1, programmeUnitEntity1, studentGroupEntity1);
        AggregateEntity aggregateEntity2 = aggregateDataSource.createAggregate(avatar1, programmeUnitEntity2, studentGroupEntity1);
        AggregateEntity aggregateEntity3 = aggregateDataSource.createAggregate(avatar1, programmeUnitEntity3, studentGroupEntity1);

        AggregateEntity aggregateEntity4 = aggregateDataSource.createAggregate(avatar1, programmeUnitEntity4, studentGroupEntity2);
        AggregateEntity aggregateEntity5 = aggregateDataSource.createAggregate(avatar1, programmeUnitEntity5, studentGroupEntity2);
        AggregateEntity aggregateEntity6 = aggregateDataSource.createAggregate(avatar1, programmeUnitEntity6, studentGroupEntity2);
        AggregateEntity aggregateEntity7 = aggregateDataSource.createAggregate(avatar2, programmeUnitEntity7, studentGroupEntity2);

        AggregateEntity aggregateEntity8 = aggregateDataSource.createAggregate(avatar2, programmeUnitEntity8, studentGroupEntity3);
        AggregateEntity aggregateEntity9 = aggregateDataSource.createAggregate(avatar2, programmeUnitEntity9, studentGroupEntity3);
        AggregateEntity aggregateEntity10 = aggregateDataSource.createAggregate(avatar2, programmeUnitEntity10, studentGroupEntity3);

        AggregateEntity aggregateEntity11 = aggregateDataSource.createAggregate(avatar2, programmeUnitEntity1, studentGroupEntity4);
        AggregateEntity aggregateEntity12 = aggregateDataSource.createAggregate(avatar3, programmeUnitEntity2, studentGroupEntity4);
        AggregateEntity aggregateEntity13 = aggregateDataSource.createAggregate(avatar3, programmeUnitEntity5, studentGroupEntity3);

        AggregateEntity aggregateEntity14 = aggregateDataSource.createAggregate(avatar1, programmeUnitEntity4, studentGroupEntity5);
        AggregateEntity aggregateEntity15 = aggregateDataSource.createAggregate(avatar2, programmeUnitEntity5, studentGroupEntity5);
        AggregateEntity aggregateEntity16 = aggregateDataSource.createAggregate(avatar3, programmeUnitEntity9, studentGroupEntity5);


        ScheduleEntity scheduleEntity = scheduleDataSource.createSchedule("Super plan", new Date(System.currentTimeMillis()));


        ConcreteDateEntity concreteDateEntity1 = concreteDateDataSource.createConcreteDate(getBeginOfMonthPlusDays(1));
        ConcreteDateEntity concreteDateEntity2 = concreteDateDataSource.createConcreteDate(getBeginOfMonthPlusDays(2));
        ConcreteDateEntity concreteDateEntity3 = concreteDateDataSource.createConcreteDate(getBeginOfMonthPlusDays(3));
        ConcreteDateEntity concreteDateEntity4 = concreteDateDataSource.createConcreteDate(getBeginOfMonthPlusDays(4));
        ConcreteDateEntity concreteDateEntity5 = concreteDateDataSource.createConcreteDate(getBeginOfMonthPlusDays(5));
        ConcreteDateEntity concreteDateEntity6 = concreteDateDataSource.createConcreteDate(getBeginOfMonthPlusDays(6));
        ConcreteDateEntity concreteDateEntity7 = concreteDateDataSource.createConcreteDate(getBeginOfMonthPlusDays(7));
        ConcreteDateEntity concreteDateEntity8 = concreteDateDataSource.createConcreteDate(getBeginOfMonthPlusDays(8));
        ConcreteDateEntity concreteDateEntity9 = concreteDateDataSource.createConcreteDate(getBeginOfMonthPlusDays(9));
        ConcreteDateEntity concreteDateEntity10 = concreteDateDataSource.createConcreteDate(getBeginOfMonthPlusDays(10));

        BuildingEntity building1 = buildingDataSource.createBuilding("A1");
        BuildingEntity building2 = buildingDataSource.createBuilding("A20");
        ClassroomHourEntity classroomHourEntity1 = classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building1), 1, 30);
        ClassroomHourEntity classroomHourEntity2 = classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building1), 40, 70);
        ClassroomHourEntity classroomHourEntity3 = classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building2), 80, 110);
        ClassroomHourEntity classroomHourEntity4 = classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building2), 120, 150);
        ClassroomHourEntity classroomHourEntity5 = classroomHourDataSource.createClassroomHour(classroomDataSource.createClassroom(building2), 160, 200);


        concreteLessonDataSource.createConcreteLesson(aggregateEntity1, classroomHourEntity1, concreteDateEntity1, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity2, classroomHourEntity2, concreteDateEntity1, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity3, classroomHourEntity3, concreteDateEntity1, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity4, classroomHourEntity4, concreteDateEntity2, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity5, classroomHourEntity5, concreteDateEntity2, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity6, classroomHourEntity1, concreteDateEntity2, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity7, classroomHourEntity2, concreteDateEntity3, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity8, classroomHourEntity3, concreteDateEntity4, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity9, classroomHourEntity4, concreteDateEntity5, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity10, classroomHourEntity5, concreteDateEntity6, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity11, classroomHourEntity1, concreteDateEntity5, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity12, classroomHourEntity2, concreteDateEntity7, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity13, classroomHourEntity3, concreteDateEntity8, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity14, classroomHourEntity4, concreteDateEntity9, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity15, classroomHourEntity5, concreteDateEntity9, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity16, classroomHourEntity5, concreteDateEntity10, scheduleEntity);
        concreteLessonDataSource.createConcreteLesson(aggregateEntity16, classroomHourEntity5, concreteDateEntity10, scheduleEntity);




    }

    public Date getBeginOfMonthPlusDays(int numberOfDays){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month = cal.get(Calendar.MONTH);

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.DAY_OF_MONTH, 1+numberOfDays);
        cal2.set(Calendar.MONTH, month);

        return cal2.getTime();
    }

}

