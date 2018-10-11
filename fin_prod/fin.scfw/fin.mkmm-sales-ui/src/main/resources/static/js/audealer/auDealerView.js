jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/auDealers/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#vorganizationno").val(result.vorganizationno);
          $("#vdealername").val(result.vdealername);
          $("#ndealerid").val(result.ndealerid);
          $("#vsuperorganizationno").val(result.vsuperorganizationno);
          $("#vcode").val(result.vcode);
          $("#nstatus").val(result.nstatus);
          $("#niscardealer").val(result.niscardealer);
          $("#nistruckdealer").val(result.nistruckdealer);
          $("#vtruckcode").val(result.vtruckcode);
          $("#nisinvoice").val(result.nisinvoice);
          $("#nptype").val(result.nptype);
          $("#ncomtype").val(result.ncomtype);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});