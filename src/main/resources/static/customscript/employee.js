$(function () {
    getDeptList();
});

function getDeptList() {
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
            // $("#example").dataTable().fnDestroy();
            // getData();
        }
    });
}

// function selectVlue() {
//     alert($( "#department" ).val());
//
// }