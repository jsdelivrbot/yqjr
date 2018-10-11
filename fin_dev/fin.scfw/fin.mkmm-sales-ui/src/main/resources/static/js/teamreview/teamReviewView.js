jQuery(function ($) {
    $("#inputForm").find('input').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    var workid = $.getUrlParam("workid");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/teamReviews/teamReviewWatch?id=' + mid+'&workeid='+workid,
        dataType: 'json'
    }).then(function (obj) {
        // 查询失败
        if (!obj.isSuccess) {
            layer.alert(obj.msg);
            return;
        }
        var result = obj.result;
        $("#areaCode").val(result.areaCode);
        $("#areaName").val(result.areaName);
        $("#teamCode").val(result.teamCode);
        $("#teamName").val(result.teamName);
        $("#teamLevel").val(result.teamLevel);
        $("#teamType").val(result.teamType);
        $("#teamStatus").val(result.teamStatus);
        $("#teamPhone").val(result.teamPhone);
        $("#teamZip").val(result.teamZip);
        $("#teamAddress").val(result.teamAddress);
        $("#teamFax").val(result.teamFax);
        $("#createTime").val(result.createTime);
        $("#remark").val(result.remark);
        $("#reviewType").val(result.reviewType);
        $("#reviewStatus").val(result.reviewStatus);
        $("#opinion").val(result.opinion);
        $("#startTime").val(splitStrToDate(result.startTime));
    }, function (e) {
        layer.alert("查询数据失败:" + e);
    })

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