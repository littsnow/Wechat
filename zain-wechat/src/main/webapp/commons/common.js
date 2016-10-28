function sendAjax(param, url) {
    var data;
    $.ajax({
        url: getBasePath() + url,
        dataType: "text",
        type: "post",
        data: param,
        async: false,
        success: function(result) {data = JSON.parse(result);},
        //error: error
    });
    return data;
}

function getBasePath() {
    var obj = window.location; //当前页面对象
    var contextPath = obj.pathname.split("/")[1];//获取项目名
    return obj.protocol+"//"+obj.host+"/"+contextPath;
}