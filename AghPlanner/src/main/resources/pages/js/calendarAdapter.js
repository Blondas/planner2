var calendarAdapter = {
    selectClassBuilding: function(aggregate, element, calendar_event) {
        $('#dialog-event-details').text(aggregate);

        element.click(function () {
            $('#dialog-event-details').dialog({
                autoOpen: false,
                modal: true,
                buttons: {
                    "Anuluj": function () {
                        $(this).dialog("close");
                    },
                    "Zatwierdź": function() {
                        var sel_building = $('#building-sel').find(":selected").text();
                        var sel_class = $('#classroom-sel').find(":selected").text();

                        calendar_event.title += 'budynek: ' + sel_building + ', klasa: ' + sel_class;

                        $('#calendar').fullCalendar('updateEvent', calendar_event);

                        $(this).dialog("close");
                    }
                },
                open: function (event, ui) {
                    $(".ui-dialog-titlebar-close").hide();
                }
            });

            $('#dialog-event-details').dialog("open");
        });


        $('#dialog-event-details').append(
            '<hr>' +
            'Budynek: <select name="building" id="building-sel">' +
                '<option>10a</option>' +
                '<option>20c</option>' +
                '<option selected="selected">10a</option>' +
                '<option>17e</option>' +
                '<option>C2</option>' +
            '</select>'
        );

        $('#dialog-event-details').append(
            'Sala: <select name="classroom" id="classroom-sel">' +
                '<option>1a</option>' +
                '<option>2a</option>' +
                '<option selected="selected">1a</option>' +
                '<option>4</option>' +
                '<option>54</option>' +
            '</select>'
        );

    },

    saveConcreteLesson: function (event, element) {
        element.addClass('concrete-lesson');
        element.data('obj', event);

        var aggregate = event.aggregate;

        calendarAdapter.selectClassBuilding(aggregate, element, event);
    },
    monthHandleDrop: function (event) {
        if (event.dataTransfer.types[0] == 'aggregate') {
            var object = JSON.parse(event.dataTransfer.getData('aggregate'));
            var date = $(this).attr('data-date');

            calendarAdapter.attachEvent(object, date);
        }
    },

    weekHandleDrop: function (event) {
        if (event.dataTransfer.types[0] == 'aggregate') {
            var object = JSON.parse(event.dataTransfer.getData('aggregate'));
            var dateTime = calendarAdapter.weekView.getDate(event);

            calendarAdapter.attachEvent(object, dateTime);
        }
    },

    dayHandleDrop: function (event) {
        if (event.dataTransfer.types[0] == 'aggregate') {
            var object = JSON.parse(event.dataTransfer.getData('aggregate'));
            var dateTime = calendarAdapter.dayView.getDate(event);

            calendarAdapter.attachEvent(object, dateTime);
        }
    },

    attachEvent: function (aggregate, dateTime) {
        var aggregateSerialized = serialize(aggregate);
        $('#calendar').fullCalendar('renderEvent', {
            title: aggregateSerialized,
            start: dateTime,
            aggregate: aggregateSerialized,
            dupa1: "adsfadsf",
            dupa2: "asfasdfdsf"
        });
    },
    //aggregate.programmeUnit.name + aggregate.teachers[0].name + aggregate.studentGroup.id

    weekView: {
        getHour: function (elem) {
            var hour_text = $(elem).parent().find('.fc-time').find('span').text();

            if (hour_text.length) {
                return hour_text;
            } else {
                var prev_hor_text = $(elem).parent().prev().find('.fc-time').find('span').text();
                return prev_hor_text + '30';
            }
        },
        getDay: function (event) {
            var x_pos = event.pageX;
            var left;
            var right;

            var day = "";
            $('.fc-day-header').each(function () {
                left = $(this).offset().left;
                right = left + $(this).outerWidth();

                if (x_pos > left && x_pos < right) {
                    day = $(this).text().substring($(this).text().indexOf('/') + 1);
                    return day;
                }
            });
            return day;
        },
        getMonth: function () {
            return $('#calendar').fullCalendar('getDate').month() + 1;
        },
        getYear: function () {
            return $('#calendar').fullCalendar('getDate').year();
        },
        getDate: function (event) {
            var year = calendarAdapter.weekView.getYear();
            var month = calendarAdapter.weekView.getMonth();
            var day = calendarAdapter.weekView.getDay(event);
            var hour = calendarAdapter.weekView.getHour(event.currentTarget);

            return calendarAdapter.weekView.dateToString(year, month, day, hour);
        },
        dateToString: function (year, month, day, hour) {
            if (month < 10) {
                month = "0" + month;
            }


            if (day < 10) {
                day = "0" + day;
            }


            var hour_temp = "";
            var minute_temp = "";
            if (hour.indexOf('am') > -1) {
                hour_temp = hour.split('am')[0];
                if (hour_temp < 10) {
                    hour_temp = "0" + hour_temp
                }

                minute_temp = hour.split('am')[1];
                if (minute_temp < 10) {
                    minute_temp += "0" + minute_temp;
                }
            } else {
                hour_temp = hour.split('pm')[0];
                if (hour_temp != 12) {
                    hour_temp = 12 + parseInt(hour_temp);
                }

                minute_temp = hour.split('pm')[1];
                if (minute_temp < 10) {
                    minute_temp += "0" + minute_temp;
                }
            }

            if (minute_temp.length < 2) {
                minute_temp = "0" + minute_temp;
            }

            hour = "";
            hour += hour_temp + ':' + minute_temp + ':' + "00";


            // 2015-02-16T16:00:00
            var string = year + '-' + month + '-' + day + 'T' + hour;

            return string;
        }
    },
    dayView: {
        getDate: function (event) {
            var year = calendarAdapter.weekView.getYear();
            var month = calendarAdapter.weekView.getMonth();
            var day = calendarAdapter.dayView.getDay(event);
            var hour = calendarAdapter.weekView.getHour(event.currentTarget);

            return calendarAdapter.weekView.dateToString(year, month, day, hour);
        },
        getDay: function (event) {
            var day = $('#calendar').fullCalendar('getDate').format('DD');

            return day;
        }
    },

    handleDragOver: function (event) {
        event.stopPropagation();

        if (event.preventDefault) {
            event.preventDefault();
        }

        return false
    },

    addEventListeners: function () {
        // month view:
        $('.fc-month-view .fc-day').each(function () {
            this.addEventListener('dragover', calendarAdapter.handleDragOver, false);
            this.addEventListener('drop', calendarAdapter.monthHandleDrop, false);
        });

        // week view:
        $('.fc-agendaWeek-view .fc-slats .ui-widget-content').not('.fc-time').each(function () {
            this.addEventListener('dragover', calendarAdapter.handleDragOver, false);
            this.addEventListener('drop', calendarAdapter.weekHandleDrop, false);
        });

        // day view:
        $('.fc-agendaDay-view .fc-slats .ui-widget-content').not('.fc-time').each(function () {
            this.addEventListener('dragover', calendarAdapter.handleDragOver, false);
            this.addEventListener('drop', calendarAdapter.dayHandleDrop, false);
        });


        $('#calendar .fc-toolbar').click(function () {
            calendarAdapter.addEventListeners();
        });

    }
};


function serialize(aggregate) {
    var teachers = '';
    aggregate.avatar.teachers.forEach(function (teacher) {
        teachers += teacher.name + ' ' + teacher.lastName + ', ';
    });
    teachers = teachers.substring(0, teachers.length - 2);

    if (typeof aggregate.avatar == 'undefined') {
        aggregate.avatar = new Object();
        aggregate.avatar.name = "";
    }

    if (typeof aggregate.studentGroup == 'undefined') {
        aggregate.studentGroup = new Object();
        aggregate.studentGroup.id = "";
    }

    if (typeof aggregate.programmeUnit == 'undefined') {
        aggregate.programmeUnit = new Object();
        aggregate.programmeUnit.name = "";
    }

    var data = {
        id: aggregate.id,
        name: aggregate.name,
        avatar: aggregate.avatar.name,
        teachers: teachers,
        studentGroup: aggregate.studentGroup.id,
        programmeUnit: aggregate.programmeUnit.name
    };

    return (
    'id agregatu: ' + JSON.stringify(data.id) + '\n' +
    'nazwa agregatu: ' + JSON.stringify(data.name) + '\n' +
    'nazwa awataru: ' + JSON.stringify(data.avatar) + '\n' +
    'nauczyciele: ' + teachers + '\n' +
    'id grupy studenckiej: ' + JSON.stringify(data.studentGroup) + '\n' +
    'nazwa jednostki programu studiów: ' + JSON.stringify(data.programmeUnit) + '\n'
    )
}

function addSaleBuildingSelection() {

}