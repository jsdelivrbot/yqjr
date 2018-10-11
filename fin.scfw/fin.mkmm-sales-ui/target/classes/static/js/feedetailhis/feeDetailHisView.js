jQuery(function ($) {
    $("#inputForm").find('input, textarea, select').attr('disabled', 'disabled');

    var mid = $.getUrlParam("id");
    $.ajax({
        type: 'GET',
        url: '/mkmm/sales/feeDetailHiss/' + mid,
        dataType: 'json'
    }).then(function (obj) {
          // 查询失败
          if (!obj.isSuccess) {
              layer.alert(obj.msg);
              return;
          }
          var result = obj.result;
          $("#id").val(result.id);
          $("#businessId").val(result.businessId);
          $("#applyId").val(result.applyId);
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
          $("#seriesName").val(result.seriesName);
          $("#carBrandType").val(result.carBrandType);
          $("#carBrandTypeName").val(result.carBrandTypeName);
          $("#carPrice").val(result.carPrice);
          $("#carMortgagerName").val(result.carMortgagerName);
          $("#nactivitiesId").val(result.nactivitiesId);
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
          $("#historyId").val(result.historyId);
          $("#mainId").val(result.mainId);
          $("#activeMatchId").val(result.activeMatchId);
      }, function (e) {
          layer.alert("查询数据失败:" + e);
      })
});