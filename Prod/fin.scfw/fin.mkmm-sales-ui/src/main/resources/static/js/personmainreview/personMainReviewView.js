jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("personCode");
    $.ajax({
        type: 'POST',
        url: '/mkmm/sales/personMainReviews/viewing?personCode=' + mid,
        dataType: 'json'
    }).then(function (obj) {
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
        $("#startTime").val(result.personTeamReview.startTime);
        $("#personFirstworktime").val(formatDate(result.personFirstworktime));//参加工作时间
        //入职()信息
        $("#teamName").val(result.teamMain.teamName);//团队名称
        $("#teamCode").val(result.personTeamReview.teamCode);//团队代码
        $("#areaCode").val(result.personTeamReview.areaCode);//归属区域代码
        $("#areaName").val(result.teamMain.areaName);//归属区域名称
        $("#personNature").val(result.personTeamReview.personNature=="0"?"团队负责人":"销售经理");//人员性质
        $("#personLevel").val(result.personTeamReview.personLevel);//人员级别
        $("#personStatus").val(result.personTeamReview.personStatus=="0"?"无效":(result.personTeamReview.personStatus=="1"?"有效":"注销"));//人员状态
        $("#personCheckStart").val(formatDate(result.personTeamReview.personCheckStart));//考核开始时间
        $("#personUptime").val(formatDate(result.personTeamReview.personUptime));//上岗时间
        $("#personCorrectime").val(formatDate(result.personTeamReview.personCorrectime));//转正时间
        $("#personTryStartime").val(formatDate(result.personTeamReview.personTryStartime));//试用期开始时间
        $("#personTryEndtime").val(formatDate(result.personTeamReview.personTryEndtime));//试用期结束时间
        $("#personJointime").val(formatDate(result.personTeamReview.personJointime));//加入我司时间
        checkworlflow(result.personCode);
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
        $("#personEmail").val(result.personEmail);//e-mail
        $("#remark").html(result.remark);

      //
      //   var workFlows=result.workFlow;
      //
      //
      //   for(var index in workFlows){
      //       // console.log(arr[index]);
      //       var arrStr = workFlows[index];
      //       var type = '';
      //       var trStr='';
      //       if('01' == arrStr.type ){
      //           type = '人员新增';
      //       } else if ('02' == arrStr.type ){
      //           type = '人员修改';
      //       }
      //       var level = '';
      //       if('1' == arrStr.reviewLevel ){
      //           level = '一级审核';
      //       } else if ('2' == arrStr.reviewLevel){
      //           level = '二级审核';
      //       }
      //       var status = '';
      //       if('00' == arrStr.reviewStatus ){
      //           status = '不通过';
      //       } else if ('04' == arrStr.reviewStatus){
      //           status = '通过';
      //       }else if ('02' == arrStr.reviewStatus){
      //           status = '审核中';
      //       }else if ('03' == arrStr.reviewStatus){
      //           status = '审核中';
      //       }else if ('01' == arrStr.reviewStatus){
      //           status = '审核中';
      //       }
      //       var dateStr='';
      //       if(arrStr.modifyTime){
      //           dateStr=formatDate(arrStr.modifyTime)
      //       }
      //       var name='';
      //       if(arrStr.modifierName){
      //           name=formatDate(arrStr.modifyTime)
      //       }
      //       trStr += '<tr >';
      //       trStr += '<td style="text-align:center;">' + type + '</td>';
      //       trStr += '<td style="text-align:center;">' + level + '</td>';
      //       trStr += '<td style="text-align:center;">' + status + '</td>';
      //       trStr += '<td style="text-align:center;">' + arrStr.opinion + '</td>';
      //       trStr += '<td style="text-align:center;">' +dateStr+'</td>';
      //       trStr += '<td style="text-align:center;">' + name+ '</td>';
      //       trStr += '</tr>';
      //   }
      //   console.log(trStr);
      //   $("#workFlowsTableBody1").html(trStr);
      // }, function (e) {
      //     layer.alert("查询数据失败:" + e);
       })
});

function checkworlflow(personCode){

    $.ajax({
        type: 'POST',
        url: '/mkmm/sales/personMainReviews/reviewwatch?personCode=' + personCode,
        dataType: 'json'
    }).then(function(obj){
        var result = obj.result;
        $("#reviewStatus").val(result.personTeamReview.reviewStatus);//审核结果
        $("#opinion").val(result.workFlow.opinion);//审核意见
    })
}