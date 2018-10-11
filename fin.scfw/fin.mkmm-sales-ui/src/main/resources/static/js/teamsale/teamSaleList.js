var shrinkToFit = false;
$(document).ready(function() {
    fundYear();
})
$(function () {
    $("#teamSaleTable").jqGrid(
        {
            url: apiEntityBasePath + "/pageByJqGrid",
            datatype: "local",
            mtype: 'GET',
            colModel: [
                { label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center',hidden:true } ,
                { label: '团队编号', name: 'teamCode', index: 'teamCode', sortable: true, width: 150, align: 'center',hidden:true } ,
                { label: '团队名称', name: 'teamName', index: 'teamName', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '品牌', name: 'brands', index: 'brands', sortable: true, width: 150, align: 'center',hidden:true } ,
                { label: '年度', name: 'year', index: 'year', sortable: true, width: 150, align: 'center',hidden:true } ,
                { label: '月', name: 'month', index: 'month', sortable: true, width: 150, align: 'center' } ,
                { label: '累计数量', name: 'amount', index: 'amount', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center',hidden:true } ,
                { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center',hidden:true } ,
                { label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center',hidden:true } ,
                { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center',hidden:true } ,
                { label: '所属公司', name: 'company', index: 'company', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                { label: '预算台数', name: 'planNum', index: 'planNum', sortable: true, width: 150, align: 'center' },
                { label: '实际台数', name: 'actualNum', index: 'actualNum', sortable: true, width: 150, align: 'center' },
                { label: '达成率', name: 'planRate', index: 'planRate', sortable: true, width: 150, align: 'center' },
                { label: '序时进度', name: 'rate', index: 'rate', sortable: true, width: 150, align: 'center' },
                { label: '达成率与序时进度差值', name: 'rateCal', index: 'rateCal', sortable: true, width: 150, align: 'center' }
            ],

            height: 'auto',
            autowidth: true,
            rowNum: 20,
            rowList: [20],
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
    $("#teamSaleTable").jqGrid('navGrid', $("#pager"), {
        edit: false,
        add: false,
        del: false,
        search: false,
        refresh: false
    })
    $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    if (!shrinkToFit) {
        $("#teamSaleTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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
    var ids = $("#teamSaleTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

    if (ids.length === 0) {
        layer.alert("请选择需要操作的数据！");
        return false;
    } else if (ids.length > 1) {
        layer.alert("请选择一条记录！");
    } else if (ids.length === 1) {
        var rowdata = $("#teamSaleTable").jqGrid("getRowData", ids[0]);
        commonForward('/mkmm/ui/teamSale/modify?id=' + rowdata.id)
    }

}

function batchDelete() {
    var ids = $("#teamSaleTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#teamSaleTable").trigger("reloadGrid");
            });
        }
    }
}

//选择时间的下拉框
function fundYear() {
    //先来取当前年份
    var date = new Date();
    var year = date.getFullYear();

    $("#year").val(year);
}

function searchDataOverWrite(tableName){
    var year = $("#year").val();
    var code = $("#teamCode").val();
    if(code==""||code==null){
        layer.alert("请输入团队代码！");
        return ;
    }
    var reg = /^[0-9]{4}$ /;
    if("" == year || null == year){
        layer.alert("请输入计划年度！");
        return ;
    }
    // if(!reg.test(year)){
    //     layer.alert("请输入正确的查询年份！");
    //     return ;
    // }

    $.ajax({
        type: 'GET',
        url: "/mkmm/sales/teamSales/queryTeamByCode?code="+code,
        dataType: "json",
        success: function (data) {
            // console.log(data)
            if(!data.isSuccess ) {
                layer.alert("团队不存在！");
            } else {
                var postData = {};
                var array = $("#searchForm").serializeArray();
                for(var i=0;i < array.length;i++){
                    if (array[i].value != '') {
                        postData[array[i].name] = array[i].value;
                    }
                }
                $("#teamName").empty();
                var teamCode = postData.teamCode;
                $.ajax({
                    type: 'POST',
                    url: "/mkmm/sales/teamSales/qryTeam",
                    data: {'teamCode':teamCode},
                    dataType: "json",
                    success: function (data) {
                        $("#teamName").attr("value",data);
                    }
                })
                $("#"+tableName).jqGrid("setGridParam",{
                    postData : postData,
                    page : 1,
                    datatype: "json"
                },true).trigger("reloadGrid");
            }
        },
        error:function () {
            layer.alert("查询失败！");
        }
    })
}

//计划跟踪导出
function teamSaleExport(){
    var teamCode = $('#teamCode').val();
    var year = $('#year').val();
    var brands = $('#brands').val();
    if(teamCode==null||year==null||teamCode==""||year==""){
        layer.alert("请输入团队代码");
        return ;
    }
    commonForward("/mkmm/sales/teamSales/teamSaleExport?teamCode="+teamCode+"&year="+year+"&brands="+brands);
}


$('.yearpicker').datepicker({
    startView: 'decade',
    minView: 'decade',
    format: 'yyyy',
    maxViewMode: 2,
    minViewMode:2,
    autoclose: true
});
