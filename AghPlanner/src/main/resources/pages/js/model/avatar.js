function Avatar(object) {
    this.teachers = Array();

    if ( typeof object != "undefined" && object.hasOwnProperty('id') ) {
        this.setId(object.id);
    }

    if ( typeof object != "undefined" && object.hasOwnProperty('name') ) {
        this.setName(object.name);
    } else {
        this.setName("");
    }

    if ( typeof object != "undefined" && object.hasOwnProperty('position') ) {
        this.setPosition(object.position);
    }

    this.setElement();

    this.$el.addEventListener('dragstart', this.handleDragStart.bind(this), false);
    this.$el.addEventListener('dragend', this.handleDragEnd.bind(this), false);
    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('dragenter', this.handleDragEnter, false);
    this.$el.addEventListener('dragleave', this.handleDragLeave, false);

    this.$el.addEventListener('drop', this.handleDocumentDrop, false);

    if ( typeof object != "undefined" && object.hasOwnProperty('teachers') ) {
        this.setTeachers(object.teachers);
    }

}

Avatar.prototype.setElement = function () {
    this.$el = document.createElement('div');
    this.$el.className = 'avatar';
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).data('obj', this);

    this.$el.innerHTML ='<span class="avatar_title">' + new Date().getMilliseconds() + '</span>';
}

Avatar.prototype.setId = function(id) {
    this.id = id;
};

Avatar.prototype.setName = function(name) {
    this.name = name;
};

Avatar.prototype.setTeachers = function(teachers) {
    for (var teacher in teachers) {
        teacher = new Teacher(teacher);
        this.addTeacher(teacher);
    }
};

Avatar.prototype.isInTeachers = function(teacher) {
    var inTeachers = false;
    this.teachers.forEach(function(entry) {
        if (entry.id == teacher.id) {
            inTeachers =  true;
        }
    });
    return inTeachers;
};

Avatar.prototype.addTeacher = function(teacher) {
    var inTeachers = this.isInTeachers(teacher);
    if ( !inTeachers ) {
        teacher.setPosition(this.$el);
        this.teachers.push(teacher);
    }
};

Avatar.prototype.removeTeacher = function(teacher) {
    this.teachers.splice( $.inArray(teacher, this.teachers), 1 );
    teacher.detach();
};

Avatar.prototype.setPosition = function(domId) {
    this.position = domId;
    $(this.position).append(this.$el);
};

Avatar.prototype.serialize = function() {
    var data = {
        id: this.id,
        name: this.name,
        teachers: this.teachers,
        className: this.$el.className,
        position: this.position
    };

    return JSON.stringify(data);
};

Avatar.prototype.handleDragStart = function(event) {
    event.stopPropagation();

    event.dataTransfer.clearData();
    event.dataTransfer.effectAllowed = 'all';
    event.dataTransfer.setData('avatar', this.serialize());

    this.$el.style.opacity = '0.4';
};

Avatar.prototype.handleDragEnd = function(event) {
    event.stopPropagation();

    this.$el.style.opacity = '1';

    $('.aggregate').removeClass('over');
    $('#aggregateContainer').removeClass('over');

    var object = $(this.position).data('obj')
    $(this.position).data('obj').removeAvatar(this);

    this.detach();
};

Avatar.prototype.handleDragOver = function(event) {
    event.stopPropagation();
    $('.aggregate').addClass('over');
    $('#aggregateContainer').addClass('over');

    if (event.preventDefault) {
        event.preventDefault();
    }
    event.dataTransfer.dropEffect = 'move';
    return false;
};

Avatar.prototype.handleDragEnter = function(event) {
    event.stopPropagation();

    // event.target is the current hover target.
    //$('.avatar').addClass('over');
    //$('#avatarContainer').addClass('over');
};

Avatar.prototype.handleDragLeave = function(event) {
    event.stopPropagation();

    // event.target is previous element
    //$('.avatar').removeClass('over');
    //$('#avatarContainer').removeClass('over');
};

Avatar.prototype.handleDocumentDrop = function(event) {
    event.stopPropagation();

    if (event.dataTransfer.types[0] ==  'teacher') {
        var avatar = $(this).data('obj');

        var object = JSON.parse(event.dataTransfer.getData('teacher'));
        object.position = avatar.$el;

        var teacher = new Teacher(object);

        avatar.addTeacher(teacher);
        avatar.save();
    }
};

Avatar.prototype.detach = function() {

    //console.log(this.$el.className);
    $(this.$el).detach();
};

Avatar.prototype.save = function() {
    $.ajax({
        url: "/avatar",
        type: 'POST',
        dataType: 'json',
        data: this.serialize(),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            console.log('Avatar saved');
        },
        error:function(data, status, er) {
            console.log('Avatar failed to save, ');
        }
    });
};

