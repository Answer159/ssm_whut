$(".shortcut #logout").click(function () {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/Tmall_SSM_war_exploded/logout.do",
        dataType: "json",
        success: function(data) {
            console.log(data);
            if(data.msg === "success")
            {
                window.location.href = "index.html";
            }
            if(data.msg ==="fail")
            {
                alert("注销失败！请检查网络。");
            }
        }

    })
})


