$(document).ready(function () {
    var activeCode = $.getUrlParam("activeCode");

    $("#brandsCode").select2();
    $("#seriesCode").select2();
    $("#moderCode").select2();
    $("#financeProdCode").select2();
    $("#businessCode").select2();
    $("#creditProdCode").select2();
    $("#marketingCode").select2();
    $("#additionalCode").select2();

    $.ajax({
        type: 'GET',
        url: "/mkmm/sales/selectCode/selectProductAll",
        dataType: 'json'
    }).then(function (obj) {
        var productCode;

        //营销活动
        var marketingCodeList = obj.result.marketingCodes;
        var marketingCodes = new Array();
        for (var i = 0; i < marketingCodeList.length; i++) {
            productCode = marketingCodeList[i];
            marketingCodes.push({id: productCode.value, text: productCode.label})
        }
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
        $("#additionalCode").select2('destroy').empty();
        $("#additionalCode").select2({
            data: additionalCodes
        });

        func(activeCode);
    });


});
function func(activeCode) {
    $.ajax({
        url: "/mkmm/sales/activeAlls/queryActive?activeCode="+activeCode,
        type: "GET",
        dataType: "json"
    }).then(function (obj) {
        // 查询失败
        if (!obj.isSuccess) {
            layer.alert(obj.msg);
            return;
        }
        var result = obj.result;
        // console.log(result);
        var activeMain = result.activeMain;
        var activeArea = result.activeArea;
        var activeDealers = result.activeDealeList;
        var activeCar = result.activeCar;
        var activeProds = result.activeProdList;
        var activeAddition = result.activeAdditional;
        var activeMarketing = result.activeMarketing;
        var activeBusiness = result.activeBusiness;
        var reachRate = result.reachRate;
        var actualTurnoverCount = result.actualTurnoverCount;
        var maxBillFee = result.maxBillFee;
        var activeAreaCode = result.activeAreaCode;
        $('#areaName').val(activeMain.areaName);
        $('#reachRate').val(reachRate);
        $('#actualTurnoverCount').val(actualTurnoverCount);
        $('#maxBillFee').val(maxBillFee);

        viewActiveMain(activeMain,activeArea);
        viewActiveDealers(activeDealers);
        viewActiveCar(activeCar);
        viewActiveProds(activeProds);
        viewActiveAddition(activeAddition);
        viewActiveMarketing(activeMarketing);
        viewActiveBusiness(activeBusiness);

        $.ajax({
            type: 'GET',
            url: "/mkmm/sales/selectCode/translateCode",
            dataType: 'json',
            data: {
                codeType:'CarBrand',codeCode:result.activeCar.brandsCode
            }
        }).then(function (data) {
            var brandsCodeList = data.result;
            for (var i = 0; i < brandsCodeList.length; i++) {
                $("#brandsCode").append("<option value='"+brandsCodeList[i].value+"' selected>"+brandsCodeList[i].label+"</option>");
            }
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
        });

        $.ajax({
            type: 'GET',
            url: "/mkmm/sales/selectCode/translateCode",
            dataType: 'json',
            data: {
                codeType:'CarBrandDetail',codeCode:result.activeCar.seriesCode
            }
        }).then(function (data) {
            var seriesCodeList = data.result;
            for (var i = 0; i < seriesCodeList.length; i++) {
                $("#seriesCode").append("<option value='"+seriesCodeList[i].value+"' selected>"+seriesCodeList[i].label+"</option>");
            }
            $("#seriesCode").select2({
                ajax: {
                    type: 'GET',
                    url: "/mkmm/sales/selectCode/CarBrandDetail",
                    dataType: 'json',
                    data: function (params) {
                        var brandsCodeList = $("#brandsCode").select2("data");
                        var brandsCodes = '';
                        for (var i=0;i<brandsCodeList.length;i++) {
                            if (i == 0){
                                brandsCodes += brandsCodeList[i].id
                            } else {
                                brandsCodes += ','
                                brandsCodes += brandsCodeList[i].id
                            }
                        }
                        return {
                            isUpCode:'1',upCode:brandsCodes}
                    },
                    processResults: function (data) {
                        var seriesInfos = data.result;
                        var seriesInfo = new Array();           //子品牌（车系）
                        for (var i = 0; i < seriesInfos.length; i++) {
                            seriesInfo.push({id: seriesInfos[i].value, text: seriesInfos[i].label})
                        }
                        return{
                            results: seriesInfo
                        };
                    },
                    cache: true,
                }
            })
        });

        $.ajax({
            type: 'GET',
            url: "/mkmm/sales/selectCode/translateCode",
            dataType: 'json',
            data: {
                codeType:'CarBrandName',codeCode:result.activeCar.moderCode
            }
        }).then(function (data) {
            var moderCodeList = data.result;
            for (var i = 0; i < moderCodeList.length; i++) {
                $("#moderCode").append("<option value='"+moderCodeList[i].value+"' selected>"+moderCodeList[i].label+"</option>");
            }
            $("#moderCode").select2({
                ajax: {
                    type: 'GET',
                    url: "/mkmm/sales/selectCode/CarBrandName",
                    dataType: 'json',
                    data: function (params) {
                        var seriesCodeList = $("#seriesCode").select2("data");
                        var seriesCodes = '';
                        for (var i=0;i<seriesCodeList.length;i++) {
                            if (i == 0){
                                seriesCodes += seriesCodeList[i].id
                            } else {
                                seriesCodes += ','
                                seriesCodes += seriesCodeList[i].id
                            }
                        }
                        return {
                            isUpCode:'1',upCode:seriesCodes}
                    },
                    processResults: function (data) {
                        var moderInfos = data.result;
                        var moderInfo = new Array();           //车型
                        for (var i = 0; i < moderInfos.length; i++) {
                            moderInfo.push({id: moderInfos[i].value, text: moderInfos[i].label})
                        }
                        return{
                            results: moderInfo
                        };
                    },
                    cache: true,
                }
            })
        });
        setHash();
    }, function (e) {
        layer.alert("查询数据失败:" + e);
    })
}
function viewActiveMain(activeMain,activeArea) {
    $('#activeCode').val(activeMain.activeCode);
    $('#activeName').val(activeMain.activeName);
    $('#patmentBegin').val(activeMain.patmentBegin);
    $('#patmentEnd').val(activeMain.patmentEnd);
    $('#loanAmtBegin').val(toDecimal2(activeMain.loanAmtBegin));
    $('#loanAmtEnd').val(toDecimal2(activeMain.loanAmtEnd));
    $('#loanTermBegin').val(activeMain.loanTermBegin);
    $('#loanTermEnd').val(activeMain.loanTermEnd);
    $('#activeStartime').val(new Date(activeMain.activeStartime).pattern("yyyy-MM-dd"));
    $('#activeEndtime').val(new Date(activeMain.activeEndtime).pattern("yyyy-MM-dd"));
    $('#loanStartime').val(new Date(activeMain.loanStartime).pattern("yyyy-MM-dd"));
    $('#loanEndtime').val(new Date(activeMain.loanEndtime).pattern("yyyy-MM-dd"));
    $('#carReg').val(activeMain.carReg);
    $('#avtiveCriterion').val(toDecimal2(activeMain.avtiveCriterion));
    $('#expectedCount').val(activeMain.expectedCount);
    $('#additionAmtBegin').val(activeMain.additionAmtBegin);
    $('#additionAmtEnd').val(activeMain.additionAmtEnd);
    $('#additionFlag').val(activeMain.additionFlag);
    $('#inputArea').val(activeMain.inputArea);
    $('#remark').val(activeMain.remark);

    var appendixId = activeMain.additionalId;

    $("#btn_add_appendix").on("click",function (e) {
        window.open("http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>"+appendixId+"</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >");
    })

    if('1' == activeMain.inputDeale) {
        $("#div_activeDeale").show();
        $('#div_area').hide();
    } else {
        $("#div_activeDeale").hide();
        if (activeArea != null && activeArea != 'undefined') {
            if (activeMain.inputArea == '1'){
                $("#provinceDiv").hide();
                $("#cityDiv").hide();
                $.ajax({
                    type: 'GET',
                    url: "/mkmm/sales/selectCode/translateCode",
                    dataType: 'json',
                    data: {
                        codeType:'Zone',codeCode:activeArea.areaCode
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
                    $("#areaCode").val(areaNames);
                });
            } else if (activeMain.inputArea == '0') {
                $("#areaDiv").hide();
                $.ajax({
                    type: 'GET',
                    url: "/mkmm/sales/selectCode/translateCode",
                    dataType: 'json',
                    data: {
                        codeType:'Province',codeCode:activeArea.provinceCode
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
                    $("#provinceCode").val(provinceNames);
                });
                $.ajax({
                    type: 'GET',
                    url: "/mkmm/sales/selectCode/translateCode",
                    dataType: 'json',
                    data: {
                        codeType:'City',codeCode:activeArea.cityCode
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
                    $("#cityCode").val(cityNames);
                });
            }
        }
    }
    if('1' == activeMain.additionFlag){
        $("#div_addition_amt").show();
        $("#div_addition_list").show();
    } else {
        $("#div_addition_amt").hide();
        $("#div_addition_list").hide();
    }

}

function viewActiveDealers(activeDealers) {
    var trStr = '';
    if (activeDealers.length > 0) {
        trStr += '<tr>';
        trStr += '<th style="text-align:center;">经销商代码</th>';
        trStr += '<th style="text-align:center;">经销商名称</th>';
        trStr += '<th style="text-align:center;">活动上限/辆</th>';
        trStr += '</tr>';

        for (var index in activeDealers) {
            var arrStr = activeDealers[index];
            var number = arrStr.activeNumber;
            if(null == number || ''== number || 'undefind'== number ){
                number = '';
            }
            trStr += '<tr >';
            trStr += '<td style="text-align:center;">' + arrStr.dealerCode + '</td>';
            trStr += '<td style="text-align:center;">' + arrStr.dealerName + '</td>';
            trStr += '<td style="text-align:center;">' + number + '</td>';
            trStr += '</tr>';
        }
        $("#activeDealeTable").html(trStr);
    }
}

function viewActiveCar(activeCar) {
    if(null != activeCar) {
        var brandsCode =activeCar.brandsCode;
        var seriesCode =activeCar.seriesCode;
        var moderCode =activeCar.moderCode;
        var brandsCodes = brandsCode.split(',');
        $('#brandsCode').select2().val(brandsCodes).trigger('change');
        var seriesCodes = seriesCode.split(',');
        $('#seriesCode').select2().val(seriesCodes).trigger('change');
        var moderCodes = moderCode.split(',');
        $('#moderCode').select2().val(moderCodes).trigger('change');

    }
}

function viewActiveProds(activeProds) {
    var product;
    var financeProdCodes = new Array();
    var creditProdCodes = new Array();
    if (activeProds != null && activeProds.length > 0) {
        for (var i = 0 ; i<activeProds.length; i++){
            product = activeProds[i];
            if (product.prodType == '01'){
                // 金融产品
                financeProdCodes = product.prodCode.split(',');
                // console.log(financeProdCodes)
            } else if (product.prodType == '02') {     // 信贷产品
                creditProdCodes = product.prodCode.split(',');
            }
        }

        $("#financeProdCode").select2().val(financeProdCodes).trigger('change');
        $("#creditProdCode").select2().val(creditProdCodes).trigger('change');

    }

}

function viewActiveAddition(activeAddition) {
    // console.log(activeAddition)
    if(null != activeAddition) {
        var additionalCodes = activeAddition.additionalCode.split(',');
        $('#additionalCode').select2().val(additionalCodes).trigger('change');
    }
}

function viewActiveMarketing(activeMarketing) {
    // console.log(activeMarketing)
    if(null != activeMarketing) {
        var marketingCodes = activeMarketing.marketingCode.split(',');
        // console.log(marketingCodes)
        $('#marketingCode').select2().val(marketingCodes).trigger('change');
    }
}

function viewActiveBusiness(activeBusiness) {
    // console.log(activeBusiness)
    if(null != activeBusiness) {
        var businessCodes = activeBusiness.businessCode.split(',');
        $('#businessCode').select2().val(businessCodes).trigger('change');
    }
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