var shrinkToFit = false;
$(function () {
  $("#planTrackHisTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' } ,
						        { label: '年份', name: 'year', index: 'year', sortable: true, width: 150, align: 'center' } ,
						        { label: '月份', name: 'month', index: 'month', sortable: true, width: 150, align: 'center' } ,
						        { label: '区域代码', name: 'areaCode', index: 'areaCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队代码', name: 'teamCode', index: 'teamCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队名称', name: 'teamName', index: 'teamName', sortable: true, width: 150, align: 'center' } ,
						        { label: '人员代码', name: 'personCode', index: 'personCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '人员名称', name: 'personName', index: 'personName', sortable: true, width: 150, align: 'center' } ,
						        { label: '人员类别', name: 'personType', index: 'personType', sortable: true, width: 150, align: 'center' } ,
						        { label: '品牌', name: 'brands', index: 'brands', sortable: true, width: 150, align: 'center' } ,
						        { label: '品牌类别', name: 'brandType', index: 'brandType', sortable: true, width: 150, align: 'center' } ,
						        { label: '月实际台数达成量', name: 'monthActualNum', index: 'monthActualNum', sortable: true, width: 150, align: 'center' } ,
						        { label: '月台数预算', name: 'monthPlanNum', index: 'monthPlanNum', sortable: true, width: 150, align: 'center' } ,
						        { label: '月台数预算达成率', name: 'monthPlanRate', index: 'monthPlanRate', sortable: true, width: 150, align: 'center' } ,
						        { label: '月序时进度', name: 'monthRate', index: 'monthRate', sortable: true, width: 150, align: 'center' } ,
						        { label: '月达成率与序时进度差值', name: 'monthRateCal', index: 'monthRateCal', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' } ,
						        { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' } ,
						        { label: '最新标识', name: 'flag', index: 'flag', sortable: true, width: 150, align: 'center' } ,
						        { label: '导入识别码', name: 'differentCode', index: 'differentCode', sortable: true, width: 150, align: 'center' } 
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
  $("#planTrackHisTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#planTrackHisTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#planTrackHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#planTrackHisTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/planTrackHis/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#planTrackHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#planTrackHisTable").trigger("reloadGrid");
            });
        }
    }
}