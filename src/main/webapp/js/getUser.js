
console.log("1");
    $.ajax({
        type: "post",
        url: "http://localhost:8080/Tmall_SSM_war_exploded/GetUser.do",
        dataType: "json",
        success: function(data) {
            console.log(data);
            if (data.msg === 'success') {
                let userInfo = data.userInfo
                let html1 = `
                <section class="shortcut">
                <div class="w">
                    <div class="fl">
                        <ul>
                            <li>师到欢迎你</li>
                        </ul>
                    </div>
                    <div class="fr">
                        <div class="userInfo">
                            <div class="downT">
                                <a href="profile.html">${userInfo.username}</a>
                            </div>
                            <div class="downMenu">
                                <ul>
                                    <li><a href="#">我的课程</a></li>
                                    <li><a href="#">我的订单</a></li>
                                    <li><a href="#">我的求助</a></li>
                                    <li id = "logout"><a href="#">注销</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
                `;
                $("body").prepend(html1);
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
                $(".userInfo ").mouseover(function() {
                    $(".downMenu").show();
                    })
                $(".userInfo ").mouseout(function() {
                        $(".downMenu").hide();
                    })


            }
            if (data.msg === "fail") {
                html1 = `
                <section class="shortcut">
                <div class="w">
                    <div class="fl">
                        <ul>
                            <li>师到欢迎你</li>
                            <li><a href="./loginPage.html">请登录</a></li>
                            <li><a class="hot-word" href="./registerPage.html">注册</a></li>
                        </ul>
                    </div>
                    <div class="fr">
                        <div class="userInfo">
                           
                        </div>
                    </div>
                </div>
            </section>
                `
                $("body").prepend(html1);
            }

        }
    });
