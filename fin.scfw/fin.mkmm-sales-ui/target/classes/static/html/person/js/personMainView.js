jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/eco/MKMM_PERSON_MAIN/personMains/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#personId").val(result.personId);
          $("#personCode").val(result.personCode);
          $("#personName").val(result.personName);
          $("#personIdcard").val(result.personIdcard);
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
          $("#perrsonEmail").val(result.perrsonEmail);
          $("#personStatus").val(result.personStatus);
          $("#perrsonCreatime").val(result.perrsonCreatime);
          $("#perrsonModtime").val(result.perrsonModtime);
          $("#perrsonStartime").val(result.perrsonStartime);
          $("#remark").val(result.remark);
          $("#transcode1").val(result.transcode1);
          $("#transcode2").val(result.transcode2);
          $("#transcode3").val(result.transcode3);
          $("#transcode4").val(result.transcode4);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});