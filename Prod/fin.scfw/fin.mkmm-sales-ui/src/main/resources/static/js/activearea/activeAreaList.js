var shrinkToFit = false;
$(function () {
  $("#activeAreaTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' } ,
						        { label: '活动ID', name: 'activeId', index: 'activeId', sortable: true, width: 150, align: 'center' } ,
						        { label: '活动编号', name: 'activeCode', index: 'activeCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '序号', name: 'serialNo', index: 'serialNo', sortable: true, width: 150, align: 'center' } ,
						        { label: '区域代码', name: 'areaCode', index: 'areaCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center' } ,
						        { label: '省份代码', name: 'provinceCode', index: 'provinceCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '省份名称', name: 'provinceName', index: 'provinceName', sortable: true, width: 150, align: 'center' } ,
						        { label: '城市编码', name: 'cityCode', index: 'cityCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '城市名称', name: 'cityName', index: 'cityName', sortable: true, width: 150, align: 'center' } ,
						        { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' } ,
						        { label: '所属公司', name: 'company', index: 'company', sortable: true, width: 150, align: 'center' } 
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
  $("#activeAreaTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#activeAreaTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#activeAreaTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#activeAreaTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/activeArea/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#activeAreaTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#activeAreaTable").trigger("reloadGrid");
            });
        }
    }
}