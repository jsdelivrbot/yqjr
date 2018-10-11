jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/areaMains/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#nparentid").val(result.nparentid);
          $("#vname").val(result.vname);
          $("#vorganizationno").val(result.vorganizationno);
          $("#vsimplename").val(result.vsimplename);
          $("#nischildarea").val(result.nischildarea);
          $("#nisparentarea").val(result.nisparentarea);
          $("#nptype").val(result.nptype);
          $("#ncomtype").val(result.ncomtype);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});