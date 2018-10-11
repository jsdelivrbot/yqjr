var businessCode = $.getUrlParam("businessCode");
jQuery(function ($) {

    $("#activeMatchViewTable").jqGrid(
        {
            url: '/mkmm/sales/activeMatchDetails/pageByJqViewGrid?businessCode='+businessCode,
            datatype: "json",
            mtype: 'GET',
            colModel: [
                { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center',hidden:true } ,
                { label: '活动代码', name: 'businessCode', index: 'businessCode', sortable: true, width: 150, align: 'center' } ,
                { label: '活动名称', name: 'businessName', index: 'businessName', sortable: true, width: 150, align: 'center'  } ,
                { label: '归属区域名称', name: 'largeAreaName', index: 'largeAreaName', sortable: true, width: 150, align: 'center' } ,
                { label: '活动经销商', name: 'distributorName', index: 'distributorName', sortable: true, width: 150, align: 'center' } ,
                { label: '活动品牌', name: 'brandsName', index: 'brandsName', sortable: true, width: 150, align: 'center' } ,
                { label: '活动子品牌', name: 'seriesName', index: 'seriesName', sortable: true, width: 150, align: 'center' } ,
                { label: '活动车型', name: 'carBrandTypeName', index: 'carBrandTypeName', sortable: true, width: 150, align: 'center' } ,
                { label: '贷款金额', name: 'nloanMoney', index: 'nloanMoney', sortable: true, width: 150, align: 'center' } ,
                { label: '贷款期限', name: 'timeLimit', index: 'timeLimit', sortable: true, width: 150, align: 'center' } ,
                { label: '放款截止日期', name: 'dfactstartDate', index: 'dfactstartDate', sortable: true, width: 150, align: 'center' } ,
                { label: '营销活动', name: 'nactivitiesName', index: 'nactivitiesName', sortable: true, width: 150, align: 'center'} ,
                { label: '金融产品', name: 'ndlrbizTypeName', index: 'ndlrbizTypeName', sortable: true, width: 150, align: 'center' } ,
                { label: '业务模式', name: 'nbizTypeName', index: 'nbizTypeName', sortable: true, width: 150, align: 'center' } ,
                { label: '信贷产品', name: 'ngetinterestTypeName', index: 'ngetinterestTypeName', sortable: true, width: 150, align: 'center' }
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
                console.log(xhr);
                updatePagerIcons(table);
                setHash();
            }
        })
    $("#activeMatchViewTable").jqGrid('navGrid', $("#pager"), {
        edit: false,
        add: false,
        del: false,
        search: false,
        refresh: false
    })
    $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    // if (!shrinkToFit) {
    //     $("#activeMatchViewTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
    // }
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

function doExport() {
    var allData = $("#activeMatchViewTable").getRowData();
    // console.log(allData.length);
    if(allData.length == 0 ) {
        layer.alert("没有可导出的数据！");
    } else {
        commonForward('/mkmm/sales/activeMatchDetails/activeMatchDetail?businessCode=' + businessCode);
    }

}