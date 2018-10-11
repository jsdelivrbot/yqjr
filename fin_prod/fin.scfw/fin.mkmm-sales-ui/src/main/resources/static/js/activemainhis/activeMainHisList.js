var shrinkToFit = false;
$(function () {
  $("#activeMainHisTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' } ,
						        { label: '活动编码', name: 'activeCode', index: 'activeCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '活动名称', name: 'activeName', index: 'activeName', sortable: true, width: 150, align: 'center' } ,
						        { label: '活动开始日期', name: 'activeStartime', index: 'activeStartime', sortable: true, width: 150, align: 'center' } ,
						        { label: '活动截止日期', name: 'activeEndtime', index: 'activeEndtime', sortable: true, width: 150, align: 'center' } ,
						        { label: '放款开始日期', name: 'loanStartime', index: 'loanStartime', sortable: true, width: 150, align: 'center' } ,
						        { label: '放款截止日期', name: 'loanEndtime', index: 'loanEndtime', sortable: true, width: 150, align: 'center' } ,
						        { label: '首付起始比例', name: 'patmentBegin', index: 'patmentBegin', sortable: true, width: 150, align: 'center' } ,
						        { label: '首付终止比例', name: 'patmentEnd', index: 'patmentEnd', sortable: true, width: 150, align: 'center' } ,
						        { label: '车籍', name: 'carReg', index: 'carReg', sortable: true, width: 150, align: 'center' } ,
						        { label: '贷款期限', name: 'loanTermBegin', index: 'loanTermBegin', sortable: true, width: 150, align: 'center' } ,
						        { label: '贷款期限', name: 'loanTermEnd', index: 'loanTermEnd', sortable: true, width: 150, align: 'center' } ,
						        { label: '贷款金额', name: 'loanAmtBegin', index: 'loanAmtBegin', sortable: true, width: 150, align: 'center' } ,
						        { label: '贷款金额', name: 'loanAmtEnd', index: 'loanAmtEnd', sortable: true, width: 150, align: 'center' } ,
						        { label: '促销活动激励标准', name: 'avtiveCriterion', index: 'avtiveCriterion', sortable: true, width: 150, align: 'center' } ,
						        { label: '附加贷(0没有，1有)', name: 'additionFlag', index: 'additionFlag', sortable: true, width: 150, align: 'center' } ,
						        { label: '附加贷起始金额', name: 'additionAmtBegin', index: 'additionAmtBegin', sortable: true, width: 150, align: 'center' } ,
						        { label: '附加贷终止金额', name: 'additionAmtEnd', index: 'additionAmtEnd', sortable: true, width: 150, align: 'center' } ,
						        { label: '活动状态', name: 'activeStatus', index: 'activeStatus', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '附件', name: 'annex', index: 'annex', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' } ,
						        { label: '所属公司', name: 'company', index: 'company', sortable: true, width: 150, align: 'center' } ,
						        { label: '动支状态', name: 'paymentStatus', index: 'paymentStatus', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注', name: 'remark', index: 'remark', sortable: true, width: 150, align: 'center' } ,
						        { label: '活动预计笔数', name: 'expectedCount', index: 'expectedCount', sortable: true, width: 150, align: 'center' } ,
						        { label: '活动主表ID', name: 'activeId', index: 'activeId', sortable: true, width: 150, align: 'center' } ,
						        { label: '有效标识（如表记录不删除，以此区分,0无效，1有效）', name: 'flag', index: 'flag', sortable: true, width: 150, align: 'center' } ,
						        { label: '附件上传文件ID', name: 'additionalId', index: 'additionalId', sortable: true, width: 150, align: 'center' } ,
						        { label: '经销商录入标识（1是 0否）', name: 'inputDeale', index: 'inputDeale', sortable: true, width: 150, align: 'center' } 
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
  $("#activeMainHisTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#activeMainHisTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#activeMainHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#activeMainHisTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/activeMainHis/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#activeMainHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#activeMainHisTable").trigger("reloadGrid");
            });
        }
    }
}