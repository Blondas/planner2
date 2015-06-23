var calendarAdapter = {
    saveConcreteLesson: function(event, element) {
        var aggregate = event.aggregate;
        console.log(aggregate);
        //console.log(aggregate.serialize());
        //var aggregate_serialized = aggregate.serialize();


        $('#dialog-event-details').text(aggregate);

        console.log(event);
            element.data('obj', event);
            element.click(function(){
                $('#dialog-event-details').dialog({
                    autoOpen: false,
                    modal: true,
                    buttons : {
                        "Anuluj" : function() {
                            $(this).dialog("close");
                        }
                    },
                    open: function(event, ui) {
                        $(".ui-dialog-titlebar-close").hide();
                    }
                });
                $('#dialog-event-details').dialog("open");
                console.log( element.data('obj') );
            });

    },
    monthHandleDrop: function(event) {
        if (event.dataTransfer.types[0] ==  'aggregate') {
            var object = JSON.parse(event.dataTransfer.getData('aggregate'));
            var date = $(this).attr('data-date');

            calendarAdapter.attachEvent(object, date);
        }
    },

    weekHandleDrop: function(event) {
        if (event.dataTransfer.types[0] ==  'aggregate') {
            var object = JSON.parse(event.dataTransfer.getData('aggregate'));
            var dateTime = calendarAdapter.weekView.getDate(event);

            calendarAdapter.attachEvent(object, dateTime);
        }
    },

    dayHandleDrop: function(event) {
        if (event.dataTransfer.types[0] ==  'aggregate') {
            var object = JSON.parse(event.dataTransfer.getData('aggregate'));
            var dateTime = calendarAdapter.dayView.getDate(event);

            calendarAdapter.attachEvent(object, dateTime);
        }
    },

    attachEvent: function(aggregate, dateTime) {
        var aggregateSerialized = serialize(aggregate);
        $('#calendar').fullCalendar( 'renderEvent', {
            title: aggregateSerialized,
            start: dateTime,
            aggregate: aggregateSerialized,
            dupa1: "adsfadsf",
            dupa2: "asfasdfdsf"
        });
    },
        //aggregate.programmeUnit.name + aggregate.teachers[0].name + aggregate.studentGroup.id

    weekView: {
        getHour: function(elem) {
            var hour_text = $(elem).parent().find('.fc-time').find('span').text();

            if (hour_text.length) {
                return hour_text;
            } else {
                var prev_hor_text = $(elem).parent().prev().find('.fc-time').find('span').text();
                return prev_hor_text + '30';
            }
        },
        getDay: function(event) {
            var x_pos = event.pageX;
            var left;
            var right;

            var day = "";
            $('.fc-day-header').each(function() {
                left = $(this).offset().left;
                right = left + $(this).outerWidth();

                if (x_pos > left && x_pos < right) {
                    day = $(this).text().substring($(this).text().indexOf('/') + 1);
                    return day;
                }
            });
            return day;
        },
        getMonth: function() {
            return $('#calendar').fullCalendar( 'getDate' ).month() + 1;
        },
        getYear: function() {
            return $('#calendar').fullCalendar( 'getDate' ).year();
        },
        getDate: function(event) {
            var year = calendarAdapter.weekView.getYear();
            var month = calendarAdapter.weekView.getMonth();
            var day = calendarAdapter.weekView.getDay(event);
            var hour = calendarAdapter.weekView.getHour(event.currentTarget);

            return calendarAdapter.weekView.dateToString(year, month, day, hour);
        },
        dateToString: function(year, month, day, hour) {
            if (month < 10) {
                month = "0" + month;
            }


            if (day < 10) {
                day = "0" + day;
            }


            var hour_temp = "";
            var minute_temp = "";
            if ( hour.indexOf('am') > -1 ) {
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
            var string = year + '-' + month + '-' + day + 'T'+ hour;

            return string;
        }
    },
    dayView: {
        getDate: function(event) {
            var year = calendarAdapter.weekView.getYear();
            var month = calendarAdapter.weekView.getMonth();
            var day = calendarAdapter.dayView.getDay(event);
            var hour = calendarAdapter.weekView.getHour(event.currentTarget);

            return calendarAdapter.weekView.dateToString(year, month, day, hour);
        },
        getDay: function(event) {
            var day = $('#calendar').fullCalendar( 'getDate' ).format('DD');

            return day;
        }
    },

    handleDragOver: function(event) {
        event.stopPropagation();

        if (event.preventDefault) {
            event.preventDefault();
        }

        return false
    },

    addEventListeners: function() {
        // month view:
        $('.fc-month-view .fc-day').each(function() {
            this.addEventListener('dragover', calendarAdapter.handleDragOver, false);
            this.addEventListener('drop', calendarAdapter.monthHandleDrop, false);
        });

        // week view:
        $('.fc-agendaWeek-view .fc-slats .ui-widget-content').not('.fc-time').each(function() {
            this.addEventListener('dragover', calendarAdapter.handleDragOver, false);
            this.addEventListener('drop', calendarAdapter.weekHandleDrop, false);
        });

        // day view:
        $('.fc-agendaDay-view .fc-slats .ui-widget-content').not('.fc-time').each(function() {
            this.addEventListener('dragover', calendarAdapter.handleDragOver, false);
            this.addEventListener('drop', calendarAdapter.dayHandleDrop, false);
        });


        $('#calendar .fc-toolbar').click(function() {
            calendarAdapter.addEventListeners();
        });

    }
};


function serialize (aggregate){
    var data = {
        id: aggregate.id,
        name: aggregate.name,
        avatar: aggregate.avatar,
        studentGroup: aggregate.studentGroup,
        programmeUnit: aggregate.programmeUnit,
        className: aggregate.className,
        position: aggregate.position
    };

    return JSON.stringify(data);
};
