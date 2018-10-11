jQuery(function ($) {
    var myCodeCity = [];
    $("#inputForm").frameworkValid({
    });
    var $c_HospitalCode = $("#cityCode").select2({
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
    var $c_HospitalCode1=$("#mgmtBrands").select2({
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
    /*$("#mgmtCity").select2();
    $("#mgmtBrands").select2();*/
    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/personMains/edit?id=' + mid,
        dataType: 'json'
    }).then(function (obj) {
        console.log(obj);
        // 查询失败
        if (!obj.isSuccess) {
            layer.alert(obj.msg);
            return;
        }
        var result = obj.result;
        $("#id").val(result.id);
        $("#personCode").val(result.personCode);//人员代码
        $("#personName").val(result.personName);//姓名
        $("#personIdcard").val(result.personIdcard);//身份证号
        if (result.personBirth==null){
            $("#personBirth").val(result.personBirth);//出生日期
        }else{
            $("#personBirth").val(formatDate(result.personBirth));//出生日期
        }
        $("#personAge").val(result.personAge);//年龄
        $("#personEthnic").val(result.personEthnic);//民族
        $("#personMarr").val(result.personMarr);//婚姻状况
        $("#personSchool").val(result.personSchool);//毕业学校
        $("#personSubject").val(result.personSubject);//专业
        $("#personEdu").val(result.personEdu);//最高学历
        $("#personEdulevel").val(result.personEdulevel);//学位
        $("#personWorktime").val(result.personWorktime);//工龄
        $("#startTime").val(result.startTime);
        console.log( $("#startTime").val());
        if (result.personFirstworktime==null){
            $("#personFirstworktime").val(result.personFirstworktime);//参加工作时间
        }else {
            $("#personFirstworktime").val(formatDate(result.personFirstworktime));//参加工作时间
        }
        //入职()信息
        $("#teamName").val(result.personTeam.teamName);//团队名称
        $("#teamCode").val(result.personTeam.teamCode);//团队代码
        $("#areaCode").val(result.personTeam.areaCode);//归属区域代码
        $("#areaName").val(result.teamMain.areaName);//归属区域名称
        $("#personNature").find("option[value = '"+result.personTeam.personNature+"']").attr("selected","selected");//.html(option1);人员性质
        document.getElementById("personNature").disabled=true;
        $("#personLevel").find("option[value = '"+result.personTeam.personLevel+"']").attr("selected","selected");//.html("<option value='"+result.personTeam.personLevel+"'>"+result.personTeam.personLevel+"</option>");人员级别
        document.getElementById("personLevel").disabled=true;
        if (result.personTeam.personStatus=='1') {
            $("#personStatus").find("option[value = '"+result.personTeam.personStatus+"']").attr("selected","selected");//人员状态
        }else {
            $("#personStatus").val(result.personTeam.personStatus);
            document.getElementById("personStatus").disabled=true;
        }


        if (result.personTeam.personCheckStart==null){
            $("#personCheckStart").val(result.personTeam.personCheckStart);//考核开始时间
        }else {
            $("#personCheckStart").val(formatDate(result.personTeam.personCheckStart));//考核开始时间
        }
        if (result.personTeam.personUptime==null){
            $("#personUptime").val(result.personTeam.personUptime);//上岗时间
        } else {
            $("#personUptime").val(formatDate(result.personTeam.personUptime));//上岗时间
        }
        if (result.personTeam.personCorrectime==null){
            $("#personCorrectime").val(result.personTeam.personCorrectime);//转正时间
        }else {
            $("#personCorrectime").val(formatDate(result.personTeam.personCorrectime));//转正时间
        }
        if (result.personTeam.personTryStartime==null){
            $("#personTryStartime").val(result.personTeam.personTryStartime);//试用期开始时间
        } else {
            $("#personTryStartime").val(formatDate(result.personTeam.personTryStartime));//试用期开始时间
        }
        if (result.personTeam.personTryEndtime==null){
            $("#personTryEndtime").val(result.personTeam.personTryEndtime);//试用期结束时间
        } else{
            $("#personTryEndtime").val(formatDate(result.personTeam.personTryEndtime));//试用期结束时间
        }
        if (result.personTeam.personJointime==null){
            $("#personJointime").val(result.personTeam.personJointime);//加入我司时间
        }else {
            $("#personJointime").val(formatDate(result.personTeam.personJointime));//加入我司时间
        }
        var cities =  $("#cityCode").select2("data");
        console.log(cities);
        var brands = $("#mgmtBrands").select2("data");
        var arr1 = [];var arr2 =[];//select2的值包装成城市、品牌

       var cs = result.cities;
        if(cs!=null && cs.length>0){
            for(var i=0;i<cs.length;i++){
                var option = new Option(cs[i].cityName, cs[i].cityName, true, true);
                $c_HospitalCode.append(option);
            }
            $c_HospitalCode.trigger('change');//使用这个方法显示到select2上.
        }
        if(cities!=null && cities.length>0){
            for(var i=0;i<cities.length;i++){
                arr1.push({cityCode:cities[i].id,cityName:cities[i].text});
            }
        }
        var brands = result.brands;
        if(brands!=null && brands.length>0){
            for(var i=0;i<brands.length;i++){
                var option = new Option(brands[i].brandName, brands[i].brandName, true, true);
                $c_HospitalCode1.append(option);
            }
            $c_HospitalCode1.trigger('change');//使用这个方法显示到select2上.
        }
        console.log(JSON.stringify(arr2));
       // formData["cities"] = arr1;
       //  formData["brands"] = arr2;

        /*    formData["teamCode"] = $("#teamName").val();
            formData["teamName"] = $("#teamName option:selected").text();*/
        // console.log("新增人员上行参数："+JSON.stringify(formData));
        //联系信息
        $("#personAddress").val(result.personAddress);//家庭住址
        $("#personHomephone").val(result.personHomephone);//家庭电话
        $("#personWorkphone").val(result.personWorkphone);//工作电话
        $("#personPhone").val(result.personPhone);//移动电话
        $("#personEmail").val(result.perrsonEmail);//e-mail
        $("#remark").html(result.remark);//e-mail
    }, function (e) {
        layer.alert("查询数据失败:" + e);
    })

   /*  //加载团队
    $.ajax({
        type: "POST",
        url: "/mkmm/sales/personMainReviews/team",
        data: {},
        dataType: "json",
        success: function(data){
            var option = "";
            if(data!=null && data.length>0){
                for(var i=0;i<data.length;i++){
                    option+=('<option value="'+data[i].teamCode+'">'+data[i].teamName+'</option>');
                }
                $("#teamName").html(option);
            }
        }
    })*/
    //团队名称联动团队代码
    $("#teamName").change(function (){
            $("#teamCode").val( $(this).val());
        }
    );

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
            var cities =  $("#cityCode").select2("data");
            var brands = $("#mgmtBrands").select2("data");
            var arr1 = [];
            var arr2 =[];
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
            formData["cities"] = arr1;
            formData["brands"] = arr2;
            formData["teamCode"] = $("#teamCode").val();
            formData["teamName"] = $("#teamName option:selected").text();
            formData["personNature"]=$("#personNature").val();
            formData["personLevel"]=$("#personLevel").val();
            formData["personStatus"]=$("#personStatus").val();
            console.log("新增人员上行参数："+JSON.stringify(formData));

            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: '/mkmm/sales/personMains/modify',
                data: JSON.stringify(formData)
            }).then(function (obj) {
                // 保存失败
                if (!obj.isSuccess) {
                    layer.alert(obj.msg);
                    return;
                }
                layer.alert(obj.msg,function(){
                    window.location='/mkmm/ui/personMain/list';
                });
                $("#inputForm").resetForm();
            }).always(function () {
                $("button").attr("disabled", false);
            });
        }
    });
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
    return dateReturn;

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

//试用期日期校验
$("#personTryStartime").on("change",function (){
    var str_date = document.getElementById("personTryStartime").value;//考核时间
    var end_date = document.getElementById("personTryEndtime").value;//上岗日期
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
    var str_date = document.getElementById("personTryStartime").value;//考核时间
    var end_date = document.getElementById("personTryEndtime").value;//上岗日期
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
//         return ;
//     }
//     if(getDate(str_date)-getDate(end_date)>0){
//         $(".datepicker").datepicker({autoclose: true});
//         layer.alert("上岗日期不能早于考核时间！");
//         $("#personCheckStart").val("");
//     }
//     return ;
//
// });
// $("#personUptime").on("change",function (){
//     var str_date = document.getElementById("personCheckStart").value;//考核时间
//     var end_date = document.getElementById("personUptime").value;//上岗日期
//     if(end_date==""||end_date==null){
//         return ;
//     }
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
        layer.alert("转正日期不能早于试用期开始日期！");
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
        layer.alert("转正日期不能早于试用期结束日期！");
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
    if(getDate(str_date)-getDate(end_date)<0){
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
//电话号码验证
function isPoneAvailable(str) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    var phone = /^0\d{2,3}-?\d{7,8}$/;
    if (myreg.test(str)||phone.test(str)) {
        return true;
    } else{
        $("#"+event.target.id).val("");
        layer.alert("请输入正确的电话格式");
    }
}
//e-mail验证
function checkEMail(e) {
    var a = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if (!a.test(e)) {
        $("#personEmail").val("");
        layer.alert("请输入格式正确的 e-mail 地址！");
    }
}
