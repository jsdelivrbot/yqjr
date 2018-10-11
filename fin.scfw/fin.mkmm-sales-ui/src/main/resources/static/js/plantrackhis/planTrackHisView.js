jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/planTrackHiss/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#year").val(result.year);
          $("#month").val(result.month);
          $("#areaCode").val(result.areaCode);
          $("#areaName").val(result.areaName);
          $("#teamCode").val(result.teamCode);
          $("#teamName").val(result.teamName);
          $("#personCode").val(result.personCode);
          $("#personName").val(result.personName);
          $("#personType").val(result.personType);
          $("#brands").val(result.brands);
          $("#brandType").val(result.brandType);
          $("#monthActualNum").val(result.monthActualNum);
          $("#monthPlanNum").val(result.monthPlanNum);
          $("#monthPlanRate").val(result.monthPlanRate);
          $("#monthRate").val(result.monthRate);
          $("#monthRateCal").val(result.monthRateCal);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#startTime").val(result.startTime);
          $("#modifier").val(result.modifier);
          $("#flag").val(result.flag);
          $("#differentCode").val(result.differentCode);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});