function onLoginClick() {
    $("#loginProgressText").html("正在登录中...");
    $.ajax({
        type: "POST",
        url: "/user/login",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: {"userName":$("#userName").val(),"password":$("#password").val()},
        dataType: "json",
        success: function (data) {
            if (data.resultData) {
                $("#loginProgressText").removeClass("color-red");
                $("#loginProgressText").addClass("color-green");
                $("#loginProgressText").html("登录成功");
                window.location.href="index.html"; 
            }else{
                $("#loginProgressText").removeClass("color-green");
                $("#loginProgressText").addClass("color-red");
                $("#loginProgressText").html(data.message);
            }
        },
        error: function (data) {
            $("#loginProgressText").html("登录失败！");
        }
    });
    return true;
}

function onRegisterClick(){
    window.location.href="register.html"; 
}