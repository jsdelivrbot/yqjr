jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/personTeamReviews/' + mid,
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
          $("#companyCode").val(result.companyCode);
          $("#teamCode").val(result.teamCode);
          $("#personNature").val(result.personNature);
          $("#personLevel").val(result.personLevel);
          $("#personStatus").val(result.personStatus);
          $("#personCheckStart").val(result.personCheckStart);
          $("#personUptime").val(result.personUptime);
          $("#personCorrectime").val(result.personCorrectime);
          $("#personTryStartime").val(result.personTryStartime);
          $("#personTryEndtime").val(result.personTryEndtime);
          $("#personJointime").val(result.personJointime);
          $("#remark").val(result.remark);
          $("#reviewStatus").val(result.reviewStatus);
          $("#startTime").val(result.startTime);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#flag").val(result.flag);
          $("#reviewType").val(result.reviewType);
          $("#flowId").val(result.flowId);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});