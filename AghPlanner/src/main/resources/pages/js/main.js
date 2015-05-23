$('document').ready(function(){
    teacher1 = new Teacher({id: 1, name: "nauczyciel 1", lastName: "nazwisko 1", position: "#teacherContainer"});
    teacher2 = new Teacher({id: 2, name: "nauczyciel 2", lastName: "nazwisko 2", position: "#teacherContainer"});
    teacher3 = new Teacher({id: 3, name: "nauczyciel 3", lastName: "nazwisko 3", position: "#teacherContainer"});
    teacher4 = new Teacher({id: 4, name: "nauczyciel 4", lastName: "nazwisko 4", position: "#teacherContainer"});

    avatarContainer1 = new AvatarContainer({position: 'body'});

    avatar1 = new Avatar({id: 1, name: "awatar 1", position: "#avatarContainer"});
    avatar2 = new Avatar({id: 2, name: "awatar 2", position: "#avatarContainer"});
    avatar3 = new Avatar({id: 3, name: "awatar 3", position: "#avatarContainer"});
    avatar4 = new Avatar({id: 4, name: "awatar 4", position: "#avatarContainer"});

    studentGroup1 = new StudentGroup({id: 1, position: "#studentGroupContainer"});
    studentGroup2 = new StudentGroup({id: 2, position: "#studentGroupContainer"});
    studentGroup3 = new StudentGroup({id: 3, position: "#studentGroupContainer"});
    studentGroup4 = new StudentGroup({id: 4, position: "#studentGroupContainer"});

    programmeUnit1 = new ProgrammeUnit({id: 1, name: "jednostka programu studiów 1", position: "#programmeUnitContainer"});
    programmeUnit2 = new ProgrammeUnit({id: 2, name: "jednostka programu studiów 1", position: "#programmeUnitContainer"});
    programmeUnit3 = new ProgrammeUnit({id: 3, name: "jednostka programu studiów 1", position: "#programmeUnitContainer"});
    programmeUnit4 = new ProgrammeUnit({id: 4, name: "jednostka programu studiów 1", position: "#programmeUnitContainer"});
});