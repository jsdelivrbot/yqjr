jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/personBrandHiss/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#personCode").val(result.personCode);
          $("#brandCode").val(result.brandCode);
          $("#brandName").val(result.brandName);
          $("#startTime").val(result.startTime);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#opreteType").val(result.opreteType);
          $("#personHisId").val(result.personHisId);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});