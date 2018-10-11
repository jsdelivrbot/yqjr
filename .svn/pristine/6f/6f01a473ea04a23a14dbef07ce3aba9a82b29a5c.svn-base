var shrinkToFit = false;
$(function () {
    $("#personMainTable").jqGrid(
        {
            url: apiEntityBasePath + "/pageByJqGrid",
            datatype: "json",
            mtype: 'GET',
            colModel: [

                {label: '人员代码', name: 'personCode', index: 'personCode', sortable: true, width: 150, align: 'center'},
                {label: '人员姓名', name: 'personName', index: 'personName', sortable: true, width: 150, align: 'center'},
                {
                    label: '人员性质',
                    name: 'personNature',
                    index: 'personNature',
                    sortable: true,
                    width: 150,
                    align: 'center',
                    formatter: function (cellvalue, options, rowObject) {
                        var person_nature = rowObject.personTeam.personNature;
                        var html = "";
                        if ("0" == person_nature) {
                            html = "团队负责人"
                        } else if ("1" == person_nature) {
                            html = "销售经理"
                        }
                        return html;
                    }
                },

                {
                    label: '人员状态',
                    name: 'personStatus',
                    index: 'personStatus',
                    sortable: true,
                    width: 150,
                    align: 'center',
                    formatter: function (cellvalue, options, rowObject) {
                        var person_status = rowObject.personTeam.personStatus;
                        var html = "";
                        if ("0" == person_status) {
                            html = "无效"
                        } else if ("1" == person_status) {
                            html = "有效"
                        } else if ("2" == person_status){
                            html = "注销";
                        }
                        return html;
                    }
                },

                {
                    label: '团队代码', name: 'teamCode', index: 'teamCode', sortable: true, width: 150, align: 'center',
                    formatter: function (cellvalue, options, rowObject) {
                        return rowObject.personTeam.teamCode;
                    }
                },
                {
                    label: '团队名称', name: 'teamName', index: 'teamName', sortable: true, width: 150, align: 'center',
                    formatter: function (cellvalue, options, rowObject) {
                        return rowObject.teamMain.teamName;
                    }
                },
                {
                    label: '操作',
                    name: 'personCorrectime',
                    index: 'personCorrectime',
                    sortable: true,
                    width: 150,
                    align: 'center',
                    formatter: function (cellvalue, options, rowdata) {
                        var v_html = "<button class='btn btn-xs btn-success' onclick='tab(" + rowdata.id + "," + rowdata.flowId + ")'> 查看 </button>";
                        return v_html;
                    }
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
    $("#personMainTable").jqGrid('navGrid', {
        edit: false,
        add: false,
        del: false,
        search: false,
        refresh: false
    })
    $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    if (!shrinkToFit) {
        $("#personMainTable").closest(".ui-jqgrid-bdiv").css({'overflow-x': 'scroll'});
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

//查询
function tab(id, flowId) {
    commonForward('/mkmm/ui/personMain/tab?id=' + id);

}