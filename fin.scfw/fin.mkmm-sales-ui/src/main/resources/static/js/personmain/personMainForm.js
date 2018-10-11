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
/*    $("#cityCode").select2();
    $("#mgmtBrands").select2();*/

    // //加载团队
    // $.ajax({
    //     type: "POST",
    //     url: "/mkmm/sales/personMainReviews/team",
    //     data: {},
    //     dataType: "json",
    //     success: function(data){
    //         var option = "";
    //         if(data!=null && data.length>0){
    //             for(var i=0;i<data.length;i++){
    //                 option+=('<option value="'+data[i].teamCode+'">'+data[i].teamName+'</option>');
    //             }
    //             $("#teamName").html(option);
    //         }
    //     }
    // })
    // //团队名称联动团队代码
    // $("#teamName").change(function (){
    //         $("#teamCode").val( $(this).val());
    //     }
    // );
    $("#teamName").change();

    //加载品牌
    // $("#mgmtBrands").select2({
    //     ajax: {
    //         type:"POST",
    //         url: "/mkmm/sales/personMainReviews/brand",
    //         dataType: 'json',
    //         delay: 250,
    //         data: function (params) {
    //             /*var InitData = {
    //                 "FiledList":[
    //                     {
    //                         "FieldName":"MaterialName",
    //                         "FieldOpt":"like",
    //                         "FieldVal":"%" + params.term.trim() + "%"
    //                     }
    //                 ]
    //             };
    //             return {
    //                 ExecType: "00",
    //                 PageInfo:JSON.stringify(PageInfo),
    //                 InitData:JSON.stringify(InitData)
    //             };*/
    //         },
    //         processResults: function (data,params) {
    //             params.page = params.page || 1;
    //             var itemList = [];//当数据对象不是{id:0,text:'ANTS'}这种形式的时候，可以使用类似此方法创建新的数组对象
    //             for(var i=0;i<data.length;i++){
    //                 itemList.push({id: data[i].ncarbrandid, text: data[i].ncarbrandname})
    //             }
    //             console.log(JSON.stringify(itemList));
    //             return {
    //                 results: itemList
    //             };
    //         },
    //         cache: true
    //     }
    // });
    $("#mgmtBrands").select2({
        ajax: {
            type: 'GET',
            url: "/mkmm/sales/selectCode/CarBrandList",
            dataType: 'json',
            data: {
                isUpCode: '0'
            },
            processResults: function (data) {
                var brandsInfos = data.result;
                var brandsInfo = new Array();           //品牌
                for (var i = 0; i < brandsInfos.length; i++) {
                    brandsInfo.push({id: brandsInfos[i].value, text: brandsInfos[i].label})
                }
                return{
                    results: brandsInfo
                };
            },
            cache: true
        }
    });
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
      if($("#personTryStartime").val()!=""&$("#personTryEndtime").val()==""){
          layer.alert("试用期时间不能为空");
          return;
      }
      if($("#personJointime").val()==""){
          layer.alert("加入我司时间不能为空");
          return;
      }
      if($("#startTime").val()==""){
          layer.alert("生效时间不能为空");
          return;
      }
      var today = getNowFormatDate();
      var deadLine = $("#startTime").val();
      if (compareDate(today,deadLine)){
          layer.alert("生效日期不能早于当前时间!");
          return;
      }
    $.each(arr, function (i, item) {
        formData[item['name']] = item['value'];
    });

    var cities =  $("#cityCode").select2("data");
    console.log(cities);
    var brands = $("#mgmtBrands").select2("data");
    var arr1 = [];var arr2 =[];//select2的值包装成城市、品牌
    if(cities!=null && cities.length>0){
        for(var i=0;i<cities.length;i++){
            arr1.push({cityCode:cities[i].id,cityName:cities[i].text});
        }
    }
    if(brands!=null && brands.length>0) {
        for (var i = 0; i < brands.length; i++) {
            arr2.push({brandCode: brands[i].id, brandName: brands[i].text});
        }
    }
    console.log(JSON.stringify(arr2));
    formData["cities"] = arr1;
    formData["brands"] = arr2;

/*    formData["teamCode"] = $("#teamName").val();
    formData["teamName"] = $("#teamName option:selected").text();*/
    console.log("新增人员上行参数："+JSON.stringify(formData));

    $.ajax({
        type: 'POST',
       contentType: 'application/json',
        url: $form.attr('action'),
 //       dataType:"json",
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

//时间插件
$(".date-picker").datepicker({
    language: "zh-CN",
    autoclose: true,//选中之后自动隐藏日期选择框
    clearBtn: true,//清除按钮
    format: "yyyy-mm-dd"//日期格式
});

function getDate(date){
    var dates = date.split("-");
    var dateReturn = '';
    for(var i=0; i<dates.length; i++){
        dateReturn+=dates[i];
    }
    return parseInt(dateReturn);

}
//上岗日期校验
$("#personUptime").on("change",function (){
    var str_date = document.getElementById("personUptime").value;//考核时间
    var end_date = document.getElementById("personCorrectime").value;//上岗日期
    if(end_date==""||end_date==null){
        return ;
    }
    if(getDate(str_date)-getDate(end_date)>0){
        $(".datepicker").datepicker({autoclose: true});
        layer.alert("转正日期不能早于上岗日期！");
        $("#personUptime").val("");
    }
    return ;

});
$("#brandsCode").select2({
    ajax: {
        type: 'GET',
        url: "/mkmm/sales/selectCode/CarBrand",
        dataType: 'json',
        data: {
            isUpCode: '0'
        },
        processResults: function (data) {
            var brandsInfos = data.result;
            var brandsInfo = new Array();           //品牌
            for (var i = 0; i < brandsInfos.length; i++) {
                brandsInfo.push({id: brandsInfos[i].value, text: brandsInfos[i].label})
            }
            return{
                results: brandsInfo
            };
        },
        cache: true,
    }
});


$("#personCorrectime").on("change",function (){
    var str_date = document.getElementById("personUptime").value;//考核时间
    var end_date = document.getElementById("personCorrectime").value;//上岗日期
    if(end_date==""||end_date==null){
        return ;
    }
    if(getDate(str_date)-getDate(end_date)>0){
        $(".datepicker").datepicker({autoclose: true});
        layer.alert("转正日期不能早于上岗日期！");
        $("#personCorrectime").val("");
    }
    return ;

});
$("#provinceCode").select2({
    ajax: {
        type: 'GET',
        url: "/mkmm/sales/selectCode/Province",
        dataType: 'json',
        data: {
            isUpCode: '0'
        },
        processResults: function (data) {
            var provinceInfos = data.result;
            var provinceInfo = new Array();           //省
            for (var i = 0; i < provinceInfos.length; i++) {
                provinceInfo.push({id: provinceInfos[i].value, text: provinceInfos[i].label})
            }
            return{
                results: provinceInfo
            };
        },
        cache: true,
    }
});
$("#cityCode").select2({
    ajax: {
        type: 'GET',
        url: "/mkmm/sales/selectCode/City",
        dataType: 'json',
        data: function (params) {
            var provinceCodes = $("#provinceCode").select2("data");
            var upCodes = '';
            for (var i=0;i<provinceCodes.length;i++) {
                if (i == 0){
                    upCodes += provinceCodes[i].id
                } else {
                    upCodes += ','
                    upCodes += provinceCodes[i].id
                }
            }
            return {
                isUpCode:'1',upCode:upCodes}
        },
        processResults: function (data) {
            var cityInfos = data.result;
            var cityInfo = new Array();           //市
            for (var i = 0; i < cityInfos.length; i++) {
                cityInfo.push({id: cityInfos[i].value, text: cityInfos[i].label})
            }
            return{
                results: cityInfo
            };
        },
        cache: true,
    }
});

//加载品牌
$("#mgmtBrands").select2({
    ajax: {
        type:"POST",
        url: "/mkmm/sales/personMainReviews/brand",
        dataType: 'json',
        delay: 250,
        data: function (params) {},
        processResults: function (data,params) {
            params.page = params.page || 1;
            var itemList = [];//当数据对象不是{id:0,text:'ANTS'}这种形式的时候，可以使用类似此方法创建新的数组对象
            for(var i=0;i<data.length;i++){
                itemList.push({id: data[i].ncarbrandid, text: data[i].ncarbrandname})
            }
            return {
                results: itemList
            };
        },
        cache: true
    }
});


//试用期日期校验
$("#personTryStartime").on("change",function (){
    var str_date = document.getElementById("personTryStartime").value;//试用期开始日期
    var end_date = document.getElementById("personTryEndtime").value;//试用期截至日期
    if(end_date==""||end_date==null){
        return ;
    }
    if(getDate(str_date)-getDate(end_date)>0){
        $(".datepicker").datepicker({autoclose: true});
        layer.alert("试用期结束时间不能早于试用期开始时间！");
        $("#personTryEndtime").val("");
    }
    return ;

});
$("#personTryEndtime").on("change",function (){
    var str_date = document.getElementById("personTryStartime").value;//试用期开始日期
    var end_date = document.getElementById("personTryEndtime").value;//试用期截至日期
    if(end_date==""||end_date==null){
        return ;
    }
    if(getDate(str_date)-getDate(end_date)>0){

        $(".datepicker").datepicker({autoclose: true});
        layer.alert("试用期结束时间不能早于试用期开始时间！");
        $("#personTryEndtime").val("");
    }
    return ;

});

// //加入我司时间与考核时间校验
// $("#personJointime").on("change",function (){
//     var str_date = document.getElementById("personJointime").value;//考核时间
//     var end_date = document.getElementById("personCheckStart").value;//上岗日期
//     if(end_date==""){
//         return ;
//     }
//     if(getDate(str_date)-getDate(end_date)>0){
//         $(".datepicker").datepicker({autoclose: true});
//         layer.alert("考核日期不能早于加入我司日期！");
//         $("#personJointime").val("");
//     }
//     return ;
//
// });
// $("#personCheckStart").on("change",function (){
//     var str_date = document.getElementById("personJointime").value;//考核时间
//     var end_date = document.getElementById("personCheckStart").value;//上岗日期
//     if(end_date==""){
//         return ;
//     }
//     if(getDate(str_date)-getDate(end_date)>0){
//         $(".datepicker").datepicker({autoclose: true});
//         layer.alert("考核日期不能早于加入我司日期！");
//         $("#personCheckStart").val("");
//     }
//     return ;
//
// });

// //考核时间与上岗日期校验
// $("#personCheckStart").on("change",function (){
//     var str_date = document.getElementById("personCheckStart").value;//考核时间
//     var end_date = document.getElementById("personUptime").value;//上岗日期
//     if(end_date==""||end_date==null){
//     return ;
//     }
// if(getDate(str_date)-getDate(end_date)>0){
//     $(".datepicker").datepicker({autoclose: true});
//     layer.alert("上岗日期不能早于考核时间！");
//     $("#personCheckStart").val("");
// }
// return ;
//
// });
// $("#personUptime").on("change",function (){
//     var str_date = document.getElementById("personCheckStart").value;//考核时间
//     var end_date = document.getElementById("personUptime").value;//上岗日期
// if(end_date==""||end_date==null){
// return ;
// }
//     if(getDate(str_date)-getDate(end_date)>0){
//         $(".datepicker").datepicker({autoclose: true});
//         layer.alert("上岗日期不能早于考核时间！");
//         $("#personUptime").val("");
//     }
//     return ;
//
// });

// //上岗日期与试用期开始日期校验
// $("#personUptime").on("change",function (){
//     var str_date = document.getElementById("personUptime").value;//上岗日期
//     var end_date = document.getElementById("personTryStartime").value;//试用期开始日期
//     if(end_date==""||end_date==null){
//         return ;
//     }
//     if(getDate(str_date)-getDate(end_date)>0){
//         $(".datepicker").datepicker({autoclose: true
//         });
//         layer.alert("试用期开始日期不能早于上岗日期！");
//         $("#personUptime").val("");
//     }
//     return ;
// });
// $("#personTryStartime").on("change",function (){
//     var str_date = document.getElementById("personUptime").value;//上岗日期
//     var end_date = document.getElementById("personTryStartime").value;//试用期开始日期
//     if(end_date==""||end_date==null){
//         return ;
//     }
//     if(getDate(str_date)-getDate(end_date)>0){
//         $(".datepicker").datepicker({autoclose: true
//         });
//         layer.alert("试用期开始日期不能早于上岗日期！");
//         $("#personTryStartime").val("");
//     }
//     return ;
// });

//转正与试用期开始时间校验
$("#personCorrectime").on("change",function (){
    var str_date = document.getElementById("personCorrectime").value;//转正日期
    var end_date = document.getElementById("personTryStartime").value;//试用期开始日期
    if(end_date==""||end_date==null){

        return ;
    }
    if(getDate(str_date)-getDate(end_date)<0){
        $(".datepicker").datepicker({autoclose: true
        });
        layer.alert("转正日期不能早于试用期开始日期！");
        $("#personCorrectime").val("");
    }
    return ;
});
$("#personTryStartime").on("change",function (){
    var str_date = document.getElementById("personCorrectime").value;//上岗日期
    var end_date = document.getElementById("personTryStartime").value;//试用期开始日期
    if(str_date==""||str_date==null){
        return ;
    }
    if(getDate(str_date)-getDate(end_date)<0){
        $(".datepicker").datepicker({autoclose: true
        });
        layer.alert("试用期开始日期不能晚于转正日期！");
        $("#personTryStartime").val("");
    }
    return ;
});

//转正日期与试用期结束日期校验
$("#personCorrectime").on("change",function (){
    var str_date = document.getElementById("personCorrectime").value;//转正日期
    var end_date = document.getElementById("personTryEndtime").value;//试用期结束日期
    if(end_date==""||end_date==null){
        return ;
    }
    if(getDate(str_date)-getDate(end_date)<0){
        $(".datepicker").datepicker({autoclose: true
        });
        layer.alert("转正日期不能早于试用期结束日期！");
        $("#personCorrectime").val("");
    }
    return ;
});
$("#personTryEndtime").on("change",function (){
    var str_date = document.getElementById("personCorrectime").value;//上岗日期
    var end_date = document.getElementById("personTryEndtime").value;//试用期开始日期
    if(str_date==""||str_date==null){
        return ;
    }
    if(getDate(str_date)-getDate(end_date)<0){
        $(".datepicker").datepicker({autoclose: true
        });
        layer.alert("试用期结束日期不能晚于转正日期！");
        $("#personTryEndtime").val("");
    }
    return ;
});


//转正日期与考核日期校验
$("#personCorrectime").on("change",function (){
    var str_date = document.getElementById("personCorrectime").value;//转正日期
    var end_date = document.getElementById("personCheckStart").value;//考核日期
    if(end_date==""||end_date==null){
        return ;
    }
    if(getDate(str_date)-getDate(end_date)<0){
        $(".datepicker").datepicker({autoclose: true
        });
        layer.alert("转正日期不能早于考核日期！");
        $("#personCorrectime").val("");
    }
    return ;
});
$("#personCheckStart").on("change",function (){
    var str_date = document.getElementById("personCorrectime").value;//转正日期
    var end_date = document.getElementById("personCheckStart").value;//试用期开始日期
    if(str_date==""||str_date==null){
        return ;
    }
    if(getDate(str_date)-getDate(end_date)<0){
        $(".datepicker").datepicker({autoclose: true
        });
        layer.alert("转正日期不能早于考核日期！");
        $("#personCheckStart").val("");
    }
    return ;
});

//转正日期于加入我司时间校验
$("#personCorrectime").on("change",function (){
    var str_date = document.getElementById("personCorrectime").value;//转正日期
    var end_date = document.getElementById("personJointime").value;//加入我司日期
    if(end_date==""||end_date==null){
        return ;
    }
    if(getDate(str_date)-getDate(end_date) <0){
        $(".datepicker").datepicker({autoclose: true
        });
        layer.alert("转正日期不能早于加入我司日期！");
        $("#personCorrectime").val("");
    }
    return ;
});
$("#personJointime").on("change",function (){
    var str_date = document.getElementById("personCorrectime").value;//转正日期
    var end_date = document.getElementById("personJointime").value;//加入我司日期
    if(str_date==""||str_date==null){
        return ;
    }
    if(getDate(str_date)-getDate(end_date)<0){
        $(".datepicker").datepicker({autoclose: true
        });
        layer.alert("加入我司日期不能晚于转正日期！");
        $("#personJointime").val("");
    }
    return ;
});


function isPoneAvailable(str) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    var phone = /^0\d{2,3}-?\d{7,8}$/;
    if (myreg.test(str)) {
        return true;
    } else if(phone.test(str)){
        return true;
    }else{
        $("#"+event.target.id).val("");
        layer.alert("请输入正确的电话格式");
    }
}

function checkEMail(e) {
    var a = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if (!a.test(e)) {
        $("#personEmail").val("");
        layer.alert("请输入格式正确的 e-mail 地址！");
    }
}

function formatDateTime(time) {
    let date = new Date(time);
    let y = date.getFullYear();
    let m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    let d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    return y + '-' + m + '-' + d;
};

//校验人员下是否有团队
function checkUnique(){
    if($("#searchPerson").val().trim()==null||$("#searchPerson").val().trim()==""){
        $("#searchPerson").val("");
        layer.alert("请输入登录用户名后查询");
        return ;
    }
    $.ajax({
        url: "/mkmm/sales/personMainReviews/selectByCheckUniquen",
        type: "GET",
        data: {"searchPerson": $("#searchPerson").val()},
        success: function(obj){
            // 成功后的回调函数，做后续处理用的。
            if(!obj.isSuccess){
                layer.alert(obj.msg);
                $("button").attr("disabled", true);
            } else {
                $("#personCode").val(obj.result.personCode);//员工编码
                $("#personName").val(obj.result.personName);//员工姓名
                $("#personIdcard").val(obj.result.personIdcard);//身份证号
                if (obj.result.personBirth==null){
                    $("#personBirth").val(obj.result.personBirth);//出生日期
                }else{
                    $("#personBirth").val(formatDateTime(obj.result.personBirth));//出生日期
                }
                $("#personAge").val(obj.result.personAge);//年龄
                $("#personEthnic").val(obj.result.personEthnic);//民族
                $("#personMarr").val(obj.result.personMarr);//婚姻状况
                $("#personSchool").val(obj.result.personSchool);//毕业学校
                $("#personSubject").val(obj.result.personSubject);//专业
                $("#personEdu").val(obj.result.personEdu);//最高学历
                $("#personEdulevel").val(obj.result.personEdulevel);//学位
                if (obj.result.personFirstworktime==null){
                    $("#personFirstworktime").val(obj.result.personFirstworktime);//参加工作日期
                }else{
                    $("#personFirstworktime").val(formatDateTime(obj.result.personFirstworktime));//参加工作日期
                }
                $("#personWorktime").val(obj.result.personWorktime);//工龄
                $("#areaCode").val(obj.result.areaCode);//归属区域代码
                $("#areaName").val(obj.result.areaName);//归属区域名称
                $("button").attr("disabled", false);
            }
        }
    });
}



//团队名称模糊查询
/**
 * ------------------------------------------------------模糊查询自动补全 begin
 */
$("#teamName").autocomplete({
    minLength:2,
    source: function( request, response ) {
        $.ajax({
            url : "/mkmm/sales/autoComplete/Team",
            type : "GET",
            contentType: 'application/json',
            data : {"name":$("#teamName").val()},
            success: function( data ) {
                response( $.map( data.result, function( item ) {
                    return {
                        label: item.label,
                        value: item.value
                    }
                }));
            }
        });
    },

    /**
     * 菜单选中时操作
     * @param event
     * @param ui
     */
    select: function(event, ui){
        // 这里的this指向当前输入框的DOM元素
        // event参数是事件对象
        // ui对象只有一个item属性，对应数据源中被选中的对象
       $(this).val(ui.item.label);
       $("#teamCode").val( ui.item.value);
       // 必须阻止事件的默认行为，否则autocomplete默认会把ui.item.value设为输入框的value值
        event.preventDefault();

    },

    /**
     * 修改输入框的值，并修改的值不在返回的数据内所做的操作
     * @param event
     * @param ui
     */
    change: function( event, ui ) {
        if(ui.item==null){
            $("#teamCode").val("");
        }
    }
});


//日期比较
function compareDate(d1, d2) {
    return ((new Date(d1.replace(/-/g, "\/"))) >= (new Date(d2.replace(/-/g, "\/"))));
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
/**
 * ------------------------------------------------------模糊查询自动补全 end
 */