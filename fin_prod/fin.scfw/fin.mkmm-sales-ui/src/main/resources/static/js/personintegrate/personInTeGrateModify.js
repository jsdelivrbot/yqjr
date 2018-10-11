jQuery(function ($) {
    $("#inputForm").frameworkValid({});


    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/personInTeGrates/edit?id=' + mid,
        dataType: 'json'
    }).then(function (obj) {
        console.log(obj);
        // 查询失败
        if (!obj.isSuccess) {
            layer.alert(obj.msg);
            return;
        }
        var result = obj.result;
        var personCode = result.personCode;
        $("#id").val(result.id);
        $("#personCode").val(result.personCode);//人员代码
        $("#personName").val(result.personName);//人员姓名
        $("#personIdcard").val(result.personIdcard);//身份证号

        if (result.personBirth != null) {
            var d = new Date(result.personBirth);    //根据时间戳生成的时间对象
            personBirth = (d.getFullYear()) + "-" +
                (d.getMonth() + 1) + "-" +
                (d.getDate());
            $("#personBirth").val(personBirth);//出生日期
        }
        /* $("#personBirth").val(result.personBirth);//出生日期*/

        $("#personAge").val(result.personAge);//年龄
        $("#personEthnic").val(result.personEthnic);//民族
        $("#personMarr").val(result.personMarr);//婚姻状况
        $("#personSchool").val(result.personSchool);//毕业学校
        $("#personSubject").val(result.personSubject);//专业
        $("#personEdu").val(result.personEdu);//最高学历
        $("#personEdulevel").val(result.personEdulevel);//学位
        $("#personWorktime").val(result.personWorktime);//工龄
        /*if (result.personFirstworktime!=null) {
            $("#personFirstworktime").val(formatDate(result.personFirstworktime));//参加工作时间
        }else {
            $("#personFirstworktime").val(result.personFirstworktime);
        }*/
        if (result.personFirstworktime != null) {
            var d = new Date(result.personFirstworktime);    //根据时间戳生成的时间对象
            personFirstworktime = (d.getFullYear()) + "-" +
                (d.getMonth() + 1) + "-" +
                (d.getDate())
            ;
            $("#personFirstworktime").val(personFirstworktime);//参加工作时间
        }

        /*$("#personFirstworktime").val(result.personFirstworktime);//参加工作时间*/
        //入职()信息
        $("#teamName").val(result.personTeam.teamName);//团队名称
        $("#teamCode").val(result.personTeam.teamCode);//团队代码
        $("#areaCode").val(result.personTeam.areaCode);//归属区域代码
        $("#areaName").val(result.teamMain.areaName);//归属区域名称
        if (result.personTeam.personNature == "1") {
            $("#personNature").val("销售经理");
        } else if (result.personTeam.personNature == "0") {
            $("#personNature").val("团队负责人");
        }
        $("#personStatus").find("option[value = '" + result.personTeam.personStatus + "']").attr("selected", "selected");//人员状态
        if (result.personTeam.personStatus == "0") {
            $("#personStatus").val("无效");
        } else if (result.personTeam.personStatus == "1") {
            $("#personStatus").val("有效");
        } else if (result.personTeam.personStatus == "2") {
            $("#personStatus").val("注销");
        }

        /* $("#personLevel").find("option[value = '"+result.personTeam.personLevel+"']").attr("selected","selected");//.html("<option value='"+result.personTeam.personLevel+"'>"+result.personTeam.personLevel+"</option>");人员级别
         document.getElementById("personLevel").disabled=true;*/
        /*        var level="";
                if("1"==result.personTeam.personLevel){
                    level="一级";
                }
                $("#personLevel").html("<option value='"+result.personTeam.personLevel+"'>"+level+"</option>");//人员级别*/

         $("#personLevel").val(result.personTeam.personLevel);//人员级别
        if(result.personTeam.personLevel!=null)
        {
            if (result.personTeam.personLevel == "1") {
                $("#personLevel").val("一级");
            } else if (result.personTeam.personLevel == "2") {
                $("#personLevel").val("二级");
            }else{
                $("#personLevel").val("三级");
            }
        }


        if (result.personTeam.personCheckStart) {
            var d = new Date(result.personTeam.personCheckStart);    //根据时间戳生成的时间对象
            personCheckStart = (d.getFullYear()) + "-" +
                (d.getMonth() + 1) + "-" +
                (d.getDate());

            $("#personCheckStart").val(personCheckStart);//考核开始时间
        }

        if (result.personTeam.personUptime) {
            var d = new Date(result.personTeam.personUptime);    //根据时间戳生成的时间对象
            personUptime = (d.getFullYear()) + "-" +
                (d.getMonth() + 1) + "-" +
                (d.getDate());
            $("#personUptime").val(personUptime);//上岗时间
        }

        if (result.personTeam.personCorrectime) {
            var d = new Date(result.personTeam.personCorrectime);    //根据时间戳生成的时间对象
            personCorrectime = (d.getFullYear()) + "-" +
                (d.getMonth() + 1) + "-" +
                (d.getDate());
            $("#personCorrectime").val(personCorrectime);//转正时间
        }

        if (result.personTeam.personTryStartime != null) {
            var d = new Date(result.personTeam.personTryStartime);    //根据时间戳生成的时间对象
            personTryStartime = (d.getFullYear()) + "-" +
                (d.getMonth() + 1) + "-" +
                (d.getDate());
            $("#personTryStartime").val(personTryStartime);//试用期开始时间
        }

        if (result.personTeam.personTryEndtime) {
            var d = new Date(result.personTeam.personTryEndtime);    //根据时间戳生成的时间对象
            personTryEndtime = (d.getFullYear()) + "-" +
                (d.getMonth() + 1) + "-" +
                (d.getDate());
            $("#personTryEndtime").val(personTryEndtime);//试用期结束时间
        }

        if (result.personTeam.personJointime) {
            var d = new Date(result.personTeam.personJointime);    //根据时间戳生成的时间对象
            personJointime = (d.getFullYear()) + "-" +
                (d.getMonth() + 1) + "-" +
                (d.getDate())
            ;
            $("#personJointime").val(personJointime);//加入我司时间
        }

        if (result.startTime) {
            var d = new Date(result.startTime);    //根据时间戳生成的时间对象
            startTime = (d.getFullYear()) + "-" +
                (d.getMonth() + 1) + "-" +
                (d.getDate());
            $("#startTime").val(startTime);//生效时间&nbsp;
        }
        //负责城市
        var cs = result.cities;

        var data = [];
        if (cs != null && cs.length > 0) {
            for (var i = 0; i < cs.length; i++) {
                data.push(cs[i].cityName);
            }
        }
        console.log("城市:" + JSON.stringify(data));
        $('#mgmtCity').val(data);
        //负责品牌
        var brands = result.brands;
        data = [];
        if (brands != null && brands.length > 0) {
            for (var i = 0; i < brands.length; i++) {
                data.push(brands[i].brandName);
            }
        }
        $("#mgmtBrands").val(data);
        console.log("品牌:" + JSON.stringify(data));
        //联系信息
        $("#personAddress").val(result.personAddress);//家庭住址
        $("#personHomephone").val(result.personHomephone);//家庭电话
        $("#personWorkphone").val(result.personWorkphone);//工作电话
        $("#personPhone").val(result.personPhone);//移动电话
        $("#personEmail").val(result.perrsonEmail);//e-mail
        $("#remark").html(result.remark);//e-mail
        console.log(personCode)

        queryPersonTeamInfo(personCode);
        queryPersonTeamHis(personCode);
        queryersonEvent(personCode);

    }, function (e) {
        layer.alert("查询数据失败:" + e);
    })

    //加载团队
    $.ajax({
        type: "POST",
        url: "/mkmm/sales/personMainReviews/team",
        data: {},
        dataType: "json",
        success: function (data) {
            var option = "";
            if (data != null && data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    option += ('<option value="' + data[i].teamCode + '">' + data[i].teamName + '</option>');
                }
                $("#teamName").html(option);
            }
        }
    })
    //团队名称联动团队代码
    $("#teamName").change(function () {
            $("#teamCode").val($(this).val());
        }
    );

    //加载品牌
    $("#mgmtBrands").select2({
        ajax: {
            type: "POST",
            url: "/mkmm/sales/personMainReviews/brand",
            dataType: 'json',
            delay: 250,
            data: function (params) {
            },
            processResults: function (data, params) {
                params.page = params.page || 1;
                var itemList = [];//当数据对象不是{id:0,text:'ANTS'}这种形式的时候，可以使用类似此方法创建新的数组对象
                for (var i = 0; i < data.length; i++) {
                    itemList.push({id: data[i].ncarbrandid, text: data[i].ncarbrandname})
                }
                return {
                    results: itemList
                };
            },
            cache: true
        }
    });
});


//人员定级历史信息查询

function queryPersonTeamInfo(personCode) {
    $.ajax({
        type: 'GET',
        url: "/mkmm/sales/personInTeGrates/pageByJqGrid?personCode="+personCode+"&pageSize=10&pageNo=1&sidx=&sord=asc",
        dataType: 'json',
        success: function (data) {
            // var id = data.result.id
            // console.log(data.result);
            var arr = data.rows;
            var trStr = '';
            for (var index in arr) {
                // console.log(arr[index]);
                var arrStr = arr[index];
                var personCorrectime = '';
                if (arrStr.personTeam.personCorrectime) {
                    var c = new Date(arrStr.personTeam.personCorrectime);    //根据时间戳生成的时间对象
                    personCorrectime = (c.getFullYear());

                }
                var personLevel = '';
                if(personCorrectime) {
                    if (arrStr.personTeam.personLevel) {
                        if (arrStr.personTeam.personLevel == "1") {
                            personLevel = "一级";
                        } else if (arrStr.personTeam.personLevel == "2") {
                            personLevel = "二级";
                        } else {
                            personLevel = "三级";
                        }
                    }
                }



                trStr += '<tr >';
                trStr += '<td style="text-align:center;">' + personCorrectime + '</td>';
                trStr += '<td style="text-align:center;">' + personLevel + '</td>';
                trStr += '</tr>';
            }
            $("#tbody1").html(trStr);
        }
    })

}


/*function queryPersonTeamInfo(personCode) {
    $.ajax({
        type: 'GET',
        url: "/mkmm/sales/eventPersons/pageByJqGridList?personCode=" + personCode + "&pageSize=10&pageNo=1&sidx=&sord=asc",
        dataType: 'json',
        success: function (data) {
            // var id = data.result.id
            // console.log(data.result);
            var arr = data.rows;
            var trStr = '';
            for (var index in arr) {
                // console.log(arr[index]);
                var arrStr = arr[index];


                trStr += '<tr >';
                trStr += '<td style="text-align:center;">' + arrStr.eventYear + '</td>';
                trStr += '<td style="text-align:center;">' + arrStr.personLevel + '</td>';
                trStr += '</tr>';
            }
            $("#tbody1").html(trStr);
        }
    })

}*/


///人员基本信息变更

function queryPersonTeamHis(personCode) {
    $.ajax({
        type: 'GET',
        url: "/mkmm/sales/personInTeGrates/querypersonteamreview?personCode=" + personCode,
        dataType: 'json',
        success: function (data) {
            // var id = data.result.id
            // console.log(data.result);
            var arr = data.result;
            var trStr = '';
            for (var index in arr) {
                // console.log(arr[index]);
                var arrStr = arr[index];
                var reviewType = '';
                if ('01' == arrStr.reviewType) {
                    reviewType = '人员信息新增';
                } else {
                    reviewType = '人员信息修改';
                }
                console.log(arrStr)

                var modifyTime = '';
                if (arrStr.modifyTime) {
                    var d = new Date(arrStr.modifyTime);    //根据时间戳生成的时间对象
                    modifyTime = (d.getFullYear()) + "-" +
                        (d.getMonth() + 1) + "-" +
                        (d.getDate()) + " " +
                        (d.getHours()) + ":" +
                        (d.getMinutes()) + ":" +
                        (d.getSeconds());


                }
                var startTime = '';
                if (arrStr.startTime) {
                    var c = new Date(arrStr.startTime);    //根据时间戳生成的时间对象
                    startTime = (c.getFullYear()) + "-" +
                        (c.getMonth() + 1) + "-" +
                        (c.getDate());


                }
                trStr += '<tr >';
                trStr += '<td style="text-align:center;">' + reviewType + '</td>';
                trStr += '<td style="text-align:center;">' + modifyTime + '</td>';
                trStr += '<td style="text-align:center;">' + startTime + '</td>';   //生效时间
                trStr += '<td style="text-align:center;">' + '<button class="btn btn-xs btn-success" onclick=' + 'queryHis("' + arrStr.id + '")> 查看历史明细 </button></td>';
                trStr += '</tr>';
            }
            $("#tbody2").html(trStr);
        }
    })
}


function queryHis(id) {

    commonForward('/mkmm/ui/personMain/tabview?id=' + id)

}


//转换时间
Date.prototype.pattern = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    var week = {
        "0": "/u65e5",
        "1": "/u4e00",
        "2": "/u4e8c",
        "3": "/u4e09",
        "4": "/u56db",
        "5": "/u4e94",
        "6": "/u516d"
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}


//重大事项查看
function queryersonEvent(personCode) {
    $.ajax({
        type: 'GET',
        url: "/mkmm/sales/eventPersons/pageByJqGridList?personCode=" + personCode + "&pageSize=10&pageNo=1&sidx=&sord=asc",
        dataType: 'json',
        success: function (data) {
            // var id = data.result.id
            // console.log(data.result);
            var arr = data.rows;
            var trStr = '';
            for (var index in arr) {
                // console.log(arr[index]);
                var arrStr = arr[index];
                var eventType = '';
                if ('0' == arrStr.eventType) {
                    eventType = '奖励';
                } else if ('1' == arrStr.eventType) {
                    eventType = '处罚';
                } else {
                    eventType = '其他';
                }
                trStr += '<tr >';
                trStr += '<td style="text-align:center;">' + arrStr.eventYear + '</td>';
                trStr += '<td style="text-align:center;">' + eventType + '</td>';
                trStr += '<td style="text-align:center;">' + arrStr.eventApart + '</td>';
                trStr += '<td style="text-align:center;">' + arrStr.createTime + '</td>';
                trStr += '<td style="text-align:center;">' + '<button class="btn btn-xs btn-success" onclick=' + 'queryEvent("' + arrStr.id + '")> 重大事项查看</button></td>';
                trStr += '</tr>';
            }
            $("#tbody3").html(trStr);
        }
    })

}

function queryEvent(id) {

    commonForward('/mkmm/ui/eventPerson/view?id=' + id);

}
