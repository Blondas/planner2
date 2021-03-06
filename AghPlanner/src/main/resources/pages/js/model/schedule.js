function Schedule(object) {


    if ( typeof object != "undefined" && object.hasOwnProperty('id') ) {
        this.setId(object.id);
    }

    if ( typeof object != "undefined" && object.hasOwnProperty('name') ) {
        this.setName(object.name);
    } else {
        this.setName("");
    }

    if ( typeof object != "undefined" && object.hasOwnProperty('date') ) {
        this.setDate(object.date);
    } else {
        this.setDate("");
    }

    if ( typeof object != "undefined" && object.hasOwnProperty('dateSemesterBegin') ) {
        this.setDateSemesterBegin(object.dateSemesterBegin);
    } else {
        this.setDateSemesterBegin("");
    }

    if ( typeof object != "undefined" && object.hasOwnProperty('dateSemesterEnd') ) {
        this.setDateSemesterEnd(object.dateSemesterEnd);
    } else {
        this.setDateSemesterEnd("");
    }

}



Schedule.prototype.setId = function(id) {
    this.id = id;
};

Schedule.prototype.setName = function(name) {
    this.name = name;
};

Schedule.prototype.setDate = function(date) {
    this.date = date;
};

Schedule.prototype.setDateSemesterBegin = function(dateSemesterBegin) {
    this.dateSemesterBegin = dateSemesterBegin;
};

Schedule.prototype.setDateSemesterEnd = function(dateSemesterEnd) {
    this.dateSemesterEnd = dateSemesterEnd;
};


Schedule.prototype.serialize = function() {
    var data = {
        id: this.id,
        name: this.name,
        date: this.date,
        dateSemesterBegin: this.dateSemesterBegin,
        dateSemesterEnd: this.dateSemesterEnd,
    };

    return JSON.stringify(JSON.decycle(data));
};

Schedule.prototype.showDialogScheduleCreated = function() {
    $("#dialogScheduleCreatedConfirmation").dialog({
        autoOpen: false,
        modal: true,
        buttons : {
            "Potwierdź" : function() {

                $("#dialogScheduleCreatedConfirmation").dialog("close");
                $('#dialogScheduleCreatedConfirmation').hide();
            }
        },
        open: function(event, ui) {
            $(".ui-dialog-titlebar-close").hide();
        }
    });

    $("#dialogScheduleCreatedConfirmation").dialog("open");
    $('#dialogScheduleCreatedConfirmation').show();
}

Schedule.prototype.save = function() {
    var schedule = this;

    $.ajax({
        url: "/schedule",
        type: 'POST',
        dataType: 'json',
        data: this.serialize(),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            schedule.setId(data.id);
            schedule.showDialogScheduleCreated();
            console.log('Schedule saved');
        },
        error:function(data, status, er) {
            console.log('Schedule failed to save');
        }
    });
};