jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/MKMM_FEE_MAIN_HIS/feeMainHiss/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#billno").val(result.billno);
          $("#feeType").val(result.feeType);
          $("#feeSource").val(result.feeSource);
          $("#businessCode").val(result.businessCode);
          $("#businessName").val(result.businessName);
          $("#company").val(result.company);
          $("#billStatus").val(result.billStatus);
          $("#isSendGx").val(result.isSendGx);
          $("#validStatus").val(result.validStatus);
          $("#maxBillFee").val(result.maxBillFee);
          $("#billFee").val(result.billFee);
          $("#settleTimes").val(result.settleTimes);
          $("#actualTurnoverCount").val(result.actualTurnoverCount);
          $("#estimateTurnoverCount").val(result.estimateTurnoverCount);
          $("#feeMainReviewId").val(result.feeMainReviewId);
          $("#feeowner").val(result.feeowner);
          $("#remark").val(result.remark);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#startTime").val(result.startTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#flag").val(result.flag);
          $("#historyId").val(result.historyId);
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
                url: '/mkmm/MKMM_FEE_MAIN_HIS/feeMainHiss/' + mid,
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
