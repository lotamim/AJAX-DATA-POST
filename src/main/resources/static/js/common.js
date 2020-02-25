// $(function() {
//  // $("#load-menu").click(function () {
//  //    autoLoad();
//
//  });
function autoLoad(val) {
    alert("Hello");
}
 // $("#container").load("Views/chatBox.html",function(){
 //  $(this).clone().appendTo("body").remove();
 // });
// });

// $('#load-menu').click(function() {
//  alert("hi");
//  // newHash = window.location.hash.substring(1);
//  // var action = $(this).attr("href"); //+ "?" + date.getMilliseconds();//window.location.hash;
//  // window.location.hash = action;//$(this).attr("href");
//  // action = '';
//  // return false;
// });

function showSuccess(body,title) { // tamim
    debugger;
    toastr.success(body, title, {
        closeButton: true
    });
}

function formClear(form) { // tamim
    form.find("input[type=text],input[type=hidden], textarea").val("");
}
