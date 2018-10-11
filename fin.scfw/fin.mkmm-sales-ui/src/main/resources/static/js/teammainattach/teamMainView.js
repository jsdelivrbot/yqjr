jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/teamMains/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#teamId").val(result.teamId);
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
          $("#teamStartime").val(result.teamStartime);
          $("#teamCreatime").val(result.teamCreatime);
          $("#teamModtime").val(result.teamModtime);
          $("#remark").val(result.remark);
          $("#transcode1").val(result.transcode1);
          $("#transcode2").val(result.transcode2);
          $("#transcode3").val(result.transcode3);
          $("#transcode4").val(result.transcode4);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});