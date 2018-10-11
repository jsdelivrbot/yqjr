var shrinkToFit = false;
$(function () {
    var postData = {};
    var array = $("#searchForm").serializeArray();
    for (var i = 0; i < array.length; i++) {
        if (array[i].value != '') {
            postData[array[i].name] = array[i].value;
        }
    }

  $("#personMainReviewTable").jqGrid(
    {
      url: apiEntityBasePath + "/pageByJqGrid",
      datatype: "json",
      mtype: 'GET',
      colModel: [
        { label: '序列', name: 'id', index: 'id', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '人员代码', name: 'personCode', index: 'personCode', sortable: true, width: 150, align: 'center' } ,
                                { label: '人员姓名', name: 'personName', index: 'personName', sortable: true, width: 150, align: 'center'} ,
                                { label: '审核类型', name: 'reviewType', index: 'reviewType', sortable: true, width: 150, align: 'center',
                                    formatter:function(cellvalue, options, rowObject){
                                        var v_review_type=rowObject.personTeamReview.reviewType;
                                        var html="";
                                        if("01"==v_review_type){
                                            html="销售人员新增"
                                        }else if("02"==v_review_type){
                                            html="销售人员修改"
                                        }
                                        return html;
                                    }
                                } ,
                                { label: '提交人', name: 'createName', index: 'createName', sortable: true, width: 150, align: 'center',
                                    formatter:function(cellvalue, options, rowObject){
                                        var v_review_creator=rowObject.personTeamReview.createName;
                                        return v_review_creator;
                                    }
                                } ,
                                { label: '提交时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center',
                                    formatter:function(cellvalue, options, rowObject){
                                        var v_review_createTime=rowObject.personTeamReview.createTime;
                                        var d = new Date(v_review_createTime);
                                        var dformat = [ d.getFullYear(), (d.getMonth() + 1)<10?"0"+(d.getMonth() + 1):d.getMonth() + 1, d.getDate()<10?"0"+d.getDate():d.getDate()  ].join('-')
                                            + ' ' + [ d.getHours()<10?"0"+d.getHours():d.getHours(), d.getMinutes()<10?"0"+d.getMinutes():d.getMinutes(), d.getSeconds()<10?"0"+d.getSeconds():d.getSeconds() ].join(':');
                                        return dformat;
                                    }
                                } ,
                                { label: '审核状态', name: 'reviewStatus', index: 'reviewStatus', sortable: true, width: 150, align: 'center',
                                    formatter:function(cellvalue, options, rowObject){
                                        var v_review_status=rowObject.personTeamReview.reviewStatus;
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
                                        var v_review_status=rowObject.personTeamReview.reviewStatus;
                                        var modifier=rowObject.personTeamReview.modifier;
                                        var user=getUserCookie();
                                        var userCode=user.id;
                                        var v_html="";
                                        if("02"==v_review_status||userCode==modifier){
                                            v_html='<button class="btn btn-xs btn-info" onclick="update('+"'"+rowObject.personCode+"'"+','+rowObject.workFlow.id+','+"'"+rowObject.personTeamReview.reviewType+"'"+')"> 审核 </button>'
                                                + '     <button class="btn btn-xs btn-success" onclick="view(' + "'" + rowObject.personCode + "'" + ')"> 查看 </button>';
                                        }else{
                                            v_html="<button class='btn btn-xs btn-success' onclick='view("+'"'+rowObject.personCode+'"'+")'> 查看 </button>";
                                        }
                                        return v_html;
                                    }
                                } ,
                                /*{ label: '创建人', name: 'creator', index: 'creator', sortable: true, width: 150, align: 'center' } ,
                                { label: '创建时间', name: 'createTime', index: 'createTime', sortable: true, width: 150, align: 'center' } ,*/
                                { label: '修改时间', name: 'modifyTime', index: 'modifyTime', sortable: true, width: 150, align: 'center',hidden:true,
                                    formatter:function(cellvalue, options, rowObject){
                                        var v_review_modifyTime=rowObject.personTeamReview.modifyTime;
                                        return v_review_modifyTime;
                                    }
                                } ,
                                { label: '修改人', name: 'modifier', index: 'modifier', sortable: true, width: 150, align: 'center',hidden:true,
                                    formatter:function(cellvalue, options, rowObject){
                                        var v_review_modifier=rowObject.personTeamReview.modifier;
                                        return v_review_modifier;
                                    }
                                } ,
                                { label: '身份证号', name: 'personIdcard', index: 'personIdcard', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '备注', name: 'remark', index: 'remark', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '年龄', name: 'personAge', index: 'personAge', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '民族', name: 'personEthnic', index: 'personEthnic', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '婚姻状况', name: 'personMarr', index: 'personMarr', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '毕业学校', name: 'personSchool', index: 'personSchool', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '专业', name: 'personSubject', index: 'personSubject', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '最高学历', name: 'personEdu', index: 'personEdu', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '学位', name: 'personEdulevel', index: 'personEdulevel', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '工龄', name: 'personWorktime', index: 'personWorktime', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '参加工作时间', name: 'personFirstworktime', index: 'personFirstworktime', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '家庭住址', name: 'personAddress', index: 'personAddress', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '家庭电话', name: 'personHomephone', index: 'personHomephone', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '工作电话', name: 'personWorkphone', index: 'personWorkphone', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '移动电话', name: 'personPhone', index: 'personPhone', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: 'e-mail', name: 'personEmail', index: 'personEmail', sortable: true, width: 150, align: 'center',hidden:true } ,
						        { label: '生效时间', name: 'startTime', index: 'startTime', sortable: true, width: 150, align: 'center',hidden:true,
                                    formatter:function(cellvalue, options, rowObject){
                                        var v_review_startTime=rowObject.personTeamReview.startTime;
                                        return v_review_startTime;
                                    }
                                } ,
						        { label: '出生日期', name: 'personBirth', index: 'personBirth', sortable: true, width: 150, align: 'center',hidden:true }
						],

      height: 'auto',
      autowidth: true,
      rowNum: 10,
      rowList: [10, 20, 30],
      pager: $('#pager'),
      shrinkToFit: true,
      viewrecords: true,
      altRows: true,
      multiselect: true,
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
  $("#personMainReviewTable").jqGrid({
    edit: false,
        add: false,
        del: false,
        search: false,
        refresh: false
  })
  $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
  if (!shrinkToFit) {
    $("#personMainReviewTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x': 'scroll' });
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

function update(personCode,workFlowId,reviewType) {
   /* var ids = $("#personMainReviewTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
    var rowdata = $("#personMainReviewTable").jqGrid("getRowData", ids[0]);*/
   console.log("审核人员id"+personCode+":"+workFlowId+":"+reviewType);
    commonForward('/mkmm/ui/personMainReview/modify?personCode=' + personCode +"&workFlowId="+workFlowId+"&reviewType="+reviewType);
    /*if (ids.length === 0) {
        layer.alert("请选择需要操作的数据！");
        return false;
    } else if (ids.length > 1) {
        layer.alert("请选择一条记录！");
    } else if (ids.length === 1) {
        var rowdata = $("#personMainReviewTable").jqGrid("getRowData", ids[0]);
        commonForward('/mkmm/ui/personMainReview/modify?id=' + rowdata.id +"&workFlowId="+workFlowId);
    }*/
}

function view(personCode) {
    commonForward('/mkmm/ui/personMainReview/view?personCode=' + personCode);
}


/*function update() {
  var ids = $("#personMainReviewTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
  if (ids.length === 0) {
    layer.alert("请选择需要操作的数据！");
    return false;
  } else if (ids.length > 1) {
    layer.alert("请选择一条记录！");
  } else if (ids.length === 1) {
    var rowdata = $("#personMainReviewTable").jqGrid("getRowData", ids[0]);
    commonForward('/mkmm/ui/personMainReview/modify?id=' + rowdata.id +"&workFlowId")
  }

}*/

function batchDelete() {
    var ids = $("#personMainReviewTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
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
                $("#personMainReviewTable").trigger("reloadGrid");
            });
        }
    }
}
