jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/MKMM_ACTIVE_MAIN_HIS/activeMainHiss/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#activeCode").val(result.activeCode);
          $("#activeName").val(result.activeName);
          $("#activeStartime").val(result.activeStartime);
          $("#activeEndtime").val(result.activeEndtime);
          $("#loanStartime").val(result.loanStartime);
          $("#loanEndtime").val(result.loanEndtime);
          $("#patmentBegin").val(result.patmentBegin);
          $("#patmentEnd").val(result.patmentEnd);
          $("#carReg").val(result.carReg);
          $("#loanTermBegin").val(result.loanTermBegin);
          $("#loanTermEnd").val(result.loanTermEnd);
          $("#loanAmtBegin").val(result.loanAmtBegin);
          $("#loanAmtEnd").val(result.loanAmtEnd);
          $("#avtiveCriterion").val(result.avtiveCriterion);
          $("#additionFlag").val(result.additionFlag);
          $("#additionAmtBegin").val(result.additionAmtBegin);
          $("#additionAmtEnd").val(result.additionAmtEnd);
          $("#activeStatus").val(result.activeStatus);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#startTime").val(result.startTime);
          $("#annex").val(result.annex);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#company").val(result.company);
          $("#paymentStatus").val(result.paymentStatus);
          $("#remark").val(result.remark);
          $("#expectedCount").val(result.expectedCount);
          $("#activeId").val(result.activeId);
          $("#flag").val(result.flag);
          $("#additionalId").val(result.additionalId);
          $("#inputDeale").val(result.inputDeale);
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
                url: '/mkmm/MKMM_ACTIVE_MAIN_HIS/activeMainHiss/' + mid,
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
