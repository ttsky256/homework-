$(document).ready(function (){
    $.ajax({
        url: "loadUser.do",
        type: "GET",
        complete: function (){
            $(".form-container").load("../JavaWeb/user.jsp .reg-form")
        }
    })
})

$(function (){
    $(".reg-form").validate({
        rules: {
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

function exit(){
    $.ajax({
        url: "exit.do",
        type: "POST",
        success: function () {
            alert("已退出登录，点击返回首页");
            window.location.href = "../JavaWeb/index.jsp";
        }
    })
}