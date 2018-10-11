jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    $(".date-picker").datepicker({
        language: "zh-CN",
        autoclose: true,//选中之后自动隐藏日期选择框
        clearBtn: true,//清除按钮
        format: "yyyy-mm-dd"//日期格式
    });

    var mid = $.getUrlParam("id");
    var flowid = $.getUrlParam("flowid");
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
          $("#startTime").val(splitStrToDate(result.startTime));
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#remark").val(result.remark);
          $("#reviewType").val(result.reviewType);
          $("#flag").val(result.flag);
          $("#reviewStatus").val(result.reviewStatus);
          $("#createName").val(result.createName);
          $("#founderLevel").val(result.founderLevel);
          $("#teamReviewType").val(result.reviewType);

          if (result.reviewType == '02'){
              $("#startTime").attr("disabled",true);
          }
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
        var today = getNowFormatDate();
        var started = $("#startTime").val();
        var reviewType = $("#teamReviewType").val();
        if (reviewType == '01'){
            if (compareDate(today,started)){
                layer.alert("生效时间不能小于当天!");
                return;
            }
        }
        if (!flag) {
            //没有通过验证
            return;
        } else {
            if($("#remark").val().trim() == ""){
                layer.alert("审核意见不能为空！");
                return
            }
            $("#btnSubmit").attr("disabled", true);
            $("#reviewType").attr("disabled", false);
            $("#teamType").attr("disabled", false);
            $("#teamStatus").attr("disabled", false);
            $("#startTime").attr("disabled", false);
            var $form = $("#inputForm");
            var arr = $form.serializeArray();
            var type = $("#reviewType").val();
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
                url: '/mkmm/sales/teamReviews/queryEdit/' + mid+'?type='+type,
                data: JSON.stringify(formData)
            }).then(function (obj) {
                // 保存失败
                if (!obj.isSuccess) {
                    layer.alert(obj.msg);
                    $("#reviewType").attr("disabled", true);
                    $("#teamType").attr("disabled", true);
                    $("#teamStatus").attr("disabled", true);
                    $("#startTime").attr("disabled", true);
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

function splitStrToDate(str) {
    if (!str) {
        return
    }
    var date = str.toString();
    if (date.length > 10){
        return date.substring(0,10)
    }else {
        return ''
    }
}

//获取当前日期，格式为yyyy-MM-dd
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

function compareDate(d1,d2){
    return ((new Date(d1.replace(/-/g,"\/"))) > (new Date(d2.replace(/-/g,"\/"))));
}