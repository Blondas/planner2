function TeacherContainer(object) {
    this.teachers = Array();
    this.$el = document.createElement('div');
    this.setPosition(object.position);
    this.$el.className = 'objectsContainer';
    this.$el.id = 'teacherContainer';

    $(this.$el).append('<div class="containerTitle">Wykładowcy:</div>');

    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
}

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

    if (event.dataTransfer.types.indexOf('teacher') > -1) {
        var teacher = JSON.parse(event.dataTransfer.getData('teacher'));
        event.dataTransfer.clearData('teacher')

        var teacher = new Teacher({position: this.$el.className});
        teacher.addTeacher(new Teacher(teacher));
    }
};