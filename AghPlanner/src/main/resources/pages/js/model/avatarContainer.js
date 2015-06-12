function AvatarContainer(object) {
    this.avatars = Array();
<<<<<<< HEAD

    this.setElement();

    if ( typeof object != "undefined" && object.hasOwnProperty('position') ) {
        this.setPosition(object.position);
    }

    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
}

AvatarContainer.prototype.setElement = function () {
    this.$el = document.createElement('div');
    this.$el.className = 'objectsContainer';
    $(this.$el).attr('id', 'avatarContainer');
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).append('<div class="containerTitle">Awatary:</div>');

    $(this.$el).data('obj', this);
};
=======
    this.$el = document.createElement('div');
    this.setPosition(object.position);
    this.$el.className = 'objectsContainer';
    $(this.$el).attr('id', 'avatarContainer');

    $(this.$el).append('<div class="containerTitle">Awatary:</div>');

    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
}
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6

AvatarContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

AvatarContainer.prototype.addAvatar = function(avatar) {
    avatar.setPosition(this.$el);
    this.avatars.push(avatar);
};

AvatarContainer.prototype.removeAvatar = function(avatar) {
<<<<<<< HEAD
    this.avatars.splice( $.inArray(avatar, this.avatars), 1 );
    avatar.detach();
=======
    this.teachers.remove(avatar);
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
};

AvatarContainer.prototype.handleDocumentDrop = function(event) {
    event.stopPropagation();

<<<<<<< HEAD
    if (event.dataTransfer.types[0] ==  'teacher') {
        var avatarContainer = $(this).data('obj');

        var avatar = new Avatar();
        avatar.position = avatarContainer.$el;
        avatarContainer.addAvatar(avatar);

        var object = JSON.parse(event.dataTransfer.getData('teacher'));
        object.position = avatar.$el;

        var teacher = new Teacher(object);

        avatar.addTeacher(teacher);
        avatar.save();
    }
};

AvatarContainer.prototype.handleDragOver = function(event) {
    event.stopPropagation();

    if (event.preventDefault) {
        event.preventDefault();
    }

    return false;
};

AvatarContainer.prototype.loadAllAvatars = function() {
    var avatarContainer = this;

    $.ajax({
        url: "/avatars",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            data.forEach(function(entry) {
                avatarContainer.addAvatar( new Avatar(entry) );
            });
        }
    });
};

=======
    if (event.dataTransfer.types.indexOf('teacher') > -1) {
        var teacher = JSON.parse(event.dataTransfer.getData('teacher'));
        event.dataTransfer.clearData('teacher')
        var avatar = new Avatar({position: $(this.$el).attr('id')});
        console.log($(this.$el).attr('id')  );
        avatar.addTeacher(new Teacher(teacher));
    }
};
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
