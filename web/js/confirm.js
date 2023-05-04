function payNow()
{
    $.ajax({
        url: "confirm.do",
        type: "POST",
        success: function (){
            alert("订单支付完成，点击确定返回商城首页");
            window.location.href = "../web/index.jsp";
        },
        data: {pay: "1"}
    })
}
function payLater()
{
    $.ajax({
        url: "confirm.do",
        type: "POST",
        success: function (){
            alert("订单记录完成，点击确定返回商城首页");
            window.location.href = "../web/index.jsp";
        },
        data: {pay: "0"}
    })
}