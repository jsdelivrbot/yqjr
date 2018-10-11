var shrinkToFit = false;
$(function () {
    var user = getUserCookie();
    var currentUser = user.id;
  $("#feeMainReviewQueryTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByQueryJqGrid?flag=1",
      datatype: "json",
      mtype: 'GET',
      colModel: [
          { label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '活动代码', name: 'businessCode', index: 'businessCode', sortable: true, width: 150, align: 'center' } ,
          { label: '活动名称', name: 'businessName', index: 'businessName', sortable: true, width: 150, align: 'center'},
          { label: '归属区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center' } ,
          { label: '活动品牌', name: 'brandsName', index: 'brandsName', sortable: true, width: 150, align: 'center' } ,
          { label: '审核状态', name: 'reviewStatus', index: 'reviewStatus', sortable: true, width: 150, align: 'center',
              formatter:function(cellvalue, options, rowObject) {
                  var v_review_status = rowObject.reviewStatus;
                  var html = "";
                  if ("02" == v_review_status) {
                      html = "待审核"
                  } else if ("00" == v_review_status) {
                      html = "驳回"
                  } else if ("03" == v_review_status) {
                      html = "审核中"
                  } else if ("04" == v_review_status) {
                      html = "审核通过"
                  } else if ("01" == v_review_status) {
                      html = "提交审核"
                  }
                  return html;
              }
          } ,
          { label: '操作', name: 'operate', index: 'operate', sortable: true, width: 150, align: 'center',
              formatter:function(cellvalue, options, rowObject){
              // console.log(rowObject.reviewStatus)
                  var v_review_status=rowObject.reviewStatus;
                  var v_html="";
                  var businessCode = rowObject.businessCode;
                  if("00"==v_review_status && "1" == rowObject.flag && currentUser ==rowObject.creator){
                      v_html="<button class='btn btn-xs btn-warning' onclick='doBILL(\""+businessCode+"\")'> 修改 </button>&nbsp;&nbsp;&nbsp;&nbsp;<button class='btn btn-xs btn-success' onclick='queryActive(\""+businessCode+"\")'> 查看 </button>";
                  }else{
                      v_html="<button class='btn btn-xs btn-success' onclick='queryActive(\""+businessCode+"\")'> 查看 </button>";
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
  $("#feeMainReviewQueryTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#feeMainReviewQueryTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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

// function update(id,wrokFlowId) {
//     commonForward('/mkmm/ui/feeMainReview/modify?id=' + id+'&wrokFlowId='+wrokFlowId);
// }

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

function doBILL(businessCode) {
    commonForward('/mkmm/ui/feeMainReview/queryModify?businessCode=' + businessCode)
}

function queryActive(businessCode) {
    commonForward('/mkmm/ui/feeMainReview/queryView?businessCode=' + businessCode)
}