$(function (){
    $(".reg-form").validate({
        rules: {
            good_id: {
                required: true,
                checkPhone: true
            },
            name: {
                required: true
            },
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
            good_id: {
                required: "货物编号不能为空",
                checkPhone: "请输入数字"
            },
            name: {
                required: "货物名字不能为空"

            },
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

function checkGoods(){
    let uid = $("#goodID").val();
    $.ajax({
        url: "checkGoods.do",
        type: "GET",
        data: {good_id: uid},
        dataType: "text",
        success: function (data){
            if(data === "0")
            {
                $("#notice").html("货物编号已存在");
            }
            else
            {
                $("#notice").html("");
            }
        }
    })
}