var shrinkToFit = false;
$(function () {
    var user = getUserCookie();
    var roleCode = user.roleCodeList;
    console.log(user)
    if (roleCode.indexOf('0000')>=0 || roleCode.indexOf('0001')>=0 || roleCode.indexOf('0002')>=0) {
    }else {
        $("#areaMainDiv").css("display","none");
    }
  $("#activeMatchMainTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGridQuery",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center', hidden:true } ,
                              { label: '活动代码', name: 'businessCode', index: 'businessCode', sortable: true, width: 150, align: 'center' } ,
                              { label: '活动名称', name: 'businessName', index: 'businessName', sortable: true, width: 150, align: 'center' } ,
          { label: '归属区域代码', name: 'areaCode', index: 'areaCode', sortable: true, width: 150, align: 'center' } ,
          { label: '归属区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center' } ,
                              { label: '活动品牌', name: 'brandsName', index: 'brandsName', sortable: true, width: 150, align: 'center' } ,
                              { label: '受理开始日期', name: 'activeStartime', index: 'activeStartime', sortable: true, width: 150, align: 'center' } ,
                              { label: '受理截止日期', name: 'activeEndtime', index: 'activeEndtime', sortable: true, width: 150, align: 'center' } ,
                              { label: '预计活动成交数量', name: 'estimateTurnoverCount', index: 'estimateTurnoverCount', sortable: true, width: 150, align: 'center' } ,
                              { label: '实际活动成交数量', name: 'actualTurnoverCount', index: 'actualTurnoverCount', sortable: true, width: 150, align: 'center' } ,
                              { label: '达成率', name: 'reachRate', index: 'reachRate', sortable: true, width: 150, align: 'center' } ,
                              { label: '是否发起动支', name: 'isSettlement', index: 'isSettlement', sortable: true, width: 150, align: 'center' ,
                                  formatter:function(cellvalue, options, rowObject){
                                    var isSettlement=rowObject.isSettlement;
                                      var html="";
                                      if("01" == isSettlement) {
                                          html = "未发起";
                                      } else if("02" == isSettlement){
                                          html = "已发起";
                                      }
                                      return html;
                              }},
                              { label: '动支状态', name: 'billStatus', index: 'billStatus', sortable: true, width: 150, align: 'center' ,formatter:function(cellvalue, options, rowObject){
                                  var billStatus=rowObject.billStatus;
                                  var html="";
                                  if("01"==billStatus){
                                      html="未动支"
                                  }else if("02"==billStatus){
                                      html="动支中"
                                  }else if("03"==billStatus){
                                      html="已动支"
                                  }else if("04"==billStatus){
                                      html="驳回"
                                  } else {
                                      html="未动支"
                                  }
                                  return html;
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
  $("#activeMatchMainTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#activeMatchMainTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
$(".date-picker").datepicker({
    language: "zh-CN",
    autoclose: true,//选中之后自动隐藏日期选择框
    clearBtn: true,//清除按钮
    format: "yyyy-mm-dd"//日期格式
});

function doPay() {
  var ids = $("#activeMatchMainTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
    // console.log(ids)
  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#activeMatchMainTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/activeMatchMain/modify?id=' + rowdata.id+'&businessCode='+rowdata.businessCode);
  }

}


function batchDelete() {
    var ids = $("#activeMatchMainTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#activeMatchMainTable").trigger("reloadGrid");
            });
        }
    }
}

function viewDetail() {
    var ids = $("#activeMatchMainTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

    if (ids.length === 0) {
        layer.alert("请选择需要操作的数据！");
        return false;
    } else if (ids.length > 1) {
        layer.alert("请选择一条记录！");
    } else if (ids.length === 1) {
        var rowdata = $("#activeMatchMainTable").jqGrid("getRowData", ids[0]);
        commonForward('/mkmm/ui/activeMatchMain/view?businessCode=' + rowdata.businessCode)
    }

}