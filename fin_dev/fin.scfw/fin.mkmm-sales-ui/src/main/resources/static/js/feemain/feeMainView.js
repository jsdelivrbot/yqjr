jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/feeMains/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#billno").val(result.billno);
          $("#feeType").val(result.feeType);
          $("#feeSource").val(result.feeSource);
          $("#businessCode").val(result.businessCode);
          $("#businessName").val(result.businessName);
          $("#company").val(result.company);
          $("#billStatus").val(result.billStatus);
          $("#isSendGx").val(result.isSendGx);
          $("#validStatus").val(result.validStatus);
          $("#maxBillFee").val(result.maxBillFee);
          $("#billFee").val(result.billFee);
          $("#settleTimes").val(result.settleTimes);
          $("#actualTurnoverCount").val(result.actualTurnoverCount);
          $("#estimateTurnoverCount").val(result.estimateTurnoverCount);
          $("#reachRate").val(result.reachRate);
          $("#areaCode").val(result.areaCode);
          $("#areaName").val(result.areaName);
          $("#brandsCode").val(result.brandsCode);
          $("#brandsName").val(result.brandsName);
          $("#activeStartime").val(result.activeStartime);
          $("#activeEndtime").val(result.activeEndtime);
          $("#feeMainReviewId").val(result.feeMainReviewId);
          $("#feeowner").val(result.feeowner);
          $("#remark").val(result.remark);
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