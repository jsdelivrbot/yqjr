jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/activeDealerReviews/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#activeReviewId").val(result.activeReviewId);
          $("#activeCode").val(result.activeCode);
          $("#dealerCode").val(result.dealerCode);
          $("#dealerName").val(result.dealerName);
          $("#activeNumber").val(result.activeNumber);
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