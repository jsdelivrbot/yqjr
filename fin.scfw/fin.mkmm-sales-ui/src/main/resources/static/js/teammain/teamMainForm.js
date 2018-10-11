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
$(".date-picker").datepicker({
    language: "zh-CN",
    autoclose: true,//选中之后自动隐藏日期选择框
    clearBtn: true,//清除按钮
    format: "yyyy-mm-dd"//日期格式
});
$(document).ready(function () {
    $("#inputForm").frameworkValid(formValidateConfig);
    var user=getUserCookie();
    $("#areaName").val(user.areaName);
    $("#areaCode").val(user.areaCode);
    $("#company").val(user.comCode);
});

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
    if ($("#startTime").val()==null || $("#startTime").val()==''){
        layer.alert("生效时间不能为空!");
        return;
    }
    var today = getNowFormatDate();
    var started = $("#startTime").val();
    if (compareDate(today,started)){
        layer.alert("生效时间不能小于当天!");
        return;
    }
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
        layer.alert(obj.msg,function (){
            history.go(-1);
        });
        // $("#inputForm").resetForm();
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
        layer.alert("邮政编码格式有误，请重新输入");
        return false;
    }
}

//电话号码校验
function isPoneAvailable(str) {
    var mobilereg=/^[1][3,4,5,7,8][0-9]{9}$/;
    // var myreg=/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/;
    var landlinereg= /^(0[0-9]{2,3}\-)([1-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
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
            layer.alert('请输入正确的传真号');
            $("#teamFax").val("");

        }
    }
}

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