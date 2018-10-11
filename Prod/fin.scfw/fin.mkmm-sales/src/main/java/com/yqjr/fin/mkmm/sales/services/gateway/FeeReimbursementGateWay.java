package com.yqjr.fin.mkmm.sales.services.gateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yqjr.fin.scfw.isomer.api.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 费用报销接口
 * Created by THINK on 2018/6/9.
 */
@Service
public class FeeReimbursementGateWay {

    @Autowired
    private FeeReimbursementClient feeReimbursementClient;

    public ResponseModel fYAFDynamicBill(String requestModelStr){
        return feeReimbursementClient.fYAFDynamicBill(requestModelStr);
    }


    @HystrixCommand
    public ResponseModel fYZLDynamicBill(String requestModelStr){
        return feeReimbursementClient.fYZLDynamicBill(requestModelStr);
    }

    @HystrixCommand
    public ResponseModel billStatusQuery(String requestModelStr){
        return feeReimbursementClient.billStatusQuery(requestModelStr);
    }













}


