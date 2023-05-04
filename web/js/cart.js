$(document).ready(function (){
    $.ajax({
        url: "loadCart.do",
        type: "GET",
        complete: function (){
            $("#cc").load("../web/cart.jsp .content")
        }
    })
})
function submitOrder(){
    let obj = document.getElementsByName("select");
    let goods = "";
    for(let i=0;i<obj.length;i++){
        if(obj[i].checked)
        {
            goods = goods + obj[i].value + "#";
        }
    }
    if(goods === "")
    {
        alert("请选择任意条目以提交订单");
    }
    else
    {
        goods = goods.substr(0, goods.length - 1);
        $.ajax({
            url: "submitOrder.do",
            type: "Post",
            data: {goods: goods},
            success: window.location.href = '../web/confirm.jsp'
        })
    }
}