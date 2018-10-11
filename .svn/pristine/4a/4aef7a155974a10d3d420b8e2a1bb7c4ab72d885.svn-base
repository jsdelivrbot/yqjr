/**
 * 常量
 */
function Constant() {
	//菜单头
	this.header = "<li><a href=\"{0}\" menu-name= \"{1}\" class=\"dropdown-toggle\"><i class=\"menu-icon fa {2}\"></i><span class=\"menu-text\">{3}</span><b class=\"arrow fa fa-angle-down\"></b></a><b class=\"arrow\"></b><ul class=\"submenu\">";
	//菜单体
	this.body = "<li><a data-url=\"{0}\" menu-name= \"{1}\" href=\"{2}\"><i class=\"menu-icon fa {3}\"></i>&nbsp;{4}</a><b class=\"arrow\"></b></li>";
}


/**
 * 菜单组件
 */
$.fn.frameworkMenu = function(ops) {
	$this = $(this);
	// 校验
	if (!ops.url) {
		layer.alert("url不能为空");
		return;
	}
	var menus = '';
	var constant = new Constant();
	var num=0;
	function showMenu(arrs){
		var arrsLength=arrs==null?0:arrs.length;
		if(arrsLength>0){
			num++;
			for(var index=0;index<arrsLength;index++){
				var data = arrs[index];
				if(!data.icon){
					data.icon = "fa-caret-right";
				}
				var tempHead = constant.header.format(data.url,data.name,data.icon, data.name);
				var tempFoot = "</ul></li>";
				var subArr=data.childMenus;
				var subArrLength=subArr==null?0:subArr.length;
				if(subArrLength>0 && data.url=="#"){
					menus += tempHead;
					for(var i = 0 ; i < subArrLength ; i++){
						var arr=subArr[i].childMenus;
						var arrLength=arr==null?0:arr.length;
						if(arrLength>0 && subArr[i].url=="#"){
							var tempHead = constant.header.format(subArr[i].url,subArr[i].name,subArr[i].icon, subArr[i].name);
							menus += tempHead;
							showMenu(arr);
						}else{
							var tempBody = constant.body.format(subArr[i].url,subArr[i].name,subArr[i].urlPrefix + subArr[i].url, subArr[i].icon, subArr[i].name);
							menus += tempBody;
						}
					}

					for(var j=0;j<num;j++){
						menus += tempFoot;
					}
				}else{
//					var tempBody = constant.body.format(data.url,data.name,data.url, data.icon, data.name);
					menus += tempHead+tempFoot;
				}
			}
		}
	}

	$.ajax({
		async : false,
		type : 'GET',
		url : ops.url,
		dataType : 'json',
		success : function(obj) {
			// 查询失败
			if(!obj.isSuccess){
				layer.alert("主界面初始化失败,"+obj.msg);
				return;
			}
			showMenu(obj.result);
			$this.append(menus);
		},
		error : function(e) {
			layer.alert("主界面初始化失败:" + e);
		}
	});
};

//通知顶层页面高度
function setHash(){
	//layer.alert("document.body.scrollHeight"+document.body.scrollHeight);
	//layer.alert("document.body.clientHeight"+document.body.clientHeight);
	//layer.alert("document.documentElement.scrollHeight"+document.documentElement.scrollHeight);
	//layer.alert("document.documentElement.clientHeight"+document.documentElement.clientHeight);
	var messenger = new Messenger('childPage', 'IframeHandle');
	messenger.addTarget(window.top, 'parent');
	//messenger.targets['parent'].send(document.body.scrollHeight);
	messenger.targets['parent'].send(document.body.clientHeight);
	//由于上面内容不能变更iframe的高度 因此加入下面两行
    var obj = parent.document.getElementById("mainFrame");
    obj.height = document.body.scrollHeight;
}

/**
 * 字符串格式化
 *
 * @returns {String}
 */
String.prototype.format = String.prototype.f = function() {

	var s = this, i = arguments.length;

	while (i--) {
		s = s.replace(new RegExp('\\{' + i + '\\}', 'm'), arguments[i]);
	}
	return s;
};

/**
 * 树组件
 */
jQuery.fn.frameworkTree = function(ops) {
	$this = $(this);
	var param = {};
	var folderSelect = false;
	var multiSelect = false;
	// 校验
	if (!ops.url) {
		layer.alert("url不能为空");
		return;
	}
	if(ops.data){
		param = ops.data;
	}
	if(ops.folderSelect){
		folderSelect = ops.folderSelect;
	}
	if(ops.multiSelect){
		multiSelect = ops.multiSelect;
	}
	//带回调函数数据源
	var remoteDateSource = function(options, callback) {
		//初始化parent_id
		var parent_id = null
		if( !('text' in options || 'type' in options) ){
			parent_id = 0;
		}
		else if('type' in options && options['type'] == 'folder') {
			if('additionalParameters' in options && 'children' in options.additionalParameters){
				parent_id = options.additionalParameters['id'];
			}
		}
		param["parent_id"] = parent_id;
		if(parent_id !== null) {
			$.ajax({
				url: ops.url,
				data : param,
				type: 'GET',
				dataType: 'json',
				success : function(response) {
					//console.log(response.data);
					//异步获取数据,绘制子节点
					callback({ data: response });
					setHash();
				},
				error: function(response) {
					console.log(response);
				}
			})
		}
	};
	$this.ace_tree(
	{
		dataSource : remoteDateSource,
		//'multiSelect' : multiSelect,
		multiSelect : multiSelect,
		cacheItems : true,
		'open-icon' : 'ace-icon fa fa-folder-open',
		'close-icon' : 'ace-icon fa fa-folder',
		'itemSelect' : true,
		'folderSelect' : folderSelect,
		'selected-icon' : 'ace-icon fa fa-check',
		'unselected-icon' : 'ace-icon fa fa-times',
		loadingHTML : '<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>',
		'folder-open-icon' : 'ace-icon tree-plus',
		'folder-close-icon' : 'ace-icon tree-minus'
	});
	return $this;
};
/**
 * 表单校验组件
 */
jQuery.fn.frameworkValid = function(ops) {
	$this = $(this);
	$("input[type='checkbox']").each(function(){
		$(this).addClass("ace").addClass("ace-checkbox-2").next().replaceWith("<span class='lbl'>&nbsp;"+$(this).next().html()+"</span>");
		$(this).parent().replaceWith("<label class='control-label'>"+$(this).parent().html()+"</label>");
	});
	var $required_obj = $('.required');
	$required_obj.each(function(index){
		$(this).attr("required_index",index);
		if($(this).is("select")){
			$(this).on("change",function(){
				var required_index = parseInt($(this).attr("required_index"));
				$required_obj.each(function(index){
    				if(parseInt($(this).attr("required_index")) == (parseInt(required_index)+1)){
    					$(this).focus();
    				}
    			});
			});
			$(this).on("keydown",function(){
				var required_index = parseInt($(this).attr("required_index"));
				if(event.keyCode == "13"){
    				$required_obj.each(function(index){
        				if(parseInt($(this).attr("required_index")) == (parseInt(required_index)+1)){
        					$(this).focus();
        				}
        			});
				}
			});
		}
	}).eq(0).focus();
	$this.validate({
		errorElement: 'label',  //错误提示使用dom
		errorClass: 'help-inline', //错误提示使用的class
		focusInvalid: true,//focusInvalid：类型 Boolean，默认 true。提交表单后，未通过验证的表单（第一个或提交之前获得焦点的未通过验证的表单）会获得焦点。
		onfocusout: function(element){
		   $(element).valid();
		},
		onclick: function(element){
		   $(element).valid();
		},
		onkeyup: function(element){
			if(event.keyCode == "13"){
				if($(element).valid()){
					var required_index = parseInt($(element).attr("required_index"));
					$required_obj.each(function(index){
        				if(parseInt($(this).attr("required_index")) == (parseInt(required_index)+1)){
        					$(this).focus();
        				}else if((parseInt(required_index)+1) >= $required_obj.size()){
        					$("#inputForm").submit();
        				}
        			});
				}
				//console.log(element);
				//$("#inputForm").submit();
			}
		},
		highlight: function (e) {//校验失败class处理
			$(e).closest('.form-group-2').removeClass('has-info').addClass('has-error');
		},
		success: function (e) {//校验成功class处理
			$(e).closest('.form-group-2').removeClass('has-error').addClass('has-info');
			$(e).remove();
		},
		errorPlacement: function (error, element) {//错误提示显示位置处理
			//error.insertAfter(element.parent());//input下方
			error.appendTo(element.parent());//input右侧
			if (element.is(":checkbox")||element.is(":radio")){
				error.appendTo(element.parent().parent());
			}
		},
		messages : ops.messages,//自定义错误提示信息
		rules : ops.rules
		// ,//自定义必输项
		// submitHandler: function(form){
		// 	$("button").attr("disabled",true);
		// 	$.gritter.add({
		// 		title: '操作提示',
		// 		sticky : true,
		// 		text: "正在提交，请稍等...",
		// 		class_name: 'gritter-info gritter-center'
		// 	});
		// 	ops.submitHandler(form);
		// }
	});
	return $this;
};
function stateChangeFirefox(_frame){
   $("#loading").hide();
   $("#mainFrame").show();
   var ifm = document.getElementById("mainFrame");
	var subWeb = document.frames ? document.frames["mainFrame"].document : ifm.contentDocument;
	if (ifm != null && subWeb != null) {
		ifm.height = subWeb.body.scrollHeight;
	}
}

function stateChangeIE(_frame){
	if (_frame.readyState=="interactive"){
	  $("#loading").hide();
	  $("#mainFrame").show();
	  var ifm = document.getElementById("mainFrame");
		var subWeb = document.frames ? document.frames["mainFrame"].document : ifm.contentDocument;
		if (ifm != null && subWeb != null) {
			ifm.height = subWeb.body.scrollHeight;
		}
	}
}
function searchData(tableName){
	var postData = {};
	var array = $("#searchForm").serializeArray();
	for(var i=0;i < array.length;i++){
		if (array[i].value != '') {
			postData[array[i].name] = array[i].value;
			console.log(array[i].name+":"+array[i].value);
		}
	}


	$("#"+tableName).jqGrid("setGridParam",{
		postData : postData,
		sortable: false
    },true).trigger("reloadGrid");

}


function commonForward(url){
	window.location = url;
}
function registerNS(ns) {
	var nsParts = ns.split(".");
	var root = window;
	for ( var i = 0; i < nsParts.length; i++) {
		if (typeof root[nsParts[i]] == "undefined")
			root[nsParts[i]] = new Object();
		root = root[nsParts[i]];
	}
}
$.getUrlParam = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return decodeURI(r[2]);
    return null;
}

//region api
/**
 * jquery api extension
 *
 */
;(function () {

    $.api = $.api || {};

    var ajax = $.ajax;
    var extend = $.extend;

    //region fns
    function toPromise($promise) {
        return $promise;
    }

    function power(arr) {
        var size = 1 << arr.length;

        var ret = [];

        for (var idx = 0; idx < size; idx++) {
            var row = [];
            for (var i = 0, n = idx; n; n >>>= 1, i++) if (n & 1) row.push(arr[i]);
            ret.push(row);
        }
        return ret;
    }

    function doRequest(method, opts, mConfig, url, data, options) {
        if (method === 'GET') {
            options = data;
            data = undefined;
        }

        options = options || {};
        var extras = extend({}, opts);

        if (!!data) {
            var data2Call = data;
            if (data instanceof FormData) {
                extras.contentType = false;
                extras.processData = false;
            } else if (typeof data === 'string') {
                extras.processData = false;
            } else {
                data2Call = JSON.stringify(data);
            }

            extras.data = data2Call;
        }

        return toPromise(ajax(extend({
            url: url,
            type: method,
            contentType: 'application/json'
        }, extras, options)));
    }

    var METHOD_NAMES = ['GET', 'POST', 'PUT', 'DELETE', 'PATCH'];

    /**
     * config metadata key
     * @type {string}
     */
    var KEY_METADATA = '_';

    /**
     * metadata order key
     * @type {string}
     */
    var KEY_METADATA_ORDER = 'order';

    /**
     * url processors key
     * @type {string}
     */
    var KEY_METADATA_URL_PROCESSORS = 'urlProcessors';

    /**
     * data processors key
     * @type {string}
     */
    var KEY_METADATA_DATA_PROCESSORS = 'dataProcessors';

    /**
     * lowest order value which is the last key
     * @type {number}
     */
    var METADATA_ORDER_LOWEST = 9999;

    /**
     * default for config
     * @type {string}
     */
    var KEY_CFG_DEFAULT = 'defConfig';

    /**
     * suffix configs
     * @type {string}
     */
    var KEY_CFG_SUFFIX = 'sufConfigs';

    /**
     * method prefix, default to 'json'
     * @type {string}
     */
    var KEY_CFG_METHOD_PREFIX = 'methodPrefix';

    var getConfigForSufs = function (sfs, sufConfigs, defConfig) {

        return sfs.reduce(function (result, suf) {
            return extend(true, {}, result, sufConfigs[suf])
        }, extend({}, defConfig))
    };

    function getData(data, mergedConfig) {

        var processors = mergedConfig[KEY_METADATA_DATA_PROCESSORS];
        if (processors) {
            return Object.keys(processors)
                .reduce(function (data, processorName) {
                    return processors[processorName](data);
                }, data);
        }

        return data;
    }

    function getUrl(url, mergedConfig) {

        var urlProcessors = mergedConfig[KEY_METADATA_URL_PROCESSORS];
        if (urlProcessors) {
            return Object.keys(urlProcessors)
                .reduce(function (url, processorName) {
                    return urlProcessors[processorName](url);
                }, url);
        }

        return url;
    }

    function factory(method, opts) {
        opts = opts || {};
        var mergedConfig = opts[KEY_METADATA] || {};
        delete opts[KEY_METADATA];

        return function (url, data, options) {

            url = getUrl(url, mergedConfig);
            data = getData(data, mergedConfig);

            return doRequest(method, opts, mergedConfig, url, data, options)
                .then(function (data) {
                    if (typeof data === 'string') {
                        data = JSON.parse(data)
                    }

                    return data;
                });
        };
    }

    //endregion

    $.extend($.api, {
        /**
         * wrap the api for convenience
         * @param config
         * @returns {*}
         */
        wrap: function (config) {
            var defConfig = config[KEY_CFG_DEFAULT] || {};
            var sufConfigs = config[KEY_CFG_SUFFIX] || {};
            var methodPrefix = config[KEY_CFG_METHOD_PREFIX] || 'json';

            function getConfigOrder(configKey) {

                if (sufConfigs[configKey] && sufConfigs[configKey][KEY_METADATA]) {
                    return sufConfigs[configKey][KEY_METADATA][KEY_METADATA_ORDER] || METADATA_ORDER_LOWEST;
                }
                return METADATA_ORDER_LOWEST;
            }

            var sortedSufConfigKeys = Object.keys(sufConfigs)
                .sort(function (configA, configB) {
                    var orderA = getConfigOrder(configA);
                    var orderB = getConfigOrder(configB);

                    return orderA - orderB;
                });

            return METHOD_NAMES
                .reduce(function (fns, method) {
                    return power(sortedSufConfigKeys)
                        .reduce(function (fs, sfs) {
                            var ret = extend({}, fs);

                            var key = methodPrefix + method + sfs.join('');

                            ret[key] = factory(method, getConfigForSufs(sfs, sufConfigs, defConfig));

                            return ret
                        }, fns)
                }, {});
        }
    });

    var apiUtilSufConfigs = {};

    function createConfig(name, order, initParams) {

        if (!name) {
            console.error('name should not be empty!');
            return;
        }

        order = order || 100;

        var config = apiUtilSufConfigs[name] = initParams || {};
        config[KEY_METADATA] = {};
        config[KEY_METADATA][KEY_METADATA_ORDER] = order;
        return config;
    }

    /***
     * create configs
     */
    (function () {

        createConfig('Sync', 0, {async: false});

        createConfig('WithoutCache', 1, {cache: false});

    })();

    $.extend({
        /**
         * api utils
         * default contentType is 'application/json'
         *
         * e.g:
         *      $.apiUtils.jsonPOST('/some/url', {name:'123'})
         *          .then(function(response) {
             *              // some codes
             *          });
         *
         * available methods:
         *
         *      jsonGET        	jsonGETWithoutCache        	jsonGETSync        	jsonGETWithoutCacheSync
         *      jsonPOST     	jsonPOSTWithoutCache    	jsonPOSTSync    	jsonPOSTWithoutCacheSync
         *      jsonPUT        	jsonPUTWithoutCache        	jsonPUTSync        	jsonPUTWithoutCacheSync
         *      jsonDELETE    	jsonDELETEWithoutCache    	jsonDELETESync    	jsonDELETEWithoutCacheSync
         *      jsonPATCH    	jsonPATCHWithoutCache    	jsonPATCHSync    	jsonPATCHWithoutCacheSync
         *
         */
        apiUtils: $.api.wrap({defConfig: {}, sufConfigs: apiUtilSufConfigs})
    });

    (function () {

        /**
         * get entity api base path
         * @param entityName
         * @param projectName
         * @param moduleName
         * @returns {*}
         */
        $.getEntityApiBasePath = function (entityName, projectName, moduleName) {
            if (!entityName) {
                return '';
            }

            var prefix = '';

            var arg;
            for (var i = 1; i < arguments.length; i++) {
                arg = arguments[i];
                if (!arg) {
                    continue;
                }

                prefix += ((arg.indexOf('/') === 0 ? '' : '/') + arg);
            }

            return prefix + '/' + entityName + 's';
        };

        /**
         * create api client for entity
         * @param entityName
         * @param opts
         */
        $.createEntityApiClient = function (entityName, opts) {
            var projectName = opts['projectName'];
            var moduleName = opts['moduleName'];

            var apiBasePath = $.getEntityApiBasePath(entityName, projectName, moduleName);

            function doById(id, method, data, options) {
                if (!id || !method) {
                    return $.Deferred().reject('arguments illegal!').promise();
                }

                var url = apiBasePath;

                if ($.isArray(id)) {
                    if (!id.length) {
                        return $.Deferred().reject('ids should not be empty!').promise();
                    }
                    url += '/batch/' + id.toString();
                } else {
                    url += '/' + id;
                }

                return $.apiUtils[method](url, data, options);
            }

            function actionById(id, action, options) {
                if (!action) {
                    return $.Deferred().reject('action should not be null!').promise();
                }

                if (typeof action === 'string') {
                    action = {name: action};
                }

                return doById(id, 'jsonPOST', action, options);
            }

            return {
                /**
                 * create an entity
                 * @param entity
                 * @param options
                 * @returns {*}
                 */
                create: function (entity, options) {

                    if (!entity) {
                        return $.Deferred().reject('entity should not be null!').promise();
                    }

                    return $.apiUtils.jsonPOST(apiBasePath, entity, options);
                },
                /**
                 * get entity by id
                 * @param id
                 * @param options
                 * @returns {*}
                 */
                getById: function (id, options) {
                    return doById(id, 'jsonGET', options);
                },
                /**
                 * get entities by ids
                 * @param ids
                 * @param options
                 * @returns {*}
                 */
                getByIds: function (ids, options) {
                    return doById(id, 'jsonGET', options);
                },
                /**
                 * patch by id
                 * @param id
                 * @param entity
                 * @param options
                 * @returns {*}
                 */
                patchById: function (id, entity, options) {
                    return doById(id, 'jsonPATCH', entity, options);
                },
                /**
                 * update by id
                 * @param id
                 * @param entity
                 * @param options
                 * @returns {*}
                 */
                updateById: function (id, entity, options) {
                    if (!id) {
                        return $.Deferred().reject('id should not be null!').promise();
                    }
                    if (!entity) {
                        return $.Deferred().reject('entity should not be null!').promise();
                    }
                    return doById(id, 'jsonUPDATE', entity, options);
                },
                /**
                 * delete by id
                 * @param id
                 * @param options
                 * @returns {*}
                 */
                deleteById: function (id, options) {
                    return doById(id, 'jsonDELETE', null, options);
                },
                /**
                 * delete by ids
                 * @param ids
                 * @param options
                 * @returns {*}
                 */
                deleteByIds: function (ids, options) {
                    return doById(ids, 'jsonDELETE', null, options);
                },
                /**
                 * do an action by id
                 * @param id
                 * @param action
                 * @param options
                 * @returns {*}
                 */
                actionById: function (id, action, options) {
                    return actionById(id, action, options);
                },
                /**
                 * do an action by ids
                 * @param ids
                 * @param action
                 * @param options
                 * @returns {*}
                 */
                actionByIds: function (ids, action, options) {
                    return actionById(ids, action, options);
                },
                /**
                 * do an action
                 * @param action
                 * @param options
                 * @returns {*}
                 */
                action: function (action, options) {

                    if (!action) {
                        return $.Deferred().reject('action should not be null!').promise();
                    }

                    if (typeof action === 'string') {
                        action = {name: action};
                    }

                    return $.apiUtils.jsonPOST(apiBasePath + '/action', action, options);
                }
            }
        };

    })();
})();
//endregion




