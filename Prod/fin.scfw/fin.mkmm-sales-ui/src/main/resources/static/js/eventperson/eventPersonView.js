jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/eventPersons/selectById?id=' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#eventYear").val(result.eventYear);
          $("#eventApart").val(result.eventApart);
          $("#brandsText").val(result.brandsText);

          $("#eventStatus").val(result.eventStatus);

          $("#transcode1").val(result.transcode1);

          $("#createTime").val(result.createTime);

      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});