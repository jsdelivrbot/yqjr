jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var user = getUserCookie();
    $("#createName").val(user.name);
    $("#company").val(user.comCode);
    var mid = $.getUrlParam("id");


    $.ajax({
        type: 'GET',
        url: apiEntityBasePath+'/'+ mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#eventCode").val(result.eventCode);
          $("#eventYear").val(result.eventYear);
          $("#eventApart").val(result.eventApart);
          $("#eventText").val(result.eventText);
          $("#code").val(result.code);
          $("#eventStatus").val(result.eventStatus);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#startTime").val(result.startTime);
          $("#remark").val(result.remark);
          $("#transcode1").val(result.transcode1);
          $("#transcode2").val(result.transcode2);
          $("#transcode3").val(result.transcode3);
          $("#transcode4").val(result.transcode4);
          $("#eventType").val(result.eventType);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#flag").val(result.flag);
          $("#teamName").val(result.teamName);
          $("#teamCode").val(result.teamCode);
          $("#company").val(result.company);
          $("#areaCode").val(result.areaCode);
          $("#areaName").val(result.areaName);
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
                url: apiEntityBasePath +'/'+ mid,
                data: JSON.stringify(formData)
            }).then(function (obj) {
                // 保存失败
                if (!obj.isSuccess) {
                    layer.alert(obj.msg);
                    return;
                }
                layer.alert(obj.msg,function (){
                    history.go(-1);
                });
                $("#inputForm").resetForm();
            }).always(function () {
                $("button").attr("disabled", false);
            });
        }
    });
});


$('.yearpicker').datepicker({
    startView: 'decade',
    minView: 'decade',
    format: 'yyyy',
    maxViewMode: 2,
    minViewMode:2,
    autoclose: true
});