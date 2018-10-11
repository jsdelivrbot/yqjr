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
    fundYear();
    $('#loading').hide();
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

function fundYear() {
    //先来取当前年份
    var date = new Date();
    var year = date.getFullYear();
    $("#uploadYear").val(year);
}

/**
 * 文件上传插件----------------------------------------------------begin
 */
$('#dealer-input-file,#appendix-input-file').ace_file_input({
    no_file:'请导入文件 ...',
    btn_choose:'浏览',
    btn_change:'修改',
    droppable:false,
    onchange:null,
    thumbnail:false
});
/**
 * 文件上传插件----------------------------------------------------end
 */
/**
 * 经销商文件上传--------------------------------------------------begin
 */
//下载模板
function downLoadExcel(){
    commonForward(apiEntityBasePath+'/createTemplate');
}

//导入
$("#upload").on("click",function (e) {
    e.preventDefault();
    var formData = new FormData($('#uploadForm')[0]);
    var year = $("#uploadYear").val();
    var fileName = $("#dealer-input-file").val();
    var index = fileName.lastIndexOf(".");
    var suffix = fileName.substring(index).toLowerCase();
    // 验证文件格式
    if(fileName == "" || !(".xls" == suffix)) {
        alert( "文件为空或格式不对，请选择xls格式！");
        return;
    } else {
        // console.log(fileSize);
        if(null != formData && '' != year) {
            // alert("正在上传，请稍等！");
            // $('#loading').show();
            $("button").attr("disabled", true);
            $.ajax({
                type: 'post',
                url: apiEntityBasePath + "/fileUpload",
                data: formData,
                cache: false,
                processData: false,
                contentType: false,
            }).success(function (data) {
                alert('上传成功！');
                window.location.reload();
            }).error(function (data) {
                alert('上传失败！请稍后再试！');
                window.location.reload();
            });
        } else {
            layer.alert("请检查导入的计划！");
        }
    }

});