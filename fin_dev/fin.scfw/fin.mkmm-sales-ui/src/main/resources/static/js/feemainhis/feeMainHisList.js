var shrinkToFit = false;
$(function () {
  $("#feeMainHisTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' } ,
						        { label: '结算单号', name: 'billno', index: 'billno', sortable: true, width: 150, align: 'center' } ,
						        { label: '费用类型 (01-活动费用)', name: 'feeType', index: 'feeType', sortable: true, width: 150, align: 'center' } ,
						        { label: '费用来源（01-正常渠道计算，02-费用追加）', name: 'feeSource', index: 'feeSource', sortable: true, width: 150, align: 'center' } ,
						        { label: '业务代码', name: 'businessCode', index: 'businessCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '业务名称', name: 'businessName', index: 'businessName', sortable: true, width: 150, align: 'center' } ,
						        { label: '所属公司', name: 'company', index: 'company', sortable: true, width: 150, align: 'center' } ,
						        { label: '结算状态（00-初始，01-未动支，02-动支中，03-已动支）', name: 'billStatus', index: 'billStatus', sortable: true, width: 150, align: 'center' } ,
						        { label: '是否送共享(01-未送共享，02-已送共享，99-未知状态)', name: 'isSendGx', index: 'isSendGx', sortable: true, width: 150, align: 'center' } ,
						        { label: '有效状态', name: 'validStatus', index: 'validStatus', sortable: true, width: 150, align: 'center' } ,
						        { label: '结算单上限金额', name: 'maxBillFee', index: 'maxBillFee', sortable: true, width: 150, align: 'center' } ,
						        { label: '结算单金额', name: 'billFee', index: 'billFee', sortable: true, width: 150, align: 'center' } ,
						        { label: '结算次数', name: 'settleTimes', index: 'settleTimes', sortable: true, width: 150, align: 'center' } ,
						        { label: '实际活动成交数量', name: 'actualTurnoverCount', index: 'actualTurnoverCount', sortable: true, width: 150, align: 'center' } ,
						        { label: '预计活动成交数量', name: 'estimateTurnoverCount', index: 'estimateTurnoverCount', sortable: true, width: 150, align: 'center' } ,
						        { label: '审核表ID', name: 'feeMainReviewId', index: 'feeMainReviewId', sortable: true, width: 150, align: 'center' } ,
						        { label: '费用申请归属部门', name: 'feeowner', index: 'feeowner', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注', name: 'remark', index: 'remark', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' } ,
						        { label: '有效标识（如表记录不删除，以此区分,0无效，1有效）', name: 'flag', index: 'flag', sortable: true, width: 150, align: 'center' } ,
						        { label: '原始ID', name: 'historyId', index: 'historyId', sortable: true, width: 150, align: 'center' } 
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
  $("#feeMainHisTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#feeMainHisTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#feeMainHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#feeMainHisTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/feeMainHis/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#feeMainHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#feeMainHisTable").trigger("reloadGrid");
            });
        }
    }
}