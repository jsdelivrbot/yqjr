var shrinkToFit = false;

$(function () {

    var user=getUserCookie();
    var roleCode=user.roleCodeList;
    if (roleCode.indexOf('0000')>=0 || roleCode.indexOf('0001')>=0 || roleCode.indexOf('0002')>=0) {
    }else {
        $("#areaMainDiv").css("display","none");
    }



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




    $(".date-picker").datepicker({
        language: "zh-CN",
        autoclose: true,//选中之后自动隐藏日期选择框
        clearBtn: true,//清除按钮
        format: "yyyy-mm-dd"//日期格式
    });

  $("#activeMainTable").jqGrid(
    {
      url: apiEntityBasePath + "/mainAllActiveList",
      datatype: "json",
      mtype: 'GET',
      colModel: [
                    { label: 'ID', name: 'id', index: 'id', sortable: true, width: 150, align: 'center',hidden:true } ,
                    { label: '归属区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center' } ,
                    { label: '活动代码', name: 'activeCode', index: 'activeCode', sortable: true, width: 150, align: 'center' } ,
                    { label: '活动名称', name: 'activeName', index: 'activeName', sortable: true, width: 150, align: 'center' } ,
                    { label: '品牌编码', name: 'brandsCode', index: 'brandsCode', sortable: true, width: 150, align: 'center',hidden:true } ,
                    { label: '活动品牌', name: 'brandsName', index: 'brandsName', sortable: true, width: 150, align: 'center' } ,
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
                    { label: '预计笔数', name: 'expectedCount', index: 'expectedCount', sortable: true, width: 150, align: 'center' } ,
                    { label: '实际成交笔数', name: 'actualTurnoverCount', index: 'actualTurnoverCount', sortable: true, width: 150, align: 'center' } ,
                    { label: '达成率', name: 'reachRate', index: 'reachRate', sortable: true, width: 150, align: 'center' } ,
                    { label: '活动状态', name: 'activeStatus', index: 'activeStatus', sortable: true, width: 150, align: 'center',
                        formatter:function(cellvalue, options, rowObject){
                            var activeStatus=rowObject.activeStatus;
                            var html="";
                            if("01"==activeStatus){
                                html="未开始"
                            }else if("02"==activeStatus){
                                html="进行中"
                            }else if("03"==activeStatus){
                                html="已结束"
                            } else {
                                html=""
                            }
                            return html;
                        }} ,
                    { label: '动支状态', name: 'billStatus', index: 'billStatus', sortable: true, width: 150, align: 'center' ,
                        formatter:function(cellvalue, options, rowObject){
                             var billStatus=rowObject.billStatus;
                             var html="";
                             if("01"==billStatus){
                                 html="动支中"
                              }else if("02"==billStatus){
                                 html="动支已发送"
                             }else if("03"==billStatus){
                                 html="已动支"
                            } else {
                                 html="未动支"
                            }
                            return html;
                    }},

                    { label: '操作', sortable: true, width: 150, align: 'center',
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

function resetSelect() {
    $("#brandsCode").select2("val", "");
    $("#brandsCode").empty();
    var billStatus=document.getElementById("billStatus");
    billStatus.innerHTML="<option value=''>-全部-</option><option value='00'>未动支</option><option value='03'>已动支</option><option value='02'>动支已发送</option>";
    var activeStatus=document.getElementById("activeStatus");
    activeStatus.innerHTML="<option value=''>-全部-</option><option value='01'>未开始</option><option value='02'>进行中</option><option value='03'>已结束</option>";

}

function bill(){
    var select=document.getElementById("activeStatus");
    var c=select.value;
    var billStatus=document.getElementById("billStatus");
    switch(c)
    {
        case "":billStatus.innerHTML="<option value=''>-全部-</option><option value='00'>未动支</option><option value='03'>已动支</option><option value='02'>动支已发送</option>";
            break;
        case "01":billStatus.innerHTML="<option value='00'>未动支</option>";
            break;
        case "02":billStatus.innerHTML="<option value='00'>未动支</option>";
            break;
        case "03":billStatus.innerHTML="<option value=''>-全部-</option><option value='00'>未动支</option><option value='03'>已动支</option><option value='02'>动支已发送</option>";
            break;
        default:alert("error");
    }
};

function active(){
    var select=document.getElementById("billStatus");
    var c=select.value;
    var activeStatus=document.getElementById("activeStatus");
    switch(c)
    {
        case "":activeStatus.innerHTML="<option value=''>-全部-</option><option value='01'>未开始</option><option value='02'>进行中</option><option value='03'>已结束</option>";
            break;
        case "00":activeStatus.innerHTML="<option value=''>-全部-</option><option value='01'>未开始</option><option value='02'>进行中</option><option value='03'>已结束</option>";
            break;
        case "03":activeStatus.innerHTML="<option value='03'>已结束</option>";
            break;
        case "02":activeStatus.innerHTML="<option value='03'>已结束</option>";
            break;
        default:alert("error");
    }
};


