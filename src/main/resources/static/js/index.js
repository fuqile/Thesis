$(document).ready(function(){ 
    $("#search").bind('input propertychange', function() { 
        getUserListByUserName($("#search").val());
    });
    getUserListByUserName('');
}); 

function getUserListByUserName(userName){
    $.ajax({
        type: "POST",
        url: "/user/queryUserListByUserName",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: {"userName":userName},
        dataType: "json",
        success: function (data) {
            var str = "";
            var list = data.resultData;
            $("#tbody-result").html("");
            for (i in list) {
                str += "<tr>" +  
                "<td>" + list[i].id + "</td>" +  
                "<td>" + list[i].userName + "</td>" +  
                "<td>" + list[i].password + "</td>" +  
                "<td>" + list[i].age + "</td>" +  
                "<td>" + (list[i].sex == 0? "男" : "女") + "</td>" +  
                "<td>" + "<a class='btn btn-danger' href='javascript:void(0)' onclick='deleteUser("+list[i].id+")'>删除</a>" + "</td>" +  
                "</tr>";  
            }
            $("#tbody-result").html(str);
        }
    });
}

function deleteUser(id){ 
    $.confirm({
        title: '操作提示',
        content: '确定要删除该用户吗?',
        buttons: {
            ok: {
                text: "确定",
                btnClass: 'btn-danger',
                keys: ['enter'],
                action: function(){
                    $.ajax({
                        type: "POST",
                        url: "/user/deleteUser",
                        contentType: "application/x-www-form-urlencoded; charset=utf-8",
                        data: {"id":id},
                        dataType: "json",
                        success: function (data) {
                            if(data.resultData){
                                getUserListByUserName($("#search").val());
                            }
                        }
                    });
                }
            },
            cancel: {
                text: "取消",
                btnClass: 'btn-default',
                keys: ['esc'],
            }
        }
    }); 
} 

function onRegisterClick(){
    window.location.href="register.html"; 
}