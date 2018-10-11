jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var mid = $.getUrlParam("personCode");
    var workid = $.getUrlParam("workFlowId");
    var reviewType = $.getUrlParam("reviewType");
    console.log("审核中人员:"+mid+":"+workid);
    $.ajax({
        type:'POST',
        url:'/mkmm/sales/personMainReviews/update?personCode='+mid,
        dataType:'json'
    })
    $.ajax({
        type: 'POST',
        url: '/mkmm/sales/personMainReviews/reviewing?personCode=' + mid +'&workFlowId='+workid+'&reviewType='+reviewType,
        dataType: 'json'
    }).then(function (obj) {
        console.log(obj);
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          //人员基本信息
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
        $("#teamName").val(result.teamMain.teamName);//团队名称
        $("#teamCode").val(result.personTeamReview.teamCode);//团队代码
        $("#areaCode").val(result.personTeamReview.areaCode);//归属区域代码
        $("#areaName").val(result.teamMain.areaName);//归属区域名称
        $("#personNature").html(getPersonNature(result.personTeamReview.personNature));//人员性质
        $("#startTime").val(result.personTeamReview.startTime);
        var level="";
        if("1"==result.personTeamReview.personLevel){
            level="一级";
        }
        $("#personLevel").html("<option value='"+result.personTeamReview.personLevel+"'>"+level+"</option>");//人员级别
        $("#personStatus").html(getPersonStatus(result.personTeamReview.personStatus));//人员状态
        $("#personCheckStart").val(formatDate(result.personTeamReview.personCheckStart));//考核开始时间
        $("#personUptime").val(formatDate(result.personTeamReview.personUptime));//上岗时间
        $("#personCorrectime").val(formatDate(result.personTeamReview.personCorrectime));//转正时间
        $("#personTryStartime").val(formatDate(result.personTeamReview.personTryStartime));//试用期开始时间
        $("#personTryEndtime").val(formatDate(result.personTeamReview.personTryEndtime));//试用期结束时间
        $("#personJointime").val(formatDate(result.personTeamReview.personJointime));//加入我司时间

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
        //联系信息
        $("#personAddress").val(result.personAddress);//家庭住址
        $("#personHomephone").val(result.personHomephone);//家庭电话
        $("#personWorkphone").val(result.personWorkphone);//工作电话
        $("#personPhone").val(result.personPhone);//移动电话
        $("#personEmail").val(result.personEmail);//e-mail
        $("#remark").html(result.remark);
        $("#opinion").val("同意");
         /* $("#startTime").val(result.startTime);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          */

      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })


    $("#reviewStatus").on("click", function (e) {
        var reviewStatus =$("#reviewStatus").find("option:selected").val();
        console.log(reviewStatus)
        if (reviewStatus=='04'){
            $("#opinion").val("同意");
        }else {
            $("#opinion").val("");
        }
    });


    $("#btnSubmit").on("click", function (e) {
        e.preventDefault();
 //       var flag = $("#inputForm").valid();
        $("button").attr("disabled", true);

        var $form = $("#inputForm");
        var arr = $form.serializeArray();
        var formData = {};
        /*if ($form.val()) {
            $form.trigger('change');
        }*/

        $.each(arr, function (i, item) {
            formData[item['name']] = item['value'];
        });
        console.log("审核信息:"+JSON.stringify(formData));
        var opinion = formData["opinion"];
        var reviewStatus = formData["reviewStatus"];
        opinion = encodeURI(opinion);
        if (!opinion) {
             //没有通过验证
            layer.alert("请输入审批意见");
            $("button").attr("disabled", false);
            return;
         }
        $.ajax({
            type: 'POST',
//            contentType: 'application/json',
         //需要通过两次编码
            url: '/mkmm/sales/personMainReviews/submit?reviewStatus='+reviewStatus+'&opinion='+opinion+'&personCode='+mid+'&workid='+workid,
            data: {},
            dataType:"json",
            success:function(obj){
                // 保存失败
                if (!obj.isSuccess) {
                    alert("失败");
                    layer.alert(obj.msg);
                    return;
                }else{
                    layer.alert(obj.msg,function (){
                        history.go(-1);
                    });
                }
            }

        })/*.then(function (obj) {
            // 保存失败
            if (!obj.isSuccess) {
                alert("失败");
                layer.alert(obj.msg);
                return;
            }
            layer.alert(obj.msg);
           //$("#inputForm").resetForm();
        }).always(function () {
            //$("button").attr("disabled", false);
        });*/
    });
});
