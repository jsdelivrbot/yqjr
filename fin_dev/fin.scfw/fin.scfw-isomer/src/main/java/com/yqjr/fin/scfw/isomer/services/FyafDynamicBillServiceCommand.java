package com.yqjr.fin.scfw.isomer.services;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yqjr.fin.scfw.isomer.api.response.ResponseModel;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * 2.1.	汽车金融事先动支单据接口
 * Created by THINK on 2018/6/8.
 */
public class FyafDynamicBillServiceCommand {

    private static final QName SERVICE_NAME = new QName("http://service.fyafdynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/", "FYAFDynamicBillServiceImplService");

    private static Logger logger = LoggerFactory.getLogger(FyafDynamicBillServiceCommand.class.getName());


    /*@Override
    public String commandToOuterCxf(FyafDynamicBillMainModel dynamicBillMainModel, DynamicBillDetailModel dynamicBillDetailModel) {

        //主信息
        FyafDynamicBillMainVO fyafDynamicBillMainVO = new FyafDynamicBillMainVO();
        fyafDynamicBillMainVO.setRequisitionUser("Auto");
        fyafDynamicBillMainVO.setRequisitionUserCompany("V98T56");
        fyafDynamicBillMainVO.setRequisitionUserDepartment("V98T56");
        //主流水  业务一次请求时唯一
        fyafDynamicBillMainVO.setMsgRef("");
        fyafDynamicBillMainVO.setFromSystem("YWXT");
        fyafDynamicBillMainVO.setToSystem("");
        //交易流水  每次流水都唯一
//        fyafDynamicBillMainVO.setExternalReferenceNo();
        //以下为非必传字段
        fyafDynamicBillMainVO.setValidCode("");
        fyafDynamicBillMainVO.setAttachmentCount("");
        fyafDynamicBillMainVO.setBusinessCode("");
        fyafDynamicBillMainVO.setMemo("");
        fyafDynamicBillMainVO.setMemo1("");
        fyafDynamicBillMainVO.setMemo2("");

        //明细信息
        List<FyafDynamicBillDetailVO> fyafDynamicBillDetailVOs = new ArrayList<FyafDynamicBillDetailVO>();
        FyafDynamicBillDetailVO fyafDynamicBillDetailVO = new FyafDynamicBillDetailVO();
        //业务信息单号   活动费用动支时为  活动代码
//        fyafDynamicBillDetailVO.setDetailId();
//        fyafDynamicBillDetailVO.setDimSubject();
        //财务事项：业务宣传-其他(301090203)
        fyafDynamicBillDetailVO.setDimAccount("301090203");
        //项目：MX0399 公共项(XM0399)
        fyafDynamicBillDetailVO.setDim04("XM0399");
        //业务线：总部：公共业务线(CP0199)区域：乘用车零售业务(CP0101)
//        fyafDynamicBillDetailVO.setDim01();
//        //IT项目
//        fyafDynamicBillDetailVO.setITproject();
//        //金额
//        fyafDynamicBillDetailVO.setNaturalCurrency();
//        //摘要
//        fyafDynamicBillDetailVO.setMemo();
//        fyafDynamicBillDetailVO.setMemo1();
//        fyafDynamicBillDetailVO.setMemo2();
//        fyafDynamicBillDetailVOs.add(fyafDynamicBillDetailVO);

        return null;
    }*/


    /**
     * 汽车金融调用共享事先动支单据接口
     */
    public static ResponseModel commandToOuterCxf(FyafDynamicBillMainVO fyafDynamicBillMainVO,  List<FyafDynamicBillDetailVO> fyafDynamicBillDetailVOs,String url)
            throws Exception_Exception, MalformedURLException {
        logger.info("汽车金融调用共享开始，main = " + JSONObject.toJSONString(fyafDynamicBillMainVO, SerializerFeature.WriteMapNullValue) +",details = " + JSONObject.toJSONString(fyafDynamicBillDetailVOs, SerializerFeature.WriteMapNullValue) +",url = " + url);
        URL wsdlURL = new URL(url);
        FYAFDynamicBillServiceImplService fyafDynamicBillServiceImplService = new FYAFDynamicBillServiceImplService(wsdlURL, SERVICE_NAME);
        FYAFDynamicBillService port = fyafDynamicBillServiceImplService.getFYAFDynamicBillServiceImplPort();
        Message message = port.createBill4FYAFDynamicBillService(fyafDynamicBillMainVO, fyafDynamicBillDetailVOs);
        logger.info("汽车金融调用共享结束， message = " + JSONObject.toJSONString(message, SerializerFeature.WriteMapNullValue));
        return CommonTools.fayfTransToOurRes(message);

    }

/*    @Override
    public String commandToOuteHttp() {
        return null;
    }

    @Override
    public String commandToOuteRest() {
        return null;
    }*/




}
