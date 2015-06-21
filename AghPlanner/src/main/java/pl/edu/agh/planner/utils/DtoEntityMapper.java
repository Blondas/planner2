package pl.edu.agh.planner.utils;

import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import pl.edu.agh.planner.domain.*;
import pl.edu.agh.planner.dto.*;

//@Component
public class DtoEntityMapper {

    private static Mapper mapper = (DozerBeanMapper) DozerBeanMapperSingletonWrapper.getInstance();

    public static AggregateEntity aggregateToEntity(Aggregate aggregate) {
        return mapper.map(aggregate, AggregateEntity.class);
    }

    public static Aggregate entityToAggregate(AggregateEntity aggregateEntity) {
        return mapper.map(aggregateEntity, Aggregate.class);
    }

    public static BuildingEntity buildingToEntity(Building building) {
        return mapper.map(building, BuildingEntity.class);
    }

    public static Building entityToBuilding(BuildingEntity buildingEntity) {
        return mapper.map(buildingEntity, Building.class);
    }

    public static AuthorizationEntity authorizationToEntity(DozerBeanMapper mapper, Authorization authorization) {
        return mapper.map(authorization, AuthorizationEntity.class);
    }

    public static AuthorizationEntity authorizationToEntity(Authorization authorization) {
        return mapper.map(authorization, AuthorizationEntity.class);
    }

    public static AuthorizationTypeEntity authorizationTypeToEntity(AuthorizationType authorizationType) {
        return mapper.map(authorizationType, AuthorizationTypeEntity.class);
    }

    public static AvatarEntity avatarToEntity(Avatar avatar) {
        return mapper.map(avatar, AvatarEntity.class);
    }

    public static Avatar entityToAvatar(AvatarEntity avatar) {
        return mapper.map(avatar, Avatar.class);
    }

    public static StudentGroup entityToStudentGroup(StudentGroupEntity entity) {
        return mapper.map(entity, StudentGroup.class);
    }

    public static StudentGroupEntity studentGroupToEntity(StudentGroup studentGroup) {
        return mapper.map(studentGroup, StudentGroupEntity.class);
    }

    public static ClassroomEntity classroomToEntity(Classroom classroom) {
        return mapper.map(classroom, ClassroomEntity.class);
    }

    public static ConcreteDateEntity concreteDateToEntity(ConcreteDate concreteDate) {
        return mapper.map(concreteDate, ConcreteDateEntity.class);
    }

    public static ConcreteDateTemplateEntity concreteDateTemplateToEntity(ConcreteDateTemplate concreteDateTemplate) {
        return mapper.map(concreteDateTemplate, ConcreteDateTemplateEntity.class);
    }

    public static ConcreteLessonEntity concreteLessonToEntity(ConcreteLesson concreteLesson) {
        return mapper.map(concreteLesson, ConcreteLessonEntity.class);
    }

    public static ConcreteLesson entityToConcreteLesson(ConcreteLessonEntity concreteLessonEntity) {
        return mapper.map(concreteLessonEntity, ConcreteLesson.class);
    }

    public static DepartmentEntity departmentToEntity(Department department) {
        return mapper.map(department, DepartmentEntity.class);
    }

    public static FacultyEntity facultyToEntity(Faculty faculty) {
        return mapper.map(faculty, FacultyEntity.class);
    }

    public static LetterDesignationEntity letterDesignationEntity(LetterDesignation letterDesignation) {
        return mapper.map(letterDesignation, LetterDesignationEntity.class);
    }

    public static ProgrammeUnit entityToProgrammeUnit(ProgrammeUnitEntity programmeUnitEntity) {
        return mapper.map(programmeUnitEntity, ProgrammeUnit.class);
    }

    public static ProgrammeUnitEntity programmeUnitToEntity(ProgrammeUnit programmeUnit) {
        return mapper.map(programmeUnit, ProgrammeUnitEntity.class);
    }

    public static ProgrammeUnitTypeEntity programmeUnitTypeToEntity(ProgrammeUnitType programmeUnitType) {
        return mapper.map(programmeUnitType, ProgrammeUnitTypeEntity.class);
    }

    public static ScheduleEntity scheduleToEntity(Schedule schedule) {
        return mapper.map(schedule, ScheduleEntity.class);
    }

    public static Schedule entityToSchedule(ScheduleEntity entity) {
        return mapper.map(entity, Schedule.class);
    }

    public static TeacherEntity teacherToEntity(Teacher teacher) {
        return mapper.map(teacher, TeacherEntity.class);
    }

    public static Teacher entityToTeacher(TeacherEntity teacherEntityher) {
        return mapper.map(teacherEntityher, Teacher.class);
    }

    public static TermsSetEntity termsSetToEntity(TermsSet termsSet) {
        return mapper.map(termsSet, TermsSetEntity.class);
    }

    public static UserEntity userToEntity(User user) {
        return mapper.map(user, UserEntity.class);
    }

    public static ViewEntity viewToEntity(View view) {
        return mapper.map(view, ViewEntity.class);
    }

    public static View entityToView(ViewEntity viewEntity) {
        return mapper.map(viewEntity, View.class);
    }
}