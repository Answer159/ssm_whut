//tab
$(".functionlist a").click(function() {
    $(this).addClass("current").siblings().removeClass("current");
    var index = $(this).index();
    $(".tab-contant .item").eq(index).show().siblings().hide();
});

function getStatus(intstatus) {
    switch (intstatus) {
        case 0:
            return "意向确认";
        case 1:
        case 2:
            return "制定价格";
        case 3:
            return "付款";
        default:
            break;
    }
}

//个人信息
$.ajax({
    type: "post",
    url: "http://localhost:8080/Tmall_SSM_war_exploded/showUserInfo.do",
    dataType: "json",
    success: function(data) {
        console.log(data);
        let html1 = `
        <div class="info">
                    <table>
                        <tr>
                            <td class="title">用户姓名:</td>
                            <td class="content">${data.userInfo.username}</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td class="title">联系电话:</td>
                            <td class="content">${data.userInfo.phone}</td>
                        </tr>
                        <tr>
                            <td class="title">个人介绍:</td>
                            <td class="content">
                                ${data.userInfo.selfIntro}
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="operate">
                    <button  class = "editUserInfo">修改信息</button>
                </div>
        `
        $(".infoshow-userinfo ").append(html1);
        $(".editUserInfo").click(function() {
            window.location.href = "editUserInfo.html"
        })
    }
});

//我的课程

$.ajax({
    type: "post",
    url: "http://localhost:8080/Tmall_SSM_war_exploded/myClassInfo.do",
    dataType: "json",
    success: function(data) {
        let html2 = ""
        let classInfos = data.classInfos
        // let cates = data.categories
        console.log(classInfos)
        $.each(classInfos, function(k, v) {
            html2 += `
            <tr>
            <td colspan="5">
                <div class="classinfo">
                    <img src="${classInfos[k].pic}"
                        height="100" width="100" class="classpic">
                    <div class="classinfo-text">
                        <div class="classitem">
                            课程名称：
                            <a href="">${classInfos[k].title}</a> <br />
                        </div>
                        <div class="class-time">
                            估计时长：
                            <a href="">${classInfos[k].suggestTime}</a>小时
                        </div>
                        <div class="class-cost">
                            课程价格：
                            <a href="">${classInfos[k].price}</a>元 <br />
                        </div>
                        <div class="classinfo-binfo">
                            简介：
                            <div class="content">${classInfos[k].textIntro}</div>
                        </div>
                    </div>
                </div>
            <td>
                <button class = "editClassInfo" id = ${classInfos[k].id}>课程修改</button>
                <br />
                <button class = "deleteClass" id = ${classInfos[k].id}>删除课程</button>
            </td>
        </tr>             
             `
        })
        $(".CLASSLISTHEAD").append(html2);
        $(".editClassInfo").click(function() {
            let class_id = $(this).attr('id');
            window.location.href = "editClassInfo.html?id=" + class_id;
        })
        $(".deleteClass").click(function() {
            if (confirm("是否确定要删除该课程？？")) {
                let classID =parseInt( $(this).attr('id'));

                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/Tmall_SSM_war_exploded/deleteClass.do",
                    data: {
                        "id": classID
                    },
                    // dataType: "json",
                    //contentType: 'application/json;charset = utf -8',
                    success: function(data) {
                        window.location.reload();
                    }
                });

            }
        })
    }
})



//订单信息
$.ajax({
    type: "post",
    url: "http://localhost:8080/Tmall_SSM_war_exploded/myAllOrder.do",
    dataType: "json",
    success: function(data) {
        let html3 = "";
        let orderInfos = data.orders;
        let classInfos = data.classInfos
        console.log(orderInfos)
        $.each(orderInfos, function(k, v) {
            html3 +=
                `
<tbody>
            <tr>
            <td colspan="3" style="text-indent: 2em">订单号：
            <div class="content" style="display: inline-block;">2021050801</div>
            <div class="content" style="display: inline-block;">${orderInfos[k].id}</div>
        </td>
        <td colspan="3" style="text-indent: 2em">
            <div class="fr" style="margin-right: 35px;">
                订单状态：
                <div class="content " style="display: inline-block;">进行中</div>
                <div class="content " style="display: inline-block;">${getStatus(orderInfos[k].status)}</div>
            </div>
        </td>
    </tr>
</tbody>
<tbody class="orderinfo-body">
    <tr>
        <td colspan="4">
            <div class="classinfo">
                <img src="" height"100" width="100" class="classpic">
                <div class="classinfo-text">
                    <div class="classitem">
                        课程名称：
                        
                        <a href="">${classInfos[k].title}</a> <br />
                    </div>
                    <div class="class-time">
                        估计时长：
                       
                        <a href="">${orderInfos[k].suggestTime}</a>小时
                    </div>
                    <div class="class-cost">
                        课程价格：
                       
                        <a href="">${orderInfos[k].price}</a>元 <br />
                    </div>
                    <div class="classinfo-binfo">
                        简介：
                       
                        <div class="content">${classInfos[k].textIntro}</div>
                    </div>
                </div>
            </div>
        </td>
        <td>
            教学者：<a href="">${data.sellers[k].username}</a> <br /> 学习者：
            <a href="">${data.buyers[k].username}</a>
        </td>
                             <td>
                                    <button class = "comment" id = "${orderInfos[k].id}">评价</button>
                                    <button class = "toDetail" id = "${orderInfos[k].id}">查看详情</button>
                                </td>
                            </tr>
                            </table>
            `
        })
        $("#ORDERINFO-HEAD").append(html3);
        $(".comment").click(function() {
            let id = $(this).attr(id);
            window.location.href = "comment.html?order_id=" + id + "classInfo_id=" + id;
        })
        $(".toDetail button").click(function() {
            let detail_id = $(this).attr(id);
            window.location.href = "orderDetail.html?order_id=" + detail_id;
        })
    }
});


//问题列表
$.ajax({
    type: "post",
    url: "http://localhost:8080/Tmall_SSM_war_exploded/myQuestion.do",
    data: "data",
    // dataType: "json",
    success: function(data) {
        console.log(data)

    }
});