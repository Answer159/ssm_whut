var request = GetLocalRequest();
var keyword_ = decodeURI(decodeURI(request.keyword));
console.log(keyword_);
$(".search input").val(keyword_);

$(".sort .by_money").click(function() {
    console.log("1");
    $.ajax({
        url: "http://localhost:8080/Tmall_SSM_war_exploded/sortclassInfo.do",
        type: "get",
        data: {
            sort: "price",
            keyword: keyword_
        },
        dataType: 'json',
        contantType: 'application/json; charset = utf-8',
        success: function(data) {
            console.log(data);
            //加课程信息
            var html = "";
            var classList = data.classInfos;
            $.each(classList, function(k, v) {
                html += '<li class = "classInfo" id= "class_' + k + '">' +
                    '<div class="title">' + classList[k].title + '</div>' +
                    '<div class = "contant">' + classList[k].class_content + '</div>' +
                    '<div class = "pic" id ="' + "class_" + k + '">' + '</div>' +
                    '</li>';
                $("#class_" + k).css("background-image", "url()");
            })
            $(".classList").append(html);
        }
    })
})


$(".sort .by_time").click(function() {

    $.ajax({
        url: "http://localhost:8080/Tmall_SSM_war_exploded/sortclassInfo.do",
        type: "get",
        data: {
            sort: "suggestTime",
            keyword: keyword_
        },
        dataType: 'json',
        contantType: 'application/json; charset = utf-8',
        success: function(data) {
            console.log(data);
            //加课程信息
            var html = "";
            var classList = data.classInfos;
            $.each(classList, function(k, v) {
                html += '<li class = "classInfo" id= "class_' + k + '">' +
                    '<div class="title">' + classList[k].title + '</div>' +
                    '<div class = "contant">' + classList[k].class_content + '</div>' +
                    '<div class = "pic" id ="' + "class_" + k + '">' + '</div>' +
                    '</li>';
                $("#class_" + k).css("background-image", "url()");
            })
            $(".classList").append(html);
        }
    })
})