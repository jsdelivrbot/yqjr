var shrinkToFit = false;
$(function () {
    var user=getUserCookie();
    var roleCode=user.roleCodeList;
    if (roleCode.indexOf('0000')>=0 || roleCode.indexOf('0001')>=0 || roleCode.indexOf('0002')>=0) {
    }else {
        $("#areaMainDiv").css("display","none");
    }
  $("#teamMainQueryTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGridAllList",
      datatype: "json",
      mtype: 'GET',
      colModel: [
          { label: '序号', name: 'id', index: 'id', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '归属区域代码', name: 'areaCode', index: 'areaCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '归属区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队代码', name: 'teamCode', index: 'teamCode', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队名称', name: 'teamName', index: 'teamName', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队级别', name: 'teamLevel', index: 'teamLevel', sortable: true, width: 150, align: 'center',
                                    formatter:function(cellvalue, options, rowObject){
                                    var v_teamLevel=rowObject.teamLevel;
                                    var html="";
                                    if("01"==v_teamLevel){
                                        html="一级"
                                    }else if("02"==v_teamLevel){
                                        html="二级"
                                    }else if("03"==v_teamLevel){
                                        html="三级"
                                    }
                                    return html;
                                }} ,
						        { label: '团队类型', name: 'teamType', index: 'teamType', sortable: true, width: 150, align: 'center',formatter:function(cellvalue, options, rowObject){
                                    var v_teamType=rowObject.teamType;
                                    var html="";
                                    if("01"==v_teamType){
                                        html="普通"
                                    }
                                    return html;
                                } } ,
						        { label: '有效状态', name: 'teamStatus', index: 'teamStatus', sortable: true, width: 150, align: 'center',
                                    formatter:function(cellvalue, options, rowObject){
                                    var today =getNowFormatDate();
                                    var date = splitStrToDate(rowObject.startTime);
                                    var html="";
                                    if(today < date){
                                        html="无效"
                                    }else if(today >= date){
                                        html="有效"
                                    }
                                    return html;
                                }} ,
						        { label: '团队负责人', name: 'teamLeader', index: 'teamLeader', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '电话', name: 'teamPhone', index: 'teamPhone', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '邮编', name: 'teamZip', index: 'teamZip', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '地址', name: 'teamAddress', index: 'teamAddress', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '传真', name: 'teamFax', index: 'teamFax', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '备注', name: 'remark', index: 'remark', sortable: true, width: 150, align: 'center', hidden:true, hidden:true   } ,
						        { label: '备注1', name: 'transcode1', index: 'transcode1', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '备注2', name: 'transcode2', index: 'transcode2', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '备注3', name: 'transcode3', index: 'transcode3', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '备注4', name: 'transcode4', index: 'transcode4', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center', hidden:true  } ,
						        { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center', hidden:true  } ,
                                { label: '审核状态', name: '', index: '', sortable: true, width: 150, align: 'center', value: '有效',hidden:true   } ,
                                { label: '操作', name: '', index: '', sortable: true, width: 150, align: 'center' ,
                                    formatter:function(cellvalue, options, rowObject){
                                        var v_html ="<button class='btn btn-xs btn-success' onclick='queryData("+rowObject.id+","+rowObject.flowId+")'> 查看 </button>";
                                        return v_html;
                                    }}
      ],

      height: 'auto',
      autowidth: true,
      rowNum: 10,
      rowList: [10, 20, 30],
      pager: $('#pager'),
      shrinkToFit: true,
      viewrecords: true,
      altRows: true,
      multiselect: false,
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
  $("#teamMainQueryTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#teamMainQueryTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#teamMainQueryTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#teamMainQueryTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/teamMain/modify?id=' + rowdata.id)
  }

}
function queryData(id,reviewLevel) {
    commonForward('/mkmm/ui/teamMain/queryModify?id=' + id);
}

function batchDelete() {
    var ids = $("#teamMainQueryTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#teamMainQueryTable").trigger("reloadGrid");
            });
        }
    }
}

//获取当前日期，格式为yyyy-MM-dd
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

//截取日期
function splitStrToDate(str) {
    if (!str) {
        return
    }
    var date = str.toString();
    if (date.length > 10){
        return date.substring(0,10)
    }else {
        return ''
    }
}