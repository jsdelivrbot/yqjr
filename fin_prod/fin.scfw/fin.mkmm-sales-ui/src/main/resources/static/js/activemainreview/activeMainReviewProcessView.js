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
            $("#btn_add_appendix").on("click",function (e) {
                window.open("http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>"+appendixId+"</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >");
            })
            $(".date-picker").datepicker({
                language: "zh-CN",
                autoclose: true,//选中之后自动隐藏日期选择框
                clearBtn: true,//清除按钮
                format: "yyyy-mm-dd"//日期格式
            });
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
            if (products != null && products.length > 0) {
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
            if (result.activeBusiness != null) {
                var activeBusinesses = result.activeBusiness.businessCode.split(',');
                $('#businessCode').select2().val(activeBusinesses).trigger('change');
            }
            if (result.activeMarketing != null) {
                var marketingCodes = result.activeMarketing.marketingCode.split(',');
                $('#marketingCode').select2().val(marketingCodes).trigger('change');
            }
            if (result.ativeMain.additionFlag == '1') {
                $("#div_addition_amt").show();
                $("#div_addition_list").show();
                $("#additionFlag").val(result.ativeMain.additionFlag);
                $("#additionAmtBegin").val(result.ativeMain.additionAmtBegin);
                $("#additionAmtEnd").val(result.ativeMain.additionAmtEnd);
                if (result.activeAdditional != null) {
                    var additionalCodeList = result.activeAdditional.additionalCode.split(',');
                    $('#additionalCode').select2().val(additionalCodeList).trigger('change');
                }
            } else {
                $("#div_addition_amt").hide();
                $("#div_addition_list").hide();
            }
            $("#remark").text(result.ativeMain.remark);
            // $("#reviewStatus").val(result.workFlow.reviewStatus);
            // $("#opinion").val(result.workFlow.opinion);
            if (result.workFlow != null && result.workFlow != 'undefined') {
                initDataWorkFlow(result.workFlow.reviewId);
            }
        }, function (e) {
            layer.alert("查询数据失败:" + e);
        })
    }
});
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

function initDataWorkFlow(reviewId){
    $("#activeWorkFlowTable").jqGrid(
        {
            url: "/mkmm/sales/workFlows/selectWorkFlow?reviewId="+reviewId,
            datatype: "json",
            mtype: 'GET',
            colModel: [
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
                    }
                } ,
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
                    }
                } ,
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
            rowNum: 10,
            rowList: [10, 20, 30],
            pager: $("#pager"),
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
                updatePagerIcons(table);
                setHash();
            }
        })
    $("#activeWorkFlowTable").jqGrid('navGrid', $("#pager"), {
        edit: false,
        add: false,
        del: false,
        search: false,
        refresh: false
    })
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

function updatePagerIcons(table) {
    var replacement =
        {
            'ui-icon-seek-first': 'ace-icon fa fa-angle-double-left bigger-140',
            'ui-icon-seek-prev': 'ace-icon fa fa-angle-left bigger-140',
            'ui-icon-seek-next': 'ace-icon fa fa-angle-right bigger-140',
            'ui-icon-seek-end': 'ace-icon fa fa-angle-double-right bigger-140'
        };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
    });
}