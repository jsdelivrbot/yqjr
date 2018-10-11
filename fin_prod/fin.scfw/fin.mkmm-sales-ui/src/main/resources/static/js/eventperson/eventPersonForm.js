var formValidateConfig = {
    rules: {
        id: {
            required: true
        }
    },
    messages: {
        id: {
        }
    }
};

$(document).ready(function () {
    $("#inputForm").frameworkValid(formValidateConfig);

    $("#personName").change();

    $("#btnSubmit").on("click", function (e) {
        e.preventDefault();
        var flag = $("#inputForm").valid();
        if (!flag) {
            //没有通过验证
            return;
        } else {

            var $form = $("#inputForm");
            var arr = $form.serializeArray();
            var formData = {};
            if ($form.val()) {
                $form.trigger('change');
            }

            $.each(arr, function (i, item) {
                formData[item['name']] = item['value'];
            });

            var personCode = $('#personCode').val();
            if(personCode == null || personCode =='') {
                layer.alert("人员不存在！");
                return;
            }
            var year = $('#eventYear').val();
            if(year == null || year =='') {
                layer.alert("请输入年份！");
                return;
            }
            $("button").attr("disabled", true);
            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: $form.attr('action')+"/insertById",
                data: JSON.stringify(formData)
            }).then(function (obj) {
                // 保存失败
                if (!obj.isSuccess) {
                    layer.alert(obj.msg);
                    return;
                }else {
                    var int=self.setInterval(function(){  // 这个方法是说在延迟两秒后执行大括号里的方法
                        window.location = '/mkmm/ui/eventPerson/list';
                        // 这个方法是刷新当前页面
                    },2000)
                }                layer.alert(obj.msg);
                $("#inputForm").resetForm();
            }).always(function () {
                $("button").attr("disabled", false);
            });
        }
    });



    /**
     * ------------------------------------------------------模糊查询自动补全 begin
     */
    $("#personName").autocomplete({
        minLength:2,
        source: function( request, response ) {
            $.ajax({
                url : "/mkmm/sales/autoComplete/Person",
                type : "GET",
                contentType: 'application/json',
                data : {"name":$("#personName").val()},
                success: function( data ) {

                    response( $.map( data.result, function( item ) {
                        return {
                            label: item.label,
                            value: item.value
                        }
                    }));
                }
            });
        },
        /**
         * 菜单选中时操作
         * @param event
         * @param ui
         */
        select: function(event, ui){
            // 这里的this指向当前输入框的DOM元素
            // event参数是事件对象
            // ui对象只有一个item属性，对应数据源中被选中的对象
            $(this).val(ui.item.label);
            $("#personCode").val( ui.item.value);
            // 必须阻止事件的默认行为，否则autocomplete默认会把ui.item.value设为输入框的value值
            event.preventDefault();
        },
        /**
         * 修改输入框的值，并修改的值不在返回的数据内所做的操作
         * @param event
         * @param ui
         */
        change: function( event, ui ) {
            if(ui.item==null){
                $("#personCode").val("");
            }
        }
    });
    /**
     * ------------------------------------------------------模糊查询自动补全 end
     */



    //年份插件
    $('.year-picker').datepicker({
        language: 'zh-CN',
        autoclose: true,//选中之后自动隐藏日期选择框
        clearBtn: true,//清除按钮
        format: 'yyyy',//日期格式
        startView: 'decade',
        minView: 'decade',
        maxViewMode: 2,
        minViewMode:2,
    });


    //选择年份验证
    $("#eventYear").on("change",function (){
        var str_date = document.getElementById("eventYear").value;//选中年份
        var d = new Date();
        var str = d.getFullYear();
        if(str==""||str==null){
            return ;
        }
        if(str_date>str){
            $('.year-picker').datepicker({autoclose: true});
            layer.alert("选择年度不得超过当前年度！");
            $("#eventYear").val("");
        }
        return ;
    });



});


