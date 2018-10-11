jQuery(function ($) {

    $("#inputForm").frameworkValid({});

    var mid = $.getUrlParam("id");
    var today = getNowFormatDate();
    $.ajax({
        type: 'GET',
        url: apiEntityBasePath + '/' + mid,
        dataType: 'json'
    }).then(function (obj) {
        // 查询失败
        if (!obj.isSuccess) {
            layer.alert(obj.msg);
            return;
        }
        var result = obj.result;
        // console.log(result);
        var teamCode = result.teamCode;
        $("#id").val(result.id);
        $("#areaCode").val(result.areaCode);
        $("#areaName").val(result.areaName);
        $("#teamCode").val(result.teamCode);
        $("#teamName").val(result.teamName);
        $("#teamLevel").val(result.teamLevel);
        $("#teamType").val(result.teamType);
        // $("#teamStatus").val(result.teamStatus);
        var nowDate = splitStrToDate(result.startTime);
        if(today < nowDate) {
            $("#teamStatus").val('0');
        } else if(today >= nowDate){
            $("#teamStatus").val('1');
        }
        $("#teamLeader").val(result.teamLeader);
        $("#teamPhone").val(result.teamPhone);
        $("#teamZip").val(result.teamZip);
        $("#teamAddress").val(result.teamAddress);
        $("#teamFax").val(result.teamFax);
        $("#startDate").val(result.startTime);
        $("#createTime").val(result.createTime);
        $("#modifyTime").val(result.modifyTime);
        $("#remark").val(result.remark);
        $("#transcode1").val(result.transcode1);
        $("#transcode2").val(result.transcode2);
        $("#transcode3").val(result.transcode3);
        $("#transcode4").val(result.transcode4);
        $("#creator").val(result.creator);
        $("#modifier").val(result.modifier);
        queryPersonTeamInfo(teamCode,nowDate);
        queryTeamHis(teamCode);
        queryTeamEvent(teamCode);
    }, function (e) {
        layer.alert("查询数据失败:" + e);
    });

});

function queryPersonTeamInfo(teamCode,nowDate) {
    var today = getNowFormatDate();
    $.ajax({
        type: 'GET',
        url: "/mkmm/sales/teamMains/queryPerson?teamCode="+teamCode,
        dataType: 'json',
        success: function (data) {
            var arr = data.result;
            // console.log(arr)
            var trStr = '';
            for(var index in arr){
                var arrStr = arr[index];
                var personNature = '';
                var personLevel = '';
                var personStatus = '';
                if('0' == arrStr.personNature){
                    personNature = '团队负责人';
                } else {
                    personNature = '销售经理';
                }

                if('1' == arrStr.personLevel){
                    personLevel = '一级';
                } else if ('2' == arrStr.personLevel){
                    personLevel = '二级';
                } else if ('3' == arrStr.personLevel){
                    personLevel = '三级';
                }

                var nowDate = splitStrToDate(arrStr.startTime);
                if(today < nowDate) {
                    personStatus = '无效';
                } else if(today >= nowDate){
                    personStatus = '有效';
                }

                // else if('2' == arrStr.personStatus){
                //     personStatus = '注销';
                // }
                trStr += '<tr >';
                trStr += '<td style="text-align:center;">' + arrStr.personName + '</td>';
                trStr += '<td style="text-align:center;">' + arrStr.personCode + '</td>';
                trStr += '<td style="text-align:center;">' + arrStr.personIdcard + '</td>';
                trStr += '<td style="text-align:center;">' + personNature + '</td>';
                trStr += '<td style="text-align:center;">' + personLevel + '</td>';
                trStr += '<td style="text-align:center;">' + arrStr.personJointime + '</td>';
                trStr += '<td style="text-align:center;">' + personStatus + '</td>';
                trStr += '</tr>';
            }
            $("#tbody1").html(trStr);
        }
    })
}

function queryTeamHis(teamCode) {
    $.ajax({
        type: 'GET',
        url: "/mkmm/sales/teamReviews/teamReviewQuery?teamCode="+teamCode+"&reviewStatus="+"04",
        dataType: 'json',
        success: function (data) {
            // var id = data.result.id
            // console.log(data.result);
            var arr = data.result;
            var trStr = '';
            for(var index = 0 ; index < arr.length ; index++){
                // console.log(arr[index]);
                var arrStr = arr[index];
                var reviewType = '';
                if('01' == arrStr.reviewType){
                    reviewType = '团队新增';
                } else {
                    reviewType = '团队修改';
                }
                trStr += '<tr >';
                trStr += '<td style="text-align:center;">' + reviewType + '</td>';
                trStr += '<td style="text-align:center;">' + arrStr.createTime + '</td>';
                trStr += '<td style="text-align:center;">' + arrStr.modifyTime + '</td>';
                trStr += '<td style="text-align:center;">' +'<button class="btn btn-xs btn-success" onclick='+'queryHis("'+arrStr.id+'")> 查看 </button></td>';
                trStr += '</tr>';
            }
            $("#tbody2").html(trStr);
        }
    })
}

function queryTeamEvent(teamCode) {
    $.ajax({
        type: 'GET',
        url: "/mkmm/sales/eventTeams/queryTeamEvent?teamCode="+teamCode,
        dataType: 'json',
        success: function (data) {
            // var id = data.result.id
            // console.log(data.result);
            var arr = data.result;
            var trStr = '';
            for(var index in arr){
                // console.log(arr[index]);
                var arrStr = arr[index];
                var eventType = '';
                if('0' == arrStr.eventType ){
                    eventType = '奖励';
                } else if ('1' == arrStr.eventType ){
                    eventType = '处罚';
                } else {
                    eventType = '其他';
                }
                trStr += '<tr >';
                trStr += '<td style="text-align:center;">' + arrStr.eventYear + '</td>';
                trStr += '<td style="text-align:center;">' + eventType + '</td>';
                trStr += '<td style="text-align:center;">' + arrStr.eventApart + '</td>';
                trStr += '<td style="text-align:center;">' + arrStr.createTime + '</td>';
                trStr += '<td style="text-align:center;">' +'<button class="btn btn-xs btn-success" onclick='+'queryEvent("'+arrStr.id+'")> 查看 </button></td>';
                trStr += '</tr>';
            }
            $("#tbody3").html(trStr);
        }
    })

}

function queryEvent(id) {
    commonForward('/mkmm/ui/eventTeam/view?id=' + id)
}
function queryHis(flowId){
    console.log(flowId)
    // commonForward('/mkmm/ui/teamHis/modify?reviewId=' + reviewId)
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/teamReviews/teamHisQuery?flowId=' + flowId,
        dataType: 'json',
        success: function (data) {
            var result = data.result;
            commonForward('/mkmm/ui/teamHis/modify?id=' + result.id);
        }
    })
}

Date.prototype.pattern=function(fmt) {
    var o = {
        "M+" : this.getMonth()+1, //月份
        "d+" : this.getDate(), //日
        "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
        "H+" : this.getHours(), //小时
        "m+" : this.getMinutes(), //分
        "s+" : this.getSeconds(), //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S" : this.getMilliseconds() //毫秒
    };
    var week = {
        "0" : "/u65e5",
        "1" : "/u4e00",
        "2" : "/u4e8c",
        "3" : "/u4e09",
        "4" : "/u56db",
        "5" : "/u4e94",
        "6" : "/u516d"
    };
    if(/(y+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    if(/(E+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);
    }
    for(var k in o){
        if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
    return fmt;
}

//获取当前日期，格式为yyyy-MM-dd
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

//截取日期
function splitStrToDate(str) {
    if (!str) {
        return
    }
    var date = str.toString();
    if (date.length > 10){
        return date.substring(0,10)
    }else {
        return ''
    }
}