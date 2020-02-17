$(function () {
    // $(".autoLoad").click(function () {
    //     $( "#replace_div" ).load("department.html");
    // });

});

function saveDept() {
    // var deptName = $('#deptName').val();
    // var maxCapacity = $('#maxCapacity').val();
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
        success:function (data) {
            toastr.success(data.message, "student save successfully !", {
                closeButton: true
            });
        }
    });
    // alert("deptName"+deptName+"maxCapacity"+maxCapacity);
}

