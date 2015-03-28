// sample POST request to spring REST api
 function teacherPOST() {
    $.ajax({
        url: "dupa.json",
        type: 'POST',
        dataType: 'json',
        data: '{"name": "Krystian", "lastname": "Ujma"}',
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
