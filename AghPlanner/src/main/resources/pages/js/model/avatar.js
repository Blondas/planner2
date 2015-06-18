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

    this.$el.innerHTML ='<span class="avatar_title">' + this.name + '</span>';

    this.createRemoveButton();
}

Avatar.prototype.setId = function(id) {
    this.id = id;
};

Avatar.prototype.setName = function(name) {
    this.name = name;
};

Avatar.prototype.setTeachers = function(teachers) {
    var avatar = this;

    teachers.forEach(function(entry) {
        var teacher = new Teacher(entry);
        avatar.addTeacher(teacher);
    });
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

/*
DRAG EVENTS
 */

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

    $('*').removeClass('over');

    var object = $(this.position).data('obj')
    $(this.position).data('obj').removeAvatar(this);

    this.detach();
};

Avatar.prototype.handleDragOver = function(event) {
    event.stopPropagation();

    if (event.dataTransfer.types[0] == 'avatar') {
        $('*').removeClass('over');
        $('.aggregate').addClass('over');
        $('#aggregateContainer').addClass('over');
    }

    if (event.preventDefault) {
        event.preventDefault();
    }
    event.dataTransfer.dropEffect = 'move';
    return false;
};

Avatar.prototype.handleDragEnter = function(event) {
    event.stopPropagation();
};

Avatar.prototype.handleDragLeave = function(event) {
    event.stopPropagation();
};

Avatar.prototype.handleDocumentDrop = function(event) {
    event.stopPropagation();
    event.originalEvent.dataTransfer.getData('source')

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


Avatar.prototype.createRemoveButton = function() {
    $(this.$el).append('<div class="remove_button"></div>');
    $(this.$el).find('.remove_button').click(function(){

        var elem = this;

        $("#dialog_remove_confirmation").dialog({
            autoOpen: false,
            modal: true,
            buttons : {
                "Confirm" : function() {
                    console.log(this);
                    var avatar = $(elem).parent().data('obj');
                    avatar.remove();

                    $("#dialog_remove_confirmation").dialog("close");
                    $('#dialog_remove_confirmation').hide();
                },
                "Cancel" : function() {
                    $(this).dialog("close");
                }
            }
        });

        $("#dialog_remove_confirmation").dialog("open");
        $('#dialog_remove_confirmation').show();
    });
}

/*
AJAX
 */

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

Avatar.prototype.remove = function() {
    var avatar = this;

    $.ajax({
        url: "/avatar",
        type: 'DELETE',
        dataType: 'text',
        data: this.serialize(),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            $(avatar.$el).remove();
            console.log('Avatar removed.');
        },
        error:function(data, status, er) {
            console.log('Avatar deletion failed.');
        }
    });
}
