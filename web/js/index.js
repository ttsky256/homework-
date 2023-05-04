 $(document).ready(function (){
    $.ajax({
        url: "load.do",
        type: "GET",
        complete: function (){
            $("#cc").load("../JavaWeb/index.jsp .content")
        }
    })
})