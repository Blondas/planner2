function ProgrammeUnitContainer(object) {
    this.programmeUnits = Array();

    this.setElement();

    if ( typeof object != "undefined" && object.hasOwnProperty('position') ) {
        this.setPosition(object.position);
    }

    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('drop', this.handleDocumentDrop, false);

    this.loadProgrammeUnitsWithoutAggregates();
}

ProgrammeUnitContainer.prototype.setElement = function () {
    this.$el = document.createElement('div');
    this.$el.className = 'objectsContainer view-selectable-element';
    $(this.$el).attr('id', 'programmeUnitContainer');
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).append('<div class="containerTitle">Jednostki Programu Studiów:</div>');

    $(this.$el).data('obj', this);
};

ProgrammeUnitContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

ProgrammeUnitContainer.prototype.addProgrammeUnit = function(programmeUnit) {
    var entry = this.doesProgrammeUnitExists(programmeUnit);

    if ( entry == false) {
        programmeUnit.setPosition(this.$el);
        this.programmeUnits.push(programmeUnit);
    }
};

ProgrammeUnitContainer.prototype.doesProgrammeUnitExists = function(programmeUnit) {
    var ret = false;
    this.programmeUnits.forEach(function(entry) {
        if (entry.id == programmeUnit.id) {
            ret = entry;
        }
    });

    return ret;
};

ProgrammeUnitContainer.prototype.removeProgrammeUnit = function(programmeUnit) {
    this.programmeUnits.splice( $.inArray(programmeUnit, this.programmeUnits), 1 );
    programmeUnit.detach();
};

ProgrammeUnitContainer.prototype.handleDocumentDrop = function(event) {
    event.stopPropagation();

    if (event.dataTransfer.types[0] ==  'programmeunit') {
        var programmeUnitContainer = $(this).data('obj');

        var object = JSON.parse(event.dataTransfer.getData('programmeunit'));
        object.position = programmeUnitContainer.$el;

        programmeUnitContainer.addProgrammeUnit( new ProgrammeUnit(programmeUnit) );
    }
};

ProgrammeUnitContainer.prototype.handleDragOver = function(event) {
    event.stopPropagation();

    if (event.preventDefault) {
        event.preventDefault();
    }

    return false;
};

ProgrammeUnitContainer.prototype.loadAllProgrammeUnits = function() {
    var programmeUnitContainer = this;

    $.ajax({
        url: "/programmeUnits",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            data.forEach(function(entry) {
                programmeUnitContainer.addProgrammeUnit( new ProgrammeUnit(entry) );
            });
        }
    });
};

ProgrammeUnitContainer.prototype.loadProgrammeUnitsWithoutAggregates = function() {
    var programmeUnit = this;

    $.ajax({
        url: "/programmeUnitsWithoutAggregate",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            data.forEach(function(entry) {
                programmeUnitContainer.addProgrammeUnit( new ProgrammeUnit(entry) );
            });
        }
    });
};