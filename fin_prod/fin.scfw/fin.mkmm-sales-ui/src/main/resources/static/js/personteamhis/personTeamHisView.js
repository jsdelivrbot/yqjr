jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/personTeamHiss/' + mid,
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
          $("#startTime").val(result.startTime);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#operateType").val(result.operateType);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});