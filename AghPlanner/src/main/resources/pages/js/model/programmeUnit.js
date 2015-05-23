function ProgrammeUnit(object) {
    this.$el = document.createElement('div');
    this.setId(object.id);
    this.setName(object.name);
    this.setPosition(object.position);
    this.$el.className = 'programmeUnit';
    this.$el.setAttribute('draggable', 'true');

    this.$el.addEventListener('dragstart', this.handleDragStart.bind(this), false);
    this.$el.addEventListener('dragend', this.handleDragEnd.bind(this), false);
    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('dragenter', this.handleDragEnter, false);
    this.$el.addEventListener('dragleave', this.handleDragLeave, false);
}

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
    event.dataTransfer.effectAllowed = 'all';
    event.dataTransfer.setData('programmeUnit', this.serialize());

    this.$el.style.opacity = '0.4';
};

ProgrammeUnit.prototype.handleDragEnd = function(event) {
    event.stopPropagation();

    this.$el.style.opacity = '1';

    $('.aggregate').removeClass('over');
    $('aggregateContainer').removeClass('over');

    //console.log(this.position);
    this.detach();
};

ProgrammeUnit.prototype.handleDragOver = function(event) {
    //console.log('ProgrammeUnit.handleDragOver');

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

