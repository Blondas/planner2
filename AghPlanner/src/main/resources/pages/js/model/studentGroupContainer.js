function StudentGroupContainer(object) {
    this.studentGroups = Array();
<<<<<<< HEAD

    this.setElement();

    if ( typeof object != "undefined" && object.hasOwnProperty('position') ) {
        this.setPosition(object.position);
    }

    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
}

StudentGroupContainer.prototype.setElement = function () {
    this.$el = document.createElement('div');
    this.$el.className = 'objectsContainer';
    $(this.$el).attr('id', 'studentGroupContainer');
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).append('<div class="containerTitle">Grupy Studenckie:</div>');

    $(this.$el).data('obj', this);
=======
    this.$el = document.createElement('div');
    this.setPosition(object.position);
    this.$el.className = 'objectsContainer';
    this.$el.id = 'studentGroupContainer';

    $(this.$el).append('<div class="containerTitle">Grupy Studenckie:</div>');

    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
}

StudentGroupContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

StudentGroupContainer.prototype.addStudentGroup = function(studentGroup) {
    studentGroup.setPosition(this.$el);
    this.studentGroups.push(studentGroup);
};

StudentGroupContainer.prototype.removeStudentGroup = function(studentGroup) {
<<<<<<< HEAD
    this.studentGroups.splice( $.inArray(studentGroup, this.studentGroups), 1 );
    studentGroup.detach();
};

StudentGroupContainer.prototype.handleDocumentDrop = function(event) {
    if (event.dataTransfer.types[0] ==  'studentGroup') {
        var studentGroupContainer = $(this).data('obj');

        var object = JSON.parse(event.dataTransfer.getData('studentGroup'));
        object.position = studentGroupContainer.$el;

        studentGroupContainer.addStudentGroup( new StudentGroup(studentGroup) );
    }
};

StudentGroupContainer.prototype.handleDragOver = function(event) {
    event.stopPropagation();

    if (event.preventDefault) {
        event.preventDefault();
    }

    return false;
=======
    this.studentGroups.remove(studentGroup);
};

StudentGroupContainer.prototype.handleDocumentDrop = function(event) {
    if (event.dataTransfer.types.indexOf('studentGroup') > -1) {
        var studentGroup = JSON.parse(event.dataTransfer.getData('studentGroup'));
        event.dataTransfer.clearData('studentGroup')

        var studentGroup = new StudentGroup({position: this.$el.className});
        studentGroup.addStudentGroup(new StudentGroup(studentGroup));
    }
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
};