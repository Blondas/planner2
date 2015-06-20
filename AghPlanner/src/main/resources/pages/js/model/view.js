function View(object) {
    if ( typeof object != "undefined" && object.hasOwnProperty('id') ) {
        this.id = object.id;
    }
    if ( typeof object != "undefined" && object.hasOwnProperty('name') ) {
        this.name = object.name;
    } else {
        this.name = "";
    }
    if ( typeof object != "undefined" && object.hasOwnProperty('calendar') ) {
        this.calendar = object.calendar;
    }
    if ( typeof object != "undefined" && object.hasOwnProperty('teacherContainer') ) {
        this.teacherContainer = object.teacherContainer;
    }
    if ( typeof object != "undefined" && object.hasOwnProperty('avatarContainer') ) {
        this.avatarContainer = object.avatarContainer;
    }
    if ( typeof object != "undefined" && object.hasOwnProperty('aggregateContainer') ) {
        this.aggregateContainer = object.aggregateContainer;
    }
    if ( typeof object != "undefined" && object.hasOwnProperty('studentGroupContainer') ) {
        this.studentGroupContainer = object.studentGroupContainer;
    }
    if ( typeof object != "undefined" && object.hasOwnProperty('programmeUnitContainer') ) {
        this.programmeUnitContainer = object.programmeUnitContainer;
    }

    if ( typeof object != "undefined" && object.hasOwnProperty('parent') ) {
        this.parent = object.parent;
    }
}

View.prototype.serialize = function() {
    var data = {
        id: this.id,
        //name: this.name,
        name: "aaaaaa",
        calendar: this.calendar,
        teacherContainer: this.teacherContainer,
        avatarContainer: this.avatarContainer,
        aggregateContainer: this.aggregateContainer,
        studentGroupContainer: this.studentGroupContainer,
        programmeUnitContainer: this.programmeUnitContainer
    };

    return JSON.stringify(data);
};

View.prototype.remove = function() {
    var view = this;

    $.ajax({
        url: "/view",
        type: 'DELETE',
        dataType: 'text',
        data: this.serialize(),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            view.parent.removeView(view);
        },
        error:function(data, status, er) {
            console.log('View deletion failed.');
        }
    });
};

View.prototype.save = function() {
    var view = this;

    $.ajax({
        url: "/view",
        type: 'POST',
        dataType: 'json',
        data: this.serialize(),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            view.id = data.id;
            view.parent.currentView = view;
        },
        error:function(data, status, er) {
            return null;
        }
    });
};

View.prototype.setVisibleElements = function() {
    if (this.calendar) {
        showElement('#calendar');
    } else {
        hideElement('#calendar');
    }

    if (this.teacherContainer) {
        showElement('#teacherContainer');
    } else {
        hideElement('#teacherContainer');
    }

    if (this.avatarContainer) {
        showElement('#avatarContainer');
    } else {
        hideElement('#avatarContainer');
    }

    if (this.aggregateContainer) {
        showElement('#aggregateContainer');
    } else {
        hideElement('#aggregateContainer');
    }

    if (this.studentGroupContainer) {
        showElement('#studentGroupContainer');
    } else {
        hideElement('#studentGroupContainer');
    }

    if (this.programmeUnitContainer) {
        showElement('#programmeUnitContainer');
    } else {
        hideElement('#programmeUnitContainer');
    }
};

View.prototype.getVisibleElements = function() {
    var view = this;
    $('.view-selectable-element').each(function() {
        switch ( $(this).attr('id') ) {
            case 'calendar':
                if ( $(this).is(':visible') ) {
                    view.calendar = true;
                } else {
                    view.calendar = false;
                }
                break;

            case 'teacherContainer':
                if ( $(this).is(':visible') ) {
                    view.teacherContainer = true;
                } else {
                    view.teacherContainer = false;
                }
                break;

            case 'avatarContainer':
                if ( $(this).is(':visible') ) {
                    view.avatarContainer = true;
                } else {
                    view.avatarContainer = false;
                }
                break;

            case 'aggregateContainer':
                if ( $(this).is(':visible') ) {
                    view.aggregateContainer = true;
                } else {
                    view.aggregateContainer = false;
                }
                break;

            case 'studentGroupContainer':
                if ( $(this).is(':visible') ) {
                    view.studentGroupContainer = true;
                } else {
                    view.studentGroupContainer = false;
                }
                break;

            case 'programmeUnitContainer':
                if ( $(this).is(':visible') ) {
                    view.programmeUnitContainer = true;
                } else {
                    view.programmeUnitContainer = false;
                }
                break;
        }
    });
};

View.prototype.setCurrentView = function (view) {
    view.setVisibleElements();
    this.currentView = view;
};




