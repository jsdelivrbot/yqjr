var shrinkToFit = false;
$(function () {
  $("#feeDetailHisTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' } ,
						        { label: '业务明细表主键ID', name: 'businessId', index: 'businessId', sortable: true, width: 150, align: 'center' } ,
						        { label: '申请ID（业务数据唯一标识）', name: 'applyId', index: 'applyId', sortable: true, width: 150, align: 'center' } ,
						        { label: '结算单号', name: 'billNo', index: 'billNo', sortable: true, width: 150, align: 'center' } ,
						        { label: '业务明细单号（合同号）', name: 'contractNo', index: 'contractNo', sortable: true, width: 150, align: 'center' } ,
						        { label: '借据号', name: 'loanNo', index: 'loanNo', sortable: true, width: 150, align: 'center' } ,
						        { label: '客户ID', name: 'customCode', index: 'customCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '客户名称', name: 'customName', index: 'customName', sortable: true, width: 150, align: 'center' } ,
						        { label: '证件类型', name: 'customIdType', index: 'customIdType', sortable: true, width: 150, align: 'center' } ,
						        { label: '证件号', name: 'customIdCard', index: 'customIdCard', sortable: true, width: 150, align: 'center' } ,
						        { label: '所属公司', name: 'company', index: 'company', sortable: true, width: 150, align: 'center' } ,
						        { label: '品牌编码', name: 'brandsCode', index: 'brandsCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '品牌名称', name: 'brandsName', index: 'brandsName', sortable: true, width: 150, align: 'center' } ,
						        { label: '车系代码', name: 'seriesCode', index: 'seriesCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '车系名称', name: 'seriesName', index: 'seriesName', sortable: true, width: 150, align: 'center' } ,
						        { label: '车型', name: 'carBrandType', index: 'carBrandType', sortable: true, width: 150, align: 'center' } ,
						        { label: '车型名称', name: 'carBrandTypeName', index: 'carBrandTypeName', sortable: true, width: 150, align: 'center' } ,
						        { label: '净车价', name: 'carPrice', index: 'carPrice', sortable: true, width: 150, align: 'center' } ,
						        { label: '车籍', name: 'carMortgagerName', index: 'carMortgagerName', sortable: true, width: 150, align: 'center' } ,
						        { label: '车贷金融产品id', name: 'nactivitiesId', index: 'nactivitiesId', sortable: true, width: 150, align: 'center' } ,
						        { label: '车贷金融产品名称', name: 'nactivitiesName', index: 'nactivitiesName', sortable: true, width: 150, align: 'center' } ,
						        { label: '附加费金融产品id', name: 'necactivitiesId', index: 'necactivitiesId', sortable: true, width: 150, align: 'center' } ,
						        { label: '附加费金融产品名称', name: 'necactivitiesName', index: 'necactivitiesName', sortable: true, width: 150, align: 'center' } ,
						        { label: '业务类型Code', name: 'nbizType', index: 'nbizType', sortable: true, width: 150, align: 'center' } ,
						        { label: '业务类型名称', name: 'nbizTypeName', index: 'nbizTypeName', sortable: true, width: 150, align: 'center' } ,
						        { label: '信贷产品Code', name: 'ngetinterestType', index: 'ngetinterestType', sortable: true, width: 150, align: 'center' } ,
						        { label: '信贷产品名称', name: 'ngetinterestTypeName', index: 'ngetinterestTypeName', sortable: true, width: 150, align: 'center' } ,
						        { label: '服务产品Code', name: 'ndlrbizType', index: 'ndlrbizType', sortable: true, width: 150, align: 'center' } ,
						        { label: '服务产品名称', name: 'ndlrbizTypeName', index: 'ndlrbizTypeName', sortable: true, width: 150, align: 'center' } ,
						        { label: '贷款金额', name: 'nloanMoney', index: 'nloanMoney', sortable: true, width: 150, align: 'center' } ,
						        { label: '贷款期限', name: 'timeLimit', index: 'timeLimit', sortable: true, width: 150, align: 'center' } ,
						        { label: '申请日期', name: 'dapplyDate', index: 'dapplyDate', sortable: true, width: 150, align: 'center' } ,
						        { label: '放款日期', name: 'dfactstartDate', index: 'dfactstartDate', sortable: true, width: 150, align: 'center' } ,
						        { label: '附加贷金额', name: 'necloanMoney', index: 'necloanMoney', sortable: true, width: 150, align: 'center' } ,
						        { label: '首付比例', name: 'firstRatio', index: 'firstRatio', sortable: true, width: 150, align: 'center' } ,
						        { label: '大区代码', name: 'largeAreaCode', index: 'largeAreaCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '大区名称', name: 'largeAreaName', index: 'largeAreaName', sortable: true, width: 150, align: 'center' } ,
						        { label: '二区代码', name: 'zoneTwoCode', index: 'zoneTwoCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '二区名称', name: 'zoneTwoName', index: 'zoneTwoName', sortable: true, width: 150, align: 'center' } ,
						        { label: '经销商代码', name: 'distributorCode', index: 'distributorCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '经销商名称', name: 'distributorName', index: 'distributorName', sortable: true, width: 150, align: 'center' } ,
						        { label: '销售顾问代码', name: 'salesPersonCode', index: 'salesPersonCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '销售顾问名称', name: 'salesPersonName', index: 'salesPersonName', sortable: true, width: 150, align: 'center' } ,
						        { label: '省份代码 ', name: 'provinceCode', index: 'provinceCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '省份名称', name: 'provinceName', index: 'provinceName', sortable: true, width: 150, align: 'center' } ,
						        { label: '城市代码', name: 'cityCode', index: 'cityCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '城市名称', name: 'cityName', index: 'cityName', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注', name: 'remark', index: 'remark', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' } ,
						        { label: '有效标识（如表记录不删除，以此区分,0无效，1有效）', name: 'flag', index: 'flag', sortable: true, width: 150, align: 'center' } ,
						        { label: '原始ID', name: 'historyId', index: 'historyId', sortable: true, width: 150, align: 'center' } ,
						        { label: '关联主表ID', name: 'mainId', index: 'mainId', sortable: true, width: 150, align: 'center' } ,
						        { label: '活动明细表ID', name: 'activeMatchId', index: 'activeMatchId', sortable: true, width: 150, align: 'center' } 
						],

      height: 'auto',
      autowidth: true,
      rowNum: 10,
      rowList: [10, 20, 30],
      pager: $('#pager'),
      shrinkToFit: true,
      viewrecords: true,
      altRows: true,
      multiselect: true,
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
  $("#feeDetailHisTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#feeDetailHisTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#feeDetailHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#feeDetailHisTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/feeDetailHis/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#feeDetailHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#feeDetailHisTable").trigger("reloadGrid");
            });
        }
    }
}