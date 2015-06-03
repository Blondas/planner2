function Aggregate(object) {
    this.avatars = Array();
    this.studentGroups = Array();
    this.programmeUnits = Array();

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

    if ( typeof object != "undefined" && object.hasOwnProperty('avatars') ) {
        this.setAvatars(object.avatars);
    }
    if ( typeof object != "undefined" && object.hasOwnProperty('studentGroups') ) {
        this.setStudentGroups(object.studentGroups);
    }
    if ( typeof object != "undefined" && object.hasOwnProperty('programmeUnits') ) {
        this.setProgrammeUnits(object.programmeUnits);
    }

}

Aggregate.prototype.setElement = function () {
    this.$el = document.createElement('div');
    this.$el.className = 'aggregate';
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).data('obj', this);

    this.$el.innerHTML ='<span class="aggregate_title">' + new Date().getMilliseconds() + '</span>';
}

Aggregate.prototype.setId = function(id) {
    this.id = id;
};

Aggregate.prototype.setName = function(name) {
    this.name = name;
};

Aggregate.prototype.setAvatars = function(avatars) {
    for (var avatar in avatars) {
        avatar = new Avatar(avatar);
        this.addAvatar(avatar);
    }
};

Aggregate.prototype.isInAvatars = function(avatar) {
    var inAvatars = false;
    this.avatars.forEach(function(entry) {
        if (entry.id == avatar.id) {
            inAvatars =  true;
        }
    });
    return inAvatars;
};

Aggregate.prototype.addAvatar = function(avatar) {
    var inAvatars = this.isInAvatars(avatar);
    if ( !inAvatars ) {
        avatar.setPosition(this.$el);
        this.avatars.push(avatar);
    }
};

Aggregate.prototype.removeAvatar = function(avatar) {
    this.avatars.splice( $.inArray(avatar, this.avatars), 1 );
    avatar.detach();
};

Aggregate.prototype.setStudentGroups = function(studentGroups) {
    for (var studentGroup in studentGroups) {
        studentGroup = new StudentGroup(studentGroup);
        this.addStudentGroup(studentGroup);
    }
};

Aggregate.prototype.isInStudentGroups = function(studentGroup) {
    var inStudentGroups = false;
    this.studentGroups.forEach(function(entry) {
        if (entry.id == studentGroup.id) {
            inStudentGroups =  true;
        }
    });
    return inStudentGroups;
};

Aggregate.prototype.addStudentGroup = function(studentGroup) {
    var inStudentGroups = this.isInStudentGroups(studentGroup);
    if ( !inStudentGroups ) {
        studentGroup.setPosition(this.$el);
        this.studentGroups.push(studentGroup);
    }
};

Aggregate.prototype.removeStudentGroup = function(studentGroup) {
    this.studentGroups.splice( $.inArray(studentGroup, this.studentGroups), 1 );
    studentGroup.detach();
};

Aggregate.prototype.setProgrammeUnits = function(programmeUnits) {
    for (var programmeUnit in programmeUnits) {
        programmeUnit = new ProgrammeUnit(programmeUnit);
        this.addProgrammeUnit(programmeUnit);
    }
};

Aggregate.prototype.isInProgrammeUnits = function(programmeUnit) {
    var inProgrammeUnits = false;
    this.programmeUnits.forEach(function(entry) {
        if (entry.id == programmeUnit.id) {
            inProgrammeUnits =  true;
        }
    });
    return inProgrammeUnits;
};

Aggregate.prototype.addProgrammeUnit = function(programmeUnit) {
    var inProgrammeUnits = this.isInProgrammeUnits(programmeUnit);
    if ( !inProgrammeUnits ) {
        programmeUnit.setPosition(this.$el);
        this.programmeUnits.push(programmeUnit);
    }
};

Aggregate.prototype.removeProgrammeUnit = function(programmeUnit) {
    this.programmeUnits.splice( $.inArray(programmeUnit, this.programmeUnits), 1 );
    programmeUnit.detach();
};

Aggregate.prototype.setPosition = function(domId) {
    this.position = domId;
    $(this.position).append(this.$el);
};

Aggregate.prototype.serialize = function() {
    var data = {
        id: this.id,
        name: this.name,
        avatars: this.avatars,
        studentGroups: this.studentGroups,
        programmeUnits: this.programmeUnits,
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

    $('.aggregate').removeClass('over');
    $('#aggregateContainer').removeClass('over');

    var object = $(this.position).data('obj')
    $(this.position).data('obj').removeAggregate(this);

    this.detach();
};

Aggregate.prototype.handleDragOver = function(event) {
    event.stopPropagation();
    $('.aggregate').addClass('over');
    $('#aggregateContainer').addClass('over');

    if (event.preventDefault) {
        event.preventDefault();
    }
    event.dataTransfer.dropEffect = 'move';
    return false;
};

Aggregate.prototype.handleDragEnter = function(event) {
    event.stopPropagation();

    // event.target is the current hover target.
    //$('.aggregate').addClass('over');
    //$('#aggregateContainer').addClass('over');
};

Aggregate.prototype.handleDragLeave = function(event) {
    event.stopPropagation();

    // event.target is previous element
    //$('.aggregate').removeClass('over');
    //$('#aggregateContainer').removeClass('over');
};

Aggregate.prototype.handleDocumentDrop = function(event) {
    event.stopPropagation();

    var aggregate = $(this).data('obj');

    switch (event.dataTransfer.types[0]) {
        case 'avatar':
            var object = JSON.parse(event.dataTransfer.getData('avatar'));
            object.position = aggregate.$el;
            aggregate.addAvatar( new Avatar(object) );

            break;

        case 'studentGroup':
            var object = JSON.parse(event.dataTransfer.getData('studentGroup'));
            object.position = aggregate.$el;
            aggregate.addStudentGroup( new StudentGroup(object) );

            break;

        case 'programmeUnit':
            var object = JSON.parse(event.dataTransfer.getData('programmeUnit'));
            object.position = aggregate.$el;
            aggregate.addProgrammeUnit( new ProgrammeUnit(object) );

            break;
    }

};

Aggregate.prototype.detach = function() {

    //console.log(this.$el.className);
    $(this.$el).detach();
};

Aggregate.prototype.save = function() {

};

