jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/workFlows/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#type").val(result.type);
          $("#reviewId").val(result.reviewId);
          $("#reviewNode").val(result.reviewNode);
          $("#reviewStatus").val(result.reviewStatus);
          $("#reviewLevel").val(result.reviewLevel);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#transcode1").val(result.transcode1);
          $("#transcode2").val(result.transcode2);
          $("#transcode3").val(result.transcode3);
          $("#transcode4").val(result.transcode4);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});