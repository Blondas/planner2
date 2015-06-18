function ProgrammeUnit(object) {
    if (typeof object != "undefined" && object.hasOwnProperty('id')) {
        this.setId(object.id);
    }

    if (typeof object != "undefined" && object.hasOwnProperty('name')) {
        this.setName(object.name);
    } else {
        this.setName("");
    }

    if (typeof object != "undefined" && object.hasOwnProperty('position')) {
        this.setPosition(object.position);
    }

    this.setElement();

    this.$el.addEventListener('dragstart', this.handleDragStart.bind(this), false);
    this.$el.addEventListener('dragend', this.handleDragEnd.bind(this), false);
    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('dragenter', this.handleDragEnter, false);
    this.$el.addEventListener('dragleave', this.handleDragLeave, false);
}

ProgrammeUnit.prototype.setElement = function () {
    this.$el = document.createElement('div');
    this.$el.className = 'programmeUnit';
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).data('obj', this);

    $(this.$el).text(this.name);

    this.createRemoveButton();
};

ProgrammeUnit.prototype.setId = function (id) {
    this.id = id;
};

ProgrammeUnit.prototype.setName = function (name) {
    this.name = name;
    $(this.$el).text(this.name);
};

ProgrammeUnit.prototype.setPosition = function (containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

ProgrammeUnit.prototype.getParentID = function () {
    return $(this.$el).parent().attr('id');
}

ProgrammeUnit.prototype.serialize = function () {
    var data = {
        id: this.id,
        name: this.name,
        className: this.$el.className,
        position: this.position
    };

    return JSON.stringify(JSON.decycle(data));
};

ProgrammeUnit.prototype.detach = function (event) {
    $(this.$el).detach();
};

ProgrammeUnit.prototype.handleDragStart = function (event) {
    event.stopPropagation();

    event.dataTransfer.clearData();
    event.dataTransfer.effectAllowed = 'all';
    event.dataTransfer.setData('programmeUnit', this.serialize());

    this.$el.style.opacity = '0.4';
};

ProgrammeUnit.prototype.handleDragEnd = function (event) {
    event.stopPropagation();

    this.$el.style.opacity = '1';

    $('*').removeClass('over');

    //console.log(this.position);
    this.detach();
};

ProgrammeUnit.prototype.handleDragOver = function (event) {
    event.stopPropagation();

    if (event.dataTransfer.types[0] == 'programmeunit') {
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

ProgrammeUnit.prototype.handleDragEnter = function (event) {
    event.stopPropagation();
};

ProgrammeUnit.prototype.handleDragLeave = function (event) {
    event.stopPropagation();
};

ProgrammeUnit.prototype.createRemoveButton = function () {
    $(this.$el).append('<div class="remove_button"></div>');
    $(this.$el).find('.remove_button').click(function () {

        var elem = this;

        $("#dialog_remove_confirmation").dialog({
            autoOpen: false,
            modal: true,
            buttons: {
                "Confirm": function () {
                    console.log(this);
                    var programmeUnit = $(elem).parent().data('obj');
                    programmeUnit.remove();

                    $("#dialog_remove_confirmation").dialog("close");
                    $('#dialog_remove_confirmation').hide();
                },
                "Cancel": function () {
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

ProgrammeUnit.prototype.remove = function () {
    var programmeUnit = this;

    $.ajax({
        url: "/programmeUnit",
        type: 'DELETE',
        dataType: 'text',
        data: this.serialize(),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
            $(programmeUnit.$el).remove();
            console.log('ProgrammeUnit removed.');
        },
        error: function (data, status, er) {
            console.log('ProgrammeUnit deletion failed.');
        }
    });
}

