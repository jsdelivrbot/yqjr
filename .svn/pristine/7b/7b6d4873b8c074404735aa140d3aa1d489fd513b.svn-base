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
    var activeCodeParam = $.getUrlParam("code");    //从Url中获取参数

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

        //营销活动，从字典表加载option
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
        $("#marketingCode").on("select2:select",function(e){
            setHash();      //若Select2选项过多导致换行，通知页面更新高度
        })
        //金融产品，从字典表加载option
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
        $("#financeProdCode").on("select2:select",function(e){
            setHash();
        })
        //业务模式，从字典表加载option
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
        $("#businessCode").on("select2:select",function(e){
            setHash();
        })
        //信贷产品，从字典表加载option
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
        $("#creditProdCode").on("select2:select",function(e){
            setHash();
        })
        //附加贷子项，从字典表加载option
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
        $("#additionalCode").on("select2:select",function(e){
            setHash();
        })
        getMessage();
    })


    function getMessage() {
        $.ajax({
            type: 'GET',
            url: "/mkmm/sales/actives/modifyfind?code=" + activeCodeParam,
            dataType: 'json'
        }).then(function (obj) {
            if (!obj.isSuccess) {
                layer.alert(obj.msg);
                return;
            }
            var result = obj.result;
            var seriesBigList = '';                             //当品牌不为全部，车系为全部时，此值为已选品牌的所有车系
            var ativeMainResult = result.ativeMain!=null?result.ativeMain:{};                           //活动主表
            var activeAdditionalResult = result.activeAdditional!=null?result.activeAdditional:{};     //附加贷
            var activeAreaResult = result.activeArea!=null?result.activeArea:{};                        //区域
            var activeBusinessResult = result.activeBusiness!=null?result.activeBusiness:{};           //业务
            var activeCarResult = result.activeCar!=null?result.activeCar:{};                           //品牌
            var activeMarketingResult = result.activeMarketing!=null?result.activeMarketing:{};        //营销活动
            var activeProdListResult = result.activeProdList!=null?result.activeProdList:[];            //金融产品和信贷产品
            var ativeDealeListResult = result.ativeDealeList!=null?result.ativeDealeList:[];            //经销商
            $(".date-picker").datepicker({
                language: "zh-CN",
                autoclose: true,//选中之后自动隐藏日期选择框
                clearBtn: true,//清除按钮
                format: "yyyy-mm-dd"//日期格式
            });
            var appendixId = ativeMainResult.additionalId;
            console.log(appendixId);
            if (appendixId == null || appendixId == "undefined") {
                console.log("该条数据的随机ID为null")
                appendixId = createRandomId();
            }
            $("#additionalId").val(appendixId);
            $("#mid").val(ativeMainResult.id);
            $("#areaMainCode").val(ativeMainResult.areaCode);
            $("#areaMainName").val(ativeMainResult.areaName);
            $("#activeName").val(ativeMainResult.activeName);
            $("#activeCode").val(ativeMainResult.activeCode);
            $("#patmentBegin").val(ativeMainResult.patmentBegin);
            $("#patmentEnd").val(ativeMainResult.patmentEnd);
            $("#loanAmtBegin").val(ativeMainResult.loanAmtBegin);
            $("#loanAmtEnd").val(ativeMainResult.loanAmtEnd);
            $("#loanTermBegin").val(ativeMainResult.loanTermBegin);
            $("#loanTermEnd").val(ativeMainResult.loanTermEnd);
            $("#activeStartime").val(formatDate(ativeMainResult.activeStartime));
            $("#activeEndtime").val(formatDate(ativeMainResult.activeEndtime));
            $("#loanStartime").val(formatDate(ativeMainResult.loanStartime));
            $("#loanEndtime").val(formatDate(ativeMainResult.loanEndtime));
            $("#carReg").val(ativeMainResult.carReg);
            $("#avtiveCriterion").val(ativeMainResult.avtiveCriterion);
            $("#expectedCount").val(ativeMainResult.expectedCount);
            $("#inputDeale").val(ativeMainResult.inputDeale);

            if (ativeMainResult.inputDeale == '1') {//若为经销商导入，则显示经销商Div，隐藏活动区域Div
                $("#div_activeDeale").show();
                var dealersInfo = ativeDealeListResult;
                $("#activeDealeReviewTable").html("");
                var sthead = "<thead> " +
                    "<tr> " +
                    "<th class='sorting'>经销商编码</th> " +
                    "<th class='sorting'>经销商名称</th> " +
                    "<th class='sorting'>活动上线数量</th> " +
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
                $("#areaCode").select2({
                    ajax: {
                        type: 'GET',
                        url: "/mkmm/sales/selectCode/Zone",
                        dataType: 'json',
                        data: {
                            isUpCode: '0'
                        },
                        processResults: function (data) {
                            var areaInfos = data.result;
                            var areaInfo = new Array();           //区域
                            for (var i = 0; i < areaInfos.length; i++) {
                                areaInfo.push({id: areaInfos[i].value, text: areaInfos[i].label})
                            }
                            return{
                                results: areaInfo
                            };
                        },
                        cache: true,
                    }
                });
                $("#areaCode").on("select2:select",function(e){
                    var data = $(this).val();
                    if (data != null && data[0]=="00"){
                        console.log("区域选择了全部")
                        $("#areaCode").val(["00","全部"]).trigger('change')
                    }
                    setHash()
                })
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
                $("#provinceCode").on("select2:select",function(e){
                    $("#cityCode").select2("val","")
                    var data = $(this).val();
                    if (data != null && data[0]=="00"){
                        console.log("省份选择了全部")
                        $("#provinceCode").val(["00","全部"]).trigger('change')
                    }
                    setHash()
                })
                $("#cityCode").select2({
                    language: {
                        noResults: function (params) {
                            return "请先选择省份";
                        }
                    },
                    ajax: {
                        type: 'GET',
                        url: "/mkmm/sales/selectCode/City",
                        dataType: 'json',
                        data: function (params) {
                            var provinceCodes = $("#provinceCode").select2("data");
                            var upCodes = '';
                            var isUpCodes = '1';
                            for (var i=0;i<provinceCodes.length;i++) {
                                if (provinceCodes[i].id == '00'){
                                    isUpCodes = '0'
                                }
                                if (i == 0){
                                    upCodes += provinceCodes[i].id
                                } else {
                                    upCodes += ','
                                    upCodes += provinceCodes[i].id
                                }
                            }
                            return {
                                isUpCode:isUpCodes,upCode:upCodes}
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
                $("#cityCode").on("select2:select",function(e){
                    var data = $(this).val();
                    if (data != null && data[0]=="00"){
                        console.log("城市选择了全部")
                        $("#cityCode").val(["00","全部"]).trigger('change')
                    }
                    setHash()
                })
                $("#div_area").hide();
            } else {
                $("#div_area").show();
                $.ajax({
                    type: 'GET',
                    url: "/mkmm/sales/selectCode/translateCode",
                    dataType: 'json',
                    data: {
                        codeType:'Zone',codeCode:activeAreaResult.areaCode
                    }
                }).then(function (data) {
                    var areaCodeList = data.result;
                    for (var i = 0; i < areaCodeList.length; i++) {
                        $("#areaCode").append("<option value='"+areaCodeList[i].value+"' selected>"+areaCodeList[i].label+"</option>");
                    }
                    $("#areaCode").select2({
                        ajax: {
                            type: 'GET',
                            url: "/mkmm/sales/selectCode/Zone",
                            dataType: 'json',
                            data: {
                                isUpCode: '0'
                            },
                            processResults: function (data) {
                                var areaInfos = data.result;
                                var areaInfo = new Array();           //区域
                                for (var i = 0; i < areaInfos.length; i++) {
                                    areaInfo.push({id: areaInfos[i].value, text: areaInfos[i].label})
                                }
                                return{
                                    results: areaInfo
                                };
                            },
                            cache: true,
                        }
                    });
                    $("#areaCode").on("select2:select",function(e){
                        var data = $(this).val();
                        if (data != null && data[0]=="00"){
                            console.log("区域选择了全部")
                            $("#areaCode").val(["00","全部"]).trigger('change')
                        }
                        setHash()
                    })
                });

                $.ajax({
                    type: 'GET',
                    url: "/mkmm/sales/selectCode/translateCode",
                    dataType: 'json',
                    data: {
                        codeType:'Province',codeCode:activeAreaResult.provinceCode
                    }
                }).then(function (data) {
                    var provinceCodeList = data.result;
                    for (var i = 0; i < provinceCodeList.length; i++) {
                        $("#provinceCode").append("<option value='"+provinceCodeList[i].value+"' selected>"+provinceCodeList[i].label+"</option>");
                    }
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
                    $("#provinceCode").on("select2:select",function(e){
                        $("#cityCode").select2("val","")
                        var data = $(this).val();
                        if (data != null && data[0]=="00"){
                            console.log("省份选择了全部")
                            $("#provinceCode").val(["00","全部"]).trigger('change')
                        }
                        setHash()
                    })
                });

                $.ajax({
                    type: 'GET',
                    url: "/mkmm/sales/selectCode/translateCode",
                    dataType: 'json',
                    data: {
                        codeType:'City',codeCode:activeAreaResult.cityCode
                    }
                }).then(function (data) {
                    var cityCodeList = data.result;
                    for (var i = 0; i < cityCodeList.length; i++) {
                        $("#cityCode").append("<option value='"+cityCodeList[i].value+"' selected>"+cityCodeList[i].label+"</option>");
                    }
                    $("#cityCode").select2({
                        language: {
                            noResults: function (params) {
                                return "请先选择省份";
                            }
                        },
                        ajax: {
                            type: 'GET',
                            url: "/mkmm/sales/selectCode/City",
                            dataType: 'json',
                            data: function (params) {
                                var provinceCodes = $("#provinceCode").select2("data");
                                var upCodes = '';
                                var isUpCodes = '1';
                                for (var i=0;i<provinceCodes.length;i++) {
                                    if (provinceCodes[i].id == '00'){
                                        isUpCodes = '0'
                                    }
                                    if (i == 0){
                                        upCodes += provinceCodes[i].id
                                    } else {
                                        upCodes += ','
                                        upCodes += provinceCodes[i].id
                                    }
                                }
                                return {
                                    isUpCode:isUpCodes,upCode:upCodes}
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
                    $("#cityCode").on("select2:select",function(e){
                        var data = $(this).val();
                        if (data != null && data[0]=="00"){
                            console.log("城市选择了全部")
                            $("#cityCode").val(["00","全部"]).trigger('change')
                        }
                        setHash()
                    })
                });
            $("#div_activeDeale").hide();
            }

            setHash();

            $.ajax({
                type: 'GET',
                url: "/mkmm/sales/selectCode/translateCode",
                dataType: 'json',
                data: {
                    codeType:'CarBrand',codeCode:activeCarResult.brandsCode
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
                $("#brandsCode").on("select2:select",function(e){
                    $("#seriesCode").select2("val","")
                    $("#moderCode").select2("val","")
                    var data = $(this).val();
                    if (data != null && data[0]=="00"){
                        console.log("品牌选择了全部")
                        $("#brandsCode").val(["00","全部"]).trigger('change')
                    }
                    setHash()
                })
            });

            $.ajax({
                type: 'GET',
                url: "/mkmm/sales/selectCode/translateCode",
                dataType: 'json',
                data: {
                    codeType:'CarBrandDetail',codeCode:activeCarResult.seriesCode
                }
            }).then(function (data) {
                var seriesCodeList = data.result;
                for (var i = 0; i < seriesCodeList.length; i++) {
                    $("#seriesCode").append("<option value='"+seriesCodeList[i].value+"' selected>"+seriesCodeList[i].label+"</option>");
                }
                $("#seriesCode").select2({
                        language: {
                            noResults: function (params) {
                                return "请先选择品牌";
                            }
                        },
                        ajax: {
                        type: 'GET',
                        url: "/mkmm/sales/selectCode/CarBrandDetail",
                        dataType: 'json',
                        data: function (params) {
                            var brandsCodeList = $("#brandsCode").select2("data");
                            var brandsCodes = '';
                            var isUpCodes = '1';
                            for (var i=0;i<brandsCodeList.length;i++) {
                                if (brandsCodeList[i].id == '00'){
                                    isUpCodes = '0'
                                }
                                if (i == 0){
                                    brandsCodes += brandsCodeList[i].id
                                } else {
                                    brandsCodes += ','
                                    brandsCodes += brandsCodeList[i].id
                                }
                            }
                            return {
                                isUpCode:isUpCodes,upCode:brandsCodes}
                        },
                        processResults: function (data) {
                            var seriesInfos = data.result;
                            var seriesInfo = new Array();           //子品牌（车系）
                            seriesBigList = '';
                            for (var i = 0; i < seriesInfos.length; i++) {
                                if (i == 0){
                                    seriesBigList += seriesInfos[i].value;
                                } else {
                                    seriesBigList += ',';
                                    seriesBigList += seriesInfos[i].value;
                                }
                                seriesInfo.push({id: seriesInfos[i].value, text: seriesInfos[i].label})
                            }
                            return{
                                results: seriesInfo
                            };
                        },
                        cache: true,
                    }
                })
                $("#seriesCode").on("select2:select",function(e){
                    $("#moderCode").select2("val","")
                    var data = $(this).val();
                    if (data != null && data[0]=="00"){
                        console.log("车系选择了全部")
                        $("#seriesCode").val(["00","全部"]).trigger('change')
                    }
                    setHash()
                })
            });

            $.ajax({
                type: 'GET',
                url: "/mkmm/sales/selectCode/translateCode",
                dataType: 'json',
                data: {
                    codeType:'CarBrandName',codeCode:activeCarResult.moderCode
                }
            }).then(function (data) {
                var moderCodeList = data.result;
                for (var i = 0; i < moderCodeList.length; i++) {
                    $("#moderCode").append("<option value='"+moderCodeList[i].value+"' selected>"+moderCodeList[i].label+"</option>");
                }
                $("#moderCode").select2({
                    language: {
                        noResults: function (params) {
                            return "请先选择子品牌";
                        }
                    },
                    ajax: {
                        type: 'GET',
                        url: "/mkmm/sales/selectCode/CarBrandName",
                        dataType: 'json',
                        data: function (params) {
                            var brandsCodeList = $("#brandsCode").select2("data");
                            var seriesCodeList = $("#seriesCode").select2("data");
                            var seriesCodes = '';
                            var isUpCodes = '1';
                            for (var i=0;i<seriesCodeList.length;i++) {
                                if (seriesCodeList[i].id == '00'){          //子品牌为全部
                                    for (var j = 0; j < brandsCodeList.length; j++) {
                                        if (brandsCodeList[j].id == '00'){      //品牌和子品牌都为全部
                                            isUpCodes = '0';
                                        }
                                    }
                                    if (isUpCodes == '0'){              //isUpCodes为0代表无上级
                                        seriesCodes = ''
                                    } else {
                                        seriesCodes = seriesBigList;
                                    }
                                    break;
                                } else {                                    //子品牌不为全部
                                    if (i == 0){
                                        seriesCodes += seriesCodeList[i].id
                                    } else {
                                        seriesCodes += ','
                                        seriesCodes += seriesCodeList[i].id
                                    }
                                }
                            }
                            return {
                                isUpCode:isUpCodes,upCode:seriesCodes}
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
                $("#moderCode").on("select2:select",function(e){
                    var data = $(this).val();
                    if (data != null && data[0]=="00"){
                        console.log("车型选择了全部")
                        $("#moderCode").val(["00","全部"]).trigger('change')
                    }
                    setHash()
                })
            });

            var product;
            var financePro = new Array();
            var creditPro = new Array();
            if (activeProdListResult != null && activeProdListResult.length > 0) {
                for (var i = 0; i < activeProdListResult.length; i++) {
                    product = activeProdListResult[i];
                    if (product.prodType == '01') {              // 金融产品
                        financePro = product.prodCode.split(',');
                    } else if (product.prodType == '02') {     // 信贷产品
                        creditPro = product.prodCode.split(',');
                    }
                }
                $('#financeProdCode').select2().val(financePro).trigger('change');
                $('#creditProdCode').select2().val(creditPro).trigger('change');
            }
            if (activeBusinessResult.businessCode != null) {
                var activeBusinesses = activeBusinessResult.businessCode.split(',');
                $('#businessCode').select2().val(activeBusinesses).trigger('change');
            }
            if (activeMarketingResult.marketingCode != null) {
                var marketingCodes = activeMarketingResult.marketingCode.split(',');
                $('#marketingCode').select2().val(marketingCodes).trigger('change');
            }
            if (ativeMainResult.additionFlag == '1') {
                $("#div_addition_amt").show();
                $("#div_addition_list").show();
                $("#additionFlag").val(ativeMainResult.additionFlag);
                $("#additionAmtBegin").val(ativeMainResult.additionAmtBegin);
                $("#additionAmtEnd").val(ativeMainResult.additionAmtEnd);
                if (activeAdditionalResult.additionalCode != null) {
                    var additionalCodeList = activeAdditionalResult.additionalCode.split(',');
                    $('#additionalCode').select2().val(additionalCodeList).trigger('change');
                }
            } else {
                $("#div_addition_amt").hide();
                $("#div_addition_list").hide();
            }
            $("#remark").text(ativeMainResult.remark);

            /**
             * 经销商区域控制显示隐藏
             */
            $("#inputDeale").on("change", function (e) {
                var value = $(this).val();
                if ("1" == value) {
                    $("#div_activeDeale").show();
                    $("#div_area").hide();
                } else {
                    $("#div_activeDeale").hide();
                    $("#div_area").show();
                }
                setHash();
            })
            /**
             * 文件上传插件----------------------------------------------------begin
             */
            $('#dealer-input-file,#appendix-input-file').ace_file_input({
                no_file: '请导入文件 ...',
                btn_choose: '浏览',
                btn_change: '修改',
                droppable: false,
                onchange: null,
                thumbnail: false
            });
            /**
             * 文件上传插件----------------------------------------------------end
             */
            /**
             * 经销商文件上传--------------------------------------------------begin
             */
            $('#btn_dealer_upload').on("click", function () {
                var fileObj = document.getElementById("dealer-input-file").files[0]; // js 获取文件对象
                if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
                    layer.alert("请选择文件");
                    return;
                }
                var formFile = new FormData();
                formFile.append("file", fileObj);
                var data = formFile;
                $.ajax({
                    url: "/mkmm/sales/activeDealerReviews/fileUpLoad",
                    data: data,
                    type: "Post",
                    dataType: "json",
                    enctype: 'multipart/form-data',
                    cache: false,//上传文件无需缓存
                    processData: false,//用于对data参数进行序列化处理 这里必须false
                    contentType: false, //必须
                    success: function (data) {
                        $("#activeDealeReviewTable").html("");
                        var thead = "<thead> " +
                            "<tr> " +
                            "<th class='sorting'>经销商编码</th> " +
                            "<th class='sorting'>经销商名称</th> " +
                            "<th class='sorting'>活动上线数量</th> " +
                            "</tr>" +
                            "</thead>";
                        var row = "<tbody>";
                        for (items in dealersInfo) {
                            srow += "<tr><td name='dealerCode'>" + dealersInfo[items].dealerCode + "</td>";
                            srow += "<td name='dealerName'>" + dealersInfo[items].dealerName + "</td>";
                            if (dealersInfo[items].activeNumber) {
                                srow += "<td name='activeNumber'>" + dealersInfo[items].activeNumber + "</td></tr>";
                            } else {
                                srow += "<td name='activeNumber'></td></tr>";
                            }
                        }
                        row += "</tbody>";
                        $("#activeDealeReviewTable").append(thead + row);
                        setHash();
                    },
                    error: function () {
                        layer.alert("上传失败！");
                    }
                })
            });
            /**
             * 经销商文件上传--------------------------------------------------end
             */
            $("#btn_add_appendix").on("click", function (e) {
                window.open("http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>" + appendixId + "</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >");
            })


            /**
             * 模板下载
             */
            $("#dowload").on("click", function (e) {
                commonForward('/mkmm/sales/activeDealerReviews/downloadTemplate');
            })

            /**
             * 附加贷显示隐藏
             */
            $("#additionFlag").on("change", function (e) {
                var value = $(this).val();
                if (value == "0") {
                    $("#div_addition_amt").hide();
                    $("#div_addition_list").hide();
                } else {
                    $("#div_addition_amt").show();
                    $("#div_addition_list").show();
                }
            })
            /**
             * 提交
             */
            $("#btnSubmit").on("click", function (e) {
                e.preventDefault();
                creactObj();
            });

            /**
             * 页面信息对象创建
             */
            function creactObj() {

                var ativeObj = {};
                var ativeMainObj = {};
                ativeMainObj["id"] = $("#mid").val();                               //ID
                ativeMainObj["activeCode"] = $("#activeCode").val();              //活动代码
                ativeMainObj["activeName"] = $("#activeName").val();              //活动名称
                ativeMainObj["patmentBegin"] = $("#patmentBegin").val();          //首付比例(%) 起始
                ativeMainObj["patmentEnd"] = $("#patmentEnd").val();              //首付比例(%) 终止
                ativeMainObj["loanAmtBegin"] = $("#loanAmtBegin").val();          //贷款金额(元) 起始
                ativeMainObj["loanAmtEnd"] = $("#loanAmtEnd").val();              //贷款金额(元) 终止
                ativeMainObj["loanTermBegin"] = $("#loanTermBegin").val();        //贷款期限(月) 起始
                ativeMainObj["loanTermEnd"] = $("#loanTermEnd").val();            //贷款期限(月) 终止
                ativeMainObj["activeStartime"] = $("#activeStartime").val();      //受理开始日期
                ativeMainObj["activeEndtime"] = $("#activeEndtime").val();        //受理截止日期
                ativeMainObj["loanStartime"] = $("#loanStartime").val();          //放款开始日期
                ativeMainObj["loanEndtime"] = $("#loanEndtime").val();            //放款截止日期
                ativeMainObj["carReg"] = $("#carReg").val();                      //车籍
                ativeMainObj["avtiveCriterion"] = $("#avtiveCriterion").val();    //促销活动激励标准
                ativeMainObj["expectedCount"] = $("#expectedCount").val();        //预计活动笔数
                ativeMainObj["inputDeale"] = $("#inputDeale").val();              //经销商导入
                ativeMainObj["additionFlag"] = $("#additionFlag").val();          //附加贷标志
                ativeMainObj["remark"] = $("#remark").val();                      //备注信息
                ativeMainObj["areaCode"] = $("#areaMainCode").val();         //区域代码
                ativeMainObj["areaName"] = $("#areaMainName").val();         //区域名称

                //经销商数据
                var ativeDealeList = new Array();
                if (ativeMainObj["inputDeale"] == "1") {
                    var v_dealerCodes = $("td[name='dealerCode']");
                    var v_dealerNames = $("td[name='dealerName']");
                    var v_activeNumbers = $("td[name='activeNumber']");
                    var dealerLen = v_dealerCodes.length;
                    for (var i = 0; i < dealerLen; i++) {
                        var ativeDealeObj = {}
                        ativeDealeObj["dealerCode"] = $(v_dealerCodes[i]).text();
                        ativeDealeObj["dealerName"] = $(v_dealerNames[i]).text();
                        ativeDealeObj["activeNumber"] = $(v_activeNumbers[i]).text();
                        ativeDealeList.push(ativeDealeObj)
                    }
                }
                var activeAreaObj = {};
                //区域信息
                if (ativeMainObj["inputDeale"] == "0") {
                    var areaList = new Array();
                    var areaCodeValues = $("#areaCode").select2("data");
                    for (var i = 0; i < areaCodeValues.length; i++) {
                        areaList.push(areaCodeValues[i].id);
                    }
                    var provinceCodeValues = $("#provinceCode").select2("data");
                    var provinceList = new Array();
                    for (var i = 0; i < provinceCodeValues.length; i++) {
                        provinceList.push(provinceCodeValues[i].id);
                    }
                    var cityCodeValues = $("#cityCode").select2("data");
                    var cityList = new Array();
                    for (var i = 0; i < cityCodeValues.length; i++) {
                        cityList.push(cityCodeValues[i].id);
                    }
                    activeAreaObj["areaCode"] = areaList.join(',');
                    activeAreaObj["provinceCode"] = provinceList.join(',');
                    activeAreaObj["cityCode"] = cityList.join(',');

                }
                //车辆信息数据-----------------------------------------------------------begin
                //品牌信息
                var brandsCodeValues = $("#brandsCode").select2("data");
                var brandsList = new Array();
                var activeCarObj = {};
                for (var i = 0; i < brandsCodeValues.length; i++) {
                    brandsList.push(brandsCodeValues[i].id);
                }
                if (brandsList.length > 0) {
                    activeCarObj["brandsCode"] = brandsList.join(",");
                }
                //子品牌（车系）信息
                var seriesCodeValues = $("#seriesCode").select2("data");
                var seriesList = new Array();
                for (var i = 0; i < seriesCodeValues.length; i++) {
                    seriesList.push(seriesCodeValues[i].id);

                }
                if (seriesList.length > 0) {
                    activeCarObj["seriesCode"] = seriesList.join(",");
                }
                //车型信息
                var moderCodeValues = $("#moderCode").select2("data");
                var moderList = new Array();
                for (var i = 0; i < moderCodeValues.length; i++) {
                    moderList.push(moderCodeValues[i].id);
                }
                if (moderList.length > 0) {
                    activeCarObj["moderCode"] = moderList.join(",");
                }


                //车辆信息数据-----------------------------------------------------------end

                //产品信息数据-----------------------------------------------------------begin
                //金融产品
                var financeProdCodeValues = $("#financeProdCode").select2("data");
                var prodList = new Array();
                var financeProdList = new Array();
                for (var i = 0; i < financeProdCodeValues.length; i++) {
                    financeProdList.push(financeProdCodeValues[i].id);
                }
                var financeProdObj = {};
                if (financeProdList.length > 0) {
                    financeProdObj["prodCode"] = financeProdList.join(",");
                    financeProdObj["prodType"] = "01";
                    prodList.push(financeProdObj);
                }

                //业务模式
                var businessCodeValues = $("#businessCode").select2("data");
                var businessList = new Array();
                for (var i = 0; i < businessCodeValues.length; i++) {
                    businessList.push(businessCodeValues[i].id);
                }
                var businessObj = {};
                if (businessList.length > 0) {
                    businessObj["businessCode"] = businessList.join(",");
                }


                //信贷产品
                var creditProdCodeValues = $("#creditProdCode").select2("data");
                var creditProdList = new Array();
                for (var i = 0; i < creditProdCodeValues.length; i++) {
                    creditProdList.push(creditProdCodeValues[i].id);
                }

                var creditProdObj = {}
                if (creditProdList.length > 0) {
                    creditProdObj["prodCode"] = creditProdList.join(",");
                    creditProdObj["prodType"] = "02";
                    prodList.push(creditProdObj);
                }

                //营销活动
                var marketingCodeValues = $("#marketingCode").select2("data");
                var marketingList = new Array();
                for (var i = 0; i < marketingCodeValues.length; i++) {
                    marketingList.push(marketingCodeValues[i].id);
                }

                var marketingObj = {}
                if (marketingList.length > 0) {
                    marketingObj["marketingCode"] = marketingList.join(",");
                }


                var additionalObj = {};
                // 附加贷信息录入
                if (ativeMainObj["additionFlag"] == "1") {
                    ativeMainObj["additionAmtBegin"] = $("#additionAmtBegin").val();
                    ativeMainObj["additionAmtEnd"] = $("#additionAmtEnd").val();
                    //附加贷数据
                    var additionalCodeValues = $("#additionalCode").select2("data");

                    var additionalList = new Array();
                    for (var i = 0; i < additionalCodeValues.length; i++) {
                        additionalList.push(additionalObj["addtitonCode"] = additionalCodeValues[i].id);
                    }
                    if (additionalList.length > 0) {
                        additionalObj["additionalCode"] = additionalList.join(",");
                    }
                }
                //产品信息数据-----------------------------------------------------------end

                ativeObj["ativeMain"] = ativeMainObj; //主信息
                ativeObj["ativeDealeList"] = ativeDealeList; //经销商信息
                ativeObj["activeArea"] = activeAreaObj;//区域信息
                ativeObj["activeCar"] = activeCarObj;//车型信息
                ativeObj["activeProdList"] = prodList;//产品信息
                ativeObj["activeBusiness"] = businessObj;//业务模式
                ativeObj["activeMarketing"] = marketingObj;//营销活动
                ativeObj["activeAdditional"] = additionalObj;//附加贷

                if (!formMainValidate(ativeObj)) {
                    return false;
                }

                if (!valiPositiveNum(ativeMainObj["avtiveCriterion"])){
                    layer.alert("活动激励标准必须为正整数！")
                    return false;
                }

                if (ativeMainObj["inputDeale"] == "1") { //验证经销商信息
                    if (!formDealeValidate(ativeObj)) {
                        return false;
                    }
                } else if (ativeMainObj["inputDeale"] == "0") {//验证区域信息
                    if (!formAreaValidate(ativeObj)) {
                        return false;
                    }
                }
                if (!formCarValidate(ativeObj)) { //验证车产品信息
                    return false;
                }
                if (!formProdValidate(ativeObj)) {//验证产品信息 业务模式 营销活动
                    return false;
                }
                if (ativeMainObj["additionFlag"] == "1") {//验证附加贷信息
                    if (!formAddtitonValidate(ativeObj)) {
                        return false;
                    }
                }
                console.log(JSON.stringify(ativeObj));
                submit(ativeObj);
            }

            /***
             *
             */
            function submit(ativeObj) {
                $.ajax({
                    url: "/mkmm/sales/actives/change",
                    data: JSON.stringify(ativeObj),
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
                        $("#inputForm").resetForm();
                    },
                    error: function () {

                    }
                }).always(function () {
                    $("#btnSubmit").attr("disabled", false);
                });
            }

            /**
             * 验证主表信息
             * @param ativeObj
             * @returns {boolean}
             */
            function formMainValidate(ativeObj) {
                var ativeMainObj = ativeObj["ativeMain"];
                if (ativeMainObj.activeName == "") {
                    layer.alert("请录入活动名称！");
                    return false;
                }
                //首付比例起始
                if (!valiNumAndRange(ativeMainObj["patmentBegin"],ativeMainObj["patmentEnd"])){
                    return false;
                }
                //贷款金额起始
                if (ativeMainObj["loanAmtBegin"] != "") {
                    if (!valiAmt(ativeMainObj["loanAmtBegin"])) {
                        layer.alert("贷款金额应为数字!");
                        return false;
                    }
                }
                //贷款金额终止
                if (ativeMainObj["loanAmtEnd"] != "") {
                    if (!valiAmt(ativeMainObj["loanAmtEnd"])) {
                        layer.alert("贷款金额应为数字!");
                        return false;
                    }
                }
                //贷款期限
                if(ativeMainObj["loanTermBegin"]!=""){
                    if (!valiPositiveNum(ativeMainObj["loanTermBegin"])) {
                        layer.alert("贷款期限应为正整数!");
                        return false;
                    }
                }
                //贷款期限
                if(ativeMainObj["loanTermEnd"]!=""){
                    if (!valiPositiveNum(ativeMainObj["loanTermEnd"])) {
                        layer.alert("贷款期限应为正整数!");
                        return false;
                    }
                }

                if(ativeMainObj["loanTermEnd"]!="" && ativeMainObj["loanTermBegin"]!=""){
                    if (ativeMainObj["loanTermEnd"] <ativeMainObj["loanTermBegin"] ) {
                        layer.alert("贷款期限起始不能大于终止!");
                        return false;
                    }
                }

                //预计笔数
                if (ativeMainObj["expectedCount"] == "") {
                    layer.alert("预计笔数不允许为空！");
                    return false;
                }

                //活动笔数
                if (!valiPositiveNum(ativeMainObj["expectedCount"])) {
                    layer.alert("活动活动笔数应为正整数!");
                    return false;
                }
                //受理起始日期
                if (ativeMainObj["activeStartime"] == "") {
                    layer.alert("受理开始日期不允许为空!");
                    return false;
                }
                //受理终止日期
                if (ativeMainObj["activeEndtime"] == "") {
                    layer.alert("受理截止日期不允许为空!");
                    return false;
                }
                //受理日期比较
                if (compareDate(ativeMainObj["activeStartime"], ativeMainObj["activeEndtime"])) {
                    layer.alert("受理终止日期必须大于受理开始日期!");
                    return false;
                }
                //放款起始日期
                if (ativeMainObj["loanStartime"] == "") {
                    layer.alert("放款开始日期不允许为空!");
                    return false;
                }
                //放款终止日期
                if (ativeMainObj["loanEndtime"] == "") {
                    layer.alert("放款截止日期不允许为空!");
                    return false;
                }
                //放款日期比较
                if (compareDate(ativeMainObj["loanStartime"], ativeMainObj["loanEndtime"])) {
                    layer.alert("放款终止日期必须大于放款开始日期!");
                    return false;
                }

                //促销活动激励标准
                if (ativeMainObj["avtiveCriterion"] == "") {
                    layer.alert("促销活动激励标准不允许为空!");
                    return false;
                }
                //促销活动激励标准
                // if (!valiAmt(ativeMainObj["avtiveCriterion"])) {
                //     layer.alert("促销活动激励标准格式不正确! 正确格式为：##.##");
                //     return false;
                // }
            }

            /**
             * 验证经销商信息
             * @param ativeObj
             */
            function formDealeValidate(ativeObj) {
                var ativeDealeList = ativeObj["ativeDealeList"];
                if (ativeDealeList.length <= 0) {
                    layer.alert("请导入经销商信息！");
                    return false;
                } else {
                    for (var i = 0; i < ativeDealeList.length; i++) {
                        var ativeDealeObj = ativeDealeList[i];
                        if (ativeDealeObj["dealerCode"] == "") {
                            layer.alert("经销商导入数据，第" + (i + 1) + "条数据，供应商代码不能为空！");
                            return false;
                        }
                        if (ativeDealeObj["dealerName"] == "") {
                            layer.alert("经销商导入数据，第" + (i + 1) + "条数据，供应商名称不能为空！");
                            return false;
                        }
                        if (ativeDealeObj["activeNumber"] != "") {
                            if (!valiNum(ativeDealeObj["activeNumber"])) {
                                layer.alert("经销商导入数据，第" + (i + 1) + "条数据，活动上限必须为数字!");
                                return false;
                            }
                        }
                    }
                }
                return true;

            }

            /**
             * 验证区域信息
             */
            function formAreaValidate(ativeObj) {
                var activeAreaObj = ativeObj["activeArea"];
                if (activeAreaObj["areaCode"] == "" && activeAreaObj["provinceCode"] == "" && activeAreaObj["cityCode"] == "") {
                    layer.alert("请录入区域或省份信息");
                    return false;
                }
                if (activeAreaObj["areaCode"] == "" && activeAreaObj["provinceCode"] == "" && activeAreaObj["cityCode"] != "") {
                    layer.alert("请录入省份信息！");
                    return false;
                }
                if (activeAreaObj["areaCode"] == "" && activeAreaObj["provinceCode"] != "" && activeAreaObj["cityCode"] == "") {
                    layer.alert("请录入城市信息！");
                    return false;
                }
                return true;
            }

            /**
             * 验证品牌信息
             */
            function formCarValidate(ativeObj) {
                var activeCar = ativeObj["activeCar"];//产品信息
                if (!activeCar["brandsCode"]) {
                    layer.alert("请选择活动品牌信息！");
                    return false;
                }
                if (!activeCar["seriesCode"]) {
                    layer.alert("请选择活动子品牌信息！");
                    return false;
                }
                if (!activeCar["moderCode"]) {
                    layer.alert("请选择活动车型信息！");
                    return false;
                }
                return true;
            }

            /**
             * 验证金融产品信息
             * @param ativeObj
             */
            function formProdValidate(ativeObj) {
                var prodList = ativeObj["activeProdList"];//产品信息
                var marketingObj = ativeObj["activeMarketing"];//营销活动
                var businessObj = ativeObj["activeBusiness"];//附加产品
                if (prodList.length == 0) {
                    layer.alert("请录入产品信息！");
                    return false;
                }
                var jrCount = 0;
                var xdCount = 0;
                for (var i = 0; i < prodList.length; i++) {
                    var prodObj = prodList[i];
                    if (prodObj["prodType"] == "01") {
                        jrCount += 1;
                    } else if (prodObj["prodType"] == "02") {
                        xdCount += 1;
                    }
                }
                if (jrCount == 0) {
                    layer.alert("请选择金融产品！");
                    return false;
                }
                if (xdCount == 0) {
                    layer.alert("请选择信贷产品！");
                    return false;
                }
                if (!marketingObj["marketingCode"]) {
                    layer.alert("请选择营销活动！");
                    return false;
                }
                if (!businessObj["businessCode"]) {
                    layer.alert("请选择业务模式！");
                    return false;
                }

                return true;
            }

            /**
             * 验证正整数
             */
            function valiPositiveNum(val){
                var reg = /^[0-9]*[1-9][0-9]*$/;
                if(!reg.test(val)){
                    return false
                }else {
                    return true
                }
            }

            /**
             * 验证数字范围是否在0-100之间
             */
            function valiNumAndRange(vala,valb){
                if (vala != "" && valb != ""){
                    var reg = /^\d+(\.\d+)?$/;
                    if (reg.test(vala) && reg.test(valb)) {
                        if (valb > 100 || vala > 100) {
                            layer.alert("首付比例不能超出100！")
                            return false;
                        } else if (valb < vala){
                            layer.alert("首付起始比例不能大于结束比例！")
                            return false;
                        }else {
                            return true
                        }
                    }else {
                        if (valb < 0 || vala < 0){
                            layer.alert("首付比例不能为负数！")
                        }else {
                            layer.alert("首付比例必须是数字！")
                        }
                        return false;
                    }
                } else if (vala != "" && valb == ""){
                    layer.alert("首付结束比例不能为空！")
                    return false
                } else if (vala == "" && valb != ""){
                    layer.alert("首付起始比例不能为空！")
                    return false
                } else {
                    return true
                }
            }

            /**
             * 验证附加贷信息
             * @param ativeObj
             */
            function formAddtitonValidate(ativeObj) {
                var additionalObj = ativeObj["activeAdditional"];
                var ativeMainObj = ativeObj["ativeMain"];

                if (!additionalObj["addtitonCode"]) {
                    layer.alert("请选择附加贷信息！");
                    return false;
                }
                var additionAmtBegin = ativeMainObj["additionAmtBegin"];
                var additionAmtEnd = ativeMainObj["additionAmtEnd"];
                if (additionAmtBegin == "") {
                    layer.alert("请录入附加贷起始金额！");
                    return false;
                }
                if (additionAmtEnd == "") {
                    layer.alert("请录入附加贷截止金额！");
                    return false;
                }
                if (!valiAmt(additionAmtBegin)) {
                    layer.alert("附加贷起始金额格式不正确！");
                    return false;
                }
                if (!valiAmt(additionAmtEnd)) {
                    layer.alert("附加贷终止金额格式不正确！");
                    return false;
                }
                if(additionAmtBegin > additionAmtEnd){
                    layer.alert("附加贷起始金额不能大于终止金额！");
                    return false;
                }
                return true;
            }


            /**
             * 验证数字
             * @param val
             * @returns {boolean}
             */
            function valiNum(val) {
                var reg = /^[0-9]*$/;
                return reg.test(val);
            }

            /**
             * 验证金额
             */
            function valiAmt(val) {
                var reg = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
                return reg.test(val);
            }

            /**
             * 日期校验
             * @param d1
             * @param d2
             * @returns {boolean}
             * @constructor
             */
            function compareDate(d1, d2) {
                return ((new Date(d1.replace(/-/g, "\/"))) > (new Date(d2.replace(/-/g, "\/"))));
            }
        }, function (e) {
            layer.alert("查询数据失败:" + e);
        })
    }
});

/**
 * 删除附件
 * @param btn
 */
function delAppendixFile(btn) {
    var v_btn_del_appendix = document.getElementsByName("btn_del_appendix");
    if (v_btn_del_appendix.length > 1) {
        for (var i = 0; i < v_btn_del_appendix.length; i++) {
            if (v_btn_del_appendix[i] == btn) {
                var childrens = $("#div_add_appendix").children();
                childrens[i].remove();
            }
        }
    } else {
        $("#div_add_appendix").children()[0].remove();
    }
}

/**
 * 生成唯一ID 用作影响系统ID
 * @returns {string}
 */
function createRandomId() {
    return (Math.random() * 10000000).toString(16).substr(0, 4) + '-' + (new Date()).getTime() + '-' + Math.random().toString().substr(2, 5);
}
