package com.yqjr.fin.risk.stat.services.gateway;

import com.yqjr.fin.fcsw.meta.api.dto.DictItemDto;
import com.yqjr.fin.fcsw.meta.api.dto.UserDto;
import com.yqjr.scfw.common.results.ListResultResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by cuiyan on 2018/9/12.
 */
@FeignClient("http://FIN-SCFW-META")
public interface MetaClient {
    @RequestMapping(method = RequestMethod.GET, value = "/dictItem/getDictItem")
    ListResultResponse<DictItemDto> transCode(@RequestParam("code") String codeType, @RequestParam("flag") String isUpFlag, @RequestParam("value") String upCode);
    
    @RequestMapping(method = RequestMethod.GET, value = "/dictItem/getDictItemList")
    ListResultResponse<DictItemDto> transCodeList(@RequestParam("code") String codeType, @RequestParam("value") String upCode);

    /**
     * 接口带回数据信息
     * create by  lzc  2018/6/6
     * @param loginName  登录用户名
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/user/loginName")
    ListResultResponse<UserDto> getByloginName(@RequestParam("loginName") String loginName);
}
