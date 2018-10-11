jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    $("#mgmtCity").select2();
    $("#mgmtBrands").select2();
    var mid = $.getUrlParam("personCode");
    // var workid = $.getUrlParam("flowId");
    $.ajax({
        type: 'POST',
        url: '/mkmm/sales/personMainReviews/reviewwatch?personCode=' + mid,
        dataType: 'json'
    }).then(function (obj) {
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
        initDataWorkFlow(mid);
        $("#teamName").val(result.teamMain.teamName)//团队名称
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
        $("#startTime").val(result.startTime);//生效时间
        console.log(  $("#startTime").val());
        //负责城市
        var cs = result.cities;
        var cityData = [];  //全部可用城市
        var selectedCities = [];   //已选中的城市
        if(cs!=null && cs.length>0) {
            for (var i = 0; i < cs.length; i++) {
                cityData.push({id: cs[i].cityCode, text: cs[i].cityName});
                selectedCities.push(cs[i].cityCode);
            }
        }
        console.log("城市:"+JSON.stringify(cityData));
        $('#mgmtCity').select2({
            data: cityData
        }).val(selectedCities).trigger('change');
        //负责品牌
        var brands = result.brands;
        var brandData=[];   //全部可用品牌
        var selectedBrands = [];    //已选中的品牌
        if(brands!=null && brands.length>0){
            for(var i=0;i<brands.length;i++){
                brandData.push({id: brands[i].brandCode, text: brands[i].brandName});
                selectedBrands.push(brands[i].brandCode);
            }
        }

        function initDate() {
            $.ajax({
                type: 'POST',
                url: '/mkmm/sales/personMainReviews/check?personCode=' + mid,
                dataType: 'json'
            }).then(function (obj) {
                var workFlows = result.workFlow;


                for (var index in workFlows) {
                    // console.log(arr[index]);
                    var arrStr = workFlows[index];
                    var type = '';
                    var trStr = '';
                    if ('01' == arrStr.type) {
                        type = '人员新增';
                    } else if ('02' == arrStr.type) {
                        type = '人员修改';
                    }
                    var level = '';
                    if ('1' == arrStr.reviewLevel) {
                        level = '一级审核';
                    } else if ('2' == arrStr.reviewLevel) {
                        level = '二级审核';
                    }
                    var status = '';
                    if ('00' == arrStr.reviewStatus) {
                        status = '不通过';
                    } else if ('04' == arrStr.reviewStatus) {
                        status = '通过';
                    } else if ('02' == arrStr.reviewStatus) {
                        status = '审核中';
                    } else if ('03' == arrStr.reviewStatus) {
                        status = '审核中';
                    } else if ('01' == arrStr.reviewStatus) {
                        status = '审核中';
                    }
                    var dateStr = '';
                    if (arrStr.modifyTime) {
                        dateStr = formatDate(arrStr.modifyTime)
                    }
                    var name = '';
                    if (arrStr.modifierName) {
                        name = formatDate(arrStr.modifyTime)
                    }
                    trStr += '<tr >';
                    trStr += '<td style="text-align:center;">' + type + '</td>';
                    trStr += '<td style="text-align:center;">' + level + '</td>';
                    trStr += '<td style="text-align:center;">' + status + '</td>';
                    trStr += '<td style="text-align:center;">' + arrStr.opinion + '</td>';
                    trStr += '<td style="text-align:center;">' + dateStr + '</td>';
                    trStr += '<td style="text-align:center;">' + name + '</td>';
                    trStr += '</tr>';
                }
                console.log(trStr);
                $("#workFlowsTableBody1").html(trStr);

            })}


        setHash();
        $("#mgmtBrands").select2({
            data: brandData
        }).val(selectedBrands).trigger('change');
    }, function (e) {
        layer.alert("查询数据失败:" + e);
    })
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
function initDataWorkFlow(personCode){
    // $("#personDiv").show();
    $("#workFlowsTable").jqGrid(
        {
            url: "/mkmm/sales/workFlows/selectWorkFlow?reviewId="+personCode,
            datatype: "json",
            mtype: 'GET',
            colModel: [
                { label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '审核类型', name: 'type', index: 'type', sortable: true, width: 150, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        var v_review_type=rowObject.type;
                        var v_html="";
                        if("01"==v_review_type){
                            v_html="新增"
                        }else if("02"==v_review_type){
                            v_html="修改"
                        }
                        return v_html;
                    }
                } ,
                { label: '审核事件id', name: 'reviewId', index: 'reviewId', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '审核级别', name: 'reviewLevel', index: 'reviewLevel', sortable: true, width: 150, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        var v_review_reviewLevel=rowObject.reviewLevel;
                        var v_html="";
                        if("1"==v_review_reviewLevel){
                            v_html="一级审核"
                        }else if("2"==v_review_reviewLevel){
                            v_html="二级审核"
                        }
                        return v_html;
                    } } ,
                { label: '审核状态', name: 'reviewStatus', index: 'reviewStatus', sortable: true, width: 150, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        var v_review_status=rowObject.reviewStatus;
                        var html="";
                        if("02"==v_review_status){
                            html="待审核"
                        }else if("00"==v_review_status){
                            html="驳回"
                        }else if("03"==v_review_status){
                            html="审核中"
                        }else if("04"==v_review_status){
                            html="审核通过"
                        }else if("01"==v_review_status){
                            html="提交审核"
                        }
                        return html;
                    }} ,
                { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center',hidden:true } ,
                { label: '审核时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        var modifyTime=rowObject.modifyTime;
                        var html= new Date(modifyTime).pattern("yyyy-MM-dd hh:mm:ss");
                        return html;
                    }
                } ,
                { label: '审核人', name: 'modifierName', index: 'modifierName', sortable: true, width: 150, align: 'center' } ,
                { label: '审核意见', name: 'opinion', index: 'opinion', sortable: true, width: 150, align: 'center' }
            ],

            height: 'auto',
            autowidth: true,
            rowNum: 100,
            rowList: [100, 200, 300],
            pager: $('#pager'),
            shrinkToFit: true,
            viewrecords: true,
            altRows: true,
            multiselect: false,
            multiboxonly: false,
            sortable: false,
            sorttype: false,
            //当从服务器返回响应时执行
            loadComplete: function (xhr) {
                var table = this;
              //  updatePagerIcons(table);
                setHash();
            }
        })
    // $("#workFlowsTable").jqGrid('navGrid', $("#pager"), {
    //     edit: false,
    //     add: false,
    //     del: false,
    //     search: false,
    //     refresh: false
    // })
    setHash();
    Date.prototype.pattern=function(fmt) {
        var o = {
            "M+" : this.getMonth()+1, //月份
            "d+" : this.getDate(), //日
            "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
            "H+" : this.getHours(), //小时
            "m+" : this.getMinutes(), //分
            "s+" : this.getSeconds(), //秒
            "q+" : Math.floor((this.getMonth()+3)/3), //季度
            "S" : this.getMilliseconds() //毫秒
        };
        var week = {
            "0" : "/u65e5",
            "1" : "/u4e00",
            "2" : "/u4e8c",
            "3" : "/u4e09",
            "4" : "/u56db",
            "5" : "/u4e94",
            "6" : "/u516d"
        };
        if(/(y+)/.test(fmt)){
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        }
        if(/(E+)/.test(fmt)){
            fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);
        }
        for(var k in o){
            if(new RegExp("("+ k +")").test(fmt)){
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            }
        }
        return fmt;
    }


}

