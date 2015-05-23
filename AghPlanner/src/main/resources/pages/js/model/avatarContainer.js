function AvatarContainer(object) {
    this.avatars = Array();
    this.$el = document.createElement('div');
    this.setPosition(object.position);
    this.$el.className = 'objectsContainer';
    this.$el.id = 'avatarContainer';

    $(this.$el).append('<div class="containerTitle">Prowadzący Zajęcia:</div>');

    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
}

AvatarContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

AvatarContainer.prototype.addAvatar = function(avatar) {
    avatar.setPosition(this.$el);
    this.avatars.push(teacher);
};

Avatar.prototype.removeAvatar = function(avatar) {
    this.teachers.remove(avatar);
};

AvatarContainer.prototype.handleDocumentDrop = function(event) {
    if (event.dataTransfer.types.indexOf('teacher') > -1) {
        var teacher = JSON.parse(event.dataTransfer.getData('teacher'));
        event.dataTransfer.clearData('teacher')

        var avatar = new Avatar({position: this.$el.className});
        avatar.addTeacher(new Teacher(teacher));
        thi
    }
};