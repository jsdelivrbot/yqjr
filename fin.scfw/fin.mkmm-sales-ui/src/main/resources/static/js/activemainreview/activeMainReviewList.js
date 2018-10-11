var shrinkToFit = false;
$(function () {
    var user = getUserCookie();
    var currentUser = user.id;
    console.log("当前User的ID为：" + currentUser);
    $("#activeMainReviewTable").jqGrid(
        {
            url: apiEntityBasePath + "/pageByJqGrid",
            datatype: "json",
            mtype: 'GET',
            colModel: [
                {label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center', hidden: true},
                {label: '活动代码', name: 'activeCode', index: 'activeCode', sortable: true, width: 150, align: 'center'},
                {label: '活动名称', name: 'activeName', index: 'activeName', sortable: true, width: 150, align: 'center'},
                {
                    label: '审核类型', name: 'reviewType', index: 'reviewType', sortable: true, width: 150, align: 'center',
                    formatter: function (cellvalue, options, rowObject) {
                        var review_type = rowObject.reviewType;
                        var html = "";
                        if ("01" == review_type) {
                            html = "新增"
                        } else if ("02" == review_type) {
                            html = "修改"
                        }
                        return html;
                    }
                },
                {label: '提交人', name: 'creatorName', index: 'creatorName', sortable: true, width: 150, align: 'center'},
                {
                    label: '提交时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center',
                    formatter: function (cellvalue, options, rowObject) {
                        var v_review_createTime = rowObject.createTime;
                        if (v_review_createTime == null) {
                            return null;
                        }
                        var d = new Date(v_review_createTime);

                        var dformat = [d.getFullYear(), (d.getMonth() + 1) < 10 ? "0" + (d.getMonth() + 1) : d.getMonth() + 1, d.getDate() < 10 ? "0" + d.getDate() : d.getDate()].join('-')
                            + ' ' + [d.getHours() < 10 ? "0" + d.getHours() : d.getHours(), d.getMinutes() < 10 ? "0" + d.getMinutes() : d.getMinutes(), d.getSeconds() < 10 ? "0" + d.getSeconds() : d.getSeconds()].join(':');
                        return dformat;
                    }
                },
                {
                    label: '审核状态',
                    name: 'reviewStatus',
                    index: 'reviewStatus',
                    sortable: true,
                    width: 150,
                    align: 'center',
                    formatter: function (cellvalue, options, rowObject) {
                        var review_status = rowObject.reviewStatus;
                        var html = "";
                        if ("01" == review_status) {
                            html = "提交审核"
                        } else if ("02" == review_status) {
                            html = "待审核"
                        } else if ("00" == review_status) {
                            html = "驳回"
                        } else if ("03" == review_status) {
                            html = "审核中"
                        } else if ("04" == review_status) {
                            html = "审核通过"
                        }
                        return html;
                    }
                },
                {
                    label: '操作', sortable: true, width: 150, align: 'center',
                    formatter: function (cellvalue, options, rowObject) {
                        var html = "";
                        var reviewStatus = rowObject.reviewStatus;
                        var activeCode = rowObject.activeCode;
                        var mid = rowObject.id;
                        if (currentUser == '1' || currentUser == '8506') {
                            html = '<button class="btn btn-xs btn-success" type="button" onclick="queryReviews(\'' + mid + '\')">查看</button>';
                        } else {
                            if (reviewStatus == "02") {
                                html = '<button class="btn btn-xs btn-info" type="button" onclick="updateReviews(\'' + mid + '\')">审核</button>'
                                    + '&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-xs btn-success" type="button" onclick="queryReviews(\'' + mid + '\')">查看</button>';
                            } else if (reviewStatus == "03" && currentUser == rowObject.modifier) {
                                html = '<button class="btn btn-xs btn-info" type="button" onclick="updateReviews(\'' + mid + '\')">审核</button>'
                                    + '&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-xs btn-success" type="button" onclick="queryReviews(\'' + mid + '\')">查看</button>';
                            } else {
                                html = '<button class="btn btn-xs btn-success" type="button" onclick="queryReviews(\'' + mid + '\')">查看</button>';
                            }
                        }
                        return html
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
    $("#activeMainReviewTable").jqGrid({
        edit: false,
        add: false,
        del: false,
        search: false,
        refresh: false
    })
    $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    if (!shrinkToFit) {
        $("#activeMainReviewTable").closest(".ui-jqgrid-bdiv").css({'overflow-x': 'scroll'});
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

function queryReviews(mid) {
    console.log("mid:" + mid);
    commonForward('/mkmm/ui/activeMainReview/check?id=' + mid + '&type=query')
}

function updateReviews(mid) {
    console.log("mid:" + mid);
    commonForward('/mkmm/ui/activeMainReview/check?id=' + mid + '&type=update')
}

