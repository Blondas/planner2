toggleElement = function(element) {
    $(element).fadeToggle();
};

addDragEventsForAllElems = function() {
    document.addEventListener('dragover', handleDragOver.bind(this), false);
    document.addEventListener('drop', handleDocumentDrop.bind(this), false);
};

handleDragOver = function(event) {
    event.stopPropagation();

    switch (event.dataTransfer.types[0]) {
        case 'aggregate':
            $('*').removeClass('over');
            $('#calendar').addClass('over');
            break;

        case 'avatar':
            $('*').removeClass('over');
            $('.aggregate').addClass('over');
            $('#aggregateContainer').addClass('over');
            break;

        case 'teacher':
            $('*').removeClass('over');
            $('.avatar').addClass('over');
            $('#avatarContainer').addClass('over');
            break;

        case 'studentgroup':
            $('*').removeClass('over');
            $('.aggregate').addClass('over');
            $('#aggregateContainer').addClass('over');
            break;

        case 'programmeunit':
            $('*').removeClass('over');
            $('.aggregate').addClass('over');
            $('#aggregateContainer').addClass('over');
            break;
    }

    return false;
};

handleDocumentDrop = function(event) {
    $('*').removeClass('over');
};