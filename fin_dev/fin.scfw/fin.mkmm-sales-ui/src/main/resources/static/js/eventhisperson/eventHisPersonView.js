jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/eventHisPersons/' + mid,
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
          $("#operatePerson").val(result.operatePerson);
          $("#operateStatus").val(result.operateStatus);
          $("#flag").val(result.flag);
          $("#remark").val(result.remark);
          $("#transcode1").val(result.transcode1);
          $("#transcode2").val(result.transcode2);
          $("#transcode3").val(result.transcode3);
          $("#transcode4").val(result.transcode4);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});