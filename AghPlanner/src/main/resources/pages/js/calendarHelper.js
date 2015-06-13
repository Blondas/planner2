var calendarHelper = {
    handleDrop: function(event) {
        event.stopPropagation();

        if (event.dataTransfer.types[0] ==  'aggregate') {
            var object = JSON.parse(event.dataTransfer.getData('aggregate'));
            var date = $(this).attr('data-date');

            $('#calendar').fullCalendar( 'renderEvent', {
                title: object.name,
                start: date
            })
        }
    },

    handleDragOver: function(event) {
        event.stopPropagation();

        if (event.preventDefault) {
            event.preventDefault();
        }

        return false
    },

    addEventListeners: function() {
        $('.fc-day').each(function() {
            this.addEventListener('dragover', calendarHelper.handleDragOver, false);
            this.addEventListener('drop', calendarHelper.handleDrop, false);
        });
    }
};