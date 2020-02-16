$(function () {
    $("#saveStunt").click(function () {
        var formData = {
            id: $('#id').val(),
            studentName: $('#studentName').val(),
            department: $('#department').val(),
            updatedBy: $('#updatedBy').val(),
            updateOn: $('#updateOn').val()
        };
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/saveStudent",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function (data) {
                toastr.success(data.message,"student save successfully !",{
                    closeButton : true
                });
                if(data.message){
                    $('#addModal').hide();
                    setTimeout(function(){ location.reload(); }, 2000);
                }
                // alert(data.message);
            }
        });
    });

    function test(data) {
       alert(data);
    }
});