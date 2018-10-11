package com.yqjr.fin.mkmm.sales.services.gateway;

import com.yqjr.fin.scfw.isomer.api.response.ResponseModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 费用报销接口
 * Created by THINK on 2018/6/9.
 */
@FeignClient("FIN-SCFW-ISOMER")
public interface FeeReimbursementClient {

    @RequestMapping(method = RequestMethod.POST, value = "/dynamicBill/fyaf")
    ResponseModel fYAFDynamicBill(@RequestBody String requestModelStr);

    @RequestMapping(method = RequestMethod.POST, value = "/dynamicBill/fyzl")
    ResponseModel fYZLDynamicBill(@RequestBody String requestModelStr);

    @RequestMapping(method = RequestMethod.POST, value = "/dynamicBill/status/query")
    ResponseModel billStatusQuery(@RequestBody String requestModelStr);


}
