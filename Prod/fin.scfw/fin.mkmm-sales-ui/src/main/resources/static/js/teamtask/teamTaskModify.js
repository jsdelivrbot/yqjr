jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/MKMM_TEAM_TASK/teamTasks/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#taskId").val(result.taskId);
          $("#taskType").val(result.taskType);
          $("#areaCode").val(result.areaCode);
          $("#areaName").val(result.areaName);
          $("#taskPeo").val(result.taskPeo);
          $("#taskCreatime").val(result.taskCreatime);
          $("#taskStartime").val(result.taskStartime);
          $("#taskModtime").val(result.taskModtime);
          $("#taskStatus").val(result.taskStatus);
          $("#remark").val(result.remark);
          $("#transcode1").val(result.transcode1);
          $("#transcode2").val(result.transcode2);
          $("#transcode3").val(result.transcode3);
          $("#transcode4").val(result.transcode4);
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
                url: '/mkmm/MKMM_TEAM_TASK/teamTasks/' + mid,
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
