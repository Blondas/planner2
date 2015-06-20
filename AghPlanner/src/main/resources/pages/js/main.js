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
        eventLimit: true,
        eventRender: function(event, element) {
            console.log('ajax zapisu do bazy');
        }
    });

    //$(function() {
    //    $( "#view-menu" ).menu();
    //});

    calendarAdapter.addEventListeners();
    addContainers();
    addScheduleCreator();
});

function addContainers() {
    teacherContainer = new TeacherContainer({position: 'body'});
    avatarContainer = new AvatarContainer({position: 'body'});
    aggregateContainer = new AggregateContainer({position: 'body'});
    studentGroupContainer = new StudentGroupContainer({position: 'body'});
    programmeUnitContainer = new ProgrammeUnitContainer({position: 'body'});

    addDragEventsForAllElems();
}

function addScheduleCreator(){
    $( "#dateSemesterBegin" ).datepicker();
    $( "#dateSemesterEnd" ).datepicker();

    $( "#scheduleCreator" ).submit(function( event ) {
        event.preventDefault();
        console.log($( this ).serializeArray());
        new Schedule().save($( this ).serializeArray());
    });
}
