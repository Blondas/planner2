function StudentGroupContainer(object) {
    this.studentGroups = Array();

    this.setElement();

    if ( typeof object != "undefined" && object.hasOwnProperty('position') ) {
        this.setPosition(object.position);
    }

    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('drop', this.handleDocumentDrop, false);

    this.loadStudentGroupsWithoutAggregate();
}

StudentGroupContainer.prototype.setElement = function () {
    this.$el = document.createElement('div');
    this.$el.className = 'objectsContainer view-selectable-element';
    $(this.$el).attr('id', 'studentGroupContainer');
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).append('<div class="containerTitle">Grupy Studenckie:</div>');

    $(this.$el).data('obj', this);
};

StudentGroupContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

StudentGroupContainer.prototype.addStudentGroup = function(studentGroup) {
    var entry = this.doesStudentGroupExists(studentGroup);

    if ( entry == false) {
        studentGroup.setPosition(this.$el);
        this.studentGroups.push(studentGroup);
    }
};

StudentGroupContainer.prototype.doesStudentGroupExists = function(studentGroup) {
    var ret = false;
    this.studentGroups.forEach(function(entry) {
        if (entry.id == studentGroup.id) {
            ret = entry;
        }
    });

    return ret;
};

StudentGroupContainer.prototype.removeStudentGroup = function(studentGroup) {
    this.studentGroups.splice( $.inArray(studentGroup, this.studentGroups), 1 );
    studentGroup.detach();
};

StudentGroupContainer.prototype.handleDocumentDrop = function(event) {
    if (event.dataTransfer.types[0] ==  'studentGroup') {
        event.stopPropagation();

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

StudentGroupContainer.prototype.loadAllStudentGroups = function() {
    var studentGroupContainer = this;

    $.ajax({
        url: "/studentGroups",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            data.forEach(function(entry) {
                studentGroupContainer.addStudentGroup( new StudentGroup(entry) );
            });
        }
    });
};

StudentGroupContainer.prototype.loadStudentGroupsWithoutAggregate = function() {
    var studentGroupContainer = this;

    $.ajax({
        url: "/getStudentGroupsWithoutAggregate",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            data.forEach(function(entry) {
                studentGroupContainer.addStudentGroup( new StudentGroup(entry) );
            });
        }
    });
};