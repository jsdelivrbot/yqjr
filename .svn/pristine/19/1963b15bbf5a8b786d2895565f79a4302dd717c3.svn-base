var shrinkToFit = false;
$(document).ready(function() {
    fundYear();
    $(function () {
        $('#myTab a:first').tab('show');
    })
    $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');

    })
});
$(function () {
    $("#personPlanTable").jqGrid(
        {
            url: apiEntityBasePath + "/pageByJqGrid",
            datatype: "json",
            mtype: 'GET',
            colModel: [
                { label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '人员代码', name: 'personCode', index: 'personCode', sortable: true, width: 150, align: 'center' } ,
                { label: '人员姓名', name: 'personName', index: 'personName', sortable: true, width: 150, align: 'center' } ,
                // { label: '所属公司', name: 'company', index: 'company', sortable: true, width: 150, align: 'center' ,
                //     formatter:function(cellvalue, options, rowObject){
                //         var company=rowObject.company;
                //         var html="";
                //         if("1"==company){
                //             html="汽车金融公司"
                //         }else if("2"==company){
                //             html="租赁公司"
                //         }else if("3"==company){
                //             html="财务公司"
                //         }
                //         return html;
                //     }},
                { label: '品牌', name: 'brands', index: 'brands', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '年度', name: 'year', index: 'year', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '月', name: 'month', index: 'month', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '数量', name: 'amount', index: 'amount', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '一月', name: 'january', index: 'january', sortable: true, width: 150, align: 'center' } ,
                { label: '二月', name: 'february', index: 'february', sortable: true, width: 150, align: 'center' } ,
                { label: '三月', name: 'march', index: 'march', sortable: true, width: 150, align: 'center' } ,
                { label: '四月', name: 'april', index: 'april', sortable: true, width: 150, align: 'center' } ,
                { label: '五月', name: 'may', index: 'may', sortable: true, width: 150, align: 'center' } ,
                { label: '六月', name: 'june', index: 'june', sortable: true, width: 150, align: 'center' } ,
                { label: '七月', name: 'jule', index: 'jule', sortable: true, width: 150, align: 'center' } ,
                { label: '八月', name: 'august', index: 'august', sortable: true, width: 150, align: 'center' } ,
                { label: '九月', name: 'september', index: 'september', sortable: true, width: 150, align: 'center' } ,
                { label: '十月', name: 'october', index: 'october', sortable: true, width: 150, align: 'center' } ,
                { label: '十一月', name: 'november', index: 'november', sortable: true, width: 150, align: 'center' } ,
                { label: '十二月', name: 'december', index: 'december', sortable: true, width: 150, align: 'center' }
            ],
            height: 'auto',
            autowidth: true,
            rowNum: 10000,
            rowList: [10000, 20000, 30000],
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
    // $("#personPlanTable").jqGrid('navGrid', $("#pager"), {
    //     edit: false,
    //     add: false,
    //     del: false,
    //     search: false,
    //     refresh: false
    // });
    $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    if (!shrinkToFit) {
        $("#teamMainTable").closest(".ui-jqgrid-bdiv").css({'overflow-x': 'scroll'});
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
  var ids = $("#personPlanTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#personPlanTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/personPlan/modify?id=' + rowdata.id)
  }

}

function batchDelete() {
    var ids = $("#personPlanTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#personPlanTable").trigger("reloadGrid");
            });
        }
    }
}

//根据年导出计划
function explorePlan() {
    var allData = $("#personPlanTable").getRowData();
    var year = $("#year").val();
    console.log(year);
    if(null==year || "" == year ) {
        layer.alert("请输入导出的年份！");
    } else {
        var url = apiEntityBasePath + '/createPlanExcel';
        var year = document.getElementById("year").value;
        commonForward(url+"?year="+year);
    }
}

function searchDataOverWrite(tableName){
    var year = $("#year").val();
    if(year==""||year==null){
        layer.alert("请输入年份查询");
        return ;
    }

    $("#queryYear").attr("value",year);
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
    $('#myTab a:first').tab('show');
}

$('.yearpicker').datepicker({
    startView: 'decade',
    minView: 'decade',
    format: 'yyyy',
    maxViewMode: 2,
    minViewMode:2,
    autoclose: true
});

function fundYear() {
    //先来取当前年份
    var date = new Date();
    var year = date.getFullYear();
    $("#year").val(year);
}

function queryBrands(obj) {
    var year = $('#queryYear').val();
    // console.log(obj)
    $("#brands").attr("value",obj);
    var personPlanTable = 'personPlanTable';
    // $("#personPlanTable  tr:not(:first)").empty("");
    searchDataOverWrite(personPlanTable);

}