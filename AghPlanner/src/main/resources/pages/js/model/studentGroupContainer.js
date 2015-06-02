function StudentGroupContainer(object) {
    this.studentGroups = Array();
    this.$el = document.createElement('div');
    this.setPosition(object.position);
    this.$el.className = 'objectsContainer';
    this.$el.id = 'studentGroupContainer';

    $(this.$el).append('<div class="containerTitle">Grupy Studenckie:</div>');

    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
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
    this.studentGroups.remove(studentGroup);
};

StudentGroupContainer.prototype.handleDocumentDrop = function(event) {
    if (event.dataTransfer.types.indexOf('studentGroup') > -1) {
        var studentGroup = JSON.parse(event.dataTransfer.getData('studentGroup'));
        event.dataTransfer.clearData('studentGroup')

        var studentGroup = new StudentGroup({position: this.$el.className});
        studentGroup.addStudentGroup(new StudentGroup(studentGroup));
    }
};