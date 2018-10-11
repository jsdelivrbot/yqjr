jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var id = $.getUrlParam("id");


    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/personInTeGrates/personTeamHisQuery?id=' + id,
        dataType: 'json',
        success: function (obj) {
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
            $("#personName").val(result.personName);//姓名
            $("#personIdcard").val(result.personIdcard);//身份证号

            if (result.personBirth != null) {
                var d = new Date(result.personBirth);    //根据时间戳生成的时间对象
                personBirth = (d.getFullYear()) + "-" +
                    (d.getMonth() + 1) + "-" +
                    (d.getDate())
                ;
                $("#personBirth").val(personBirth);//出生日期
            }
            /*$("#personBirth").val(result.personBirth);//出生日期*/

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
            if (result.personTeam.personCheckStart != null) {
                var d = new Date(result.personTeam.personCheckStart);    //根据时间戳生成的时间对象
                personCheckStart = (d.getFullYear()) + "-" +
                    (d.getMonth() + 1) + "-" +
                    (d.getDate());

                $("#personCheckStart").val(personCheckStart);//考核开始时间
            }

            if (result.personTeam.personUptime != null) {
                var d = new Date(result.personTeam.personUptime);    //根据时间戳生成的时间对象
                personUptime = (d.getFullYear()) + "-" +
                    (d.getMonth() + 1) + "-" +
                    (d.getDate());
                $("#personUptime").val(personUptime);//上岗时间
            }

            if (result.personTeam.personCorrectime != null) {
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

            if (result.personTeam.personTryEndtime != null) {
                var d = new Date(result.personTeam.personTryEndtime);    //根据时间戳生成的时间对象
                personTryEndtime = (d.getFullYear()) + "-" +
                    (d.getMonth() + 1) + "-" +
                    (d.getDate());
                $("#personTryEndtime").val(personTryEndtime);//试用期结束时间
            }

            if (result.personTeam.personJointime != null) {
                var d = new Date(result.personTeam.personJointime);    //根据时间戳生成的时间对象
                personJointime = (d.getFullYear()) + "-" +
                    (d.getMonth() + 1) + "-" +
                    (d.getDate())
                ;
                $("#personJointime").val(personJointime);//加入我司时间
            }

            if (result.startTime != null) {
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


        }
        // , function (e) {
        //     layer.alert("查询数据失败:" + e);
        // }
    });
});

function splitStrToDate(str) {
    if (!str) {
        return
    }
    var date = str.toString();
    if (date.length > 10) {
        return date.substring(0, 10)
    } else {
        return ''
    }
}