$(".classList .classInfo").click(function() {
    console.log($(this).attr('id'));
    var ClassID = $(this).attr('id');
    window.location.href = "classDetail.html?id=" + ClassID;
})