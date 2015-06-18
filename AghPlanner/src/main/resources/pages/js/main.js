$('document').ready(function(){
    $('#calendar').fullCalendar({
        firstDay: 1,
        theme: true,
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        editable: true,
        eventLimit: true
    });

    calendarAdapter.addEventListeners();
    addContainers();
});

function addContainers() {
    teacherContainer = new TeacherContainer({position: 'body'});
    avatarContainer = new AvatarContainer({position: 'body'});
    aggregateContainer = new AggregateContainer({position: 'body'});
    studentGroupContainer = new StudentGroupContainer({position: 'body'});
    programmeUnitContainer = new ProgrammeUnitContainer({position: 'body'});

    addDragEventsForAllElems();
}
