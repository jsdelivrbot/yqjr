jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });
    $( "#createTime" ).datepicker();
    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/eventPersons/selectById?id=' + mid,
        dataType: 'json'
    }).then(function (obj) {
        // 查询失败
        if (!obj.isSuccess) {
            layer.alert(obj.msg);
            return;
        }
        var result = obj.result;
        // var transcode1 = function (){
        //     if(result.transcode1=="1"){
        //         $("#transcode1").text("惩罚");
        //         $("#transcode1").val("1");
        //         return ;
        //     }else if(result.transcode1=="0"){
        //         $("#transcode1").text("奖励");
        //         $("#transcode1").val("0");
        //         return ;
        //     }else if(result.transcode1=="2"){
        //         $("#transcode1").text("其他");
        //         $("#transcode1").val("2");
        //         return ;
        //     }
        // };
        $("#id").val(result.id);
        $("#eventCode").val(result.eventCode);
        $("#eventYear").val(result.eventYear);
        $("#eventApart").val(result.eventApart);
        $("#brandsText").val(result.brandsText);
        $("#code").val(result.code);
        $("#eventStatus").val(result.eventStatus);
        $("#createTime").val(result.createTime);
        $("#bemark").val(result.bemark);
        $("#personCode").val(result.personCode);
        $("#personName").val(result.personName);
        $("#transcode1").val(result.transcode1);
        $("#transcode2").val(result.transcode2);
        $("#transcode3").val(result.transcode3);
        $("#transcode4").val(result.transcode4);
        $("#modifyTime").val(result.modifyTime);
        $("#startTime").val(result.startTime);
        $("#creator").val(result.creator);
        $("#modifier").val(result.modifier);
        $("#flag").val(result.flag);
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
                type: 'POST',
                contentType: 'application/json',
                url: '/mkmm/sales/eventPersons/updateById',
                data: JSON.stringify(formData)
            }).then(function (obj) {
                // 保存失败
                if (!obj.isSuccess) {
                    layer.alert(obj.msg);
                    return;
                }
                layer.alert(obj.msg,function(){
                    window.location='/mkmm/ui/eventPerson/list';
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
