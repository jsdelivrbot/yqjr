jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/MKMM_AU_DEALER/auDealers/' + mid,
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

    $("#btnSubmit").on("click", function (e) {
        e.preventDefault();
        var flag = $("#inputForm").valid();
        if (!flag) {
            //没有通过验证
            return;
        } else {
            $("button").attr("disabled", true);
            var $form = $("#inputForm");
            var arr = $form.serializeArray();
            var formData = {};
            if ($form.val()) {
                $form.trigger('change');
            }

            $.each(arr, function (i, item) {
                formData[item['name']] = item['value'];
            });

            $.ajax({
                type: 'PATCH',
                contentType: 'application/json',
                url: '/mkmm/MKMM_AU_DEALER/auDealers/' + mid,
                data: JSON.stringify(formData)
            }).then(function (obj) {
                // 保存失败
                if (!obj.isSuccess) {
                    layer.alert(obj.msg);
                    return;
                }
                layer.alert(obj.msg);
                $("#inputForm").resetForm();
            }).always(function () {
                $("button").attr("disabled", false);
            });
        }
    });
});
