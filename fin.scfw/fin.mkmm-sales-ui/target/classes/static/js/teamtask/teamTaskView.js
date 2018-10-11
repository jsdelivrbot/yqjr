jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/teamTasks/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#taskId").val(result.taskId);
          $("#taskType").val(result.taskType);
          $("#areaCode").val(result.areaCode);
          $("#areaName").val(result.areaName);
          $("#taskPeo").val(result.taskPeo);
          $("#taskCreatime").val(result.taskCreatime);
          $("#taskStartime").val(result.taskStartime);
          $("#taskModtime").val(result.taskModtime);
          $("#taskStatus").val(result.taskStatus);
          $("#remark").val(result.remark);
          $("#transcode1").val(result.transcode1);
          $("#transcode2").val(result.transcode2);
          $("#transcode3").val(result.transcode3);
          $("#transcode4").val(result.transcode4);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});