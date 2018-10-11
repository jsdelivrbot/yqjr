package com.yqjr.fin.mkmm.sales.services;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yqjr.fin.mkmm.sales.condition.ActiveMainCondition;
import com.yqjr.fin.mkmm.sales.condition.UserRelationCondition;
import com.yqjr.fin.mkmm.sales.entity.ActiveMain;
import com.yqjr.fin.mkmm.sales.entity.FeeMain;
import com.yqjr.fin.mkmm.sales.entity.UserRelation;
import com.yqjr.fin.mkmm.sales.services.gateway.FeeReimbursementGateWay;
import com.yqjr.fin.scfw.isomer.api.CommonStatusEnum;
import com.yqjr.fin.scfw.isomer.api.request.BillStatusModel;
import com.yqjr.fin.scfw.isomer.api.request.BillStatusRequestModel;
import com.yqjr.fin.scfw.isomer.api.request.DynamicBillRequestModel;
import com.yqjr.fin.scfw.isomer.api.request.FyafDynamicBillDetailModel;
import com.yqjr.fin.scfw.isomer.api.request.FyafDynamicBillMainModel;
import com.yqjr.fin.scfw.isomer.api.request.FyzlDynamicBillDetailModel;
import com.yqjr.fin.scfw.isomer.api.request.FyzlDynamicBillMainModel;
import com.yqjr.fin.scfw.isomer.api.response.ResponseDetailModel;
import com.yqjr.fin.scfw.isomer.api.response.ResponseModel;
import com.yqjr.scfw.common.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by THINK on 2018/6/9.
 */
@Transactional(readOnly = true)
@Service
public class FeeSendToGXService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //创建人公司
    private static final String USER_COMPANY = "V98T56";
    //来源系统
    private static final String FROM_SYSTEM = "YWXT";
    //项目
    private static final String PROJECT = "XM0399";
    //财务事项
    private static final String DIM_ACCOUNT = "301090203";
    //目标系统
    private static final String TO_SYSTEM = "FSSC";
    //公共业务线
    private static final String  PUBLIC_BUSINESS_LINE = "CP0199";
    //乘用车零售业务
    private static final String  CAR_RETAIL_BUSINESS = "CP0101";

    //乘用车零售业务
    private static final String  CHANNEL = "WLZL0101";

    @Autowired
    ActiveMainService activeMainService;

    @Autowired
    FeeReimbursementGateWay service;

    @Autowired
    FeeMainService feeMainService;

    @Autowired
    UserRelationService userRelationService;


    /**
     * 传输数据至共享系统进行报销
     */
    public void senfInfoToGX(FeeMain feeMain) throws Exception {
        logger.info("senfInfoToGX start,feeMain = " + JSONObject.toJSONString(feeMain));
        //根据不同公司进行组装不同数据 公司类型：1-汽车金融公司，2-租赁公司，3-财务公司
        if (null == feeMain) {
            throw new ValidationException("参数异常:费用数据为空");
        }
        ActiveMain activeMain = getActiveMainByCode(feeMain);
        UserRelation userRelation = getUserRealtionByCreator(feeMain);
        if (null == activeMain) {
            throw new ValidationException("参数异常:活动信息为空");
        }
        if (null == userRelation) {
            throw new ValidationException("参数异常:当前用户在共享系统不存在");
        }
        if (feeMain.getCompany().equals("1")) {
            senfInfoToGXByFinance(feeMain, activeMain, userRelation);
        } else if (feeMain.getCompany().equals("2")) {
            senfInfoToGXByLease(feeMain, activeMain, userRelation);
        }
        logger.info("senfInfoToGX end ");
    }


    /**
     * 调用异构账单状态查询
     */
    public ResponseModel billStatusQuery(FeeMain feeMain) throws Exception{
        logger.info("billStatusQuery start");
        UserRelation userRelation = getUserRealtionByCreator(feeMain);
        if(null == userRelation){
            logger.info("userRelation 为空");
            return null;
        }
        DynamicBillRequestModel requestModel = new DynamicBillRequestModel();
        requestModel.setBillStatusReuqest(buildBillStatusRequest(feeMain,userRelation));
        requestModel.setBillStatusList(buildBillStatusList(feeMain));
        return service.billStatusQuery(JSONObject.toJSONString(requestModel));
    }

    /**
     * 发送数据至共享  租赁公司
     * @param feeMain
     */
    private void senfInfoToGXByLease(FeeMain feeMain,ActiveMain activeMain,UserRelation userRelation) throws Exception{
        logger.info("senfInfoToGXByLease start,feeMainId = " + feeMain.getId());
        FyzlDynamicBillMainModel dynamicBillMainModel = buildFyzlMainInfo(activeMain,userRelation);
        List<FyzlDynamicBillDetailModel> list = buildFyzlDetailInfo(feeMain,userRelation);
        DynamicBillRequestModel requestModel = new DynamicBillRequestModel();
        requestModel.setFyzlDynamicBillMain(dynamicBillMainModel);
        requestModel.setFyzldetailList(list);
        ResponseModel responseModel = service.fYZLDynamicBill(JSONObject.toJSONString(requestModel));
        logger.info("租赁公司调用异构平台结束，返回值:" + JSONObject.toJSONString(responseModel,SerializerFeature.WriteMapNullValue));
        if(!"100".equals(responseModel.getReqCode())){
            throw new ValidationException("租赁公司费用报销失败，原因:" + responseModel.getReqMsg());
        }
        updateFeeMain(responseModel,feeMain);
        logger.info("senfInfoToGXByLease end");

    }

    /**
     * 发送数据至共享  汽车金融公司
     * @param feeMain
     */
    private void senfInfoToGXByFinance(FeeMain feeMain,ActiveMain activeMain,UserRelation userRelation) throws Exception {
        logger.info("senfInfoToGXByFinance start,feeMainId = " + feeMain.getId());
        FyafDynamicBillMainModel dynamicBillMainModel = buildFyafMainInfo(activeMain,userRelation);
        List<FyafDynamicBillDetailModel> list = buildFyafDetailInfo(feeMain,userRelation);
        DynamicBillRequestModel requestModel = new DynamicBillRequestModel();
        requestModel.setFyafDynamicBillMain(dynamicBillMainModel);
        requestModel.setFyafdetailList(list);
        ResponseModel responseModel = service.fYAFDynamicBill(JSONObject.toJSONString(requestModel));
        logger.info("金融公司调用异构平台结束，返回值:" + JSONObject.toJSONString(responseModel),SerializerFeature.WRITE_MAP_NULL_FEATURES);
        if("100" != responseModel.getReqCode()){
            throw new ValidationException("金融公司费用报销失败，原因:" + responseModel.getReqMsg());
        }
        updateFeeMain(responseModel,feeMain);
        logger.info("senfInfoToGXByFinance end");
    }

    /**
     * 构建汽车金融事先动支请求主数据
     */
    public FyafDynamicBillMainModel buildFyafMainInfo(ActiveMain activeMain,UserRelation userRelation){
        logger.info("buildFyafMainInfo start");
        String sericalNo = UUID.randomUUID().toString().replace("-","").toLowerCase();
        FyafDynamicBillMainModel dynamicBillMainModel = new FyafDynamicBillMainModel();
        dynamicBillMainModel.setExternalReferenceNo(sericalNo);
        dynamicBillMainModel.setFromSystem(FROM_SYSTEM);
        dynamicBillMainModel.setMsgRef(sericalNo);
        dynamicBillMainModel.setRequisitionUser(userRelation.getPsUserCode());
        dynamicBillMainModel.setRequisitionUserCompany(USER_COMPANY);
        dynamicBillMainModel.setRequisitionUserDepartment(userRelation.getPsDepartmentCode());
        dynamicBillMainModel.setToSystem(TO_SYSTEM);
        dynamicBillMainModel.setBusinessCode(activeMain.getAdditionalId());
        // dynamicBillMainModel.setTradecode();//
        logger.info("buildFyafMainInfo end");
        return dynamicBillMainModel;
    }

    /**
     * 构建租赁公司事先动支请求主数据
     */
    public FyzlDynamicBillMainModel buildFyzlMainInfo(ActiveMain activeMain,UserRelation userRelation){
        logger.info("buildFyzlMainInfo start");
        String sericalNo = UUID.randomUUID().toString().replace("-","").toLowerCase();
        FyzlDynamicBillMainModel dynamicBillMainModel = new FyzlDynamicBillMainModel();
        dynamicBillMainModel.setExternalReferenceNo(sericalNo);
        dynamicBillMainModel.setFromSystem(FROM_SYSTEM);
        dynamicBillMainModel.setMsgRef(sericalNo);
        dynamicBillMainModel.setRequisitionUser(userRelation.getPsUserCode());
        dynamicBillMainModel.setRequisitionUserCompany(USER_COMPANY);
        dynamicBillMainModel.setRequisitionUserDepartment(userRelation.getPsDepartmentCode());
        dynamicBillMainModel.setToSystem(TO_SYSTEM);//
        dynamicBillMainModel.setBusinessCode(activeMain.getAdditionalId());
        // dynamicBillMainModel.setTradecode();//
        logger.info("buildFyzlMainInfo end");
        return dynamicBillMainModel;
    }

    /**
     * 构建汽车金融事先动支请求详细数据
     */
    public List<FyafDynamicBillDetailModel> buildFyafDetailInfo(FeeMain feeMain,UserRelation userRelation){
        logger.info("buildFyafDetailInfo start,feeMainid = " + feeMain.getId());
        FyafDynamicBillDetailModel dynamicBillDetailModel = new FyafDynamicBillDetailModel();
        dynamicBillDetailModel.setDetailId(feeMain.getBusinessCode());
        dynamicBillDetailModel.setDimSubject(userRelation.getPsDepartmentCode());
        dynamicBillDetailModel.setDimAccount(DIM_ACCOUNT);
        dynamicBillDetailModel.setDim01(getBusinessLineByArea(feeMain.getAreaCode()));
        dynamicBillDetailModel.setDim04(PROJECT);
        //dynamicBillDetailModel.setiTproject(IT_SUBJECT);
        dynamicBillDetailModel.setNaturalCurrency(""+feeMain.getBillFee());
        dynamicBillDetailModel.setMemo(feeMain.getAreaName()+"费用报销申请");//TODO
        List<FyafDynamicBillDetailModel> list = new ArrayList<>();
        list.add(dynamicBillDetailModel);
        logger.info("buildFyafDetailInfo end");
        return list;
    }

    /**
     * 构建租赁公司事先动支请求详细数据
     */
    public List<FyzlDynamicBillDetailModel> buildFyzlDetailInfo(FeeMain feeMain,UserRelation userRelation) throws Exception{
        logger.info("buildFyzlDetailInfo start,feeMainid = " + feeMain.getId());
        FyzlDynamicBillDetailModel dynamicBillDetailModel = new FyzlDynamicBillDetailModel();
        dynamicBillDetailModel.setDetailId(feeMain.getBusinessCode());
        dynamicBillDetailModel.setDimSubject(userRelation.getPsDepartmentCode());
        dynamicBillDetailModel.setDimAccount(DIM_ACCOUNT);
        dynamicBillDetailModel.setDim03(CHANNEL);
        //dynamicBillDetailModel.setiTproject(IT_SUBJECT);
        dynamicBillDetailModel.setNaturalCurrency(""+feeMain.getBillFee());
        dynamicBillDetailModel.setMemo(feeMain.getAreaName()+"费用报销申请"); //TODO
        List<FyzlDynamicBillDetailModel> list = new ArrayList<>();
        list.add(dynamicBillDetailModel);
        logger.info("buildFyzlDetailInfo end");
        return list;
    }

    /**
     * 构建订单状态查询基础数据
     */
    private BillStatusRequestModel buildBillStatusRequest(FeeMain feeMain,UserRelation userRelation) throws Exception{
        logger.info("buildBillStatusRequest start,id = " + feeMain.getId());
        BillStatusRequestModel billStatusRequestModel = new BillStatusRequestModel();
        billStatusRequestModel.setExternalReferenceNo(feeMain.getSerialNumber());
        billStatusRequestModel.setFromSystem(FROM_SYSTEM);
        billStatusRequestModel.setMsgRef(feeMain.getSerialNumber());
        billStatusRequestModel.setRequisitionUser(userRelation.getPsUserCode());//
        billStatusRequestModel.setRequisitionUserCompany(USER_COMPANY);
        billStatusRequestModel.setRequisitionUserDepartment(userRelation.getPsDepartmentCode());
        billStatusRequestModel.setToSystem(TO_SYSTEM);
        // billStatusRequestModel.setTradecode();//
        logger.info("buildBillStatusRequest end");
        return billStatusRequestModel;
    }

    /**
     * 构建订单状态查询数据结合
     */
    private List<BillStatusModel> buildBillStatusList(FeeMain feeMain) throws Exception{
        logger.info("buildBillStatusList start,feeMainId = " + feeMain.getId());
        BillStatusModel billStatusModel = new BillStatusModel();
        billStatusModel.setExternalReferenceNo(feeMain.getSerialNumber());
        List<BillStatusModel> list = new ArrayList<>();
        list.add(billStatusModel);
        logger.info("buildBillStatusList end");
        return list;
    }

    /**
     * 事先动支接口调用成功后，将流水号插入到费用表中 更新结算状态 和 是否发送共享状态
     */
    private void updateFeeMain(ResponseModel responseModel,FeeMain feeMain) throws Exception{
        logger.info("updateFeeMain start,feeMainId = " + feeMain.getId());
        //接口调用成功
        if(CommonStatusEnum.SUCCESS.getCode().equals(responseModel.getReqCode())){
            ResponseDetailModel responseDetailModel = JSONObject.parseObject(JSONObject.toJSONString(responseModel.getData()),ResponseDetailModel.class);
            String serialNumber = responseDetailModel.getExternalReferenceNo();
            feeMain.setSerialNumber(serialNumber);
            feeMain.setBillStatus("02");//动支中
            feeMain.setIsSendGx("02");//已送共享
            feeMainService.updateById(feeMain);
        }
        logger.info("updateFeeMain end");
    }

    /**
     * 通过区域代码判断所属业务线 市场部 -- 总部，区域 -- 乘用车零售业务
     */
    private String getBusinessLineByArea(String areaCode){
        String bussinessLine = "";
        //R00000 市场部区域代码
        if("R00000".equals(areaCode)){
            bussinessLine = PUBLIC_BUSINESS_LINE;
        }else {
            bussinessLine = CAR_RETAIL_BUSINESS;
        }
        return bussinessLine;
    }


    /**
     * 通过活动编码和公司查询活动信息
     */
    private ActiveMain getActiveMainByCode(FeeMain feeMain){
        logger.info("getActiveMainByCode start,feeMain = " + JSONObject.toJSONString(feeMain));
        ActiveMain activeMain = null;
        ActiveMainCondition activeMainCondition = new ActiveMainCondition();
        activeMainCondition.setActiveCode(feeMain.getBusinessCode());
        activeMainCondition.setCompany(feeMain.getCompany());
        List<ActiveMain> activeMainList = activeMainService.selectList(activeMainCondition);
        if(null != activeMainList && activeMainList.size()>0){
            activeMain = activeMainList.get(0);
        }
        logger.info("getActiveMainByCode end, activeMain = " + activeMain);
        return activeMain;
    }

    /**
     * 通过用户登录id和公司查询用户在共享的用户编码和部门编码
     */
    private UserRelation getUserRealtionByCreator(FeeMain feeMain){
        logger.info("getUserRealtionByCreator start");
        UserRelation userRelation = null;
        UserRelationCondition userRelationCondition = new UserRelationCondition();
        userRelationCondition.setPlarformUserId(feeMain.getCreator());
        userRelationCondition.setCompany(feeMain.getCompany());
        List<UserRelation> list = userRelationService.selectList(userRelationCondition);
        if(null != list && list.size()>0){
            userRelation = list.get(0);
        }
        logger.info("getUserRealtionByCreator end,userRelation = " + JSONObject.toJSONString(userRelation, SerializerFeature.WriteMapNullValue));
        return userRelation;
    }

}
