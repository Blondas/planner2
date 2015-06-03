function StudentGroupContainer(object) {
    this.studentGroups = Array();

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
};