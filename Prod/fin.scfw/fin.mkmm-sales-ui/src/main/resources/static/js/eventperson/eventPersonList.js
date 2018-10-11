var shrinkToFit = false;

$(function () {
    $("#eventPersonTable").jqGrid(
        {
            url: apiEntityBasePath + "/pageByJqGridList",
            datatype: "json",
            mtype: 'GET',
            colModel: [
                { label: '序号', name: 'id', index: 'id',hidden:true, sortable: true, width: 150, align: 'center' } ,
                {
                    label: '人员代码',
                    name: 'personCode',
                    index: 'personCode',
                    sortable: true,
                    width: 150,
                    align: 'center'
                },
                {
                    label: '人员姓名',
                    name: 'personName',
                    index: 'personName',
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
                    name: 'transcode1',
                    index: 'transcode1',
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
                }
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
    $("#eventPersonTable").jqGrid('navGrid', $("#pager"), {
        edit: false,
        add: false,
        del: false,
        search: false,
        refresh: false
    })
    $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    if (!shrinkToFit) {
        $("#eventPersonTable").closest(".ui-jqgrid-bdiv").css({'overflow-x': 'scroll'});
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
    var ids = $("#eventPersonTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据

    if (ids.length === 0) {
        layer.alert("请选择需要操作的数据！");
        return false;
    } else if (ids.length > 1) {
        layer.alert("请选择一条记录！");
    } else if (ids.length === 1) {
        var rowdata = $("#eventPersonTable").jqGrid("getRowData", ids[0]);
        commonForward('/mkmm/ui/eventPerson/modify?id=' + rowdata.id)
    }

}

function batchDelete() {
    var ids = $("#eventPersonTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
    if (ids.length === 0) {
        alert("请选择需要操作的数据！");
        return false;
    } else {
        if (confirm("确定进行删除？")) {
            var url = "/mkmm/sales/eventPersons" + '/batch/' + ids.toString();
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
                $("#eventPersonTable").trigger("reloadGrid");
            });
        }
    }
}
function seeLook(){
    var ids = $("#eventPersonTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
    if (ids.length === 0) {
        layer.alert("请选择需要操作的数据！");
        return false;
    } else if (ids.length > 1) {
        layer.alert("请选择一条记录！");
    } else if (ids.length === 1) {
        var rowdata = $("#eventPersonTable").jqGrid("getRowData", ids[0]);
        commonForward('/mkmm/ui/eventPerson/view?id=' + rowdata.id)
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