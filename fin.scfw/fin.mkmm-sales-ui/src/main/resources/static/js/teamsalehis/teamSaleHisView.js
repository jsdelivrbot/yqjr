jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/teamSaleHiss/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#teamCode").val(result.teamCode);
          $("#teamName").val(result.teamName);
          $("#brands").val(result.brands);
          $("#year").val(result.year);
          $("#month").val(result.month);
          $("#amount").val(result.amount);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#company").val(result.company);
          $("#differentCode").val(result.differentCode);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});