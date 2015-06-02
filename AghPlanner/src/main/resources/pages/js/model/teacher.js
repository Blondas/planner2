function Teacher(object) {
    this.setId(object.id);
    this.setName(object.name);
    this.setLastName(object.lastName);
    this.setPosition(object.position);

    this.setElement(this.name, this.lastName, this.position);

    this.$el.addEventListener('dragstart', this.handleDragStart.bind(this), false);
    this.$el.addEventListener('dragend', this.handleDragEnd.bind(this), false);
    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('dragenter', this.handleDragEnter, false);
    this.$el.addEventListener('dragleave', this.handleDragLeave, false);
}

Teacher.prototype.setElement = function(name, lastName) {
    this.$el = document.createElement('div');
    this.$el.className = 'teacher';
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).text(this.name + ' ' + lastName);

    $(this.$el).data('obj', this);
};

Teacher.prototype.setId = function(id) {
    this.id = id;
};

Teacher.prototype.setName = function(name) {
    this.name = name;
};

Teacher.prototype.setLastName = function(lastName) {
    this.lastName = lastName;
};

Teacher.prototype.setPosition = function(parent) {
    this.position = parent;
    $(this.position).append(this.$el);
};

Teacher.prototype.getParentID = function() {
    return $(this.$el).parent().attr('id');
}

Teacher.prototype.serialize = function() {
    var data = {
        id: this.id,
        name: this.name,
        lastName: this.lastName,
        className: this.$el.className,
        position: this.position
    };

    return JSON.stringify(JSON.decycle(data));
};

Teacher.prototype.detach = function(event) {
    $(this.$el).detach();
};

//Teacher.prototype.save() = function() {
//    function teacherUPDATE() {
//        $.ajax({
//            //url: "/rest/teacher.json",
//            url: "/teacher",
//            type: 'POST',
//            dataType: 'json',
//            data: '{"id": ' + this.id + ', "name": "up Krystian", "lastName": "up Ujma"}',
//            contentType: 'application/json',
//            mimeType: 'application/json',
//            success: function(data) {
//                console.log(data);
//            },
//            error:function(data, status, er) {
//                console.log('Fail to save teacher.');
//            }
//        });
//    }
//};

// poczatek ruchu, this/event dotyczy przenoszonego elementu
Teacher.prototype.handleDragStart = function(event) {
    event.stopPropagation();

    event.dataTransfer.effectAllowed = 'all';
    event.dataTransfer.setData('teacher', this.serialize());

    this.$el.style.opacity = '0.4';
};

// koniec ruchu, this/event dotyczy przenoszonego elementu
Teacher.prototype.handleDragEnd = function(event) {
    event.stopPropagation();

    this.$el.style.opacity = '1';

    $('.avatar').removeClass('over');
    $('#avatarContainer').removeClass('over');

    if (this.getParentID() != 'teacherContainer') {
        $(this.position)
        this.detach();
    }
};

// odpalany co chwile podczas trwania calego ruchu, this/event dotyczy przenoszonego elementu
Teacher.prototype.handleDragOver = function(event) {
    event.stopPropagation();

    $('.avatar').addClass('over');
    $('#avatarContainer').addClass('over');

    //console.log('StudentGroup.handleDragOver');
    if (event.preventDefault) {
        event.preventDefault(); // Necessary. Allows us to drop.
    }
    event.dataTransfer.dropEffect = 'move';  // See the section on the DataTransfer object.
    return false;
}

// odpalany w chwili wejscia w przestrzen, this/event dotyczy przenoszonego elementu
Teacher.prototype.handleDragEnter = function(event) {
    event.stopPropagation();

    //console.log('StudentGroup.handleDragEnter');
    // event.target is the current hover target.
    //$('.avatar').addClass('over');
    //$('#avatarContainer').addClass('over');
}

// odpalany w chwili wyjscia z przestrzeni, this/event dotyczy przenoszonego elementu
Teacher.prototype.handleDragLeave = function(event) {
    event.stopPropagation();
    //console.log('StudentGroup.handleDragLeave');
    // event.target is previous element
    //$('.avatar').removeClass('over');
    //$('#avatarContainer').removeClass('over');
}

