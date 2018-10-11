jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/MKMM_PERSON_MAIN_HIS/personMainHiss/' + mid,
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
          $("#personName").val(result.personName);
          $("#personIdcard").val(result.personIdcard);
          $("#remark").val(result.remark);
          $("#personAge").val(result.personAge);
          $("#personEthnic").val(result.personEthnic);
          $("#personMarr").val(result.personMarr);
          $("#personSchool").val(result.personSchool);
          $("#personSubject").val(result.personSubject);
          $("#personEdu").val(result.personEdu);
          $("#personEdulevel").val(result.personEdulevel);
          $("#personWorktime").val(result.personWorktime);
          $("#personFirstworktime").val(result.personFirstworktime);
          $("#personAddress").val(result.personAddress);
          $("#personHomephone").val(result.personHomephone);
          $("#personWorkphone").val(result.personWorkphone);
          $("#personPhone").val(result.personPhone);
          $("#personEmail").val(result.personEmail);
          $("#startTime").val(result.startTime);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#personBirth").val(result.personBirth);
          $("#operateType").val(result.operateType);
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
                url: '/mkmm/MKMM_PERSON_MAIN_HIS/personMainHiss/' + mid,
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
