var shrinkToFit = false;
$(function () {
    /**
     * ------------------------------------------------------模糊查询自动补全 begin
     */
    $("#activeCode").autocomplete({
        minLength:2,
        source: function( request, response ) {
            $.ajax({
                url : "/mkmm/sales/autoComplete/ActiveCode",
                type : "GET",
                contentType: 'application/json',
                data : {name:$("#activeCode").val()},
                success: function( data ) {
                    response( $.map( data.result, function( item ) {
                        return {
                            label: item.value,
                            value: item.label
                        }
                    }));
                }
            });
        },
        /**
         * 菜单选中时操作
         */
        select: function(event, ui){
            // 这里的this指向当前输入框的DOM元素
            // event参数是事件对象
            // ui对象只有一个item属性，对应数据源中被选中的对象
            $(this).val(ui.item.label);
            $("#activeName").val( ui.item.value);
            // 必须阻止事件的默认行为，否则autocomplete默认会把ui.item.value设为输入框的value值
            event.preventDefault();
        },
        /**
         * 修改输入框的值，并修改的值不在返回的数据内所做的操作
         */
        change: function( event, ui ) {
            if(ui.item==null){
                $("#activeName").val("");
            }
        }
    });
    /**
     * ------------------------------------------------------模糊查询自动补全 end
     */

    /**
     * ------------------------------------------------------下拉框查询品牌、车系、车型，依次关联 begin
     */
    
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
        $("#carBrandType").select2("val","")
        var data = $(this).val();
        if (data != null && data[0]=="00"){
            console.log("品牌选择了全部")
            $("#brandsCode").val(["00","全部"]).trigger('change')
        }
        setHash()
    })
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
        $("#carBrandType").select2("val","")
        var data = $(this).val();
        if (data != null && data[0]=="00"){
            console.log("车系选择了全部")
            $("#seriesCode").val(["00","全部"]).trigger('change')
        }
        setHash()
    })
    $("#carBrandType").select2({
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
    $("#carBrandType").on("select2:select",function(e){
        var data = $(this).val();
        if (data != null && data[0]=="00"){
            console.log("车型选择了全部")
            $("#carBrandType").val(["00","全部"]).trigger('change')
        }
        setHash()
    })
    
    /**
     * ------------------------------------------------------
     */
    $("#activeMatchDetailTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "loacl",
      mtype: 'GET',
      colModel: [
        { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center', hidden:true} ,
        { label: '活动代码', name: 'businessCode', index: 'businessCode', sortable: true, width: 150, align: 'center'} ,
        { label: '活动名称', name: 'businessName', index: 'businessName', sortable: true, width: 150, align: 'center'} ,
          { label: '归属区域名称', name: 'largeAreaName', index: 'largeAreaName', sortable: true, width: 150, align: 'center' } ,
          { label: '活动经销商', name: 'distributorName', index: 'distributorName', sortable: true, width: 150, align: 'center' } ,
          { label: '活动品牌', name: 'brandsName', index: 'brandsName', sortable: true, width: 150, align: 'center' } ,
          { label: '活动子品牌', name: 'seriesName', index: 'seriesName', sortable: true, width: 150, align: 'center' } ,
          { label: '活动车型', name: 'carBrandTypeName', index: 'carBrandTypeName', sortable: true, width: 150, align: 'center' } ,
          { label: '贷款金额', name: 'nloanMoney', index: 'nloanMoney', sortable: true, width: 150, align: 'center' } ,
          { label: '放款日期', name: 'dfactstartDate', index: 'dfactstartDate', sortable: true, width: 150, align: 'center' } ,
          { label: '营销活动', name: 'nactivitiesName', index: 'nactivitiesName', sortable: true, width: 150, align: 'center' } ,
          { label: '金融产品', name: 'ndlrbizTypeName', index: 'ndlrbizTypeName', sortable: true, width: 150, align: 'center' } ,
          { label: '业务模式', name: 'nbizTypeName', index: 'nbizTypeName', sortable: true, width: 150, align: 'center' } ,
          { label: '信贷产品', name: 'ngetinterestTypeName', index: 'ngetinterestTypeName', sortable: true, width: 150, align: 'center' } ,
						        { label: '关联业务明细表主键ID', name: 'businessid', index: 'businessid', sortable: true, width: 150, align: 'center', hidden:true } ,
						        { label: '关联经销商匹配表ID', name: 'distributorid', index: 'distributorid', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '是否在统计最大值范围内', name: 'isCountMaxIn', index: 'isCountMaxIn', sortable: true, width: 150, align: 'center', hidden:true } ,
						        { label: '关联任务表ID', name: 'taskId', index: 'taskId', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '统计归属日期（按照放款日期筛选）', name: 'countDate', index: 'countDate', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '申请ID（业务数据唯一标识）', name: 'applyid', index: 'applyid', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '结算单号', name: 'billNo', index: 'billNo', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '合同号', name: 'contractNo', index: 'contractNo', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '借据号', name: 'loanNo', index: 'loanNo', sortable: true, width: 150, align: 'center', hidden:true } ,
						        { label: '客户ID', name: 'customCode', index: 'customCode', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '客户名称', name: 'customName', index: 'customName', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '证件类型', name: 'customIdType', index: 'customIdType', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '证件号', name: 'customIdCard', index: 'customIdCard', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '所属公司', name: 'company', index: 'company', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '品牌编码', name: 'brandsCode', index: 'brandsCode', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '车系代码', name: 'seriesCode', index: 'seriesCode', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '车型', name: 'carBrandType', index: 'carBrandType', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '净车价', name: 'carPrice', index: 'carPrice', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '车贷金融产品id', name: 'nactivitiesId', index: 'nactivitiesId', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '车籍', name: 'carMortgagerName', index: 'carMortgagerName', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '附加费金融产品id', name: 'necactivitiesId', index: 'necactivitiesId', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '附加费金融产品名称', name: 'necactivitiesName', index: 'necactivitiesName', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '业务类型Code', name: 'nbizType', index: 'nbizType', sortable: true, width: 150, align: 'center' , hidden:true} ,
                                { label: '信贷产品Code', name: 'ngetinterestType', index: 'ngetinterestType', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '服务产品Code', name: 'ndlrbizType', index: 'ndlrbizType', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '贷款期限', name: 'timeLimit', index: 'timeLimit', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '申请日期', name: 'dapplyDate', index: 'dapplyDate', sortable: true, width: 150, align: 'center', hidden:true } ,
						        { label: '附加贷金额', name: 'necloanMoney', index: 'necloanMoney', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '首付比例', name: 'firstRatio', index: 'firstRatio', sortable: true, width: 150, align: 'center', hidden:true } ,
						        { label: '大区代码', name: 'largeAreaCode', index: 'largeAreaCode', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '二区代码', name: 'zoneTwoCode', index: 'zoneTwoCode', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '二区名称', name: 'zoneTwoName', index: 'zoneTwoName', sortable: true, width: 150, align: 'center', hidden:true } ,
						        { label: '经销商代码', name: 'distributorCode', index: 'distributorCode', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '销售顾问代码', name: 'salesPersonCode', index: 'salesPersonCode', sortable: true, width: 150, align: 'center', hidden:true } ,
						        { label: '销售顾问名称', name: 'salesPersonName', index: 'salesPersonName', sortable: true, width: 150, align: 'center', hidden:true } ,
						        { label: '省份代码', name: 'provinceCode', index: 'provinceCode', sortable: true, width: 150, align: 'center', hidden:true } ,
						        { label: '省份名称', name: 'provinceName', index: 'provinceName', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '城市代码', name: 'cityCode', index: 'cityCode', sortable: true, width: 150, align: 'center', hidden:true} ,
						        { label: '城市名称', name: 'cityName', index: 'cityName', sortable: true, width: 150, align: 'center', hidden:true } ,
						        { label: '备注', name: 'remark', index: 'remark', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '创建时间(数据提取时间)', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' , hidden:true} ,
						        { label: '有效标识（如表记录不删除，以此区分,0无效，1有效）', name: 'flag', index: 'flag', sortable: true, width: 150, align: 'center', hidden:true }
						],

      height: 'auto',
      autowidth: true,
      rowNum: 10,
      rowList: [10, 20, 30],
      pager: $('#pager'),
      shrinkToFit: true,
      viewrecords: true,
      altRows: true,
      multiselect: false,
      multiboxonly: false,
      sortable: true,
      sorttype: true,
      //当从服务器返回响应时执行
      loadComplete: function (xhr) {
        var table = this;
        updatePagerIcons(table);
        setHash();
      }
    })
  $("#activeMatchDetailTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#activeMatchDetailTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
});

function update() {
  var ids = $("#activeMatchDetailTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#activeMatchDetailTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/activeMatchDetail/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#activeMatchDetailTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
    if (ids.length === 0) {
        alert("请选择需要操作的数据！");
        return false;
    } else {
        if (confirm("确定进行批量删除？")) {
            var url = apiEntityBasePath + '/batch/' + ids.toString();
            $.ajax({
                async: false,
                type: 'DELETE',
                url: url,
                dataType: 'json'
            }).then(function (obj) {
                // 查询失败
                if (!obj.isSuccess) {
                    alert(obj.msg);
                    return;
                }
                layer.alert(obj.msg);
                $("#activeMatchDetailTable").trigger("reloadGrid");
            });
        }
    }
}

function searchDataOverWrite(tableName){
    var activeCode = $("#activeCode").val();
    if("" == activeCode || null == activeCode){
        layer.alert("请输入活动代码");
        return ;
    }
    var postData = {};
    var array = $("#searchForm").serializeArray();
    for(var i=0;i < array.length;i++){
        if (array[i].value != '') {
            postData[array[i].name] = array[i].value;
        }
    }
    $("#"+tableName).jqGrid("setGridParam",{
        postData : postData,
        page : 1,
        datatype: "json"
    },true).trigger("reloadGrid");
}

function drownLoad(){
    var allData = $("#activeMatchDetailTable").getRowData();
    if(allData.length == 0 ) {
        layer.alert("没有可导出的数据！");
    } else if (document.getElementById("activeCode").value == null || document.getElementById("activeCode").value == ''){
        layer.alert("活动代码不能为空！");
    } else {
        var url = apiEntityBasePath + '/drownLoadDetail';
        // var activeCode = document.getElementById("activeCode").value != null ? document.getElementById("activeCode").value:"";
        // var largeAreaName = document.getElementById("largeAreaName").value != null ? document.getElementById("largeAreaName").value:"";
        // var distributorName = document.getElementById("distributorName").value != null ? document.getElementById("distributorName").value:"";
        // var brandsName = document.getElementById("brandsName").value != null ? document.getElementById("brandsName").value:"";
        // var seriesName = document.getElementById("seriesName").value != null ? document.getElementById("seriesName").value:"";
        // var carBrandTypeName = document.getElementById("carBrandTypeName").value != null ? document.getElementById("carBrandTypeName").value:"";
        var activeCode = document.getElementById("activeCode").value;
        var largeAreaName = document.getElementById("largeAreaName").value;
        var distributorName = document.getElementById("distributorName").value;
        var brandsCode = document.getElementById("brandsCode").value;
        var seriesCode = document.getElementById("seriesCode").value;
        var carBrandType = document.getElementById("carBrandType").value;
        // console.log(personName);
        commonForward(url+"?activeCode="+activeCode+"&largeAreaName="+largeAreaName+"&distributorName="+distributorName+"&brandsCode="+brandsCode+"&seriesCode="+seriesCode+"&carBrandType="+carBrandType);
    }
}

function resetSelect() {
    $("#brandsCode").select2("val", "");
    $("#seriesCode").select2("val", "");
    $("#carBrandType").select2("val", "");
    $("#brandsCode").empty();
    $("#seriesCode").empty();
    $("#carBrandType").empty();

}