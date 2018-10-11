jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/MKMM_PLAN_TRACK_HIS/planTrackHiss/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#year").val(result.year);
          $("#month").val(result.month);
          $("#areaCode").val(result.areaCode);
          $("#areaName").val(result.areaName);
          $("#teamCode").val(result.teamCode);
          $("#teamName").val(result.teamName);
          $("#personCode").val(result.personCode);
          $("#personName").val(result.personName);
          $("#personType").val(result.personType);
          $("#brands").val(result.brands);
          $("#brandType").val(result.brandType);
          $("#monthActualNum").val(result.monthActualNum);
          $("#monthPlanNum").val(result.monthPlanNum);
          $("#monthPlanRate").val(result.monthPlanRate);
          $("#monthRate").val(result.monthRate);
          $("#monthRateCal").val(result.monthRateCal);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#startTime").val(result.startTime);
          $("#modifier").val(result.modifier);
          $("#flag").val(result.flag);
          $("#differentCode").val(result.differentCode);
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
                url: '/mkmm/MKMM_PLAN_TRACK_HIS/planTrackHiss/' + mid,
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
