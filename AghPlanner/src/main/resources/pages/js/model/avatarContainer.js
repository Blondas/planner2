function AvatarContainer(object) {
    this.avatars = Array();
    this.$el = document.createElement('div');
    this.setPosition(object.position);
    this.$el.className = 'objectsContainer';
    $(this.$el).attr('id', 'avatarContainer');

    $(this.$el).append('<div class="containerTitle">Awatary:</div>');

    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
}

AvatarContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

AvatarContainer.prototype.addAvatar = function(avatar) {
    avatar.setPosition(this.$el);
    this.avatars.push(avatar);
};

AvatarContainer.prototype.removeAvatar = function(avatar) {
    this.teachers.remove(avatar);
};

AvatarContainer.prototype.handleDocumentDrop = function(event) {
    event.stopPropagation();

    if (event.dataTransfer.types.indexOf('teacher') > -1) {
        var teacher = JSON.parse(event.dataTransfer.getData('teacher'));
        event.dataTransfer.clearData('teacher')
        var avatar = new Avatar({position: $(this.$el).attr('id')});
        console.log($(this.$el).attr('id')  );
        avatar.addTeacher(new Teacher(teacher));
    }
};