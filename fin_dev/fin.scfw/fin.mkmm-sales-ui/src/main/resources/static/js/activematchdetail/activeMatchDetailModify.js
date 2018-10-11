jQuery(function ($) {

    $("#inputForm").frameworkValid({
    });

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/MKMM_ACTIVE_MATCH_DETAIL/activeMatchDetails/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#businessCode").val(result.businessCode);
          $("#businessName").val(result.businessName);
          $("#businessid").val(result.businessid);
          $("#distributorid").val(result.distributorid);
          $("#isCountMaxIn").val(result.isCountMaxIn);
          $("#taskId").val(result.taskId);
          $("#countDate").val(result.countDate);
          $("#applyid").val(result.applyid);
          $("#billNo").val(result.billNo);
          $("#contractNo").val(result.contractNo);
          $("#loanNo").val(result.loanNo);
          $("#customCode").val(result.customCode);
          $("#customName").val(result.customName);
          $("#customIdType").val(result.customIdType);
          $("#customIdCard").val(result.customIdCard);
          $("#company").val(result.company);
          $("#brandsCode").val(result.brandsCode);
          $("#brandsName").val(result.brandsName);
          $("#seriesCode").val(result.seriesCode);
          $("#carBrandType").val(result.carBrandType);
          $("#carBrandTypeName").val(result.carBrandTypeName);
          $("#seriesName").val(result.seriesName);
          $("#carPrice").val(result.carPrice);
          $("#nactivitiesId").val(result.nactivitiesId);
          $("#carMortgagerName").val(result.carMortgagerName);
          $("#nactivitiesName").val(result.nactivitiesName);
          $("#necactivitiesId").val(result.necactivitiesId);
          $("#necactivitiesName").val(result.necactivitiesName);
          $("#nbizType").val(result.nbizType);
          $("#nbizTypeName").val(result.nbizTypeName);
          $("#ngetinterestType").val(result.ngetinterestType);
          $("#ngetinterestTypeName").val(result.ngetinterestTypeName);
          $("#ndlrbizType").val(result.ndlrbizType);
          $("#ndlrbizTypeName").val(result.ndlrbizTypeName);
          $("#nloanMoney").val(result.nloanMoney);
          $("#timeLimit").val(result.timeLimit);
          $("#dapplyDate").val(result.dapplyDate);
          $("#dfactstartDate").val(result.dfactstartDate);
          $("#necloanMoney").val(result.necloanMoney);
          $("#firstRatio").val(result.firstRatio);
          $("#largeAreaCode").val(result.largeAreaCode);
          $("#largeAreaName").val(result.largeAreaName);
          $("#zoneTwoCode").val(result.zoneTwoCode);
          $("#zoneTwoName").val(result.zoneTwoName);
          $("#distributorCode").val(result.distributorCode);
          $("#distributorName").val(result.distributorName);
          $("#salesPersonCode").val(result.salesPersonCode);
          $("#salesPersonName").val(result.salesPersonName);
          $("#provinceCode").val(result.provinceCode);
          $("#provinceName").val(result.provinceName);
          $("#cityCode").val(result.cityCode);
          $("#cityName").val(result.cityName);
          $("#remark").val(result.remark);
          $("#createTime").val(result.createTime);
          $("#modifyTime").val(result.modifyTime);
          $("#startTime").val(result.startTime);
          $("#creator").val(result.creator);
          $("#modifier").val(result.modifier);
          $("#flag").val(result.flag);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })

    $("#btnSubmit").on("click", function (e) {
        e.preventDefault();
        var flag = $("#inputForm").valid();
        if (!flag) {
            //没有通过验证
            return;
        } else {
            $("button").attr("disabled", true);
            var $form = $("#inputForm");
            var arr = $form.serializeArray();
            var formData = {};
            if ($form.val()) {
                $form.trigger('change');
            }

            $.each(arr, function (i, item) {
                formData[item['name']] = item['value'];
            });

            $.ajax({
                type: 'PATCH',
                contentType: 'application/json',
                url: '/mkmm/MKMM_ACTIVE_MATCH_DETAIL/activeMatchDetails/' + mid,
                data: JSON.stringify(formData)
            }).then(function (obj) {
                // 保存失败
                if (!obj.isSuccess) {
                    layer.alert(obj.msg);
                    return;
                }
                layer.alert(obj.msg);
                $("#inputForm").resetForm();
            }).always(function () {
                $("button").attr("disabled", false);
            });
        }
    });
});
