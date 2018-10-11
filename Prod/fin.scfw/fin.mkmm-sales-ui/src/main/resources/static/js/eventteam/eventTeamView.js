jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/eventTeams/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#eventYear").val(result.eventYear);
          $("#eventApart").val(result.eventApart);
          $("#eventText").val(result.eventText);
          $("#eventStatus").val(result.eventStatus);
          $("#eventType").val(result.eventType);
          $("#createTime").val(result.createTime);
          $("#teamCode").val(result.teamCode);
          $("#teamName").val(result.teamName);

          $("#company").val(result.company);
          $("#areaCode").val(result.areaCode);
          $("#areaName").val(result.areaName);
    }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});