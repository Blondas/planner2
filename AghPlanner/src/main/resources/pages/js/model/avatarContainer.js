function AvatarContainer(object) {
    this.avatars = Array();

    this.setElement();

    if ( typeof object != "undefined" && object.hasOwnProperty('position') ) {
        this.setPosition(object.position);
    }

    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('drop', this.handleDocumentDrop, false);

    this.loadAvatarsWithoutAggregates();
}

AvatarContainer.prototype.setElement = function () {
    this.$el = document.createElement('div');
    this.$el.className = 'objectsContainer view-selectable-element';
    $(this.$el).attr('id', 'avatarContainer');
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).append('<div class="containerTitle">Awatary:</div>');

    $(this.$el).data('obj', this);
};

AvatarContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

AvatarContainer.prototype.addAvatar = function(avatar) {
    var entry = this.doesAvatarExists(avatar);

    if ( entry == false) {
        avatar.setPosition(this.$el);
        this.avatars.push(avatar);
    } else {
        entry.setTeachers(avatar.teachers);
    }
};

AvatarContainer.prototype.doesAvatarExists = function(avatar) {
    var ret = false;
    this.avatars.forEach(function(entry) {
        if (entry.id == avatar.id) {
            ret = entry;
        }
    });

    return ret;
};

AvatarContainer.prototype.removeAvatar = function(avatar) {
    this.avatars.splice( $.inArray(avatar, this.avatars), 1 );
    avatar.detach();
};

AvatarContainer.prototype.handleDocumentDrop = function(event) {
    event.stopPropagation();

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

AvatarContainer.prototype.loadAvatarsWithoutAggregates = function() {
    var avatarContainer = this;

    $.ajax({
        url: "/avatarsWithoutAggregates",
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

