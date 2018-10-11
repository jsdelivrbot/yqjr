var shrinkToFit = false;
$(function () {
  $("#personTeamReviewTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        /*{ label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' } ,*/
						        { label: '人员代码', name: 'personCode', index: 'personCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '姓名', name: 'personName', index: 'personName', sortable: true, width: 150, align: 'center' } ,
						        { label: '人员性质', name: 'personNature', index: 'personNature', sortable: true, width: 150, align: 'center' } ,
                                { label: '团队代码', name: 'teamCode', index: 'teamCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队名称', name: 'teamName', index: 'teamName', sortable: true, width: 150, align: 'center' } ,
                                { label: '归属区名称', name: 'personCheckStart', index: 'personCheckStart', sortable: true, width: 150, align: 'center' } ,
                                { label: '人员状态', name: 'personUptime', index: 'personUptime', sortable: true, width: 150, align: 'center' } ,
						        { label: '人员状态', name: 'personStatus', index: 'personStatus', sortable: true, width: 150, align: 'center' } ,
						        { label: '操作', name: 'personCorrectime', index: 'personCorrectime', sortable: true, width: 150, align: 'center' }
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
  $("#personTeamReviewTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#personTeamReviewTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#personTeamReviewTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#personTeamReviewTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/personTeamReview/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#personTeamReviewTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#personTeamReviewTable").trigger("reloadGrid");
            });
        }
    }
}