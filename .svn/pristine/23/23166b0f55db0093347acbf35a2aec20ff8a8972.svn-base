jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/MKMM_TEAM_MAIN/teamMains/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#teamId").val(result.teamId);
          $("#areaCode").val(result.areaCode);
          $("#areaName").val(result.areaName);
          $("#teamCode").val(result.teamCode);
          $("#teamName").val(result.teamName);
          $("#teamLevel").val(result.teamLevel);
          $("#teamType").val(result.teamType);
          $("#teamStatus").val(result.teamStatus);
          $("#teamLeader").val(result.teamLeader);
          $("#teamPhone").val(result.teamPhone);
          $("#teamZip").val(result.teamZip);
          $("#teamAddress").val(result.teamAddress);
          $("#teamFax").val(result.teamFax);
          $("#teamStartime").val(result.teamStartime);
          $("#teamCreatime").val(result.teamCreatime);
          $("#teamModtime").val(result.teamModtime);
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
                url: '/mkmm/MKMM_TEAM_MAIN/teamMains/' + mid,
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
