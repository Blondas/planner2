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
            calendarAdapter.saveConcreteLesson(event, element);
        }
    });

    calendarAdapter.addEventListeners();
    addContainers();
    addScheduleCreator();
    createDatabaseWithoutRelations();
});

function addContainers() {
    viewContainer = new ViewContainer({position: '#menu'});

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

        var dateBegin = $("#dateSemesterBegin").datepicker("getDate");
        var dateEnd = $("#dateSemesterEnd").datepicker("getDate");

        var dateBeginFormat = $.datepicker.formatDate('dd/mm/yy', new Date(dateBegin));
        var dateEndFormat = $.datepicker.formatDate('dd/mm/yy', new Date(dateEnd));

        var object = new Object();
        object.name = $("#name").val();
        object.dateSemesterBegin = dateBeginFormat;
        object.dateSemesterEnd = dateEndFormat;

        var schedule = new Schedule(object);
        schedule.save();


        //console.log($( this ).serializeArray());

    });

}

function createDatabaseWithoutRelations(){
    $('#buttonCreateDropDatabase').click(function() {
        $.ajax({
            url: "/createDatabaseWithoutRelations",
            type: 'GET',
            dataType: 'json',
            data: 'text',
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function(data) {
                console.log('Database without relations created');
            },
            error:function(data, status, er) {
                console.log('Database without relations failed to create');
            }
        });
    });
};