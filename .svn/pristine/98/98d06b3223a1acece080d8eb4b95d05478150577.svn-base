jQuery(function ($) {
    // $("#inputForm").find('input').attr('disabled', 'disabled');
    var mid = $.getUrlParam("id");
    var workid = $.getUrlParam("workid");
    var user = getUserCookie();
    $("#company").val(user.comCode);
    $("#modifierName").val(user.name);
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/teamReviews/reviewing?id=' + mid+'&workeid='+workid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg,function (){
                  history.go(-1);
              });
              return;
          }
          var result = obj.result;
          $("#areaCode").val(result.areaCode);
          $("#areaName").val(result.areaName);
          $("#teamCode").val(result.teamCode);
          $("#teamName").val(result.teamName);
          $("#teamLevel").val(result.teamLevel);
          $("#teamType").val(result.teamType);
          $("#teamStatus").val(result.teamStatus);
          $("#teamLeader").val(result.teamLeader);
          $("#teamPhone").val(result.teamPhone);
          $("#teamZip").val(result.teamZip);
          $("#teamAddress").val(result.teamAddress);
          $("#teamFax").val(result.teamFax);
          $("#startTime").val(splitStrToDate(result.startTime));
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#remark").val(result.remark);
          $("#reviewType").val(result.reviewType);
          $("#flag").val(result.flag);
          $("#transcode1").val(result.transcode1);
          $("#transcode2").val(result.transcode2);
          $("#transcode3").val(result.transcode3);
          $("#transcode4").val(result.transcode4);
          $("#teamReviewType").val(result.reviewType);
          $("#opinion").val("同意");
          setHash()
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })

    $("#reviewStatus").on("click", function (e) {
        var reviewStatus =$("#reviewStatus").find("option:selected").val();
        console.log(reviewStatus)
        if (reviewStatus=='04'){
            $("#opinion").val("同意");
        }else {
            $("#opinion").val("");
        }
    });



    $("#btnSubmit").on("click", function (e) {
        e.preventDefault();
        var flag = $("#inputForm").valid();
        if (!flag) {
            //没有通过验证
            return;
        } else {
            var choose = $("#reviewStatus").val();
            var request = $("#teamReviewType").val();
            if (choose == '04' && request == '01') {
                var today = getNowFormatDate();
                var started = $("#startTime").val();
                if (compareDate(today,started)){
                    layer.alert("该申请已经过期，请驳回!");
                    return;
                }
            }
            if($("#opinion").val().trim() == ""){
                layer.alert("审核意见不能为空！");
                return
            }
            $("button").attr("disabled", true);
            var $form = $("#inputForm");
            var arr = $form.serializeArray();
            var formData = {};
            if ($form.val()) {
                $form.trigger('change');
            }

            $.each(arr, function (i, item) {
                formData[item['name']] = item['value'];
            });
            $.ajax({
                type: 'PATCH',
                contentType: 'application/json',
                url: '/mkmm/sales/teamReviews/submit?id=' + mid+"&workeid="+workid,
                data: JSON.stringify(formData)
            }).then(function (obj) {
                // 保存失败
                if (!obj.isSuccess) {
                    layer.alert(obj.msg);
                    return;
                }
                layer.alert(obj.msg,function (){
                    history.go(-1);
                    window.location = '/mkmm/ui/teamReview/list';
                });
                //$("#inputForm").resetForm();
            });
        }
    });
});
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
//日期比较
function compareDate(d1, d2) {
    return ((new Date(d1.replace(/-/g, "\/"))) >= (new Date(d2.replace(/-/g, "\/"))));
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