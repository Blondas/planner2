function ViewContainer() {
    this.currentView = null;
    this.views = this.loadAllViews();

}

ViewContainer.prototype.loadAllViews = function() {
    var viewContainer = this;

    var views = new Array();

    $.ajax({
        url: "/views",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            data.forEach(function(entry) {
                entry.parent = viewContainer;
                views.push( new View(entry) );
            });

            return views;
        }
    });
};

TeacherContainer.prototype.addView = function(view) {
    var entry = this.doesViewExists(view);

    if ( entry == false) {
        this.views.push(view);
    }
};

TeacherContainer.prototype.doesViewExists = function(view) {
    var ret = false;
    this.view.forEach(function(entry) {
        if (entry.id == view.id) {
            ret = entry;
        }
    });

    return ret;
};

TeacherContainer.prototype.removeView = function(views) {
    this.views.splice( $.inArray(view, this.views), 1 );
};

TeacherContainer.prototype.handleDocumentDrop = function(event) {
    event.stopPropagation();

    if (event.dataTransfer.types[0] ==  'teacher') {
        var teacherContainer = $(this).data('obj');

        var object = JSON.parse(event.dataTransfer.getData('teacher'));
        object.position = teacherContainer.$el;
        teacherContainer.addTeacher( new Teacher(object))
    }
};

TeacherContainer.prototype.handleDragOver = function(event) {
    event.stopPropagation();

    if (event.preventDefault) {
        event.preventDefault();
    }

    return false;
};

TeacherContainer.prototype.loadAllTeachers = function() {
    var teacherContainer = this;

    $.ajax({
        url: "/teachers",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            data.forEach(function(entry) {
                teacherContainer.addTeacher( new Teacher(entry) );
            });
        }
    });
};

TeacherContainer.prototype.loadTeachersWithoutAvatar = function() {
    var teacherContainer = this;

    $.ajax({
        url: "/teachersWithoutAvatar",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            data.forEach(function(entry) {
                teacherContainer.addTeacher( new Teacher(entry) );
            });
        }
    });
};