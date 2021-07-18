$(".search button").click(function() {
    console.log("ok");

    var keyword_ = $(".search input")[0].value;
    JSON.stringify(keyword_);
    window.location.href = "classSearchList.html?keyword=" + encodeURI(encodeURI(keyword_));

    // $.ajax({
    //     url: "clssSearchList.html",
    //     type: "get",
    //     data: {
    //         keyword: keyword_
    //     },
    //     dataType: "json",
    //     contantType: 'pplication/json; chaarset = utf-8',
    //     success: function(data) {
    //         location.href = 'classSearchList.html?keyword=' + keyword
    //     }
    // })

})