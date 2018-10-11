jQuery(function ($) {
    $("#inputForm").frameworkValid({
    });


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
        $("#teamName").val(result.personTeam.teamName);//团队名称
        $("#teamCode").val(result.personTeam.teamCode);//团队代码
        $("#areaCode").val(result.personTeam.areaCode);//归属区域代码
        $("#areaName").val(result.teamMain.areaName);//归属区域名称
        if (result.personTeam.personNature=="1"){
            $("#personNature").val("销售经理");
        }else if (result.personTeam.personNature=="0"){
            $("#personNature").val("团队负责人");
        }
        $("#personStatus").find("option[value = '"+result.personTeam.personStatus+"']").attr("selected","selected");//人员状态
        if (result.personTeam.personStatus=="0"){
            $("#personStatus").val("无效");
        }else if (result.personTeam.personStatus=="1"){
            $("#personStatus").val("有效");
        }else if (result.personTeam.personStatus=="2"){
            $("#personStatus").val("注销");
        }
        $("#personCheckStart").val(formatDate(result.personTeam.personCheckStart));//考核开始时间
        $("#personUptime").val(formatDate(result.personTeam.personUptime));//上岗时间
        $("#personCorrectime").val(formatDate(result.personTeam.personCorrectime));//转正时间
        $("#personTryStartime").val(formatDate(result.personTeam.personTryStartime));//试用期开始时间
        $("#personTryEndtime").val(formatDate(result.personTeam.personTryEndtime));//试用期结束时间
        $("#personJointime").val(formatDate(result.personTeam.personJointime));//加入我司时间
        $("#startTime").val(result.personTeam.startTime);//生效时间&nbsp;
        //负责城市
        var cs = result.cities;

        var data = [];
        if(cs!=null && cs.length>0) {
            for (var i = 0; i < cs.length; i++) {
                data.push(cs[i].cityName);
            }
        }
        console.log("城市:"+JSON.stringify(data));
        $('#mgmtCity').val(data);
        //负责品牌
        var brands = result.brands;
        data=[];
        if(brands!=null && brands.length>0){
            for(var i=0;i<brands.length;i++){
                data.push(brands[i].brandName);
            }
        }
        $("#mgmtBrands").val(data);
        console.log("品牌:"+JSON.stringify(data));
        //联系信息
        $("#personAddress").val(result.personAddress);//家庭住址
        $("#personHomephone").val(result.personHomephone);//家庭电话
        $("#personWorkphone").val(result.personWorkphone);//工作电话
        $("#personPhone").val(result.personPhone);//移动电话
        $("#personEmail").val(result.perrsonEmail);//e-mail
        $("#remark").html(result.personTeam.remark);//e-mail
    }, function (e) {
        layer.alert("查询数据失败:" + e);
    })

    //加载团队
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
    })
    //团队名称联动团队代码
    $("#teamName").change(function (){
            $("#teamCode").val( $(this).val());
        }
    );

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
});