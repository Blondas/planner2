// sample POST request to spring REST api
function teacherPOST() {
    $.ajax({
        url: "/teacher",
        type: 'POST',
        dataType: 'json',
        data: '{"name": "Krystian", "lastName": "Ujma"}',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            console.log('SUKCES, data: ' + data);
        },
        error:function(data, status, er) {
            console.log('FAIL, data: ' + data);
            console.log('status: ' + status);
            console.log('er: ' + er);
        }
    });
}

function teacherUPDATE() {
    $.ajax({
        //url: "/rest/teacher.json",
        url: "/teacher",
        type: 'POST',
        dataType: 'json',
        data: '{"id": "1", "name": "up Krystian", "lastName": "up Ujma"}',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            console.log('SUKCES, data: ' + data);
        },
        error:function(data, status, er) {
            console.log('FAIL, data: ' + data);
            console.log('status: ' + status);
            console.log('er: ' + er);
        }
    });
}

function teacherGET() {
    $.ajax({
        url: "/teachers",
        type: 'GET',
        dataType: 'json',
        data: '{"name": "Krystian", "lastName": "Ujma"}',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            console.log('SUKCES, data: ' + data);
        },
        error:function(data, status, er) {
            console.log('FAIL, data: ' + data);
            console.log('status: ' + status);
            console.log('er: ' + er);
        }
    });
}

function classroomPOST() {
    $.ajax({
        url: "/rest/classroom/add",
        type: 'POST',
        dataType: 'json',
        data: '{"id": "1", "number": "1", "buildingId": "2", "numberOfSeats": "3"}',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            console.log('SUKCES, data: ' + data);
        },
        error:function(data, status, er) {
            console.log('FAIL, data: ' + data);
            console.log('status: ' + status);
            console.log('er: ' + er);
        }
    });
}

function classroomGET() {
    $.ajax({
        url: "/rest/classroom/1",
        type: 'GET',
        dataType: 'json',
        data: '{"id": "1", "number": "1", "buildingId": "2", "numberOfSeats": "3"}',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            console.log('SUKCES, data: ' + data);
        },
        error:function(data, status, er) {
            console.log('FAIL, data: ' + data);
            console.log('status: ' + status);
            console.log('er: ' + er);
        }
    });
}