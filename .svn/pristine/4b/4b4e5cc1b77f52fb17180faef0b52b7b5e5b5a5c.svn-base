package com.yqjr.fin.mkmm.sales.services.gateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yqjr.fin.fcsw.meta.api.dto.DictItemDto;
import com.yqjr.fin.fcsw.meta.api.dto.UserDto;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectCodeVo;
import com.yqjr.scfw.common.results.ListResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouchong on 2018/6/4.
 */
@Service
public class MetaGateway {
    protected Logger logger = LoggerFactory.getLogger(MetaGateway.class);
    @Autowired
    private MetaClient metaClient;

    /**
     * 获取字典信息
     * @param codeType 代码类型
     * @param isUpFlag 是否有上级，1为有,0为无
     * @param upCode
     * @return
     */
    @HystrixCommand
    public List<SelectCodeVo> transCode(String codeType, String isUpFlag, String upCode){
        ListResultResponse<DictItemDto> dictItemDtoListResultResponse = metaClient.transCode(codeType,isUpFlag,upCode);
        List<DictItemDto> dictItemDtoList=dictItemDtoListResultResponse.getResult();
        int size=dictItemDtoList.size();
        SelectCodeVo selectCodeVo=null;
        List<SelectCodeVo> selectCodeVoList=new ArrayList<SelectCodeVo>();
        for(int i=0;i<size;i++){
            selectCodeVo=new SelectCodeVo();
            selectCodeVo.setValue(dictItemDtoList.get(i).getValue());
            selectCodeVo.setLabel(dictItemDtoList.get(i).getName());
            selectCodeVo.setHeadLetter(dictItemDtoList.get(i).getSimpleName()==null?"":dictItemDtoList.get(i).getSimpleName());
            selectCodeVoList.add(selectCodeVo);
        }
        return selectCodeVoList;
    }
    /**
     * code转化
     * @param codeType  类型
     * @param codeCode  value值
     * @return
     */
    @HystrixCommand
    public List<SelectCodeVo> transCode(String codeType,String codeCode){
        ListResultResponse<DictItemDto> dictItemDtoListResultResponse = metaClient.transCodeList(codeType,codeCode);
        List<DictItemDto> dictItemDtoList=dictItemDtoListResultResponse.getResult();
        int size=dictItemDtoList.size();
        SelectCodeVo selectCodeVo=null;
        List<SelectCodeVo> selectCodeVoList=new ArrayList<SelectCodeVo>();
        for(int i=0;i<size;i++){
            selectCodeVo=new SelectCodeVo();
            selectCodeVo.setValue(dictItemDtoList.get(i).getValue());
            selectCodeVo.setLabel(dictItemDtoList.get(i).getName());
            selectCodeVo.setHeadLetter(dictItemDtoList.get(i).getSimpleName()==null?"":dictItemDtoList.get(i).getSimpleName());
            selectCodeVoList.add(selectCodeVo);
        }
        return selectCodeVoList;
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
