package com.yqjr.fin.mkmm.sales.rest;

import com.alibaba.fastjson.JSONObject;
import com.yqjr.fin.mkmm.sales.entity.FeeMain;
import com.yqjr.fin.mkmm.sales.services.FeeMainService;
import com.yqjr.fin.mkmm.sales.services.FeeSendToGXService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 账单状态查询
 * @author: lixue
 * @date: 2018/06/11 18:29:16
 **/

@RestController
@RequestMapping(value = "/billStatus")
public class BillStatusSelectRest {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    FeeMainService feeMainService;

    @Autowired
    FeeSendToGXService feeSendToGXService;

    @ApiOperation(value = "查询已发送共享的账单状态", tags = "账单状态查询：BillStatusSelectRest")
    @RequestMapping("/query")
    public void selectDynamicBillStatus(){
        logger.info("selectDynamicBillStatus start");
        List<FeeMain> list = feeMainService.selectSendGxBill();
        logger.info("list size = " + list.size());
        if (null != list && list.size() > 0) {
            feeMainService.billStatusQuery(list);
        }
        logger.info("selectDynamicBillStatus end");
    }

}
