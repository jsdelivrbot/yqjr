var shrinkToFit = false;
$(function () {
  $("#teamTaskTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
                                { label: '任务序号', name: 'taskId', index: 'taskId', sortable: true, width: 150, align: 'center' } ,
						        { label: '任务类型(01裂变，00撤并，09撤销)', name: 'taskType', index: 'taskType', sortable: true, width: 150, align: 'center' } ,
						        { label: '区域代码', name: 'areaCode', index: 'areaCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center' } ,
						        { label: '任务发起人', name: 'taskPeo', index: 'taskPeo', sortable: true, width: 150, align: 'center' } ,
						        { label: '任务创建时间', name: 'taskCreatime', index: 'taskCreatime', sortable: true, width: 150, align: 'center' } ,
						        { label: '任务生效时间', name: 'taskStartime', index: 'taskStartime', sortable: true, width: 150, align: 'center' } ,
						        { label: '任务修改时间', name: 'taskModtime', index: 'taskModtime', sortable: true, width: 150, align: 'center' } ,
						        { label: '任务状态(审核通过情况)', name: 'taskStatus', index: 'taskStatus', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注', name: 'remark', index: 'remark', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注1', name: 'transcode1', index: 'transcode1', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注2', name: 'transcode2', index: 'transcode2', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注3', name: 'transcode3', index: 'transcode3', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注4', name: 'transcode4', index: 'transcode4', sortable: true, width: 150, align: 'center' } 
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
  $("#teamTaskTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#teamTaskTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#teamTaskTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#teamTaskTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/teamTask/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#teamTaskTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#teamTaskTable").trigger("reloadGrid");
            });
        }
    }
}