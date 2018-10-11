var shrinkToFit = false;
$(function () {
  $("#personMainTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: '序号', name: 'personId', index: 'personId', sortable: true, width: 150, align: 'center' } ,
						        { label: '员工编号', name: 'personCode', index: 'personCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '员工姓名', name: 'personName', index: 'personName', sortable: true, width: 150, align: 'center' } ,
						        { label: '身份证号', name: 'personIdcard', index: 'personIdcard', sortable: true, width: 150, align: 'center' } ,
						        { label: '年龄', name: 'personAge', index: 'personAge', sortable: true, width: 150, align: 'center' } ,
						        { label: '民族', name: 'personEthnic', index: 'personEthnic', sortable: true, width: 150, align: 'center' } ,
						        { label: '婚姻状况', name: 'personMarr', index: 'personMarr', sortable: true, width: 150, align: 'center' } ,
						        { label: '毕业学校', name: 'personSchool', index: 'personSchool', sortable: true, width: 150, align: 'center' } ,
						        { label: '专业', name: 'personSubject', index: 'personSubject', sortable: true, width: 150, align: 'center' } ,
						        { label: '最高学历', name: 'personEdu', index: 'personEdu', sortable: true, width: 150, align: 'center' } ,
						        { label: '学位', name: 'personEdulevel', index: 'personEdulevel', sortable: true, width: 150, align: 'center' } ,
						        { label: '工龄', name: 'personWorktime', index: 'personWorktime', sortable: true, width: 150, align: 'center' } ,
						        { label: '参加工作时间', name: 'personFirstworktime', index: 'personFirstworktime', sortable: true, width: 150, align: 'center' } ,
						        { label: '家庭住址', name: 'personAddress', index: 'personAddress', sortable: true, width: 150, align: 'center' } ,
						        { label: '家庭电话', name: 'personHomephone', index: 'personHomephone', sortable: true, width: 150, align: 'center' } ,
						        { label: '工作电话', name: 'personWorkphone', index: 'personWorkphone', sortable: true, width: 150, align: 'center' } ,
						        { label: '移动电话', name: 'personPhone', index: 'personPhone', sortable: true, width: 150, align: 'center' } ,
						        { label: 'e-mail', name: 'perrsonEmail', index: 'perrsonEmail', sortable: true, width: 150, align: 'center' } ,
						        { label: '员工状态', name: 'personStatus', index: 'personStatus', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建时间', name: 'perrsonCreatime', index: 'perrsonCreatime', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改时间', name: 'perrsonModtime', index: 'perrsonModtime', sortable: true, width: 150, align: 'center' } ,
						        { label: '生效时间', name: 'perrsonStartime', index: 'perrsonStartime', sortable: true, width: 150, align: 'center' } ,
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
  $("#personMainTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#personMainTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#personMainTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#personMainTable").jqGrid("getRowData", ids[0]);
    commonForward('/eco/ui/personMain/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#personMainTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#personMainTable").trigger("reloadGrid");
            });
        }
    }
}