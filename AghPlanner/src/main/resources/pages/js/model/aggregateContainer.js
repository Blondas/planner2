function AggregateContainer(object) {
    this.aggregates = Array();

    this.setElement();

    if ( typeof object != "undefined" && object.hasOwnProperty('position') ) {
        this.setPosition(object.position);
    }

    this.$el.addEventListener('dragover', this.handleDragOver.bind(this), false);
    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
}

AggregateContainer.prototype.setElement = function () {
    this.$el = document.createElement('div');
    this.$el.className = 'objectsContainer';
    $(this.$el).attr('id', 'aggregateContainer');
    this.$el.setAttribute('draggable', 'true');

    $(this.$el).append('<div class="containerTitle">Agregaty:</div>');

    $(this.$el).data('obj', this);
}

AggregateContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
    $(this.position).append(this.$el);
};

AggregateContainer.prototype.addAggregate = function(aggregate) {
    aggregate.setPosition(this.$el);
    this.aggregates.push(aggregate);
};

AggregateContainer.prototype.removeAggregate = function(aggregate) {
    this.aggregates.splice( $.inArray(aggregate, this.aggregates), 1 );
    aggregate.detach();
};

AggregateContainer.prototype.handleDocumentDrop = function(event) {
    event.stopPropagation();

    if (event.dataTransfer.types[0] ==  'avatar' || event.dataTransfer.types[0] ==  'studentgroup'
            || event.dataTransfer.types[0] ==  'programmeunit') {
        var aggregateContainer = $(this).data('obj');

        var aggregate = new Aggregate();
        aggregate.position = aggregateContainer.$el;
        aggregateContainer.addAggregate(aggregate);

        switch (event.dataTransfer.types[0]) {
            case 'avatar':
                var object = JSON.parse(event.dataTransfer.getData('avatar'));
                object.position = aggregate.$el;
                aggregate.addAvatar( new Avatar(object) );

                break;

            case 'studentgroup':
                var object = JSON.parse(event.dataTransfer.getData('studentGroup'));
                object.position = aggregate.$el;
                aggregate.addStudentGroup( new StudentGroup(object) );

                break;

            case 'programmeunit':
                var object = JSON.parse(event.dataTransfer.getData('programmeUnit'));
                object.position = aggregate.$el;
                aggregate.addProgrammeUnit( new ProgrammeUnit(object) );

                break;
        }
    }

    if (event.dataTransfer.types.indexOf('aggregate') > -1) {
        var aggregate = JSON.parse(event.dataTransfer.getData('aggregate'));
        event.dataTransfer.clearData('aggregate')

        var aggregate = new Aggregate({position: this.$el.className});
        aggregate.addAggregate(new Aggregate(aggregate));
    }
};

AggregateContainer.prototype.handleDragOver = function(event) {
    event.stopPropagation();

    if (event.preventDefault) {
        event.preventDefault();
    }

    return false;
};