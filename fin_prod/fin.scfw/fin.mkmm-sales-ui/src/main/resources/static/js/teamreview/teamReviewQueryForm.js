jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var mid = $.getUrlParam("id");

    $.ajax({
        type: 'GET',
        url: apiEntityBasePath+'/' + mid,
        dataType: 'json'
    }).then(function (obj) {
        // 查询失败
        if (!obj.isSuccess) {
            layer.alert(obj.msg);
            return;
        }
        var result = obj.result;
        $("#id").val(result.id);
        $("#areaCode").val(result.areaCode);
        $("#areaName").val(result.areaName);
        $("#teamCode").val(result.teamCode);
        $("#teamName").val(result.teamName);
        $("#teamLevel").val(result.teamLevel);
        $("#teamType").val(result.teamType);
        $("#teamStatus").val(result.teamStatus);
        $("#teamLeader").val(result.teamLeader);
        $("#teamPhone").val(result.teamPhone);
        $("#teamZip").val(result.teamZip);
        $("#teamAddress").val(result.teamAddress);
        $("#teamFax").val(result.teamFax);
        $("#startTime").val(splitStrToDate(result.startTime));
        $("#createTime").val(result.createTime);
        $("#modifyTime").val(result.modifyTime);
        $("#creator").val(result.creator);
        $("#modifier").val(result.modifier);
        $("#remark").val(result.remark);
        $("#reviewType").val(result.reviewType);
        $("#flag").val(result.flag);
        $("#reviewStatus").val(result.reviewStatus);
        $("#transcode1").val(result.transcode1);
        $("#transcode2").val(result.transcode2);
        $("#transcode3").val(result.transcode3);
        $("#transcode4").val(result.transcode4);
        initDataWorkFlow(result.teamCode);
    }, function (e) {
        layer.alert("查询数据失败:" + e);
    });

    function initDataWorkFlow(teamCode){
        // $("#personDiv").show();
        $("#workFlowsTable").jqGrid(
            {
                url: "/mkmm/sales/workFlows/selectWorkFlow?reviewId="+teamCode,
                datatype: "json",
                mtype: 'GET',
                colModel: [
                    { label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                    { label: '审核类型', name: 'type', index: 'type', sortable: true, width: 150, align: 'center',
                        formatter:function(cellvalue, options, rowObject){
                            var v_review_type=rowObject.type;
                            var v_html="";
                            if("01"==v_review_type){
                                v_html="新增"
                            }else if("02"==v_review_type){
                                v_html="修改"
                            }
                            return v_html;
                        }
                    } ,
                    { label: '审核事件id', name: 'reviewId', index: 'reviewId', sortable: true, width: 150, align: 'center' ,hidden:true} ,
                    { label: '审核级别', name: 'reviewLevel', index: 'reviewLevel', sortable: true, width: 150, align: 'center',
                        formatter:function(cellvalue, options, rowObject){
                            var v_review_reviewLevel=rowObject.reviewLevel;
                            var v_html="";
                            if("1"==v_review_reviewLevel){
                                v_html="一级审核"
                            }else if("2"==v_review_reviewLevel){
                                v_html="二级审核"
                            }
                            return v_html;
                        } } ,
                    { label: '审核状态', name: 'reviewStatus', index: 'reviewStatus', sortable: true, width: 150, align: 'center',
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
                            }else if("01"==v_review_status){
                                html="提交审核"
                            }
                            return html;
                        }} ,
                    { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center',hidden:true } ,
                    { label: '审核时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center',
                        formatter:function(cellvalue, options, rowObject){
                            var modifyTime=rowObject.modifyTime;
                            var html= new Date(modifyTime).pattern("yyyy-MM-dd hh:mm:ss");
                            return html;
                        }
                    } ,
                    { label: '审核人', name: 'modifierName', index: 'modifierName', sortable: true, width: 150, align: 'center' } ,
                    { label: '审核意见', name: 'opinion', index: 'opinion', sortable: true, width: 150, align: 'center' }
                ],

                height: 'auto',
                autowidth: true,
                rowNum: 100,
                rowList: [100, 200, 300],
                pager: $('#pager'),
                shrinkToFit: true,
                viewrecords: true,
                altRows: true,
                multiselect: false,
                multiboxonly: false,
                sortable: false,
                sorttype: false,
                //当从服务器返回响应时执行
                loadComplete: function (xhr) {
                    var table = this;
                    updatePagerIcons(table);
                    setHash();
                }
            })
        // $("#workFlowsTable").jqGrid('navGrid', $("#pager"), {
        //     edit: false,
        //     add: false,
        //     del: false,
        //     search: false,
        //     refresh: false
        // })
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

    Date.prototype.pattern=function(fmt) {
        var o = {
            "M+" : this.getMonth()+1, //月份
            "d+" : this.getDate(), //日
            "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
            "H+" : this.getHours(), //小时
            "m+" : this.getMinutes(), //分
            "s+" : this.getSeconds(), //秒
            "q+" : Math.floor((this.getMonth()+3)/3), //季度
            "S" : this.getMilliseconds() //毫秒
        };
        var week = {
            "0" : "/u65e5",
            "1" : "/u4e00",
            "2" : "/u4e8c",
            "3" : "/u4e09",
            "4" : "/u56db",
            "5" : "/u4e94",
            "6" : "/u516d"
        };
        if(/(y+)/.test(fmt)){
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        }
        if(/(E+)/.test(fmt)){
            fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);
        }
        for(var k in o){
            if(new RegExp("("+ k +")").test(fmt)){
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            }
        }
        return fmt;
    }

});

function splitStrToDate(str) {
    if (!str) {
        return
    }
    var date = str.toString();
    if (date.length > 10){
        return date.substring(0,10)
    }else {
        return ''
    }
}