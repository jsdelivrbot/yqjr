var shrinkToFit = false;
$(function () {
  $("#areaMainTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' } ,
						        { label: 'index', name: 'nparentid', index: 'nparentid', sortable: true, width: 150, align: 'center' } ,
						        { label: '区域名称', name: 'vname', index: 'vname', sortable: true, width: 150, align: 'center' } ,
						        { label: '组织机构编号', name: 'vorganizationno', index: 'vorganizationno', sortable: true, width: 150, align: 'center' } ,
						        { label: '直客合同号生成简写 如CC ,SZ,BJ等', name: 'vsimplename', index: 'vsimplename', sortable: true, width: 150, align: 'center' } ,
						        { label: '是否为二级区域', name: 'nischildarea', index: 'nischildarea', sortable: true, width: 150, align: 'center' } ,
						        { label: '是否为大区', name: 'nisparentarea', index: 'nisparentarea', sortable: true, width: 150, align: 'center' } ,
						        { label: '业务类型,1乘用车零售贷款2乘用车零售租赁', name: 'nptype', index: 'nptype', sortable: true, width: 150, align: 'center' } ,
						        { label: '公司类型,1汽车金融2租赁3财务公司', name: 'ncomtype', index: 'ncomtype', sortable: true, width: 150, align: 'center' } 
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
  $("#areaMainTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#areaMainTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#areaMainTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#areaMainTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/areaMain/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#areaMainTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#areaMainTable").trigger("reloadGrid");
            });
        }
    }
}