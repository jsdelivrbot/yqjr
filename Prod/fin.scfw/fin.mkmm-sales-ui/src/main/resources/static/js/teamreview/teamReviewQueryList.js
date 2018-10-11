var shrinkToFit = false;
$(function () {
    var user=getUserCookie();
    var roleCode=user.roleCodeList;
    if (roleCode.indexOf('0000')>=0 || roleCode.indexOf('0001')>=0 || roleCode.indexOf('0002')>=0) {
    }else {
        $("#areaMainDiv").css("display","none");
    }

  $("#teamReviewQueryTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid?flag=1",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center' ,hidden:true } ,
          { label: '归属区域代码', name: 'areaCode', index: 'areaCode', sortable: true, width: 150, align: 'center', } ,
          { label: '归属区域名称', name: 'areaName', index: 'areaName', sortable: true, width: 150, align: 'center', } ,
          { label: '团队代码', name: 'teamCode', index: 'teamCode', sortable: true, width: 150, align: 'center' } ,
          { label: '团队名称', name: 'teamName', index: 'teamName', sortable: true, width: 170, align: 'center' } ,
          { label: '团队等级', name: 'teamLevel', index: 'teamLevel', sortable: true, width: 120, align: 'center' ,formatter:function(cellvalue, options, rowObject){
                  var v_teamLevel=rowObject.teamLevel;
                  var html="";
                  if("01"==v_teamLevel){
                      html="一级"
                  }else if("02"==v_teamLevel){
                      html="二级"
                  }else if("03"==v_teamLevel){
                      html="三级"
                  }
                  return html;
              } } ,
          { label: '团队类型', name: 'teamType', index: 'teamType', sortable: true, width: 120, align: 'center',formatter:function(cellvalue, options, rowObject){
                  var v_teamType=rowObject.teamType;
                  var html="";
                  if("01"==v_teamType){
                      html="普通"
                  }
                  return html;
              } } ,
          { label: '团队状态', name: 'teamStatus', index: 'teamStatus', sortable: true, width: 120, align: 'center',formatter:function(cellvalue, options, rowObject){
                  var v_teamStatus=rowObject.teamStatus;
                  var html="";
                  if("0"==v_teamStatus){
                      html="无效"
                  }else if("1"==v_teamStatus){
                      html="有效"
                  }
                  return html;
              } } ,
          { label: '审核类型', name: 'reviewType', index: 'reviewType', sortable: true, width: 120, align: 'center' ,formatter:function(cellvalue, options, rowObject){
                  var v_reviewType=rowObject.reviewType;
                  var html="";
                  if("01"==v_reviewType){
                      html="新增"
                  }else if("02"==v_reviewType){
                      html="修改"
                  }
                  return html;
              }},
		  { label: '审核状态', name: 'reviewStatus', index: 'reviewStatus', sortable: true, width: 130, align: 'center',
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
                                    }
                                } ,
        {label: '操作', sortable: true, width: 170, align: 'center',
                                      formatter:function(cellvalue, options, rowObject){
                                          var v_review_status=rowObject.reviewStatus;
                                          var v_html="";
                                          console.log();
                                          if("00"==v_review_status && "1" == rowObject.flag){
                                              v_html="<button class='btn btn-xs btn-warning' onclick='update("+rowObject.id+","+rowObject.flowId+")'> 修改 </button>&nbsp;&nbsp;&nbsp;<button class='btn btn-xs btn-success' onclick='queryReview("+rowObject.id+","+rowObject.flowId+")'> 查看 </button>"
                                          }else{
                                              v_html="<button class='btn btn-xs btn-success' onclick='queryReview("+rowObject.id+","+rowObject.flowId+")'> 查看 </button>"
                                          }
                                          return v_html;
                                      }
                                },
          { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '提交人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center',hidden:true} ,
          { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '有效标识（如表记录不删除，以此区分）', name: 'flag', index: 'flag', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '备用字段1', name: 'transcode1', index: 'transcode1', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '邮编', name: 'teamZip', index: 'teamZip', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '地址', name: 'teamAddress', index: 'teamAddress', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '传真', name: 'teamFax', index: 'teamFax', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '备注', name: 'remark', index: 'remark', sortable: true, width: 150, align: 'center' ,hidden:true} ,
          { label: '备用字段2', name: 'transcode2', index: 'transcode2', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '备用字段3', name: 'transcode3', index: 'transcode3', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '备用字段4', name: 'transcode4', index: 'transcode4', sortable: true, width: 150, align: 'center',hidden:true },
          { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '团队等级', name: 'teamLevel', index: 'teamLevel', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '团队类型', name: 'teamType', index: 'teamType', sortable: true, width: 150, align: 'center',hidden:true  } ,
          { label: '团队状态', name: 'teamStatus', index: 'teamStatus', sortable: true, width: 150, align: 'center',hidden:true  } ,
          { label: '团队负责人', name: 'teamLeader', index: 'teamLeader', sortable: true, width: 150, align: 'center',hidden:true } ,
          { label: '联系电话', name: 'teamPhone', index: 'teamPhone', sortable: true, width: 150, align: 'center' ,hidden:true}
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
  $("#teamReviewQueryTable").jqGrid('navGrid', $("#pager"), {
    edit: false,
    add: false,
    del: false,
    search: false,
    refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#teamReviewQueryTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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

function update(id,flowId,reviewLevel) {
    // alert(id);
    // alert(flowId);
    commonForward('/mkmm/ui/teamReview/queryModify?id=' + id+'&flowid='+flowId)
}

function queryReview(id,flowId,reviewLevel) {
    commonForward('/mkmm/ui/teamReview/queryForm?id=' + id+'&flowid='+flowId)
}

function batchDelete() {
    var ids = $("#teamReviewQueryTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#teamReviewQueryTable").trigger("reloadGrid");
            });
        }
    }
}