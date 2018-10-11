package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.entity.ActiveMatchDetail;
import com.yqjr.fin.mkmm.sales.entity.FeeMainReview;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.FeeDetailReview;
import com.yqjr.fin.mkmm.sales.mapper.FeeDetailReviewMapper;
import com.yqjr.scfw.common.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FeeDetailReviewService extends BaseService<FeeDetailReviewMapper, FeeDetailReview, Long> {


    //region generated by CodeRobot

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
    @Autowired
    FeeDetailReviewMapper feeDetailReviewMapper;


    /**
     * 转换明细数据 并且保存
     * @param activeMatchDetailList
     * @param feeMainReview
     */
    @Transactional
    public void trunAndSave(List<ActiveMatchDetail> activeMatchDetailList, FeeMainReview feeMainReview) {
        //循环数据转换并插入
        for (ActiveMatchDetail activeMatchDetail : activeMatchDetailList) {

            FeeDetailReview feeDetailReview = new FeeDetailReview();
            BeanUtils.copyProperties(feeDetailReview,activeMatchDetail);

            feeDetailReview.setBusinessId(activeMatchDetail.getBusinessid());
            feeDetailReview.setApplyId(activeMatchDetail.getApplyid());
            feeDetailReview.setBillNo(activeMatchDetail.getBillNo());
            feeDetailReview.setContractNo(activeMatchDetail.getContractNo());
            feeDetailReview.setLoanNo(activeMatchDetail.getLoanNo());
            feeDetailReview.setCustomCode(activeMatchDetail.getCustomCode());
            feeDetailReview.setCustomName(activeMatchDetail.getCustomName());
            feeDetailReview.setCustomIdCard(activeMatchDetail.getCustomIdCard());
            feeDetailReview.setCustomIdType(activeMatchDetail.getCustomIdType());
            feeDetailReview.setCompany(activeMatchDetail.getCompany());
            feeDetailReview.setBrandsCode(activeMatchDetail.getBrandsCode());
            feeDetailReview.setBrandsName(activeMatchDetail.getBrandsName());
            feeDetailReview.setSeriesCode(activeMatchDetail.getSeriesCode());
            feeDetailReview.setSeriesName(activeMatchDetail.getSeriesName());
            feeDetailReview.setCarBrandType(activeMatchDetail.getCarBrandType());
            feeDetailReview.setCarBrandTypeName(activeMatchDetail.getCarBrandTypeName());
            feeDetailReview.setCarPrice(activeMatchDetail.getCarPrice());
            feeDetailReview.setCarMortgagerName(activeMatchDetail.getCarMortgagerName());
            feeDetailReview.setNactivitiesId(activeMatchDetail.getNactivitiesId());
            feeDetailReview.setNactivitiesName(activeMatchDetail.getNactivitiesName());
            feeDetailReview.setNecactivitiesId(activeMatchDetail.getNecactivitiesId());
            feeDetailReview.setNecactivitiesName(activeMatchDetail.getNecactivitiesName());
            feeDetailReview.setNbizType(activeMatchDetail.getNbizType());
            feeDetailReview.setNbizTypeName(activeMatchDetail.getNbizTypeName());
            feeDetailReview.setNgetinterestType(activeMatchDetail.getNgetinterestType());
            feeDetailReview.setNgetinterestTypeName(activeMatchDetail.getNgetinterestTypeName());
            feeDetailReview.setNdlrbizType(activeMatchDetail.getNdlrbizType());
            feeDetailReview.setNdlrbizTypeName(activeMatchDetail.getNdlrbizTypeName());
            feeDetailReview.setNloanMoney(activeMatchDetail.getNloanMoney());
            feeDetailReview.setTimeLimit(activeMatchDetail.getTimeLimit());
            feeDetailReview.setDapplyDate(activeMatchDetail.getDapplyDate());
            feeDetailReview.setDfactstartDate(activeMatchDetail.getDfactstartDate());
            feeDetailReview.setNecloanMoney(activeMatchDetail.getNecloanMoney());
            feeDetailReview.setFirstRatio(activeMatchDetail.getFirstRatio());
            feeDetailReview.setLargeAreaCode(activeMatchDetail.getLargeAreaCode());
            feeDetailReview.setLargeAreaName(activeMatchDetail.getLargeAreaName());
            feeDetailReview.setZoneTwoCode(activeMatchDetail.getZoneTwoCode());
            feeDetailReview.setZoneTwoName(activeMatchDetail.getZoneTwoName());
            feeDetailReview.setDistributorCode(activeMatchDetail.getDistributorCode());
            feeDetailReview.setDistributorName(activeMatchDetail.getDistributorName());
            feeDetailReview.setSalesPersonCode(activeMatchDetail.getSalesPersonCode());
            feeDetailReview.setSalesPersonName(activeMatchDetail.getSalesPersonName());
            feeDetailReview.setProvinceCode(activeMatchDetail.getProvinceCode());
            feeDetailReview.setProvinceName(activeMatchDetail.getProvinceName());
            feeDetailReview.setCityCode(activeMatchDetail.getCityCode());
            feeDetailReview.setCityName(activeMatchDetail.getCityName());
            feeDetailReview.setRemark(activeMatchDetail.getRemark());
            feeDetailReview.setFlag(activeMatchDetail.getFlag());
            //差关联主表ID信息
            feeDetailReview.setMainId(feeMainReview.getId());
            feeDetailReview.setActiveMatchId(activeMatchDetail.getId());
            feeDetailReview.setFlag("1");

            this.insert(feeDetailReview);

        }
    }

    /**
     * 根据条件查询数据
     * @param feeDetailReviewQuery
     * @return
     */
    public List<FeeDetailReview> select(FeeDetailReview feeDetailReviewQuery) {
        return feeDetailReviewMapper.select(feeDetailReviewQuery);
    }
}