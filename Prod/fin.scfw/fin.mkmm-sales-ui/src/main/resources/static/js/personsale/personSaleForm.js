var formValidateConfig = {
    rules: {
        id: {
            required: true
        }
    },
    messages: {
        id: {
        }
    }
};
$(document).ready(function () {
    $("#inputForm").frameworkValid(formValidateConfig);
});
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
        url: $form.attr('action'),
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