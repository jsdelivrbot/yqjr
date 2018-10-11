jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/productCodes/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#vdictcode").val(result.vdictcode);
          $("#value").val(result.value);
          $("#name").val(result.name);
          $("#ngradation").val(result.ngradation);
          $("#vstatus").val(result.vstatus);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});