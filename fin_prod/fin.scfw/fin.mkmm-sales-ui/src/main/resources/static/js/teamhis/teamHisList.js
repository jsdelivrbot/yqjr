var shrinkToFit = false;
$(function () {
  $("#teamHisTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: '序号', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' } ,
						        { label: '归属区域代码', name: 'areaCode', index: 'areaCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '归属区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队代码', name: 'teamCode', index: 'teamCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队名称', name: 'teamName', index: 'teamName', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队级别（01一级，02二级，03三级）', name: 'teamLevel', index: 'teamLevel', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队类型（01普通）', name: 'teamType', index: 'teamType', sortable: true, width: 150, align: 'center' } ,
						        { label: '有效状态(0 无效,1 有效)', name: 'teamStatus', index: 'teamStatus', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队负责人', name: 'teamLeader', index: 'teamLeader', sortable: true, width: 150, align: 'center' } ,
						        { label: '电话', name: 'teamPhone', index: 'teamPhone', sortable: true, width: 150, align: 'center' } ,
						        { label: '邮编', name: 'teamZip', index: 'teamZip', sortable: true, width: 150, align: 'center' } ,
						        { label: '地址', name: 'teamAddress', index: 'teamAddress', sortable: true, width: 150, align: 'center' } ,
						        { label: '传真', name: 'teamFax', index: 'teamFax', sortable: true, width: 150, align: 'center' } ,
						        { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改时间', name: 'modtfyTime', index: 'modtfyTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '操作员', name: 'operatePerson', index: 'operatePerson', sortable: true, width: 150, align: 'center' } ,
						        { label: '操作状态(生效，新增未提交，修改未提交，审核中，审核退回,可能没啥用)', name: 'operateStatus', index: 'operateStatus', sortable: true, width: 150, align: 'center' } ,
						        { label: '是否最新标识', name: 'flag', index: 'flag', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注', name: 'remark', index: 'remark', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注1', name: 'transcode1', index: 'transcode1', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注2', name: 'transcode2', index: 'transcode2', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注3', name: 'transcode3', index: 'transcode3', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注4', name: 'transcode4', index: 'transcode4', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' } ,
						        { label: '审核ID', name: 'reviewId', index: 'reviewId', sortable: true, width: 150, align: 'center' } 
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
  $("#teamHisTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#teamHisTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#teamHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#teamHisTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/teamHis/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#teamHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#teamHisTable").trigger("reloadGrid");
            });
        }
    }
}