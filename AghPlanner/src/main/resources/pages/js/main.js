$('document').ready(function(){
    $('#calendar').fullCalendar({
        droppable: true,
        drop: function(date) {
            alert("Dropped on " + date.format());
        },

        defaultDate: '2015-02-12',
        editable: true,
        eventLimit: true
        //events: [
        //    {
        //        title: 'All Day Event',
        //        start: '2015-02-01'
        //    },
        //    {
        //        title: 'Long Event',
        //        start: '2015-02-07',
        //        end: '2015-02-10'
        //    },
        //    {
        //        id: 999,
        //        title: 'Repeating Event',
        //        start: '2015-02-09T16:00:00'
        //    },
        //    {
        //        id: 999,
        //        title: 'Repeating Event',
        //        start: '2015-02-16T16:00:00'
        //    },
        //    {
        //        title: 'Conference',
        //        start: '2015-02-11',
        //        end: '2015-02-13'
        //    },
        //    {
        //        title: 'Meeting',
        //        start: '2015-02-12T10:30:00',
        //        end: '2015-02-12T12:30:00'
        //    },
        //    {
        //        title: 'Lunch',
        //        start: '2015-02-12T12:00:00'
        //    },
        //    {
        //        title: 'Meeting',
        //        start: '2015-02-12T14:30:00'
        //    },
        //    {
        //        title: 'Happy Hour',
        //        start: '2015-02-12T17:30:00'
        //    },
        //    {
        //        title: 'Dinner',
        //        start: '2015-02-12T20:00:00'
        //    },
        //    {
        //        title: 'Birthday Party',
        //        start: '2015-02-13T07:00:00'
        //    },
        //    {
        //        title: 'Click for Google',
        //        url: 'http://google.com/',
        //        start: '2015-02-28'
        //    }
        //]
    });

    $('.fc-day').(function() {
        this.
        Avatar.prototype.handleDocumentDrop = function(event) {
            event.stopPropagation();

            if (event.dataTransfer.types[0] ==  'teacher') {
                var avatar = $(this).data('obj');

                var object = JSON.parse(event.dataTransfer.getData('teacher'));
                object.position = avatar.$el;

                var teacher = new Teacher(object);

                avatar.addTeacher(teacher);
                avatar.save();
            }
        };
    });

    addContainers();
});

function addContainers() {
    //teacherContainer = new TeacherContainer({position: 'body'});
    avatarContainer = new AvatarContainer({position: 'body'});
    aggregateContainer = new AggregateContainer({position: 'body'});
    //studentGroupContainer = new StudentGroupContainer({position: 'body'});
    //programmeUnitContainer = new ProgrammeUnitContainer({position: 'body'});
    //
    //teacherContainer.loadAllTeachers();
    avatarContainer.loadAllAvatars();
    //
    //studentGroup1 = new StudentGroup({id: 1});
    //studentGroup2 = new StudentGroup({id: 2});
    //studentGroup3 = new StudentGroup({id: 3});
    //studentGroup4 = new StudentGroup({id: 4});
    //
    //studentGroupContainer.addStudentGroup(studentGroup1);
    //studentGroupContainer.addStudentGroup(studentGroup2);
    //studentGroupContainer.addStudentGroup(studentGroup3);
    //studentGroupContainer.addStudentGroup(studentGroup4);
    //
    //
    //programmeUnit1 = new ProgrammeUnit({id: 1, name: "jednostka programu studiów 1"});
    //programmeUnit2 = new ProgrammeUnit({id: 2, name: "jednostka programu studiów 1"});
    //programmeUnit3 = new ProgrammeUnit({id: 3, name: "jednostka programu studiów 1"});
    //programmeUnit4 = new ProgrammeUnit({id: 4, name: "jednostka programu studiów 1"});
    //
    //programmeUnitContainer.addProgrammeUnit(programmeUnit1);
    //programmeUnitContainer.addProgrammeUnit(programmeUnit2);
    //programmeUnitContainer.addProgrammeUnit(programmeUnit3);
    //programmeUnitContainer.addProgrammeUnit(programmeUnit4);
}