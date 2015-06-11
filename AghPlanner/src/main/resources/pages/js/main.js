$('document').ready(function(){
    addContainers();

    teacherContainer.loadAllTeachers();



    avatar1 = new Avatar({id: 1, name: "awatar 1"});
    avatar2 = new Avatar({id: 2, name: "awatar 2"});
    avatar3 = new Avatar({id: 3, name: "awatar 3"});
    avatar4 = new Avatar({id: 4, name: "awatar 4"});

    avatarContainer.addAvatar(avatar1);
    avatarContainer.addAvatar(avatar2);
    avatarContainer.addAvatar(avatar3);
    avatarContainer.addAvatar(avatar4);


    studentGroup1 = new StudentGroup({id: 1});
    studentGroup2 = new StudentGroup({id: 2});
    studentGroup3 = new StudentGroup({id: 3});
    studentGroup4 = new StudentGroup({id: 4});

    studentGroupContainer.addStudentGroup(studentGroup1);
    studentGroupContainer.addStudentGroup(studentGroup2);
    studentGroupContainer.addStudentGroup(studentGroup3);
    studentGroupContainer.addStudentGroup(studentGroup4);


    programmeUnit1 = new ProgrammeUnit({id: 1, name: "jednostka programu studiów 1"});
    programmeUnit2 = new ProgrammeUnit({id: 2, name: "jednostka programu studiów 1"});
    programmeUnit3 = new ProgrammeUnit({id: 3, name: "jednostka programu studiów 1"});
    programmeUnit4 = new ProgrammeUnit({id: 4, name: "jednostka programu studiów 1"});

    programmeUnitContainer.addProgrammeUnit(programmeUnit1);
    programmeUnitContainer.addProgrammeUnit(programmeUnit2);
    programmeUnitContainer.addProgrammeUnit(programmeUnit3);
    programmeUnitContainer.addProgrammeUnit(programmeUnit4);
});

function addContainers() {
    teacherContainer = new TeacherContainer({position: 'body'});
    avatarContainer = new AvatarContainer({position: 'body'});
    aggregateContainer = new AggregateContainer({position: 'body'});
    studentGroupContainer = new StudentGroupContainer({position: 'body'});
    programmeUnitContainer = new ProgrammeUnitContainer({position: 'body'});
}