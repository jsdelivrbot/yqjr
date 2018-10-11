var shrinkToFit = false;
$(function () {
  $("#workFlowTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建类型（01人员添加，02人员信息修改，03团队添加，04团队修改）', name: 'type', index: 'type', sortable: true, width: 150, align: 'center' } ,
						        { label: '审核事件id', name: 'reviewId', index: 'reviewId', sortable: true, width: 150, align: 'center' } ,
						        { label: '审核节点', name: 'reviewNode', index: 'reviewNode', sortable: true, width: 150, align: 'center' } ,
						        { label: '审核状态（00审核通过，01待审核，02驳回）', name: 'reviewStatus', index: 'reviewStatus', sortable: true, width: 150, align: 'center' } ,
						        { label: '审核级别', name: 'reviewLevel', index: 'reviewLevel', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改人（审核人）', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' } ,
						        { label: '备用1', name: 'transcode1', index: 'transcode1', sortable: true, width: 150, align: 'center' } ,
						        { label: '备用2', name: 'transcode2', index: 'transcode2', sortable: true, width: 150, align: 'center' } ,
						        { label: '备用3', name: 'transcode3', index: 'transcode3', sortable: true, width: 150, align: 'center' } ,
						        { label: '备用4', name: 'transcode4', index: 'transcode4', sortable: true, width: 150, align: 'center' } 
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
  $("#workFlowTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#workFlowTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#workFlowTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#workFlowTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/workFlow/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#workFlowTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#workFlowTable").trigger("reloadGrid");
            });
        }
    }
}