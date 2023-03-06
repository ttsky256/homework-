$(document).ready(function (){
    $.ajax({
        url: "loadOrders.do",
        type: "GET",
        complete: function (){
            $("#cc").load("../JavaWeb/orders.jsp .content")
        }
    })
})

function cancelOrder(obj){
    let order_id = $(obj).attr("value");
    $.ajax({
        url: "cancel.do",
        type: "POST",
        data: {order_id: order_id},
        success: function ()
        {
            alert("已取消订单");
            window.location.href = '../JavaWeb/orders.jsp'
        }
    })
}

function payOrder(obj){
    let order_id = $(obj).attr("value");
    $.ajax({
        url: "pay.do",
        type: "POST",
        data: {order_id: order_id},
        success: function (){
            alert("付款完成");
            window.location.href = '../JavaWeb/orders.jsp'
        }
    })
}