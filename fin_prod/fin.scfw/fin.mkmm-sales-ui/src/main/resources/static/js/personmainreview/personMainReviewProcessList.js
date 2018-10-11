var shrinkToFit = false;
$(function () {
    $("#personMainReviewTable").jqGrid(
        {
            url: '/mkmm/sales/personMainReviews/processPageByJqGrid',
            datatype: "json",
            mtype: 'GET',
            colModel: [
                { label: '序列', name: 'id', index: 'id', sortable: true, width: 120, align: 'center',hidden:true } ,
                { label: '人员代码', name: 'personCode', index: 'personCode', sortable: true, width: 120, align: 'center' } ,
                { label: '人员姓名', name: 'personName', index: 'personName', sortable: true, width: 120, align: 'center' } ,
                { label: '审核类型', name: 'reviewType', index: 'reviewType', sortable: true, width: 120, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        var review_type=rowObject.reviewType;
                        var html="";
                        if("01"==review_type){
                            html="销售人员新增"
                        }else if("02"==review_type){
                            html="销售人员修改"
                        }
                        return html;
                    }
                } ,
                { label: '团队代码', name: 'teamCode', index: 'teamCode', sortable: true, width: 120, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        return rowObject.teamCode;
                    }
                }  ,

                { label: '提交时间', name: 'createTime', index: 'createTime', sortable: true, width: 120, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        console.log(rowObject.createTime);
                        var html = rowObject.createTime;
                        return  html;
                    }
                } ,

                { label: '审核状态', name: 'reviewStatus', index: 'reviewStatus', sortable: true, width: 120, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        var v_review_status=rowObject.reviewStatus;
                        var html="";
                        if("02"==v_review_status){
                            html="待审核"
                        }else if("00"==v_review_status){
                            html="驳回"
                        }else if("03"==v_review_status){
                            html="审核中"
                        }else if("04"==v_review_status){
                            html="审核通过"
                        }
                        return html;
                    }
                } ,
                { label: '操作', sortable: true, width: 130, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        var html = "";
                        // if (rowObject.reviewStatus == "00"){
                        //     html='<button class="btn btn-xs btn-success" onclick="update('+"'"+rowObject.personCode+"'"+','+rowObject.workFlow.id+')"> 操作 </button>'+
                        //         "&nbsp;&nbsp;&nbsp;<button onclick='view("+rowObject.personCode+","+rowObject.flowId+")' class='btn btn-xs btn-success' > 查看 </button>"
                        // }else {
                        //     html = "<button onclick='queryReviews("+rowObject.personCode+","+rowObject.flowId+")' class='btn btn-xs btn-success' > 查看 </button>"
                        // }
                        var personCode = rowObject.personCode;
                        var flowId = rowObject.flowId;
                        var reviewStatus = rowObject.reviewStatus;
                        if (reviewStatus == "00") {
                            html='<button class="btn btn-xs btn-warning" type="button" onclick="updateReviews(\''+personCode+'\')">修改</button>'
                                +'&nbsp;&nbsp;&nbsp;&nbsp;'
                                +'<button class="btn btn-xs btn-success" type="button" onclick="queryReviews(\''+personCode+'\')">查看</button>';
                        }else {
                            html= '<button class="btn btn-xs btn-success" type="button" onclick="queryReviews(\''+personCode+'\')">查看</button>';
                        }
                        return html
                    }
                },
                { label: '工作流ID', name: 'flowId', index: 'flowId', sortable: true, width: 120, align: 'center',hidden:true }
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
    $("#personMainReviewTable").jqGrid('navGrid', $("#pager"), {
        edit: false,
        add: false,
        del: false,
        search: false,
        refresh: false
    })
    $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    if (!shrinkToFit) {
        $("#personMainReviewTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
    }
    function updatePagerIcons(table) {
        var replacement =
            {
                'ui-icon-seek-first': 'ace-icon fa fa-angle-double-left bigger-150',
                'ui-icon-seek-prev': 'ace-icon fa fa-angle-left bigger-150',
                'ui-icon-seek-next': 'ace-icon fa fa-angle-right bigger-150',
                'ui-icon-seek-end': 'ace-icon fa fa-angle-double-right bigger-150'
            };
        $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
            var icon = $(this);
            var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

            if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
        });
    }
});

function queryReviews(personCode) {
    console.log("personCode:"+personCode);
    commonForward('/mkmm/ui/personMainReview/processview?personCode=' + personCode)
}

function updateReviews(personCode) {
    console.log("personCode:"+personCode);
    commonForward('/mkmm/ui/personMainReview/processmodify?personCode=' + personCode)
}

// function update() {
    // var ids = $("#personMainTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
    // if (ids.length === 0) {
    //     layer.alert("请选择需要操作的数据！");
    //     return false;
    // } else if (ids.length > 1) {
    //     layer.alert("请选择一条记录！");
    // } else if (ids.length === 1) {
    //     var rowdata = $("#personMainTable").jqGrid("getRowData", ids[0]);
    //     commonForward('/mkmm/ui/personMain/modify?id=' + rowdata.id)
    // }
// }

