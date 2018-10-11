jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });
    var user = getUserCookie();
    $("#createName").val(user.name);
    $("#company").val(user.comCode);
    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: apiEntityBasePath+'/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          var oldValue = result.teamName;
          $("#id").val(result.id);
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
          $("#startTime").val(result.startTime);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#remark").val(result.remark);
          $("#transcode1").val(result.transcode1);
          $("#transcode2").val(result.transcode2);
          $("#transcode3").val(result.transcode3);
          $("#transcode4").val(result.transcode4);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);

          $("#teamName").on("change",function (e) {
              var value=$(this).val();
              checkUnique(value,oldValue);
          })

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
            if ($("#remark").val()==null || $("#remark").val().trim()==''){
                layer.alert("备注不能为空!");
                return;
            }
            $("#btnSubmit").attr("disabled", true);
            $("#teamStatus").attr("disabled", false);
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
                url: '/mkmm/sales/teamReviews/edit/' + mid,
                data: JSON.stringify(formData)
            }).then(function (obj) {
                // 保存失败
                if (!obj.isSuccess) {
                    $("#teamStatus").attr("disabled", true);
                    layer.alert(obj.msg);
                    return;
                }
                layer.alert(obj.msg,function (){
                    history.go(-1);
                });
                // $("#inputForm").resetForm();
            });
        }
    });
});

//邮编校验
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
    var mobilereg=/^[1][3,4,5,7,8][0-9]{9}$/;
    // var myreg=/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/;
    var landlinereg= /^(0[0-9]{2,3}\-)([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
    if (landlinereg.test(str) || mobilereg.test(str)) {
        return true;
    } else {
        $("#"+event.target.id).val("");
        layer.alert("输入的电话号码有误，请重新输入");
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
            layer.alert('输入的传真号有误，请重输');
            $("#teamFax").val("");

        }
    }
}

//团队名称唯一性校验
function checkUnique(value,oldValue){
    if(value==null || value.toString().trim()==""){
        $("#teamName").val("");
        return ;
    }
    if (value == oldValue){
        console.log("团队名称没有变化，不发送唯一性检测")
        return
    }

    $.ajax({
        url: "/mkmm/sales/teamReviews/selectByCheckUniquen",
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