jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var mid = $.getUrlParam("id");

    $.ajax({
        type: 'GET',
        url: apiEntityBasePath+ '/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          var startDateTime = timestampToTime(result.startTime);
          var today = getNowFormatDate();
          console.log(startDateTime)
          console.log(today)
          $("#id").val(result.id);
          $("#areaCode").val(result.areaCode);
          $("#areaName").val(result.areaName);
          $("#teamCode").val(result.teamCode);
          $("#teamName").val(result.teamName);
          $("#teamLevel").val(result.teamLevel);
          $("#teamType").val(result.teamType);
          if(today < startDateTime) {
              $("#teamStatus").val('0');
          } else if(today >= startDateTime){
              $("#teamStatus").val('1');
          }
          $("#teamLeader").val(result.teamLeader);
          $("#teamPhone").val(result.teamPhone);
          $("#teamZip").val(result.teamZip);
          $("#teamAddress").val(result.teamAddress);
          $("#teamFax").val(result.teamFax);
          $("#startTime").val(result.startTime);
          $("#createTime").val(result.createTime);
          $("#modtfyTime").val(result.modtfyTime);
          $("#operatePerson").val(result.operatePerson);
          $("#operateStatus").val(result.operateStatus);
          $("#flag").val(result.flag);
          $("#remark").val(result.remark);
          $("#transcode1").val(result.transcode1);
          $("#transcode2").val(result.transcode2);
          $("#transcode3").val(result.transcode3);
          $("#transcode4").val(result.transcode4);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#reviewId").val(result.reviewId);
          $("#startDate").val(startDateTime);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })

    $("#btnSubmit").on("click", function (e) {
        e.preventDefault();
        var flag = $("#inputForm").valid();
        if (!flag) {
            //没有通过验证
            return;
        } else {
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
                url: '/mkmm/MKMM_TEAM_HIS/teamHiss/' + mid,
                data: JSON.stringify(formData)
            }).then(function (obj) {
                // 保存失败
                if (!obj.isSuccess) {
                    layer.alert(obj.msg);
                    return;
                }
                layer.alert(obj.msg);
                $("#inputForm").resetForm();
            }).always(function () {
                $("button").attr("disabled", false);
            });
        }
    });
});
function timestampToTime(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '-';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = date.getDate() + ' ';
    return Y+M+D;
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