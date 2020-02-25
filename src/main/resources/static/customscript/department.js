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
                    {
                        "data": function (data, type, row, meta) {
                            return '<a href="Javascript:void(0)"  onclick="setDataField(' + '\'' + data.id + '\')">' + data.deptName + '</a>';

                        }
                    },
                    // {"data": "deptName"},
                    {"data": "maxCapacity"}
                ]
            });
        }
    });
}

function saveDept() { //  save or update
    var data = {
        deptId :$('#deptId').val(),
        deptName: $('#deptName').val(),
        maxCapacity: $('#maxCapacity').val()
    };
    var commUrl = "";
    if($('#deptId').val()){
        commUrl = "/updateDept";
    }else {
        commUrl = "/saveDept";
    }
    $.ajax({
                type: "POST",
                contentType: "application/json",
                url: commUrl,
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (data) {
                    showSuccess(data.message, "Department Save Successfully !");
                    formClear($('#deptFrom'));
                    $("#example").dataTable().fnDestroy();
                    getData();
                }
            });
    }

function setDataField(id) { // set value in text box.
 // alert(id);
    var data ={
        id:id
    };
 $.ajax({
     type: "POST",
     contentType: "application/json",
     url: "/select",
     data: JSON.stringify(data),
     dataType: 'json',
     success:function (reuslt) {
         $('#deptId').val(reuslt.id);
         $('#deptName').val(reuslt.deptName);
         $('#maxCapacity').val(reuslt.maxCapacity);
        //console.log(reuslt);
     }
 });
}

function clearData() {
    formClear($('#deptFrom'));
}



