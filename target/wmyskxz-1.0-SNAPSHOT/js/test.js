$(".submit").click(function() {
    // 获取信息
    let data = $("from").serializeArray();
    console.log(data);
})