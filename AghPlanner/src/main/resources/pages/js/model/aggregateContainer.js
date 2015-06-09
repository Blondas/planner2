function AggregateContainer(object) {
    this.aggregates = Array();
    this.$el = document.createElement('div');
    this.setPosition(object.position);
    this.$el.className = 'objectsContainer';
    this.$el.id = 'aggregateContainer';

    $(this.$el).append('<div class="containerTitle">Agregaty:</div>');

    this.$el.addEventListener('drop', this.handleDocumentDrop, false);
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
    this.aggregates.remove(aggregate);
};

AggregateContainer.prototype.handleDocumentDrop = function(event) {
    event.stopPropagation();

    if (event.dataTransfer.types.indexOf('aggregate') > -1) {
        var aggregate = JSON.parse(event.dataTransfer.getData('aggregate'));
        event.dataTransfer.clearData('aggregate')

        var aggregate = new Aggregate({position: this.$el.className});
        aggregate.addAggregate(new Aggregate(aggregate));
    }
};
