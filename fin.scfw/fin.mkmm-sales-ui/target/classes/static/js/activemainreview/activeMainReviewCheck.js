var formValidateConfig = {
    errorElement: 'div',
    errorClass: 'help-block',
    focusInvalid: false,
    ignore: "",
    rules: {},
    messages: {}
};
$(document).ready(function () {
    $("#inputForm").frameworkValid(formValidateConfig);

    var mid = $.getUrlParam("id");
    var mtype = $.getUrlParam("type");      //query为只读，update为允许审核

    if (mtype == 'query') {
        $("#reviewStatus").attr("disabled","true");
        $("#opinion").attr("disabled","true");
        $("#opinionDiv").hide();
        $("#btnSubmit").remove();
        setHash()
    } else {
        var user = getUserCookie();
        $("#modifierName").val(user.name);
        $("#btnSubmit").on("click", function (e) {
            e.preventDefault();
            creactObj();
        });
    }
    
    //从字典表获取金融产品、业务模式、信贷产品、营销活动、附加贷子项
    $.ajax({
        type: 'GET',
        url: "/mkmm/sales/selectCode/selectProductAll",
        dataType: 'json',
    }).then(function (obj) {
        if (!obj.isSuccess) {
            return;
        }
        var productCode;

        //营销活动
        var marketingCodeList = obj.result.marketingCodes;
        var marketingCodes = new Array();
        for (var i = 0; i < marketingCodeList.length; i++) {
            productCode = marketingCodeList[i];
            marketingCodes.push({id: productCode.value, text: productCode.label})
        }
        $("#marketingCode").select2();
        $("#marketingCode").select2('destroy').empty();
        $("#marketingCode").select2({
            data: marketingCodes
        });

        //金融产品
        var financeCodeList = obj.result.financeCodes;
        var financeProdCodes = new Array();
        for (var i = 0; i < financeCodeList.length; i++) {
            productCode = financeCodeList[i];
            financeProdCodes.push({id: productCode.value, text: productCode.label})
        }
        $("#financeProdCode").select2();
        $("#financeProdCode").select2('destroy').empty();
        $("#financeProdCode").select2({
            data: financeProdCodes
        });

        //业务模式
        var businessCodeList = obj.result.businessCodes;
        var businessCodes = new Array();
        for (var i = 0; i < businessCodeList.length; i++) {
            productCode = businessCodeList[i];
            businessCodes.push({id: productCode.value, text: productCode.label})
        }
        $("#businessCode").select2();
        $("#businessCode").select2('destroy').empty();
        $("#businessCode").select2({
            data: businessCodes
        });

        //信贷产品
        var creditCodeList = obj.result.creditCodes;
        var creditProdCodes = new Array();
        for (var i = 0; i < creditCodeList.length; i++) {
            productCode = creditCodeList[i];
            creditProdCodes.push({id: productCode.value, text: productCode.label})
        }
        $("#creditProdCode").select2();
        $("#creditProdCode").select2('destroy').empty();
        $("#creditProdCode").select2({
            data: creditProdCodes
        });

        //附加贷子项
        var additionalCodeList = obj.result.additionalCodes;
        var additionalCodes = new Array();
        for (var i = 0; i < additionalCodeList.length; i++) {
            productCode = additionalCodeList[i];
            additionalCodes.push({id: productCode.value, text: productCode.label})
        }
        $("#additionalCode").select2();
        $("#additionalCode").select2('destroy').empty();
        $("#additionalCode").select2({
            data: additionalCodes
        });
        getMessage();
    })

    function getMessage() {
        $.ajax({
            type: 'GET',
            url: "/mkmm/sales/actives/checkfind?id=" + mid,
            dataType: 'json'
        }).then(function (obj) {
            if (!obj.isSuccess) {
                layer.alert(obj.msg);
                return;
            }
            var result = obj.result;
            var appendixId = result.ativeMain.additionalId;
            $("#additionalId").val(appendixId);
            $("#btn_add_appendix").on("click",function (e) {
                window.open("http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>"+appendixId+"</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >");
            })
            $(".date-picker").datepicker({
                language: "zh-CN",
                autoclose: true,//选中之后自动隐藏日期选择框
                clearBtn: true,//清除按钮
                format: "yyyy-mm-dd"//日期格式
            });
            $("#workFlowId").val(result.workFlow.id);
            $("#reviewLevel").val(result.workFlow.reviewLevel);
            $("#areaMainCode").val(result.ativeMain.areaCode);
            $("#areaMainName").val(result.ativeMain.areaName);
            $("#activeName").val(result.ativeMain.activeName);
            $("#activeCode").val(result.ativeMain.activeCode);
            $("#patmentBegin").val(result.ativeMain.patmentBegin);
            $("#patmentEnd").val(result.ativeMain.patmentEnd);
            $("#loanAmtBegin").val(toDecimal2(result.ativeMain.loanAmtBegin));
            $("#loanAmtEnd").val(toDecimal2(result.ativeMain.loanAmtEnd));
            $("#loanTermBegin").val(result.ativeMain.loanTermBegin);
            $("#loanTermEnd").val(result.ativeMain.loanTermEnd);
            $("#activeStartime").val(formatDate(result.ativeMain.activeStartime));
            $("#activeEndtime").val(formatDate(result.ativeMain.activeEndtime));
            $("#loanStartime").val(formatDate(result.ativeMain.loanStartime));
            $("#loanEndtime").val(formatDate(result.ativeMain.loanEndtime));
            $("#carReg").val(result.ativeMain.carReg);
            $("#avtiveCriterion").val(toDecimal2(result.ativeMain.avtiveCriterion));
            $("#expectedCount").val(result.ativeMain.expectedCount);
            $("#inputDeale").val(result.ativeMain.inputDeale);
            $("#inputArea").val(result.ativeMain.inputArea);

            if (result.ativeMain.reviewStatus == '02' && mtype != 'query'){
                $.ajax({
                    type: 'GET',
                    url: "/mkmm/sales/actives/checking",
                    dataType: 'json',
                    data: {
                        id: result.ativeMain.id,
                        folowId: result.ativeMain.folowId
                    },
                    success: function (obj) {
                        //该审核被占用
                        if (!obj.isSuccess) {
                            layer.alert(obj.msg,function (){
                                history.go(-1);
                            });
                            return;
                        }
                        // $("#inputForm").resetForm();
                    }
                })
            }
            if (result.ativeMain.inputDeale == '1') {
                $("#div_activeDeale").show();
                var dealersInfo = result.ativeDealeList;
                $("#activeDealeReviewTable").html("");
                var sthead = "<thead> " +
                    "<tr> " +
                    "<th class='sorting'>经销商代码</th> " +
                    "<th class='sorting'>经销商名称</th> " +
                    "<th class='sorting'>活动上限/辆</th> " +
                    "</tr>" +
                    "</thead>";
                var srow = "<tbody>";
                for (items in dealersInfo) {
                    srow += "<tr><td name='dealerCode'>" + dealersInfo[items].dealerCode + "</td>";
                    srow += "<td name='dealerName'>" + dealersInfo[items].dealerName + "</td>";
                    if (dealersInfo[items].activeNumber) {
                        srow += "<td name='activeNumber'>" + dealersInfo[items].activeNumber + "</td></tr>";
                    } else {
                        srow += "<td name='activeNumber'></td></tr>";
                    }
                }
                srow += "</tbody>";
                $("#activeDealeReviewTable").append(sthead + srow);
                $("#div_area").hide();
            } else {
                $("#div_area").show();
                if (result.ativeMain.inputArea == '1'){
                    $("#cityDiv").hide();
                    $.ajax({
                        type: 'GET',
                        url: "/mkmm/sales/selectCode/translateCode",
                        dataType: 'json',
                        data: {
                            codeType:'Zone',codeCode:result.activeArea.areaCode
                        }
                    }).then(function (data) {
                        var areaCodeList = data.result;
                        var areaNames = '';                 //区域Name
                        for (var i = 0; i < areaCodeList.length; i++) {
                            if (i==0){
                                areaNames += areaCodeList[i].label;
                            } else {
                                areaNames += '，';
                                areaNames += areaCodeList[i].label;
                            }
                        }
                        $("#areaName").val(areaNames);
                    });
                }else {
                    $("#areaDiv").hide();
                    $.ajax({
                        type: 'GET',
                        url: "/mkmm/sales/selectCode/translateCode",
                        dataType: 'json',
                        data: {
                            codeType:'Province',codeCode:result.activeArea.provinceCode
                        }
                    }).then(function (data) {
                        var provinceCodeList = data.result;
                        var provinceNames = '';                 //省Name
                        for (var i = 0; i < provinceCodeList.length; i++) {
                            if (i==0){
                                provinceNames += provinceCodeList[i].label;
                            } else {
                                provinceNames += '，';
                                provinceNames += provinceCodeList[i].label;
                            }
                        }
                        $("#provinceName").val(provinceNames);
                    });
                    $.ajax({
                        type: 'GET',
                        url: "/mkmm/sales/selectCode/translateCode",
                        dataType: 'json',
                        data: {
                            codeType:'City',codeCode:result.activeArea.cityCode
                        }
                    }).then(function (data) {
                        var cityCodeList = data.result;
                        var cityNames = '';                 //市Name
                        for (var i = 0; i < cityCodeList.length; i++) {
                            if (i==0){
                                cityNames += cityCodeList[i].label;
                            } else {
                                cityNames += '，';
                                cityNames += cityCodeList[i].label;
                            }
                        }
                        $("#cityName").val(cityNames);
                    });
                }
                $("#div_activeDeale").hide();
            }
            setHash();

            $.ajax({
                type: 'GET',
                url: "/mkmm/sales/selectCode/translateCode",
                dataType: 'json',
                data:{
                    codeType:'CarBrand',codeCode:result.activeCar.brandsCode
                }
            }).then(function (data) {
                var brandsCodeList = data.result;
                var brandsNames = '';                 //品牌Name
                for (var i = 0; i < brandsCodeList.length; i++) {
                    if (i==0){
                        brandsNames += brandsCodeList[i].label;
                    } else {
                        brandsNames += '，';
                        brandsNames += brandsCodeList[i].label;
                    }
                }
                $("#brandsName").val(brandsNames);
            });

            $.ajax({
                type: 'GET',
                url: "/mkmm/sales/selectCode/translateCode",
                dataType: 'json',
                data:{
                    codeType:'CarBrandDetail',codeCode:result.activeCar.seriesCode
                }
            }).then(function (data) {
                var seriesCodeList = data.result;
                var seriesNames = '';                 //子品牌（车系）Name
                for (var i = 0; i < seriesCodeList.length; i++) {
                    if (i==0){
                        seriesNames += seriesCodeList[i].label;
                    } else {
                        seriesNames += '，';
                        seriesNames += seriesCodeList[i].label;
                    }
                }
                $("#seriesName").val(seriesNames);
            });

            $.ajax({
                type: 'GET',
                url: "/mkmm/sales/selectCode/translateCode",
                dataType: 'json',
                data:{
                    codeType:'CarBrandName',codeCode:result.activeCar.moderCode
                }
            }).then(function (data) {
                var moderCodeList = data.result;
                var moderNames = '';                 //车型Name
                for (var i = 0; i < moderCodeList.length; i++) {
                    if (i==0){
                        moderNames += moderCodeList[i].label;
                    } else {
                        moderNames += '，';
                        moderNames += moderCodeList[i].label;
                    }
                }
                $("#moderName").val(moderNames);
            });

            var product;
            var products = [];
            var financePro = new Array();
            var creditPro = new Array();
            products = result.activeProdList;
            if (products && products.length > 0) {
                for (var i = 0; i < products.length; i++) {
                    product = products[i];
                    if (product.prodType == '01') {              // 金融产品
                        financePro = product.prodCode.split(',');
                    } else if (product.prodType == '02') {     // 信贷产品
                        creditPro = product.prodCode.split(',');
                    }
                }
                $('#financeProdCode').select2().val(financePro).trigger('change');
                $('#creditProdCode').select2().val(creditPro).trigger('change');
            }
            if (result.activeBusiness) {
                if (result.activeBusiness.businessCode){
                    var activeBusinesses = result.activeBusiness.businessCode.split(',');
                    $('#businessCode').select2().val(activeBusinesses).trigger('change');
                }
            }
            if (result.activeMarketing) {
                if (result.activeMarketing.marketingCode){
                    var marketingCodes = result.activeMarketing.marketingCode.split(',');
                    $('#marketingCode').select2().val(marketingCodes).trigger('change');
                }
            }
            if (result.ativeMain.additionFlag == '1') {
                $("#div_addition_amt").show();
                $("#div_addition_list").show();
                $("#additionFlag").val(result.ativeMain.additionFlag);
                $("#additionAmtBegin").val(result.ativeMain.additionAmtBegin);
                $("#additionAmtEnd").val(result.ativeMain.additionAmtEnd);
                if (result.activeAdditional) {
                    var additionalCodeList = result.activeAdditional.additionalCode.split(',');
                    $('#additionalCode').select2().val(additionalCodeList).trigger('change');
                }
            } else {
                $("#div_addition_amt").hide();
                $("#div_addition_list").hide();
            }
            $("#remark").text(result.ativeMain.remark);
            $("#opinion").val("同意");

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
    }
});

/**
 * 生成唯一ID 用作影响系统ID
 * @returns {string}
 */
function createRandomId() {
    return (Math.random() * 10000000).toString(16).substr(0, 4) + '-' + (new Date()).getTime() + '-' + Math.random().toString().substr(2, 5);
}
/**
 * 页面信息对象创建
 */
function creactObj() {
    var workFlowObj = {};
    workFlowObj["id"] = $("#workFlowId").val();
    workFlowObj["reviewStatus"] = $("#reviewStatus").val();
    workFlowObj["opinion"] = $("#opinion").val().trim();
    workFlowObj["reviewLevel"] = $("#reviewLevel").val();
    workFlowObj["reviewId"] = $("#activeCode").val();
    workFlowObj["modifierName"] = $("#modifierName").val();
    console.log(JSON.stringify(workFlowObj));
    submit(workFlowObj);
}

/***
 * 提交
 */
function submit(workFlowObj) {
    var sss = $("#opinion").val().trim();
    var choose = $("#reviewStatus").val();
    if(sss == ""){
        layer.alert("审核意见不能为空！");
        return
    }
    if (choose == '04') {
        var today = getNowFormatDate();
        var deadLine = $("#activeStartime").val();
        if (compareDate(today,deadLine)){
            layer.alert("该申请已经过期，请驳回!");
            return;
        }
    }
    $("#btnSubmit").attr("disabled", true);
    $.ajax({
        url: "/mkmm/sales/actives/checksubmit",
        data: JSON.stringify(workFlowObj),
        type: "Post",
        dataType: "json",
        cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false, //必须
        success: function (obj) {
            // 保存失败
            if (!obj.isSuccess) {
                layer.alert(obj.msg);
                return;
            }
            layer.alert(obj.msg,function (){
                history.go(-1);
            });
            // $("#inputForm").resetForm();
        },
        error: function () {
        }
    });
}

//保留两位小数
function toDecimal2(x) {
    var f = parseFloat(x);
    if (isNaN(f)) {
        return '';
    }
    var f = Math.round(x*100)/100;
    var s = f.toString();
    var rs = s.indexOf('.');
    if (rs < 0) {
        rs = s.length;
        s += '.';
    }
    while (s.length <= rs + 2) {
        s += '0';
    }
    return s;
}

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