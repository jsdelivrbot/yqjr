var shrinkToFit = false;
$(function () {
  $("#personMainHisTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' } ,
						        { label: '人员代码', name: 'personCode', index: 'personCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '人员姓名', name: 'personName', index: 'personName', sortable: true, width: 150, align: 'center' } ,
						        { label: '身份证号', name: 'personIdcard', index: 'personIdcard', sortable: true, width: 150, align: 'center' } ,
						        { label: '备注', name: 'remark', index: 'remark', sortable: true, width: 150, align: 'center' } ,
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
						        { label: 'e-mail', name: 'personEmail', index: 'personEmail', sortable: true, width: 150, align: 'center' } ,
						        { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' } ,
						        { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' } ,
						        { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' } ,
						        { label: '出生日期', name: 'personBirth', index: 'personBirth', sortable: true, width: 150, align: 'center' } ,
						        { label: '操作类型(1修改，2删除)', name: 'operateType', index: 'operateType', sortable: true, width: 150, align: 'center' } 
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
  $("#personMainHisTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#personMainHisTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#personMainHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#personMainHisTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/personMainHis/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#personMainHisTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#personMainHisTable").trigger("reloadGrid");
            });
        }
    }
}