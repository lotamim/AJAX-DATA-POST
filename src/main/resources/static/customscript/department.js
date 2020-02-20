$(function () {
    getData();
});
function getData() {
    $.ajax({
        'url': "/getList",
        'method': "GET",
        'contentType': 'application/json',
        success:function (data) {
            $('#example').dataTable({
                "paging": false,
                "searching": false,
                "retrieve": true,
                // "bDestroy": true,
                "aaData": data,
                "columns": [
                    {"data": "id"},
                    {"data": "deptName"},
                    {"data": "maxCapacity"}
                ]
            });
        }
    });
}

function saveDept() {
    var data = {
        deptName: $('#deptName').val(),
        maxCapacity: $('#maxCapacity').val()
    };
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/saveDept",
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (data) {
            showSuccess(data.message, "Department Save Successfully !");
            getData();
            formClear($('#deptFrom'));
        }
    });
}



