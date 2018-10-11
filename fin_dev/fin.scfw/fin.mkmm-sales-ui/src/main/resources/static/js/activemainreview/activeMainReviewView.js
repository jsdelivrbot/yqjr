jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/activeMainReviews/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#activeCode").val(result.activeCode);
          $("#activeName").val(result.activeName);
          $("#activeStartime").val(result.activeStartime);
          $("#activeEndtime").val(result.activeEndtime);
          $("#loanStartime").val(result.loanStartime);
          $("#loanEndtime").val(result.loanEndtime);
          $("#patmentBegin").val(result.patmentBegin);
          $("#patmentEnd").val(result.patmentEnd);
          $("#carReg").val(result.carReg);
          $("#loanTermBegin").val(result.loanTermBegin);
          $("#loanTermEnd").val(result.loanTermEnd);
          $("#loanAmtBegin").val(result.loanAmtBegin);
          $("#loanAmtEnd").val(result.loanAmtEnd);
          $("#avtiveCriterion").val(result.avtiveCriterion);
          $("#additionFlag").val(result.additionFlag);
          $("#additionAmtBegin").val(result.additionAmtBegin);
          $("#additionAmtEnd").val(result.additionAmtEnd);
          $("#activeStatus").val(result.activeStatus);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#startTime").val(result.startTime);
          $("#annex").val(result.annex);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#company").val(result.company);
          $("#paymentStatus").val(result.paymentStatus);
          $("#remark").val(result.remark);
          $("#expectedCount").val(result.expectedCount);
          $("#folowId").val(result.folowId);
          $("#activeReviewId").val(result.activeReviewId);
          $("#reviewType").val(result.reviewType);
          $("#reviewStatus").val(result.reviewStatus);
          $("#flag").val(result.flag);
          $("#additionalId").val(result.additionalId);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});