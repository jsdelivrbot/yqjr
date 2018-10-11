jQuery(function ($) {
    var brandChanged =false;    //检查品牌是否被改变
    var cityChanged =false;     //检查城市是否被改变
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
    $(".date-picker").datepicker({
        language: "zh-CN",
        autoclose: true,//选中之后自动隐藏日期选择框
        clearBtn: true,//清除按钮
        format: "yyyy-mm-dd"//日期格式
    });

    var mid = $.getUrlParam("personCode");
    // var workid = $.getUrlParam("flowId");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/personMainReviews/reviewwatch?personCode=' + mid,
        dataType: 'json'
    }).then(function (obj) {
        if (!obj.isSuccess) {
            layer.alert(obj.msg);
            return;
        }
        var result = obj.result;
        var reviewType=result.personTeamReview.reviewType//审核类型
        console.log(reviewType);
        if (reviewType=='01'){
            $("#teamName").attr("readOnly",false);
            $("#startTime").attr("readOnly",false);
        }else {
            $("#teamName").attr("readOnly",true);
            $("#startTime").attr("readOnly",true);
        }
        $("#personReviewId").val(result.id);
        $("#reviewType").val(result.personTeamReview.reviewType);
        $("#personTeamId").val(result.personTeamReview.id);
        $("#personCode").val(result.personCode);//人员代码
        $("#personName").val(result.personName);//姓名
        $("#personIdcard").val(result.personIdcard);//身份证号
        $("#personBirth").val(formatDate(result.personBirth));//出生日期
        $("#personAge").val(result.personAge);//年龄
        $("#personEthnic").val(result.personEthnic);//民族
        $("#personMarr").val(result.personMarr);//婚姻状况
        $("#personSchool").val(result.personSchool);//毕业学校
        $("#personSubject").val(result.personSubject);//专业
        $("#personEdu").val(result.personEdu);//最高学历
        $("#personEdulevel").val(result.personEdulevel);//学位
        $("#personWorktime").val(result.personWorktime);//工龄
        $("#personFirstworktime").val(formatDate(result.personFirstworktime));//参加工作时间
        //入职()信息
        $("#teamName").val(result.teamMain.teamName);//团队名称
        $("#teamCode").val(result.personTeamReview.teamCode);//团队代码
        $("#areaCode").val(result.personTeamReview.areaCode);//归属区域代码
        $("#areaName").val(result.teamMain.areaName);//归属区域名称
        $("#personNature").find("option[value = '"+result.personTeamReview.personNature+"']").attr("selected","selected");//.html(option1);人员性质
        $("#personLevel").find("option[value = '"+result.personTeamReview.personLevel+"']").attr("selected","selected");//.html("<option value='"+result.personTeam.personLevel+"'>"+result.personTeam.personLevel+"</option>");人员级别
        $("#personStatus").find("option[value = '"+result.personTeamReview.personStatus+"']").attr("selected","selected");//人员状态
        $("#personCheckStart").val(formatDate(result.personTeamReview.personCheckStart));//考核开始时间
        $("#personUptime").val(formatDate(result.personTeamReview.personUptime));//上岗时间
        $("#personCorrectime").val(formatDate(result.personTeamReview.personCorrectime));//转正时间
        $("#personTryStartime").val(formatDate(result.personTeamReview.personTryStartime));//试用期开始时间
        $("#personTryEndtime").val(formatDate(result.personTeamReview.personTryEndtime));//试用期结束时间
        $("#personJointime").val(formatDate(result.personTeamReview.personJointime));//加入我司时间
        $("#personAddress").val(result.personAddress);//家庭地址
        $("#personHomephone").val(result.personHomephone);//家庭电话
        $("#personWorkphone").val(result.personWorkphone);//工作电话
        $("#personPhone").val(result.personPhone);//移动电话
        $("#personEmail").val(result.personEmail);//e-mail
        $("#remark").val(result.remark);//备注
        $("#reviewStatus").val(result.personTeamReview.reviewStatus);//审核结果
        $("#opinion").val(result.workFlow.opinion);//审核意见
        $("#startTime").val(result.personTeamReview.startTime);//生效时间
        $("#createName").val(result.personTeamReview.createName);//创建人


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
        // if(cities!=null && cities.length>0){
        //     for(var i=0;i<cities.length;i++){
        //         arr1.push({cityCode:cities[i].id,cityName:cities[i].text});
        //     }
        // }
        var brands = result.brands;
        if(brands!=null && brands.length>0){
            for(var i=0;i<brands.length;i++){
                var option = new Option(brands[i].brandName, brands[i].brandName, true, true);
                $c_HospitalCode1.append(option);
            }
            $c_HospitalCode1.trigger('change');//使用这个方法显示到select2上.
        }
        console.log(JSON.stringify(arr2));


        $("#mgmtBrands").select2({
            ajax: {
                type:"POST",
                url: "/mkmm/sales/personMainReviews/brand",
                dataType: 'json',
                delay: 250,
                data: function (params) {
                    /*var InitData = {
                        "FiledList":[
                            {
                                "FieldName":"MaterialName",
                                "FieldOpt":"like",
                                "FieldVal":"%" + params.term.trim() + "%"
                            }
                        ]
                    };
                    return {
                        ExecType: "00",
                        PageInfo:JSON.stringify(PageInfo),
                        InitData:JSON.stringify(InitData)
                    };*/
                },
                processResults: function (data,params) {
                    params.page = params.page || 1;
                    var itemList = [];//当数据对象不是{id:0,text:'ANTS'}这种形式的时候，可以使用类似此方法创建新的数组对象
                    for(var i=0;i<data.length;i++){
                        itemList.push({id: data[i].ncarbrandid, text: data[i].ncarbrandname})
                    }
                    console.log(JSON.stringify(itemList));
                    return {
                        results: itemList
                    };
                },
                cache: true
            }
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

        // //负责城市
        // var cs = result.cities;
        // var cityData = [];  //全部可用城市
        // var selectedCities = [];   //已选中的城市
        // if(cs!=null && cs.length>0) {
        //     for (var i = 0; i < cs.length; i++) {
        //         cityData.push({id: cs[i].cityCode, text: cs[i].cityName});
        //         selectedCities.push(cs[i].cityCode);
        //     }
        // }
        // console.log("城市:"+JSON.stringify(cityData));
        // $('#mgmtCity').select2({
        //     data: cityData
        // }).val(selectedCities).trigger('change');
        // //负责品牌
        // var brands = result.brands;
        // var brandData=[];   //全部可用品牌
        // var selectedBrands = [];    //已选中的品牌
        // if(brands!=null && brands.length>0){
        //     for(var i=0;i<brands.length;i++){
        //         // $("#mgmtBrands").append(new Option("Jquery", 10001, false, true));
        //         brandData.push({id: brands[i].brandCode, text: brands[i].brandName});
        //         selectedBrands.push(brands[i].brandCode);
        //     }
        // }
        // $("#mgmtBrands").select2({
        //     data: brandData
        // }).val(selectedBrands).trigger('change');
        // $("#mgmtCity").on("change",function () {
        //     console.log("这是选中的城市数据");
        //     var citySelected = $("#mgmtCity").val();
        //     console.log(citySelected);
        //     console.log(selectedCities);
        //     if (citySelected == null){
        //         if (selectedCities.length>0) {
        //             console.log("因为城市被清空，城市被改变");
        //             cityChanged = true;
        //         }else {
        //             cityChanged = false;
        //         }
        //     } else {
        //         if (selectedCities.length != citySelected.length){
        //             console.log("因为长度变化，城市被改变");
        //             cityChanged = true;
        //         } else {
        //             for (var i = 0 ;i<selectedCities.length;i++){
        //                 if ($.inArray(selectedCities[i], citySelected) < 0) {
        //                     console.log("因为数据变化，城市被改变");
        //                     cityChanged = true;
        //                     break;
        //                 }
        //                 cityChanged = false;
        //             }
        //         }
        //     }
        //     console.log("城市是否改变了:"+cityChanged);
        // })



    //
    //     $("#mgmtBrands").on("change",function () {
    //         console.log("这是选中的品牌数据");
    //         var brandSelected = $("#mgmtBrands").val();
    //         console.log($("#mgmtBrands").val());
    //         if (brandSelected == null){
    //             if (selectedBrands.length>0) {
    //                 console.log("因为品牌被清空，品牌被改变");
    //                 brandChanged = true;
    //             }else {
    //                 brandChanged = false;
    //             }
    //         } else {
    //             if (selectedBrands.length != brandSelected.length) {
    //                 console.log("品牌被改变");
    //                 brandChanged = true;
    //             } else {
    //                 for (var i = 0; i < selectedBrands.length; i++) {
    //                     if ($.inArray(selectedBrands[i], brandSelected) < 0) {
    //                         console.log("品牌被改变");
    //                         brandChanged = true;
    //                         break;
    //                     }
    //                     brandChanged = false;
    //                 }
    //             }
    //         }
    //         console.log("品牌是否改变了:"+brandChanged);
    //     })
    //     console.log("品牌:"+JSON.stringify(selectedBrands));
    //     console.log($("#personStatus").val());
    // }, function (e) {
    //     layer.alert("查询数据失败:" + e);
     })

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

    // 加载品牌
    // $("#mgmtBrands").select2({
    //     ajax: {
    //         type:"POST",
    //         url: "/mkmm/sales/personMainReviews/brand",
    //         dataType: 'json',
    //         delay: 250,
    //         data: function (params) {},
    //         processResults: function (data,params) {
    //             params.page = params.page || 1;
    //             var itemList = [];//当数据对象不是{id:0,text:'ANTS'}这种形式的时候，可以使用类似此方法创建新的数组对象
    //             for(var i=0;i<data.length;i++){
    //                 itemList.push({id: data[i].ncarbrandid, text: data[i].ncarbrandname})
    //             }
    //             return {
    //                 results: itemList
    //             };
    //         },
    //         cache: true
    //     }
    // });


    $("#btnSubmit").on("click", function (e) {
        e.preventDefault();
        $("#personStatus").attr("disabled",false);

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
            var arr1 = [];var arr2 =[];
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

            formData["teamName"] = $("#teamName").val();
            formData["brandChanged"] = brandChanged;
            formData["cityChanged"] = cityChanged;
            console.log("修改人员上行参数："+JSON.stringify(formData));

            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: '/mkmm/sales/personMainReviews/processmodifysubmit',
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
});


$(".datepicker").datepicker({
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
        if(ui.item==null&&$("#teamName").val()==null){
            $("#teamCode").val("");
        }
    }
});


function isPoneAvailable(str) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(str)) {
        console.log(event.target.id)
        $("#"+event.target.id).val("");
        layer.alert("请输入正确的电话格式");
    } else {
        return true;
    }
}

function checkEMail(e) {
    var a = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if (!a.test(e)) {
        $("#personEmail").val("");
        layer.alert("请输入格式正确的 e-mail 地址！");
    }
}


