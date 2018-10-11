var shrinkToFit = false;

$(function () {
    $(".date-picker").datepicker({
        language: "zh-CN",
        autoclose: true,//选中之后自动隐藏日期选择框
        clearBtn: true,//清除按钮
        format: "yyyy-mm-dd"//日期格式
    });
    var user=getUserCookie();
    var roleCode=user.roleCodeList;
    if (roleCode.indexOf('0000')>=0 || roleCode.indexOf('0001')>=0 || roleCode.indexOf('0002')>=0) {
    }else {
        $("#areaMainDiv").css("display","none");
    }
  $("#activeMainTable").jqGrid(
    {
      url: apiEntityBasePath + "/mainActiveList",
      datatype: "json",
      mtype: 'GET',
      colModel: [
                    { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center',hidden:true } ,
                    { label: '归属区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center' } ,
                    { label: '活动代码', name: 'activeCode', index: 'activeCode', sortable: true, width: 150, align: 'center' } ,
                    { label: '活动名称', name: 'activeName', index: 'activeName', sortable: true, width: 200, align: 'center' } ,
                    { label: '品牌编码', name: 'brandsCode', index: 'brandsCode', sortable: true, width: 150, align: 'center',hidden:true } ,
                    { label: '活动品牌', name: 'brandsName', index: 'brandsName', sortable: true, width: 140, align: 'center' } ,
                    { label: '受理开始日期', name: 'activeStartime', index: 'activeStartime', sortable: true, width: 150, align: 'center' ,
                        formatter:function(cellvalue, options, rowObject){
                            var v_time=rowObject.activeStartime;
                            if (v_time == null){
                                return "";
                            }
                            var d = new Date(v_time);
                            var dformat = [ d.getFullYear(), (d.getMonth() + 1)<10?"0"+(d.getMonth() + 1):d.getMonth() + 1, d.getDate()<10?"0"+d.getDate():d.getDate()  ].join('-');
                            return dformat;
                        }} ,
                    { label: '受理截止日期', name: 'activeEndtime', index: 'activeEndtime', sortable: true, width: 150, align: 'center',
                        formatter:function(cellvalue, options, rowObject){
                            var v_time=rowObject.activeEndtime;
                            if (v_time == null){
                                return "";
                            }
                            var d = new Date(v_time);
                            var dformat = [ d.getFullYear(), (d.getMonth() + 1)<10?"0"+(d.getMonth() + 1):d.getMonth() + 1, d.getDate()<10?"0"+d.getDate():d.getDate()  ].join('-');
                            return dformat;
                        }} ,
                    { label: '预计笔数', name: 'expectedCount', index: 'expectedCount', sortable: true, width: 140, align: 'center' } ,
                    { label: '实际成交笔数', name: 'actualTurnoverCount', index: 'actualTurnoverCount', sortable: true, width: 140, align: 'center' } ,
                    { label: '达成率', name: 'reachRate', index: 'reachRate', sortable: true, width: 140, align: 'center' } ,
                    { label: '活动状态', name: 'activeStatus', index: 'activeStatus', sortable: true, width: 140, align: 'center',
                        formatter:function(cellvalue, options, rowObject){
                            var systemTime = rowObject.systemTime;
                            var beginTime = rowObject.activeStartime;
                            var endTime = rowObject.activeEndtime;
                            if (systemTime > endTime) {
                                return '已结束'
                            }else if (systemTime >= beginTime) {
                                return '进行中'
                            }else {
                                return '未开始'
                            }
                        }} ,
                    { label: '操作', sortable: true, width: 140, align: 'center',
                        formatter:function(cellvalue, options, rowObject){
                            var html = "";
                            html='<button class="btn btn-xs btn-success" type="button" onclick="activeMainView(\''+rowObject.activeCode+'\')">查看</button>';
                            return html
                        } }
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
    $("#activeMainTable").jqGrid('navGrid', $("#pager"), {
        edit: false,
        add: false,
        del: false,
        search: false,
        refresh: false
    })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    if (!shrinkToFit) {
        $("#activeMainTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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

function batchDelete() {
    var ids = $("#activeMainTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#activeMainTable").trigger("reloadGrid");
            });
        }
    }
}

function activeMainView(code) {
    // console.log(code)
    commonForward('/mkmm/ui/activeMain/queryView?activeCode=' + code);
}