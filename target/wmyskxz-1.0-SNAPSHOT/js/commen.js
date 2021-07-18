// 获得地址栏中数据 未转码
function GetLocalRequest() {
    let url = location.search; //获取url带来的参数
    let theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        var strs = str.split("&");
        for (let i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split('=')[1]);
        }
        return theRequest;
    } else {
        return "";
    }
}