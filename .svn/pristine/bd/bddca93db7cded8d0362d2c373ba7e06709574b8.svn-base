jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/planTrackYearHiss/' + mid,
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
          $("#yearActualNum").val(result.yearActualNum);
          $("#yearPlanNum").val(result.yearPlanNum);
          $("#yearPlanRate").val(result.yearPlanRate);
          $("#yearRate").val(result.yearRate);
          $("#yearRateCal").val(result.yearRateCal);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#startTime").val(result.startTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#flag").val(result.flag);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});