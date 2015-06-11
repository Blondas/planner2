function AvatarContainer(object) {
    this.avatars = Array();

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

AvatarContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

AvatarContainer.prototype.addAvatar = function(avatar) {
    avatar.setPosition(this.$el);
    this.avatars.push(avatar);
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
        avatar.addTeacher( new Teacher(object) );
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

