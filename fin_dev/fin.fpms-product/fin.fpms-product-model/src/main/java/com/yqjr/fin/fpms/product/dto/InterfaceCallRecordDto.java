package com.yqjr.fin.fpms.product.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 接口调用记录表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:19
*/

@Data
public class InterfaceCallRecordDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 接口地址
     */
    private String interfaceUrl;
	
    /**
     * 接口名称
     */
    private String interfaceName;
	
    /**
     * 接口参数
     */
    private String interfaceParam;
	
    /**
     * 返回结果
     */
    private String returnResult;
	
    /**
     * 调用方
     */
    private String caller;
	
    /**
     * 状态 1有效0无效
     */
    private Long flag;
	

}
