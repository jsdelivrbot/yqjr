/**
 * 通用文件管理组件
 */
var basePath="/base";
var uiPath="/ui";
var _$$$self;
var _$$$attach;

(function ($, window, document, undefined) {
    'use strict';

    var modals=window.top.modals;
    var pluginName = 'attach';

    $.fn[pluginName] = function (options) {
        var self = $(this);
        if (this == null)
            return null;
        var data = this.data(pluginName);
        if (!data) {
            data = new BaseFile(this, $.extend(true, {}, options));
            self.data(pluginName, data);
        }
    };


    var BaseFile = function (element, options) {
        this.element = element;
        //extend优先级 后面的会覆盖前面的
        //alert(this.element.selector);
        //将容器ID传过去便于弹窗获取到BaseFile对象，如果页面布局不在使用jquery.load方法，则该方法会失效，因为不是一个页面了
        options.container = options.container || this.element.selector.replace("#", "");
        //初始化文件图标信息
        this.getFileIconSettings();
        this.options = $.extend(true, {}, this.default, options);
        if(this.options.showType=="detail"){
        	this.element.hide();
        }
        
        //初始化图标信息
        this.initFileIds();

        if(this.options.window) {
            this.element.click(function () {
                $(this).data('attach').openWin();
            });
        }else{
            //非弹窗形式
            if(this.options.multiple)
                this.element.attr("multiple","multiple");
        }

        //如果配置了附件编辑容器showContainer（附件列表，可单个删除），则进行初始化
        if(this.hasDisplayZone()){
            this.showFiles();
        }


    }

    BaseFile.prototype.default = {
        winId: "fileWin",
        width: 900,
        title: "文件上传",
        //通用文件上传界面
        url: uiPath + "/file/modal.html",
        //默认支持多文件上传
        multiple: true,
        //默认弹出附件上传窗口
        window:true,
        showType:"detail",
        fileinput: {
            language: 'zh',
            uploadUrl: "/zuul"+basePath + "/file/uploadMultipleFile",
            deleteUrl:basePath+"/file/delete",
            uploadAsync:false,
            validateInitialCount:true,
            overwriteInitial: true,
            preferIconicPreview: true,
		    maxFileSize: 10240,
		    maxFileCount:5,
            fileActionSettings:{
            	showDownload:true,
                showZoom:false,
                showDrag:false
            },
            //allowedPreviewTypes: ['image', 'html', 'text', 'video', 'audio', 'flash', 'object'], 
            initialPreviewDownloadUrl:basePath+"/file/download/{key}",
            previewFileIcon:'<i class="fa fa-file-o"></i>',
            previewFileIconSettings: { // configure your icon file extensions
                'doc': '<i class="fa fa-file-word-o text-primary"></i>',
                'xls': '<i class="fa fa-file-excel-o text-success"></i>',
                'ppt': '<i class="fa fa-file-powerpoint-o text-danger"></i>',
                'pdf': '<i class="fa fa-file-pdf-o text-danger"></i>',
                'zip': '<i class="fa fa-file-archive-o text-muted"></i>',
                'htm': '<i class="fa fa-file-code-o text-info"></i>',
                'txt': '<i class="fa fa-file-text-o text-info"></i>',
                'mov': '<i class="fa fa-file-movie-o text-warning"></i>',
                'mp3': '<i class="fa fa-file-audio-o text-warning"></i>',
                // note for these file types below no extension determination logic 
                // has been configured (the keys itself will be used as extensions)
                'jpg': '<i class="fa fa-file-photo-o text-danger"></i>', 
                'gif': '<i class="fa fa-file-photo-o text-muted"></i>', 
                'png': '<i class="fa fa-file-photo-o text-primary"></i>'    
            },
            previewFileExtSettings: { // configure the logic for determining icon file extensions
                'doc': function(ext) {
                    return ext.match(/(doc|docx)$/i);
                },
                'xls': function(ext) {
                    return ext.match(/(xls|xlsx)$/i);
                },
                'ppt': function(ext) {
                    return ext.match(/(ppt|pptx)$/i);
                },
                'zip': function(ext) {
                    return ext.match(/(zip|rar|tar|gzip|gz|7z)$/i);
                },
                'htm': function(ext) {
                    return ext.match(/(htm|html)$/i);
                },
                'txt': function(ext) {
                    return ext.match(/(txt|ini|csv|java|php|js|css)$/i);
                },
                'mov': function(ext) {
                    return ext.match(/(avi|mpg|mkv|mov|mp4|3gp|webm|wmv)$/i);
                },
                'mp3': function(ext) {
                    return ext.match(/(mp3|wav)$/i);
                }
            },
            //otherActionButtons:'<button type="button" class="kv-file-down btn btn-xs btn-default" {dataKey} title="下载附件"><i class="fa fa-cloud-download"></i></button>',
            //otherActionButtons:'<button type="button" class="kv-file-down btn btn-kv btn-default btn-outline-secondary" {dataKey} title="下载附件"><i class="glyphicon glyphicon-download"></i></button>',
            slugCallback: function (text) {
                var newtext=(!text||text=='') ? '' : String(text).replace(/[\-\[\]\/\{}:;#%=\(\)\*\+\?\\\^\$\|<>&"']/g, '_');
                //去除空格
                return newtext.replace(/(^\s+)|(\s+$)/g,"").replace(/\s/g,"");
            }
        }
    }

    BaseFile.prototype.getFileInputConfig=function () {
        return this.options.fileinput;
    }
    
    BaseFile.prototype.getFileIconSettings = function () {
        var self = this;
        ajaxPost(basePath + "/file/icons", null, function (icons) {
            self.previewFileIconSettings = icons;
            //console.log(self.previewFileIconSettings);
        })
    }


    BaseFile.prototype.openWin = function () {
        var that = this;
        var self = $.extend(true, {}, this.options);
        //深拷贝后删除属性，这样不会通过后台传送过去，防止被XSS过滤掉特殊字符
        //不需要通过参数config=传递到弹窗的参数可使用delete删除
        delete self.callback;
        delete self.fileIds;
        delete self.showContainer;
        delete self.fileIdContainer;
        delete self.fileinput;
        
        _$$$self=self;
        _$$$attach=that;
        
        /*console.log(this.options);
         console.log("=============");
         console.log(self);*/
        modals.openWin({
            winId: that.options.winId,
            url: that.options.url,
            width: that.options.width + "px",
            title: that.options.title,
            backdrop: "static"
        });
    }

    BaseFile.prototype.callbackHandler = function (fileIds) {
        //更新fileIds并执行回调函数
        var oldfileIds = this.options.fileIds;
        this.options.fileIds = fileIds;
        this.updateFileIds();
        if (this.options.callback) {
            this.options.callback.call(this, fileIds, oldfileIds);
        }
    }

    //调用成功后执行显示附件
    BaseFile.prototype.showFiles=function(options){
        options=options||{};
        if(!this.hasDisplayZone()){
            modals.error("请配置showContainer属性，并在容器下配置type=file的input组件");
            return;
        }
        var fileIds=options.fileIds||this.options.fileIds;
        if(!fileIds&&this.options.window){
           $(this.options.showContainer).hide();
            return;
        }
        //显示
        $(this.options.showContainer).show();
        var fileComponet=$(this.options.showContainer);
        var fileResult=this.getFileResult(fileIds),preview=fileResult.initialPreview,previewConfig=fileResult.initialPreviewConfig,self=this;
        //配置三类参数 edit=附件列表（可删除） detail=附件列表（显示） 可上传
        var defaultConfig={
            initialPreview:preview,
            initialPreviewConfig:previewConfig,
            previewFileIconSettings:this.previewFileIconSettings
        };
        var config;
        if(this.options.showType=="detail"){
            config=$.extend({},self.options.fileinput,defaultConfig,{
                showRemove:false,
                showUpload:false,
                showClose:false,
                showBrowse:false,
                showCaption:false,
                showDrag:false,
                showCancel:false,
                theme: "explorer",
                preferIconicPreview: true,
   		     	dropZoneEnabled:false,
                initialPreviewShowDelete:false,
                fileActionSettings:{
                    showZoom:false,
                    showDrag:false
                }
            },options);
        }else {
            if (this.options.window) {
                if (this.options.showType == "edit") {
                    //全局配置->本方法默认配置->edit属性下配置->外部参数
                    config = $.extend({}, self.options.fileinput, defaultConfig, {
                        showRemove: false,
                        showUpload: false,
                        showClose: false,
                        showBrowse: false,
                        showCaption: false,
                        showDrag:false,
                        showCancel:false,
                        theme: "explorer",
                        preferIconicPreview: true,
           		     	dropZoneEnabled:false,
                        fileActionSettings:{
                            showZoom:false,
                            showDrag:false
                        }
                    }, options);
                }
            } else {
                config = $.extend({}, self.options.fileinput, defaultConfig, {
                    showClose: false
                }, options);
            }
        }
        if(!config){
            modals.error("缺少配置，请检查");
            return;
        }
        //console.log("config=========="+JSON.stringify(config));
        fileComponet.fileinput('destroy');
        fileComponet.fileinput(config).on("filedeleted",function (event,key) {
            var newfids=self.deleteFileIds(key,self.options.fileIds);
            self.options.fileIds=newfids;
            self.updateFileIds();
        }).on("fileuploaded",function(event,data,previewId,index){
            var newfids=self.addFileIds(data.response.fileIds,self.options.fileIds);
            self.options.fileIds=newfids;
            self.updateFileIds();
            //otherActionButtons绑定事件 下载按钮绑定
           // self.downloadHandler(this);
        }).on("filebatchuploadsuccess",function (event,data,previewId,index) {
            var newfids=self.addFileIds(data.response.fileIds,self.options.fileIds);
            self.options.fileIds=newfids;
            self.updateFileIds();
            //otherActionButtons绑定事件
           // self.downloadHandler(this);
        }).on("filezoomhidden", function(event, params) {
            $(document.body).removeClass('modal-open');
            $(document.body).css("padding-right","0px");
        })
        //this.downloadHandler(fileComponet);
    }


    /**
     * 其他按钮（如下载）绑定时间
     */
    BaseFile.prototype.downloadHandler=function(fileobj){
        if(!fileobj)
            fileobj=$(this.options.showContainer);
        var objs=$(fileobj).data('fileinput').$preview.find(".kv-preview-thumb .kv-file-down");
        objs.unbind("click");
        objs.on("click",function(){
           //点击下载
            window.location.href=basePath+"/file/download/"+$(this).data("key");
        });
    }
    /**
     * 向targetIds里删除数据fileIds
     * @param fileIds
     * @param targetIds
     */
    BaseFile.prototype.deleteFileIds=function(fileIds,targetIds){
        if(!fileIds) return targetIds;
        //没有文件删除，其中必有蹊跷
        if(!targetIds){
            modals.error("没有要删除的文件，请检查是否数据没有初始化");
            return;
        }
        fileIds=new String(fileIds);
        targetIds=new String(fileIds);
        var fileIdArr=fileIds.split(",");
        var fresult=targetIds.split(",");
        $.each(fileIdArr,function (index,fileId){
            //存在则删除
            if($.inArray(fileId,fresult)>-1){
                fresult.splice($.inArray(fileId,fresult),1);
            }
        })
        return fresult.join();
    }

    /**
     * 向targetIds里加数据fileIds
     * @param fileIds
     * @param targetIds
     */
    BaseFile.prototype.addFileIds=function (fileIds,targetIds) {
        if(!fileIds)return targetIds;
        var fileIdArr=fileIds.split(",");
        var fresult=[];
        if(targetIds){
            fresult=targetIds.split(",");
        }
        $.each(fileIdArr,function (index,fileId){
            //不存在，新增
            if($.inArray(fileId,fresult)==-1){
                fresult.push(fileId);
            }
        })
        return fresult.join();
    }

    BaseFile.prototype.updateFileIds=function(){
        if(this.options.fileIdContainer)
            $(this.options.fileIdContainer).val(this.options.fileIds);
    }

    BaseFile.prototype.initFileIds=function(){
        //不弹出窗口的话一定要绑定fileIdContainer
        if(!this.options.window){
            if(!this.options.fileIdContainer||!$(this.options.fileIdContainer)){
                modals.info("请设置fileIdContainer属性");
                return;
            }
        }
        if(!this.options.fileIds){
            if(this.options.fileIdContainer){
                this.options.fileIds=$(this.options.fileIdContainer).val();
            }
        }
    }

    BaseFile.prototype.getFileResult=function(fileIds){
        var ret=null;
        ajaxPost(basePath+"/file/getFiles",{fileIds:fileIds},function(result){
            ret=result;
        });
        return ret;
    };

    /**
     * 是否有显示区域
     * @returns {boolean}
     */
    BaseFile.prototype.hasDisplayZone=function(){
        if(!this.options.showContainer){
           this.options.showContainer=this.element.selector;
        }
        if(!this.options.showContainer||!$(this.options.showContainer)){
            return false;
        }
        return true;
    }
    
    

})(jQuery, window, document);