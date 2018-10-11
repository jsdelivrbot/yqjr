package com.yqjr.fin.risk.stat.services.gateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yqjr.fin.fcsw.meta.api.dto.DictItemDto;
import com.yqjr.fin.fcsw.meta.api.dto.UserDto;
import com.yqjr.scfw.common.results.ListResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by cuiyan on 2018/9/12
 */
@Service
public class MetaGateway {
    protected Logger logger = LoggerFactory.getLogger(MetaGateway.class);
    @Autowired
    private MetaClient metaClient;

    /**
     * 获取字典信息
     * @param code 代码类型
     * @param isUpFlag 是否有上级，1为有,0为无
     * @param upCode  上级代码
     * @return
     */
    @HystrixCommand
    public List<DictItemDto> transCode(String code, String isUpFlag, String upCode){
        ListResultResponse<DictItemDto> dictItemDtoListResultResponse = metaClient.transCode(code,isUpFlag,upCode);
        List<DictItemDto> dictItemDtoList=dictItemDtoListResultResponse.getResult();
        return dictItemDtoList;
    }
    /**
     * code转化
     * @param codeType  类型
     * @param codeCode  value值
     * @return
     */
    @HystrixCommand
    public List<DictItemDto> transCode(String codeType,String codeCode){
        ListResultResponse<DictItemDto> dictItemDtoListResultResponse = metaClient.transCodeList(codeType,codeCode);
        List<DictItemDto> dictItemDtoList=dictItemDtoListResultResponse.getResult();
        return dictItemDtoList;
    }

    /**
     * 通过用户名带出人员信息
     * @param loginName  查询用户名
     * @return
     */
    public List<UserDto> getByloginName(String loginName){
        ListResultResponse<UserDto>  userDtoListResultResponse =metaClient.getByloginName(loginName);
        List<UserDto>  userDtoList= userDtoListResultResponse.getResult();
        return userDtoList;
    }

}
