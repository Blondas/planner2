function Aggregate(object) {

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

    if ( typeof object != "undefined" && object.hasOwnProperty('avatar') && object.avatar != null) {
        this.setAvatar(object.avatar);
    }
    if ( typeof object != "undefined" && object.hasOwnProperty('studentGroup')  && object.studentGroup != null) {
        this.setStudentGroup(object.studentGroup);
    }
    if ( typeof object != "undefined" && object.hasOwnProperty('programmeUnit') && object.programmeUnit != null) {
        this.setProgrammeUnit(object.programmeUnit);
    }

}

Aggregate.prototype.setElement = function () {
    this.$el = document.createElement('div');
    this.$el.className = 'aggregate';
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).data('obj', this);

    this.$el.innerHTML ='<span class="aggregate_title">' + this.name + '</span>';

    this.createRemoveButton();
}

Aggregate.prototype.setId = function(id) {
    this.id = id;
};

Aggregate.prototype.setName = function(name) {
    this.name = name;
};

Aggregate.prototype.setAvatar = function(object) {
    var avatar = new Avatar(object);
    avatar.setPosition(this.$el);
    this.avatar = avatar;
};

Aggregate.prototype.addProgrammeUnit = function(programmeUnit) {
    programmeUnit.setPosition(this.$el);
    this.programmeUnit = programmeUnit
};

Aggregate.prototype.addStudentGroup = function(studentGroup) {
    studentGroup.setPosition(this.$el);
    this.studentGroup = studentGroup;
};

Aggregate.prototype.addAvatar = function(avatar) {
    avatar.setPosition(this.$el);
    this.avatar = avatar;
};

//Aggregate.prototype.removeAvatar = function(avatar) {
//    this.avatars.splice( $.inArray(avatar, this.avatars), 1 );
//    avatar.detach();
//};

Aggregate.prototype.setStudentGroup = function(object) {
    var studentGroup = new StudentGroup(object);
    studentGroup.setPosition(this.$el);
    this.studentGroup = studentGroup;
};


//Aggregate.prototype.removeStudentGroup = function(studentGroup) {
//    this.studentGroups.splice( $.inArray(studentGroup, this.studentGroups), 1 );
//    studentGroup.detach();
//};

Aggregate.prototype.setProgrammeUnit = function(object) {
    var programmeUnit = new ProgrammeUnit(object);
    programmeUnit.setPosition(this.$el);

    this.programmeUnit = programmeUnit;
};


//Aggregate.prototype.removeProgrammeUnit = function(programmeUnit) {
//    this.programmeUnits.splice( $.inArray(programmeUnit, this.programmeUnits), 1 );
//    programmeUnit.detach();
//};

Aggregate.prototype.setPosition = function(domId) {
    this.position = domId;
    $(this.position).append(this.$el);
};

Aggregate.prototype.serialize = function() {
    var data = {
        id: this.id,
        name: this.name,
        avatar: this.avatar,
        studentGroup: this.studentGroup,
        programmeUnit: this.programmeUnit,
        className: this.$el.className,
        position: this.position
    };

    return JSON.stringify(data);
};

Aggregate.prototype.handleDragStart = function(event) {
    event.stopPropagation();

    event.dataTransfer.clearData();
    event.dataTransfer.effectAllowed = 'all';
    event.dataTransfer.setData('aggregate', this.serialize());

    this.$el.style.opacity = '0.4';
};

Aggregate.prototype.handleDragEnd = function(event) {
    event.stopPropagation();

    this.$el.style.opacity = '1';

    $('*').removeClass('over');

    var object = $(this.position).data('obj')
    $(this.position).data('obj').removeAggregate(this);

    this.detach();
};

Aggregate.prototype.handleDragOver = function(event) {
    event.stopPropagation();
    if (event.dataTransfer.types[0] == 'aggregate') {
        $('*').removeClass('over');
        $('#calendar').addClass('over');
    }


    if (event.preventDefault) {
        event.preventDefault();
    }
    event.dataTransfer.dropEffect = 'move';
    return false;
};

Aggregate.prototype.handleDragEnter = function(event) {
    event.stopPropagation();
};

Aggregate.prototype.handleDragLeave = function(event) {
    event.stopPropagation();
};

Aggregate.prototype.handleDocumentDrop = function(event) {
    var aggregate = $(this).data('obj');

    switch (event.dataTransfer.types[0]) {
        case 'avatar':
            event.stopPropagation();

            var object = JSON.parse(event.dataTransfer.getData('avatar'));
            object.position = aggregate.$el;
//            aggregate.avatar =  new Avatar(object) ;
            aggregate.addAvatar( new Avatar(object) );
            aggregate.save();

            break;

        case 'studentgroup':
            event.stopPropagation();

            var object = JSON.parse(event.dataTransfer.getData('studentGroup'));
            object.position = aggregate.$el;
//            aggregate.studentGroup = new StudentGroup(object);
            aggregate.addStudentGroup( new StudentGroup(object) );
            aggregate.save();

            break;

        case 'programmeunit':
            event.stopPropagation();

            var object = JSON.parse(event.dataTransfer.getData('programmeUnit'));
            object.position = aggregate.$el;
//            aggregate.programmeUnit = new ProgrammeUnit(object);
            aggregate.addProgrammeUnit( new ProgrammeUnit(object) );
            aggregate.save();

            break;
    }

};

Aggregate.prototype.detach = function() {

    //console.log(this.$el.className);
    $(this.$el).detach();
};

Aggregate.prototype.save = function() {
    var aggregate = this;
    $.ajax({
        url: "/aggregate",
        type: 'POST',
        dataType: 'json',
        data: this.serialize(),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            aggregate.setId(data.id);
            console.log('Aggregate saved');
        },
        error:function(data, status, er) {
            console.log('Aggregate failed to save, ');
        }
    });
};

Aggregate.prototype.createRemoveButton = function() {
    $(this.$el).append('<div class="remove_button"></div>');
    $(this.$el).find('.remove_button').click(function(){

        var elem = this;

        $("#dialog_remove_confirmation").dialog({
            autoOpen: false,
            modal: true,
            buttons : {
                "Potwierdź" : function() {
                    console.log(this);
                    var aggregate = $(elem).parent().data('obj');
                    aggregate.remove();

                    $("#dialog_remove_confirmation").dialog("close");
                    $('#dialog_remove_confirmation').hide();
                },
                "Anuluj" : function() {
                    $(this).dialog("close");
                }
            },
            open: function(event, ui) {
                $(".ui-dialog-titlebar-close").hide();
            }
        });

        $("#dialog_remove_confirmation").dialog("open");
        $('#dialog_remove_confirmation').show();
    });
}

/*
 AJAX
 */

Aggregate.prototype.remove = function() {
    var aggregate = this;

    $.ajax({
        url: "/aggregate",
        type: 'DELETE',
        dataType: 'text',
        data: this.serialize(),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            $(aggregate.$el).remove();
            console.log('ProgrammeUnit removed.');
        },
        error:function(data, status, er) {
            console.log('ProgrammeUnit deletion failed.');
        }
    });
}