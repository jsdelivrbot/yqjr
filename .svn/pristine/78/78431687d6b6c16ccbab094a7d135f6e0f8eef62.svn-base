var shrinkToFit = false;

$(function () {
    var user=getUserCookie();
    console.log(user);
    var roleCode=user.roleCodeList;
    console.log(typeof  roleCode);
    if (roleCode.indexOf('0000')>=0) {

    }else {
        $("#areaCode").css("display","none");
    }

  $("#eventTeamTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGridList",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: '团队事件序号', name: 'id', index: 'id', sortable: true, width: 150, align: 'center',hidden:true } ,


          {
              label: '团队代码',
              name: 'teamCode',
              index: 'teamCode',
              sortable: true,
              width: 150,
              align: 'center'
          },
          {
              label: '团队名称',
              name: 'teamName',
              index: 'teamName',
              sortable: true,
              width: 150,
              align: 'center'
          },
          {
              label: '事项年度',
              name: 'eventYear',
              index: 'eventYear',
              sortable: true,
              width: 150,
              align: 'center'
          },
          {
              label: '事项分类',
              name: 'eventType',
              index: 'eventType',
              sortable: true,
              width: 150,
              align: 'center',
              formatter:function(value,options,rowData){
                  if( value=="0" ){
                      return '奖励';
                  }else if( value=="1"){
                      return '处罚';
                  }else if( value=="2"){
                      return '其他';
                  }
              }
          },
          {
              label: '处理单位',
              name: 'eventApart',
              index: 'eventApart',
              sortable: true,
              width: 150,
              align: 'center'
          },
          {
              label: '处理时间',
              name: 'createTime',
              index: 'createTime',
              sortable: true,
              width: 150,
              align: 'center'
          },




          { label: '团队事件编号', name: 'eventCode', index: 'eventCode', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '团队事件内容', name: 'eventText', index: 'eventText', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '团队事件归属编号', name: 'code', index: 'code', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '事件状态', name: 'eventStatus', index: 'eventStatus', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '事件修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '事件生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '备注', name: 'remark', index: 'remark', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '备注1', name: 'transcode1', index: 'transcode1', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '备注2', name: 'transcode2', index: 'transcode2', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '备注3', name: 'transcode3', index: 'transcode3', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '备注4', name: 'transcode4', index: 'transcode4', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '最新标识', name: 'flag', index: 'flag', sortable: true, width: 150, align: 'center' ,hidden:true},
          { label: '团队名称', name: 'teamName', index: 'teamName', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '团队代码', name: 'teamCode', index: 'teamCode', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '所属公司', name: 'company', index: 'company', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '区域代码', name: 'areaCode', index: 'areaCode', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center' ,hidden:true}
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
  $("#eventTeamTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#eventTeamTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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

function select() {
    var ids = $("#eventTeamTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

    if (ids.length === 0) {
        layer.alert("请选择需要操作的数据！");
        return false;
    } else if (ids.length > 1) {
        layer.alert("请选择一条记录！");
    } else if (ids.length === 1) {
        var rowdata = $("#eventTeamTable").jqGrid("getRowData", ids[0]);
        commonForward('/mkmm/ui/eventTeam/view?id=' + rowdata.id)
    }

}

function update() {
  var ids = $("#eventTeamTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#eventTeamTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/eventTeam/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#eventTeamTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
    if (ids.length === 0) {
        alert("请选择需要操作的数据！");
        return false;
    } else {
        if (confirm("确定进行删除？")) {
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
                $("#eventTeamTable").trigger("reloadGrid");
            });
        }
    }
}

//年份插件
$('.year-picker').datepicker({
    language: 'zh-CN',
    autoclose: true,//选中之后自动隐藏日期选择框
    clearBtn: true,//清除按钮
    format: 'yyyy',//日期格式
    startView: 'decade',
    minView: 'decade',
    maxViewMode: 2,
    minViewMode:2,
});