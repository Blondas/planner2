function ProgrammeUnitContainer(object) {
    this.programmeUnits = Array();
    this.$el = document.createElement('div');
    this.setPosition(object.position);
    this.$el.className = 'objectsContainer';
    this.$el.id = 'programmeUnitContainer';

    $(this.$el).append('<div class="containerTitle">Jednostki Programów Studiów:</div>');

    this.$el.addEventListener('drop', this.handleDocumentDrop, false);

    this.loadAllProgrammeUnits();
}

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
    //programmeUnit.detach();
};

ProgrammeUnitContainer.prototype.handleDocumentDrop = function(event) {
    event.stopPropagation();

    if (event.dataTransfer.types.indexOf('programmeUnit') > -1) {
        var programmeUnit = JSON.parse(event.dataTransfer.getData('programmeUnit'));
        event.dataTransfer.clearData('programmeUnit')

        var programmeUnit = new ProgrammeUnit({position: this.$el.className});
        programmeUnit.addProgrammeUnit(new ProgrammeUnit(programmeUnit));
    }
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