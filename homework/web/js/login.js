$(function (){
    $(".login-form").validate({
        rules:{
            user_id: {
                required: true,
            },
            user_pwd: {
                required: true,
                rangelength:[6, 20],
            },
        },
        messages: {
            user_id: {
                required: "账号不能为空",
            },
            user_pwd: {
                required: "密码不能为空",
                rangelength: "密码长度须为8-20位"
            },
        },
    });
});