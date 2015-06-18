function StudentGroup(object) {
    if ( typeof object != "undefined" && object.hasOwnProperty('id') ) {
        this.setId(object.id);
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
}

StudentGroup.prototype.setElement = function() {
    this.$el = document.createElement('div');
    this.$el.className = 'studentGroup';
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).data('obj', this);

    this.$el.innerHTML ='<span class="studentGroup_title">' + this.id + '</span>';

    this.createRemoveButton();
};

StudentGroup.prototype.setId = function(id) {
    this.id = id;
};

StudentGroup.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

StudentGroup.prototype.getParentID = function() {
    return $(this.$el).parent().attr('id');
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
    event.stopPropagation();

    event.dataTransfer.clearData();
    event.dataTransfer.effectAllowed = 'all';
    event.dataTransfer.setData('studentGroup', this.serialize());

    this.$el.style.opacity = '0.4';
};

StudentGroup.prototype.handleDragEnd = function(event) {
    event.stopPropagation();

    this.$el.style.opacity = '1';

    $('*').removeClass('over');

    var object = $(this.position).data('obj')
    $(this.position).data('obj').removeStudentGroup(this);
};

StudentGroup.prototype.handleDragOver = function(event) {
    event.stopPropagation();

    if (event.dataTransfer.types[0] == 'studentgroup') {
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

StudentGroup.prototype.handleDragEnter = function(event) {
    event.stopPropagation();

    //console.log('StudentGroup.handleDragEnter');
    // event.target is the current hover target.
    //$('.avatar').addClass('over');
    //$('#avatarContainer').addClass('over');
};

StudentGroup.prototype.handleDragLeave = function(event) {
    event.stopPropagation();

    //console.log('StudentGroup.handleDragLeave');
    // event.target is previous element
    //$('.avatar').removeClass('over');
    //$('#avatarContainer').removeClass('over');
};

StudentGroup.prototype.createRemoveButton = function() {
    $(this.$el).append('<div class="remove_button"></div>');
    $(this.$el).find('.remove_button').click(function(){

        var elem = this;

        $("#dialog_remove_confirmation").dialog({
            autoOpen: false,
            modal: true,
            buttons : {
                "Confirm" : function() {
                    console.log(this);
                    var studentGroup = $(elem).parent().data('obj');
                    studentGroup.remove();

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


StudentGroup.prototype.remove = function() {
    var studentGroup = this;

    $.ajax({
        url: "/studentGroup",
        type: 'DELETE',
        dataType: 'text',
        data: this.serialize(),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            $(studentGroup.$el).remove();
            console.log('StudentGroup removed.');
        },
        error:function(data, status, er) {
            console.log('StudentGroup deletion failed.');
        }
    });
}


