$(function (){
    $(".reg-form").validate({
        rules: {
            user_id: {
                required: true
            },
            password: {
                required: true,
                rangelength: [8, 20]
            },
            email_address: {
                required: true,
                email: true
            },
            phone_num: {
                required: true,
                checkPhone: true
            }
        },
        messages: {
            user_id: {
                required: "账号不能为空"
            },
            password: {
                required: "密码不能为空",
                rangelength: "密码长度须为8-20位"
            },
            email_address: {
                required: "电子邮件地址不能为空",
                email: "请输入正确的电子邮件地址"
            },
            phone_num: {
                required: "电话号码不能为空",
                checkPhone: "请输入正确的手机号码"
            }
        }
    });

    $.validator.addMethod("checkPhone", function (value, element){
        let reg = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
        return this.optional(element) || (reg.test(value));
    })
})

function checkUser(){
    let uid = $("#userID").val();
    $.ajax({
        url: "checkUser.do",
        type: "GET",
        data: {user_id: uid},
        dataType: "text",
        success: function (data){
            if(data === "0")
            {
                $("#notice").html("用户名已存在");
            }
            else
            {
                $("#notice").html("");
            }
        }
    })
}