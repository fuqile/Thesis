function onLoginClick(value){
    window.location.href="login"; 
}

function onUserNameBlur(value){
    if(!checkUserName()){
        return false;
    }

    $.ajax({
        type: "POST",
        url: "/user/checkUserExist",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: {"userName":value},
        dataType: "json",
        success: function (data) {
            if (!data.resultData) {
                $("#userNameHint").removeClass("color-red");
                $("#userNameHint").addClass("color-green");
                $("#userNameHint").html("用户名可以使用！");
                return true;
            }else{
                $("#userNameHint").removeClass("color-green");
                $("#userNameHint").addClass("color-red");
                $("#userNameHint").html("用户名已经被注册！");
                return false;
            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {

        }
    });
    return true;
}

function checkUserName(){
    if($("#userName").val()==''){
        $("#userNameHint").removeClass("color-green");
        $("#userNameHint").addClass("color-red");
        $("#userNameHint").html("用户名不能为空！");
        return false;
    }
    return true;
}

/**
 * 表达提交前验证是都有错误
 */
function beforeSubmit(){
    if(!checkUserName()){
        return false;
    }

    // 当提示框内容不为空且颜色为红色时，返回false
    if($("#userNameHint").html() != '' && $("#userNameHint").hasClass("color-red")){
        return false;
    }
    return true;
}

function onRegisterClick(){
    if(!beforeSubmit()){
        return false;
    }

    $.ajax({
        type: "POST",
        url: "/user/register",
        contentType: "application/json; charset=utf-8 ",
        data: JSON.stringify({"userName":$("#userName").val(),"password":$("#password").val(),"age":$("#age").val(),"sex":$("#sex").val()}),
        dataType: "json",
        success: function (data) {
            console.log(data);
            if (data.resultData) {
                alert("注册成功！请重新登录！");
                window.location.href="login.html"; 
            }else{
                alert(data.message);
            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {

        }
    });
}