function TeacherContainer(object) {
    this.teachers = Array();

    this.setElement();

    if ( typeof object != "undefined" && object.hasOwnProperty('position') ) {
        this.setPosition(object.position);
    }

    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
}

TeacherContainer.prototype.setElement = function () {
    this.$el = document.createElement('div');
    this.$el.className = 'objectsContainer';
    $(this.$el).attr('id', 'teacherContainer');
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).append('<div class="containerTitle">Wykładowcy:</div>');

    $(this.$el).data('obj', this);
};

TeacherContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

TeacherContainer.prototype.addTeacher = function(teacher) {
    teacher.setPosition(this.$el);
    this.teachers.push(teacher);
};

TeacherContainer.prototype.removeTeacher = function(teacher) {
    this.teachers.remove(teacher);
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