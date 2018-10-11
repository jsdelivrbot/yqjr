var shrinkToFit = false;
$(document).ready(function() {
    showFuncId();
    fundYear();
})
$(function () {
  $("#planTrackTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByTrackJqGrid",
      datatype: "local",
      mtype: 'GET',
      colModel: [
        { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '年份', name: 'year', index: 'year', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '月份', name: 'month', index: 'month', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '区域代码', name: 'areaCode', index: 'areaCode', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '归属区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center' } ,
						        { label: '团队代码', name: 'teamCode', index: 'teamCode', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '团队名称', name: 'teamName', index: 'teamName', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '下辖区域代码', name: 'cityCode', index: 'cityCode', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '下辖区域名称', name: 'cityName', index: 'cityName', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '人员代码', name: 'personCode', index: 'personCode', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '人员姓名', name: 'personName', index: 'personName', sortable: true, width: 150, align: 'center' } ,
						        { label: '人员性质', name: 'personType', index: 'personType', sortable: true, width: 150, align: 'center',
                                    formatter:function(cellvalue, options, rowObject){
                                        var v_personType=rowObject.personType;
                                        var html="";
                                        if("1"==v_personType){
                                            html="销售经理"
                                        }else if("0"==v_personType){
                                            html="团队负责人"
                                        }
                                        return html;
                                    }} ,
						        { label: '品牌', name: 'brands', index: 'brands', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '品牌类别', name: 'brandType', index: 'brandType', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '月实际台数达成量', name: 'monthActualNum', index: 'monthActualNum', sortable: true, width: 150, align: 'center' } ,
						        { label: '月台数预算', name: 'monthPlanNum', index: 'monthPlanNum', sortable: true, width: 150, align: 'center' } ,
                                { label: '月台数预算达成率(%)', name: 'monthPlanRate', index: 'monthPlanRate', sortable: true, width: 150, align: 'center' } ,
                                { label: '月序时进度(%)', name: 'monthRate', index: 'monthRate', sortable: true, width: 150, align: 'center' } ,
                                { label: '月达成率与序时进度差值(%)', name: 'monthRateCal', index: 'monthRateCal', sortable: true, width: 150, align: 'center' } ,
						        { label: '年台数实际达成量', name: 'yearActualNum', index: 'yearActualNum', sortable: true, width: 150, align: 'center' } ,
						        { label: '年台数预算数', name: 'yearPlanNum', index: 'yearPlanNum', sortable: true, width: 150, align: 'center' } ,
                                { label: '年台数预算数达成率(%)', name: 'yearPlanRate', index: 'yearPlanRate', sortable: true, width: 150, align: 'center' } ,
                                { label: '年序时进度(%)', name: 'yearRate', index: 'yearRate', sortable: true, width: 150, align: 'center' } ,
                                { label: '年达成率与序时进度差值(%)', name: 'yearRateCal', index: 'yearRateCal', sortable: true, width: 150, align: 'center' },
						        { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '备用1', name: 'transcode1', index: 'transcode1', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '备用2', name: 'transcode2', index: 'transcode2', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '备用3', name: 'transcode3', index: 'transcode3', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '备用4', name: 'transcode4', index: 'transcode4', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' ,hidden:true} ,
						        { label: '最新标识', name: 'flag', index: 'flag', sortable: true, width: 150, align: 'center' ,hidden:true}
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
        // console.log(table);
        updatePagerIcons(table);
        setHash();
      }
    })
  $("#planTrackTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#planTrackTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
  var ids = $("#planTrackTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#planTrackTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/planTrack/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#planTrackTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#planTrackTable").trigger("reloadGrid");
            });
        }
    }
}
function result(){
    commonForward('/mkmm/ui/planTrack/result')
}

//页面加载时查询所有大区
function showFuncId() {
    $("#areaCode").empty();
    var ciValue = $('#areaCode');
    ciValue.append('<option value="">-全部-</option>');
    $.ajax({
        type: 'POST',
        url: "/mkmm/sales/planTracks/qryProvince",
        dataType: "json",
        success: function (data) {

            for (var i in data) {
                var jsonObj = data[i];
                // console.log(jsonObj)
                var name = jsonObj.label;
                var code = jsonObj.value;
                // console.log(vorganizationno);
                var option = '';
                option += "<option value=\""  + code + "\">" + name + "</option>";
                ciValue.append(option);
            }
        }
    })

}

//页面二级联动
function selectChange(vorganizationno) {
    // console.log(vorganizationno);
    $("#cityCode").empty();
    var ciValue2 = $('#cityCode');
    ciValue2.append('<option value="">-请选择-</option>');

    $.ajax({
        type: 'POST',
        url:  '/mkmm/sales/planTracks/qryCity',
        dataType: 'json',
        data:{"vorganizationno": vorganizationno},
        success: function (data) {
            if(data != null ){
                for (var i in data) {
                    var jsonObj = data[i];
                    var name = jsonObj.vname;
                    var vorganizationno = jsonObj.vorganizationno;
                    // console.log(vorganizationno);
                    var option = '';
                    option += "<option value=\""  + vorganizationno + "\">" + name + "</option>";
                    ciValue2.append(option);
                }
            }
        }
    })
}

//导出计划跟踪查询结果
function oneExplore() {
    var allData = $("#planTrackTable").getRowData()
    if(allData.length == 0) {
        layer.alert("没有可导出的数据！");
    } else {
        var url = apiEntityBasePath + '/createTrackExcel';
        var areaCode = document.getElementById("areaCode").value;
        var brands = document.getElementById("brands").value;
        var year = document.getElementById("year").value;
        var month = document.getElementById("month").value;
        var personName = document.getElementById("personName").value;
        // console.log(personName);
        commonForward(url+"?year="+year+"&areaCode="+areaCode+"&brands="+brands+"&month="+month+"&personName="+personName);
    }
}

//选择时间的下拉框
function fundYear() {
    //先来取当前年份
    var date = new Date();
    var year = date.getFullYear();
    $("#year").val(year);
}

function searchData1111(tableName){
    var Year = $("#year").val();
    if(Year==""||Year==null){
        layer.alert("请输入年份查询");
        return ;
    }
    var postData = {};
    var array = $("#searchForm").serializeArray();
    for(var i=0;i < array.length;i++){
        if (array[i].value != '') {
            postData[array[i].name] = array[i].value;
        }
    }

    $("#"+tableName).jqGrid("setGridParam",{
        postData : postData,
        page : 1,
        datatype: "json"
    },true).trigger("reloadGrid");
}

$('.yearpicker').datepicker({
    startView: 'decade',
    minView: 'decade',
    format: 'yyyy',
    maxViewMode: 2,
    minViewMode:2,
    autoclose: true
});