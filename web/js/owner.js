$(document).ready(function (){
    $.ajax({
        url: "loadworker.do",
        type: "GET",
        complete: function (){
            $("#ccc").load("../JavaWeb/owner.jsp .content")
        }
    })
})