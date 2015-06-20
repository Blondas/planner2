function ViewContainer(object) {
    this.currentView = null;
    this.views = Array();

    if ( typeof object != "undefined" && object.hasOwnProperty('position') ) {
        this.setPosition(object.position);
    }

    this.loadAllViews();

}

ViewContainer.prototype.addEventListeners = function() {
    // save new button:
    $('#save-new-view-button').click(function() {
        var viewContainer = $('#view-menu').data('obj');

        viewContainer.currentView = new View();
        viewContainer.currentView.parent = viewContainer;
        viewContainer.currentView.getVisibleElements();
        viewContainer.currentView = viewContainer.currentView.save();

        viewContainer.loadAllViews();
    });

    // save current button:
    $('#save-current-view-button').click(function() {
        var viewContainer = $('#view-menu').data('obj');

        if ( !(viewContainer.currentView instanceof View) ) {
            viewContainer.currentView = new View();
            viewContainer.currentView.parent = viewContainer;
        }

        viewContainer.currentView.getVisibleElements();
        viewContainer.currentView = viewContainer.currentView.save();

        viewContainer.loadAllViews();
    });

    // delete button:
    $('#delete-view-button').click(function() {
        var viewContainer = $('#view-menu').data('obj');
        var currentView = viewContainer.currentView;

        if ( currentView instanceof View ) {
            currentView.remove();

            viewContainer.loadAllViews();
            currentView = null;
            viewContainer.renderMenu();
        }
    });

    // select view button:
    var viewItems = $('.viewContainer-viewItem');
    for (i = 0; i < this.views.length; i++) {
        $(viewItems[i]).click(function() {
            var view_id = $(this).attr('view_id');
            var viewContainer = $('#view-menu').data('obj');

            var selectedView = viewContainer.doesViewExistsById(view_id);
            selectedView.setVisibleElements();

            viewContainer.loadAllViews();
            viewContainer.currentView = selectedView;
            viewContainer.renderMenu();
        });
    }


};

ViewContainer.prototype.renderMenu = function () {
    $('#view-menu').remove();

    this.$el = document.createElement('ul');
    $(this.$el).attr('id', 'view-menu');

    // create list items:
    var html = '' +
        '<li>Widok' +
            '<ul>' +
                '<li id="save-current-view-button"><span class="ui-icon ui-icon-disk" ></span>Zapisz Bieżący Widok</li>' +
                '<li id="save-new-view-button"><span class="ui-icon ui-icon-disk" ></span>Zapisz Nowy Widok</li>' +
                '<li id="delete-view-button"><span class="ui-icon ui-icon-disk" ></span>Usuń Bieżący Widok</li>';


    this.views.forEach(function(entry) {
        html += '<li class="viewContainer-viewItem" view_id="' + entry.id + '"></span>' + entry.name + '</li>';
    });

    html += '' +
            '</ul>' +
        '</li>';

    $(this.$el).html(html);


    $(this.$el).data('obj', this);
    $(this.position).append(this.$el);

    this.addEventListeners();

    $( "#view-menu" ).menu();
};

ViewContainer.prototype.setPosition = function(containerID) {
    this.position = containerID;
};

ViewContainer.prototype.loadAllViews = function() {
    var viewContainer = this;

    $.ajax({
        url: "/views",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            data.forEach(function(entry) {
                var view = new View(entry);
                view.parent = viewContainer;

                viewContainer.addView(view);
            });

            viewContainer.renderMenu();
        }
    });
};

ViewContainer.prototype.addView = function(view) {
    var entry = this.doesViewExists(view);

    if ( entry == false) {
        this.views.push(view);
    }
};

ViewContainer.prototype.doesViewExists = function(view) {
    var ret = false;
    this.views.forEach(function(entry) {
        if (entry.id == view.id) {
            ret = entry;
        }
    });

    return ret;
};

ViewContainer.prototype.removeView = function(views) {
    this.views.splice( $.inArray(view, this.views), 1 );
};

ViewContainer.prototype.doesViewExistsById = function(view_id) {
    var ret = false;
    this.views.forEach(function(entry) {
        if (entry.id == view_id) {
            ret = entry;
        }
    });

    return ret;
};
