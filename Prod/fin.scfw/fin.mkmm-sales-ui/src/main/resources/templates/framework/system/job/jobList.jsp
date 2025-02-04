<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/framework/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/jsp/framework/include/head.jsp"%>
<script type="text/javascript">
	jQuery(function($) {

	});
	function update(){
		 var ids = $("#jobTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
		 if (ids.length == 0) {
             alert("请选择需要操作的数据！");
             return false;
         }else if(ids.length > 1){
        	 alert("请选择一条记录！");
         }else if(ids.length == 1){
        	 var rowdata = $("#jobTable").jqGrid("getRowData", ids[0]);
        	 commonForward('${uiPath}/sys/job/form?id='+rowdata.id);
         }
	}
	function updateJobStatus(status){
		 var ids = $("#jobTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
		 var msg = "确定将任务";
		 if (ids.length == 0) {
            alert("请选择需要操作的数据！");
            return false;
         }else if(ids.length > 1){
       		alert("请选择一条记录！");
         }else{
        	 if(status == "1"){
        	 	msg += "启用";
        	 }else if(status == "0"){
        		msg += "停用";
        	 }
        	if(confirm(msg)){
        		var rowdata = $("#jobTable").jqGrid("getRowData", ids[0]);
	        	commonForward('${uiPath}/sys/job/updateJobStatus?id='+rowdata.id+'&jobStatus='+status);
       	 	}
        }
	}
	function batchDelete(){
		 var ids = $("#jobTable").jqGrid("getGridParam", "selarrrow");// 获得选中行数据
		 if (ids.length == 0) {
	            alert("请选择需要操作的数据！");
	            return false;
	        }else{
	       	 if(confirm("确定进行批量删除？")){
	        	 commonForward('${uiPath}/sys/job/delete?ids='+ids.toString());
	       	 }
	     }
	}
</script>
</head>
<body class="no-skin">
	<div class="page-content" id="mainContent">
		<div class="widget-box transparent ui-sortable-handle collapsed"
			id="widget-box-search">
			<div class="widget-header">
				<h3 class="widget-title smaller lighter">&nbsp;定时任务列表</h3>
				<div class="widget-toolbar no-border">
					<a href="#" data-action="collapse"> <i class="ace-icon fa fa-chevron-down">
						<span style="font-family: '微软雅黑'; font-size: 14px;">&nbsp;打开</span></i>
					</a>
				</div>
			</div>
			<yqjr:message content="${frameMessageContent}" type="${frameMessageType}"></yqjr:message>
			<div class="widget-body">
				<div class="widget-main padding-6 no-padding-left no-padding-right">
					<div class="space-6"></div>
					<form:form id="searchForm" modelAttribute="jobCondition" method="post" class="form-horizontal">
						<div class="row">
							<div class="col-sm-4">
								<label class="col-sm-4 control-label no-padding-right" for="loginName"> 登录名 ：</label>
								<div class="col-sm-8">
									<form:input path="jobName" htmlEscape="false" maxlength="50" cssClass="form-control input-sm" />
								</div>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label no-padding-right" for="status"> 状态 ： </label>
								<div class="col-sm-8">
									<form:select path="jobStatus" cssClass="form-control input-sm">
										<form:option value="" label="请选择..." />
										<form:options items="${fns:getDictList('job_status') }" itemLabel="label" itemValue="value" htmlEscape="false" cssClass="required"/>
									</form:select>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="dataTables_paginate paging_simple_numbers">
									<ul class="pagination">
										<li>
											<button id="searchBtn" onclick="searchData('jobTable')" type="button" class="btn btn-primary">
												<span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
												查询
											</button>
										</li>
										<li>
											<button id="resetBtn" type="reset" class="btn btn-primary">
												<span class="ace-icon fa fa-refresh icon-on-right bigger-110"></span>
												重 置
											</button>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="hr hr-dotted"></div>
					</form:form>
				</div>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-white btn-sm btn-primary" onclick="updateJobStatus('1');"><i class="ace-icon fa fa-play-circle"></i>&nbsp;启用</button>
				<button type="button" class="btn btn-white btn-sm btn-primary" onclick="updateJobStatus('0');"><i class="ace-icon fa fa-pause"></i>&nbsp;停用</button>
				<button type="button" class="btn btn-white btn-sm btn-primary" onclick="commonForward('${uiPath}/sys/job/form')">新增</button>
				<button type="button" class="btn btn-white btn-sm btn-primary" onclick="update();">修改</button>
				<button type="button" class="btn btn-white btn-sm btn-primary" onclick="delete();">删除</button>
			</div>
			<yqjr:table id="jobTable" colModel="[{label:'ID',name:'id',index:'id',sortable:true, width:150, align:'left',hidden:true},
										{label:'任务名称',name:'jobName',index:'loginName',sortable:true, width:150, align:'left'},
										{label:'任务状态',name:'jobStatus',sortable:true,width:150,align:'center',formatter: 'select',editoptions: {value: '${fns:getDictListForTable('job_status')}'}},
										{label:'执行规则',name:'jobCron',sortable:true,width:150,align:'center'},
										{label:'执行类',name:'jobClass',sortable:false, width:200, align:'center'}]"
			            url="${uiPath }/sys/job/listData" shrinkToFit="true"/>
		</div>
	</div>
</body>
