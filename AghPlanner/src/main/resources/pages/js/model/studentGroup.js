function StudentGroup(object) {
    this.$el = document.createElement('div');
    this.setId(object.id);
    this.setPosition(object.position);
    this.$el.className = 'studentGroup';
    this.$el.setAttribute('draggable', 'true');

    this.$el.addEventListener('dragstart', this.handleDragStart.bind(this), false);
    this.$el.addEventListener('dragend', this.handleDragEnd.bind(this), false);
    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('dragenter', this.handleDragEnter, false);
    this.$el.addEventListener('dragleave', this.handleDragLeave, false);
}

StudentGroup.prototype.setId = function(id) {
    this.id = id;
    $(this.$el).text(this.id);
};

StudentGroup.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

StudentGroup.prototype.serialize = function() {
    var data = {
        id: this.id,
        className: this.$el.className,
        position: this.position
    };

    return JSON.stringify(JSON.decycle(data));
};

StudentGroup.prototype.detach = function(event) {
    $(this.$el).detach();
};

StudentGroup.prototype.handleDragStart = function(event) {
    event.stopPropagation()

    event.dataTransfer.clearData();
    event.dataTransfer.effectAllowed = 'all';
    event.dataTransfer.setData('studentGroup', this.serialize());

    this.$el.style.opacity = '0.4';
};

StudentGroup.prototype.handleDragEnd = function(event) {
    event.stopPropagation();

    this.$el.style.opacity = '1';

    $('.aggregate').removeClass('over');
    $('aggregateContainer').removeClass('over');

    //console.log(this.position);
    this.detach();
};

StudentGroup.prototype.handleDragOver = function(event) {
    //console.log('StudentGroup.handleDragOver');

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
StudentGroup.prototype.handleDragEnter = function(event) {
    event.stopPropagation();

    //console.log('StudentGroup.handleDragEnter');
    // event.target is the current hover target.
    //$('.avatar').addClass('over');
    //$('#avatarContainer').addClass('over');
};

// odpalany w chwili wyjscia z przestrzeni, this/event dotyczy przenoszonego elementu
StudentGroup.prototype.handleDragLeave = function(event) {
    event.stopPropagation();

    //console.log('StudentGroup.handleDragLeave');
    // event.target is previous element
    //$('.avatar').removeClass('over');
    //$('#avatarContainer').removeClass('over');
};

