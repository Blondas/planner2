function ProgrammeUnit(object) {
<<<<<<< HEAD
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
=======
    this.$el = document.createElement('div');
    this.setId(object.id);
    this.setName(object.name);
    this.setPosition(object.position);
    this.$el.className = 'programmeUnit';
    this.$el.setAttribute('draggable', 'true');
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6

    this.$el.addEventListener('dragstart', this.handleDragStart.bind(this), false);
    this.$el.addEventListener('dragend', this.handleDragEnd.bind(this), false);
    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('dragenter', this.handleDragEnter, false);
    this.$el.addEventListener('dragleave', this.handleDragLeave, false);
}

<<<<<<< HEAD
ProgrammeUnit.prototype.setElement = function() {
    this.$el = document.createElement('div');
    this.$el.className = 'programmeUnit';
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).data('obj', this);

    $(this.$el).text(this.name + ' ' + this.lastName);
};

=======
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
ProgrammeUnit.prototype.setId = function(id) {
    this.id = id;
};

ProgrammeUnit.prototype.setName = function(name) {
    this.name = name;
    $(this.$el).text(this.name);
};

ProgrammeUnit.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

<<<<<<< HEAD
ProgrammeUnit.prototype.getParentID = function() {
    return $(this.$el).parent().attr('id');
}

=======
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
ProgrammeUnit.prototype.serialize = function() {
    var data = {
        id: this.id,
        name: this.name,
        className: this.$el.className,
        position: this.position
    };

    return JSON.stringify(JSON.decycle(data));
};

ProgrammeUnit.prototype.detach = function(event) {
    $(this.$el).detach();
};

ProgrammeUnit.prototype.handleDragStart = function(event) {
    event.stopPropagation();

<<<<<<< HEAD
    event.dataTransfer.clearData();
=======
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
    event.dataTransfer.effectAllowed = 'all';
    event.dataTransfer.setData('programmeUnit', this.serialize());

    this.$el.style.opacity = '0.4';
};

ProgrammeUnit.prototype.handleDragEnd = function(event) {
    event.stopPropagation();

    this.$el.style.opacity = '1';

    $('.aggregate').removeClass('over');
<<<<<<< HEAD
    $('#aggregateContainer').removeClass('over');
=======
    $('aggregateContainer').removeClass('over');
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6

    //console.log(this.position);
    this.detach();
};

ProgrammeUnit.prototype.handleDragOver = function(event) {
<<<<<<< HEAD
=======
    //console.log('ProgrammeUnit.handleDragOver');

>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
    event.stopPropagation();

    $('.aggregate').addClass('over');
    $('#aggregateContainer').addClass('over');

    if (event.preventDefault) {
        event.preventDefault();
    }
    event.dataTransfer.dropEffect = 'move';
    return false;
};

// odpalany w chwili wejscia w przestrzen, this/event dotyczy przenoszonego elementu
ProgrammeUnit.prototype.handleDragEnter = function(event) {
    event.stopPropagation();

    //console.log('ProgrammeUnit.handleDragEnter');
    // event.target is the current hover target.
    //$('.avatar').addClass('over');
    //$('#avatarContainer').addClass('over');
};

// odpalany w chwili wyjscia z przestrzeni, this/event dotyczy przenoszonego elementu
ProgrammeUnit.prototype.handleDragLeave = function(event) {
    event.stopPropagation();

    //console.log('ProgrammeUnit.handleDragLeave');
    // event.target is previous element
    //$('.avatar').removeClass('over');
    //$('#avatarContainer').removeClass('over');
};

