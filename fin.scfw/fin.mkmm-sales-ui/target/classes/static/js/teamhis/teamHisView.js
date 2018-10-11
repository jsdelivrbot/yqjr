jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/teamHiss/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
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
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});