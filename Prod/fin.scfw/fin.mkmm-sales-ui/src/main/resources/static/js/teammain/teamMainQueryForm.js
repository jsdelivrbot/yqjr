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

//邮编地址校验
function checkPostal(postalcode){
    var reg = /^[0-9]{6}$/;
    if(reg.test(postalcode)){
        return true;
    }else{
        $("#teamZip").val("");
        layer.alert("邮政编码格式有误，请重输");
        return false;
    }
}
//电话号码校验
function isPoneAvailable(str) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(str)) {
        $("#"+event.target.id).val("");
        layer.alert("请输入正确的电话格式");
    } else {
        return true;
    }
}
//传真号码校验
function isTel(event) {
    //国家代码(2到3位)-区号(2到3位)-电话号码(7到8位)-分机号(3位)"

    var s =document.getElementById("teamFax").value;
    var pattern =/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
    //var pattern =/(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{7,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/;
    if(s!="")
    {
        if(!pattern.exec(s))
        {
            layer.alert('请输入正确的传真号');
            $("#teamFax").val("");

        }
    }
}

//团队名称唯一性校验
// function checkUnique(value){
//     if(value.toString().trim()==""||value.toString().trim()==null){
//         $("#teamName").val("");
//         layer.alert("用户名不能为空");
//         return ;
//     }
//     $.ajax({
//         url: "/mkmm/sales/teamReviews"+"/selectByCheckUniquen",
//         type: "GET",
//         data: {"teamName": value},
//         success: function(obj){
//             // 成功后的回调函数，做后续处理用的。jsonObject 一般是json对象
//             if(!obj.isSuccess){ // jsonObject.success,其实在后台中应该类似于map.put("success",true); 不懂可以查一下json是什么。（其实就是以对象，有属性名，属性值）
//
//             } else {
//                 $("#teamName").val("");
//                 layer.alert("用户名已存在");
//             }
//         }
//     });
// }


//团队名称唯一性校验
function checkUnique(value){
    if(value==null || value.toString().trim()==""){
        $("#teamName").val("");
        return ;
    }
    $.ajax({
        url: "/mkmm/sales/teamReviews"+"/selectByCheckUniquen",
        type: "GET",
        data: {"teamName": value.toString().trim()},
        success: function(obj){
            // 成功后的回调函数，做后续处理用的。jsonObject 一般是json对象
            if(obj.isSuccess){ // jsonObject.success,其实在后台中应该类似于map.put("success",true); 不懂可以查一下json是什么。（其实就是以对象，有属性名，属性值）

            } else {
                $("#teamName").val("");
                layer.alert("用户名已存在");
            }
        }
    });
}

