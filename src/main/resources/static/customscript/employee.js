$(function () {
    getDeptList();
    getEmployeeList();
});

function getDeptList() { // dropdown list
    $.ajax({
        url: '/getList',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
             //console.log(data);
            var content = "<option value=''>-Select Department-</option>";
            $('#department').empty();
            $("#department").append(content);
            $.each(data, function (i, val) {
                content = "<option value=" + val.id + ">" + val.deptName + "</option>";
                $("#department").append(content);
            });
        }
        // error: function (x, e) {
        //     onAjaxError(x, e);
        // }
    });
}

function saveEmp() { //  save or update
    var data = {
        empId :$('#empId').val(),
        empFirstName: $('#empFirstName').val(),
        empLastName: $('#empLastName').val(),
        department: $( "#department" ).val()
    };
    // var commUrl = "";
    // if($('#deptId').val()){
    //     commUrl = "/updateDept";
    // }else {
    //     commUrl = "/saveDept";
    // }
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/saveEmployee",
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (data) {
            showSuccess(data.message, "Employee Save Successfully !");
            formClear($('#empFrom'));
             $("#employeeTable").dataTable().fnDestroy();
             getEmployeeList()();
        }
    });
}

function getEmployeeList() {
    $.ajax({
        'url': "/getAllEmployee",
        'method': "GET",
        'contentType': 'application/json',
        success:function (data) {
//            console.log(data);
//            debugger;
             $('#employeeTable').dataTable({
                 "paging": false,
                 "searching": false,
                 "retrieve": true,
                 // "bDestroy": true,
                 "aaData": data,
                 "columns": [
                     {"data": "id"},
                     {
                         "data": function (data, type, row, meta) {
                             return '<a href="javascript:void(0)"  onclick="setDataFieldForEmp(' + '\'' + data.id + '\')">' + data.emp_first_name + '</a>';

                         }
                     },
                     {"data": "emp_last_name"},
                     {"data": "dept_name"},
                 ]
             });
        }
    });
}


function setDataFieldForEmp(empId) { // set value in text box.
 // alert(id);
    var data ={
        empId:empId
    };
 $.ajax({
     type: "POST",
     contentType: "application/json",
     url: "/selectedEmp",
     data: JSON.stringify(data),
     dataType: 'json',
     success:function (reuslt) {
     console.log(reuslt.empData);
         $('#empId').val(reuslt.empData.id);
         $('#empFirstName').val(reuslt.empData.emp_first_name);
         $('#empLastName').val(reuslt.empData.emp_last_name);
         getDeptListforUpdate(reuslt.empData.dept_id);
     }
 });
}

function getDeptListforUpdate(deptId) { // selected for update
    $.ajax({
        url: '/getList',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
             //console.log(data);
            var content = "<option value=''>-Select Department-</option>";
            $('#department').empty();
            $("#department").append(content);
            $.each(data, function (i, val) {
                content = "<option value=" + val.id + ">" + val.deptName + "</option>";
                $("#department").append(content);
            });
            $("#department").val(deptId)
        }
    });
}
// function selectVlue() {
//     alert($( "#department" ).val());
//
// }