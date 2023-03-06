 $(document).ready(function (){
    $.ajax({
        url: "load.do",
        type: "GET",
        complete: function (){
            $("#cc").load("../index.jsp .content")
        }
    })
})