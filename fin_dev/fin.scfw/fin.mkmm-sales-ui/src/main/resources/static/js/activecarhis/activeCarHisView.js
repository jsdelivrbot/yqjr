jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/activeCarHiss/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#activeHisId").val(result.activeHisId);
          $("#activeCode").val(result.activeCode);
          $("#serialNo").val(result.serialNo);
          $("#brandsCode").val(result.brandsCode);
          $("#brandsName").val(result.brandsName);
          $("#seriesCode").val(result.seriesCode);
          $("#seriesName").val(result.seriesName);
          $("#moderCode").val(result.moderCode);
          $("#moderName").val(result.moderName);
          $("#startTime").val(result.startTime);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#company").val(result.company);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});