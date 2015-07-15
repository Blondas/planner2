jQuery(document).ready(function ($) {
    $('#loginform').submit(function (event) {
        event.preventDefault();
        var data = 'username=' + $('#username').val() + '&password=' + $('#password').val();
        $.ajax({
            data: data,
            timeout: 1000,
            type: 'POST',
            url: '/login'

        }).done(function(data, textStatus, jqXHR) {
            window.location='main.html';

        }).fail(function(jqXHR, textStatus, errorThrown) {
            alert('Booh! Wrong credentials, try again!');
        });
    });
});