function ProgrammeUnitContainer(object) {
    this.programmeUnits = Array();
    this.$el = document.createElement('div');
    this.setPosition(object.position);
    this.$el.className = 'objectsContainer';
    this.$el.id = 'programmeUnitContainer';

    $(this.$el).append('<div class="containerTitle">Jednostki Programów Studiów:</div>');

    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
}

ProgrammeUnitContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

ProgrammeUnitContainer.prototype.addProgrammeUnit = function(programmeUnit) {
    programmeUnit.setPosition(this.$el);
    this.programmeUnits.push(programmeUnit);
};

ProgrammeUnitContainer.prototype.removeProgrammeUnit = function(programmeUnit) {
    this.programmeUnits.remove(programmeUnit);
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
        url: "/programmeUnit",
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