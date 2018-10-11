var shrinkToFit = false;
$(function () {
    var user=getUserCookie();
    var roleCode=user.roleCodeList;
    if (roleCode.indexOf('0000')>=0 || roleCode.indexOf('0001')>=0 || roleCode.indexOf('0002')>=0) {
    }else {
        $("#areaMainDiv").css("display","none");
    }
    $("#areaCode").select2({
        ajax: {
            type: 'GET',
            url: "/mkmm/sales/selectCode/Zone",
            dataType: 'json',
            data: {
                isUpCode: '0'
            },
            processResults: function (data) {
                var areaInfos = data.result;
                var areaInfo = new Array();           //区域
                for (var i = 0; i < areaInfos.length; i++) {
                    areaInfo.push({id: areaInfos[i].value, text: areaInfos[i].label})
                }
                return{
                    results: areaInfo
                };
            },
            cache: true,
        }
    });
    $("#areaCode").on("select2:select",function(e){
        var data = $(this).val();
        if (data != null && data[0]=="00"){
            $("#areaCode").val(["00","全部"]).trigger('change')
        }
    })
    $("#brandsCode").select2({
        ajax: {
            type: 'GET',
            url: "/mkmm/sales/selectCode/CarBrand",
            dataType: 'json',
            data: {
                isUpCode: '0'
            },
            processResults: function (data) {
                var brandsInfos = data.result;
                var brandsInfo = new Array();           //品牌
                for (var i = 0; i < brandsInfos.length; i++) {
                    brandsInfo.push({id: brandsInfos[i].value, text: brandsInfos[i].label})
                }
                return{
                    results: brandsInfo
                };
            },
            cache: true,
        }
    });
    $("#brandsCode").on("select2:select",function(e){
        var data = $(this).val();
        if (data != null && data[0]=="00"){
            $("#brandsCode").val(["00","全部"]).trigger('change')
        }
    })
    $("#activeMainReviewTable").jqGrid(
        {
            url: apiEntityBasePath + "/processlist",
            datatype: "json",
            mtype: 'GET',
            colModel: [
                { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center',hidden:true } ,
                { label: '活动代码', name: 'activeCode', index: 'activeCode', sortable: true, width: 90, align: 'center' } ,
                { label: '活动名称', name: 'activeName', index: 'activeName', sortable: true, width: 160, align: 'center' } ,
                { label: '归属区域代码', name: 'areaCode', index: 'areaCode', sortable: true, width: 160, align: 'center',hidden:true},
                { label: '归属区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 160, align: 'center'} ,
                { label: '品牌代码', name: 'brandsCode', index: 'brandsCode', sortable: true, width: 150, align: 'center',hidden:true,
                    formatter:function(cellvalue, options, rowObject){
                        if (rowObject.activeCarReview){
                            return rowObject.activeCarReview.brandsCode==null?"":rowObject.activeCarReview.brandsCode;
                        }else {
                            return ""
                        }
                    }} ,
                { label: '活动品牌', name: 'brandsName', index: 'brandsName', sortable: true, width: 150, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        if (rowObject.activeCarReview){
                            return rowObject.activeCarReview.brandsName==null?"":rowObject.activeCarReview.brandsName;
                        }else {
                            return ""
                        }
                    }} ,
                { label: '审核状态', name: 'reviewStatus', index: 'reviewStatus', sortable: true, width: 100, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        var review_status=rowObject.reviewStatus;
                        var html="";
                        if("01"==review_status){
                            html="提交审核"
                        }else if("02"==review_status){
                            html="待审核"
                        }else if("00"==review_status){
                            html="驳回"
                        }else if("03"==review_status){
                            html="审核中"
                        }else if("04"==review_status){
                            html="审核通过"
                        }
                        return html;
                    }} ,
                { label: '操作', sortable: true, width: 100, align: 'center',
                    formatter:function(cellvalue, options, rowObject){
                        var html = "";
                        var activeId = rowObject.id;
                        var activeCode = rowObject.activeCode;
                        var reviewStatus = rowObject.reviewStatus;
                        if (reviewStatus == "00") {
                            html='<button class="btn btn-xs btn-warning" type="button" onclick="updateReviews(\''+activeId+'\')">修改</button>'
                            +'&nbsp;&nbsp;&nbsp;<button class="btn btn-xs btn-success" type="button" onclick="queryReviews(\''+activeId+'\')">查看</button>';
                        }else {
                            html= '<button class="btn btn-xs btn-success" type="button" onclick="queryReviews(\''+activeId+'\')">查看</button>';
                        }
                        return html
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
    $("#activeMainReviewTable").jqGrid('navGrid', $("#pager"), {
        edit: false,
        add: false,
        del: false,
        search: false,
        refresh: false
    })
    $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    if (!shrinkToFit) {
        $("#activeMainReviewTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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

function queryReviews(activeId) {
    console.log("activeId:"+activeId);
    commonForward('/mkmm/ui/activeMainReview/processview?id=' + activeId)
}

function updateReviews(activeId) {
    console.log("activeId:"+activeId);
    commonForward('/mkmm/ui/activeMainReview/processmodify?activeId=' + activeId)
}

function resetSelect() {
    $("#areaCode").select2("val", "");
    $("#brandsCode").select2("val", "");
    $("#areaCode").empty();
    $("#brandsCode").empty();
}