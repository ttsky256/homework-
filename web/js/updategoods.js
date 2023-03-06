$(document).ready(function (){
    $.ajax({
        url: "findOneGood.do",
        type: "GET",
        complete: function (){
            $(".form-container").load("../updategoods.jsp .reg-form")
        }
    })
})
$(function (){
    $(".reg-form").validate({
        rules: {
            price: {
                required: true,
                checkPhone: true
            },
            stock: {
                required: true,
                checkPhone: true
            }
        },
        messages: {
            price: {
                required: "价格不能为空",
                checkPhone: "请输入数字"
            },
            stock: {
                required: "库存量不能为空",
                checkPhone: "请输入数字"
            }
        }
    });

    $.validator.addMethod("checkPhone", function (value, element){
        let reg = /^\d{1,8}$/;
        return this.optional(element) || (reg.test(value));
    })
})