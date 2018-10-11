var shrinkToFit = false;
$(function () {
    var user = getUserCookie();
    var currentUser = user.id;
  $("#feeMainReviewTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
          { label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '活动代码', name: 'businessCode', index: 'businessCode', sortable: true, width: 150, align: 'center' } ,
          { label: '活动名称', name: 'businessName', index: 'businessName', sortable: true, width: 150, align: 'center'},
          { label: '审核类型', name: 'reviewType', index: 'reviewType', sortable: true, width: 150, align: 'center',
              formatter:function(cellvalue, options, rowObject){
                  var html="";
                  html = "活动费用动支申请";
                  return html;
              }
          } ,
          { label: '提交人', name: 'creatorName', index: 'creatorName', sortable: true, width: 150, align: 'center'} ,
          { label: '提交时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center',
              formatter:function(cellvalue, options, rowObject){
                  var v_review_createTime=rowObject.createTime;
                  return v_review_createTime;
              }
          } ,
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
                  }
                  return html;
              }
          } ,
          { label: '操作', name: 'operate', index: 'operate', sortable: true, width: 150, align: 'center',
              formatter:function(cellvalue, options, rowObject){
                  var v_review_status=rowObject.reviewStatus;
                  var v_html="";
                  var businessCode = rowObject.businessCode;
                  var flowId = rowObject.flowId;
                  var id = rowObject.id;
                  // console.log(currentUser)
                  // console.log(rowObject.modifier)
                  // console.log(rowObject.flag)
                  // console.log(v_review_status)
                  if(currentUser == '1' || currentUser == '8506') {
                      v_html="<button class='btn btn-xs btn-success' onclick='viewFee(\""+businessCode+"\")'>查看</button>";
                  } else {
                      if("02"==v_review_status && "1" == rowObject.flag){
                          v_html="<button class='btn btn-xs btn-primary' onclick='updateFee(\""+businessCode+"\")'>审核</button>"+
                              "&nbsp;&nbsp;&nbsp;<button class='btn btn-xs btn-success' onclick='viewFee(\""+businessCode+"\")'>查看</button>";
                      }else if("03"==v_review_status && currentUser==rowObject.modifier && "1" == rowObject.flag){
                          v_html="<button class='btn btn-xs btn-primary' onclick='updateFee(\""+businessCode+"\")'>审核</button>"+
                              "&nbsp;&nbsp;&nbsp;<button class='btn btn-xs btn-success' onclick='viewFee(\""+businessCode+"\")'>查看</button>";
                      }else {
                          v_html="<button class='btn btn-xs btn-success' onclick='viewFee(\""+businessCode+"\")'>查看</button>";
                      }

                  }
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
  $("#feeMainReviewTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#feeMainReviewTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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

function updateFee(businessCode) {
    commonForward('/mkmm/ui/feeMainReview/modify?businessCode=' + businessCode)

}

function viewFee(businessCode) {
    commonForward('/mkmm/ui/feeMainReview/queryView?businessCode=' + businessCode)
}

function batchDelete() {
    var ids = $("#feeMainReviewTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#feeMainReviewTable").trigger("reloadGrid");
            });
        }
    }
}